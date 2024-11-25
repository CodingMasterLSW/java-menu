package menu;

import menu.config.AppConfig;
import menu.controller.MenuController;

public class Application {

    public static void main(String[] args) {
        MenuController menuController = AppConfig.createMenuController();
        menuController.start();
    }
}
