package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void start() {
        inputView.printStartMessage();
        Coaches coaches = manageCoachNameInput();
        manageCoachCannotEatMenu(coaches);
        manageRecommendResult(coaches);
    }

    private Coaches manageCoachNameInput() {
        inputView.printCoachInputMessage();
        return retryOnInvalidInput(() -> {
            String userInput = inputView.coachInput();
            return menuService.createCoach(userInput);
        });
    }

    private void manageCoachCannotEatMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            inputView.printCannotEatMenu(coach);
            retryOnInvalidInput(() -> {
                String cannotEatMenu = inputView.inputCannotEatMenu();
                menuService.addUnavailableMenu(coach, cannotEatMenu);
                return null;
            });
        }
    }

    private void manageRecommendResult(Coaches coaches) {
        List<Category> categories = menuService.recommendWeekCategory();
        outputView.printResultMessage();
        outputView.printCategory(categories);
        menuService.recommendMenus(coaches, categories);
        outputView.printRecommendMenus(coaches);
        outputView.printFinishMessage();
    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
