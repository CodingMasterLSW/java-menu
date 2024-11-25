package menu.utils;

import static menu.exception.ErrorMessage.INVALID_COACH_NAME_LENGTH;
import static menu.exception.ErrorMessage.INVALID_COACH_PARTICIPATION;
import static menu.exception.ErrorMessage.INVALID_MENU;
import static menu.exception.ErrorMessage.INVALID_UNAVAILABLE_MENU_SIZE;

import java.util.Arrays;
import java.util.List;
import menu.domain.Category;

public class InputParser {

    private static final String DELIMITER = ",";
    private static final int MIN_COACH_NAME_LENGTH = 2;
    private static final int MAX_COACH_NAME_LENGTH = 4;
    private static final int MIN_COACH_PARTICIPATION = 2;
    private static final int MAX_COACH_PARTICIPATION = 5;
    private static final int MAX_UNAVAILABLE_MENU = 2;


    private InputParser() {
    }

    public static InputParser create() {
        return new InputParser();
    }

    public List<String> splitAndValidateUserInput(String userInput) {
        List<String> coaches = List.of(userInput.split(DELIMITER));
        validateUserInput(coaches);
        return coaches;
    }

    public List<String> splitAndValidateUnavailableInput(String userInput) {
        List<String> unavailableMenus = List.of(userInput.split(DELIMITER));
        validateUnavailableMenuSize(unavailableMenus);
        return unavailableMenus;
    }

    private void validateUserInput(List<String> coaches) {
        validateCoachParticipation(coaches);
        for (String coach : coaches) {
            validateCoachNameLength(coach);
        }
    }

    private void validateCoachNameLength(String coach) {
        if (coach.length() < MIN_COACH_NAME_LENGTH || coach.length() > MAX_COACH_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_LENGTH.getMessage());
        }
    }

    private void validateCoachParticipation(List<String> coaches) {
        if (coaches.size() < MIN_COACH_PARTICIPATION || coaches.size() > MAX_COACH_PARTICIPATION) {
            throw new IllegalArgumentException(INVALID_COACH_PARTICIPATION.getMessage());
        }
    }

    private void validateUnavailableMenuSize(List<String> unavailableMenus) {
        if (unavailableMenus.size() > MAX_UNAVAILABLE_MENU) {
            throw new IllegalArgumentException(INVALID_UNAVAILABLE_MENU_SIZE.getMessage());
        }

        for (String unavailableMenu : unavailableMenus) {
            if (unavailableMenus == null || unavailableMenu.isBlank()) {
                continue;
            }
            if (!Category.hasMenu(unavailableMenu)) {
                throw new IllegalArgumentException(INVALID_MENU.getMessage());
            }
        }
    }
}
