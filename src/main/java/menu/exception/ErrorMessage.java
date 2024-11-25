package menu.exception;

public enum ErrorMessage {
    NOT_BLANK_INPUT("입력은 공백일 수 없습니다. 다시 입력해주세요."),
    INVALID_COACH_NAME_LENGTH("코치의 이름은 최소 2글자, 최대 4글자입니다. 다시 입력해주세요."),
    INVALID_COACH_PARTICIPATION("인원은 최소 2명, 최대 5명입니다. 다시 입력해주세요."),
    INVALID_UNAVAILABLE_MENU_SIZE("먹지 못하는 메뉴는 최대 2개까지 입력 가능합니다. 다시 입력해주세요."),
    INVALID_MENU("존재하지 않는 메뉴입니다, 다시 입력해주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
