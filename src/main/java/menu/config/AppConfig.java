package menu.config;

import menu.controller.MenuController;
import menu.service.MenuService;
import menu.utils.InputParser;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {

    private AppConfig() {
    }

    public static MenuController createMenuController() {
        return new MenuController(InputView.create(), OutputView.create(), createMenuService());
    }

    public static MenuService createMenuService() {
        return new MenuService(InputParser.create());
    }

}
