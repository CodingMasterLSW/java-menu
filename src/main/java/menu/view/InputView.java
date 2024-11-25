package menu.view;

import static menu.exception.ErrorMessage.NOT_BLANK_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private static final String BLANK = "";
    private static final String COACH_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";

    private InputView() {
    }

    public static InputView create() {
        return new InputView();
    }

    public String userInput() {
        String userInput = Console.readLine();
        validateInput(userInput);
        return userInput;
    }

    public void printStartMessage() {
        printMessage(START_MESSAGE);
        printMessage(BLANK);
    }

    public void printCoachInputMessage() {
        printMessage(COACH_INPUT_MESSAGE);
    }

    public String coachInput() {
        return userInput();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void validateInput(String userInput) {
        if (userInput.isBlank() || userInput == null) {
            throw new IllegalArgumentException(NOT_BLANK_INPUT.getMessage());
        }
    }
}