package menu.view;


import java.util.List;

public class OutputView {

    private static final String BLANK = "";
    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    public void printRecommendMenus(List<String> recommendMenus) {
        for (String recommendMenu : recommendMenus) {
            System.out.print(recommendMenu + "|");
        }
        System.out.println();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
