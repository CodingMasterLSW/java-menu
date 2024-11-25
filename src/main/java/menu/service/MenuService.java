package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.utils.InputParser;
import menu.utils.RandomNumber;

public class MenuService {

    private final InputParser inputParser;
    private Coaches coaches;

    public MenuService(InputParser inputParser) {
        this.inputParser = inputParser;
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

    public String recommendMenu() {
        int number = RandomNumber.generate();
        Category category = Category.decideCategory(number);
        String decideMenu = Category.decideMenu(category);
        return decideMenu;
    }

}
