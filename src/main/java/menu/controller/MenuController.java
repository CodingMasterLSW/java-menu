package menu.controller;

import java.util.List;
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
        inputView.printCoachInputMessage();
        String userInput = inputView.coachInput();
        Coaches coaches = menuService.createCoach(userInput);
        for (Coach coach : coaches.getCoaches()) {
            inputView.printCannotEatMenu(coach);
            String cannotEatMenu = inputView.inputCannotEatMenu();
            menuService.addUnavailableMenu(coach, cannotEatMenu);
        }
        System.out.println("메뉴 추천 결과입니다");
        List<Category> categories = menuService.recommendWeekCategory();

        for (Coach coach : coaches.getCoaches()) {
            List<String> recommendMenus = menuService.recommendMenus(coach, categories);
            outputView.printRecommendMenus(recommendMenus);
        }


    }
}
