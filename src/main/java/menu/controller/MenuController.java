package menu.controller;

import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService service;

    public MenuController(InputView inputView, OutputView outputView, MenuService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void start() {
        inputView.printStartMessage();
    }
}
