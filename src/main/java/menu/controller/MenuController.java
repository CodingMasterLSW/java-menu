package menu.controller;

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
        }
        System.out.println("메뉴 추천 결과입니다");
        String decideMenu = menuService.recommendMenu();
        System.out.println(decideMenu);
    }
}
