package menu.utils;

import static menu.exception.ErrorMessage.INVALID_COACH_NAME_LENGTH;
import static menu.exception.ErrorMessage.INVALID_COACH_PARTICIPATION;

import java.util.List;

public class InputParser {

    private static final String DELIMITER = ",";
    private static final int MIN_COACH_NAME_LENGTH = 2;
    private static final int MAX_COACH_NAME_LENGTH = 4;
    private static final int MIN_COACH_PARTICIPATION = 2;
    private static final int MAX_COACH_PARTICIPATION = 5;


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
}
