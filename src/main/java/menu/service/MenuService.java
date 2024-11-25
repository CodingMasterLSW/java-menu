package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.CategoryResult;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.utils.InputParser;
import menu.utils.RandomNumber;

public class MenuService {

    private final InputParser inputParser;
    private final CategoryResult categoryResult;
    private Coaches coaches;


    public MenuService(InputParser inputParser, CategoryResult categoryResult) {
        this.inputParser = inputParser;
        this.categoryResult = categoryResult;
    }

    public Coaches createCoach(String userInput) {
        List<Coach> tmpCoaches = new ArrayList<>();
        List<String> userInputSplitter = inputParser.splitAndValidateUserInput(userInput);
        for (String tmpCoach : userInputSplitter) {
            Coach coach = Coach.from(tmpCoach);
            tmpCoaches.add(coach);
        }
        coaches = Coaches.from(tmpCoaches);
        return coaches;
    }

    public void addUnavailableMenu(Coach coach, String userInput) {
        List<String> tmpUnavailableMenus = inputParser.splitAndValidateUnavailableInput(userInput);
        for (String unavailableMenu : tmpUnavailableMenus) {
            coach.addUnavailableMenu(unavailableMenu);
        }
    }

    public Category recommendCategory() {
        Category category;
        while (true) {
            int number = RandomNumber.generate();
            category = Category.decideCategory(number);
            boolean status = categoryResult.increaseCount(category);
            if (status) {
                break;
            }
        }
        return category;

    }

}
