package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;

public class OutputView {

    private static final String BLANK = "";
    private static final String MENU_RECOMMEND_RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String MENU_RESULT_CLASSIFICATION = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String MENU_CATEGORY = "[ 카테고리 | %s ]";
    private static final String RECOMMEND_RESULT = "[ %s | %s ]";
    private static final String RECOMMEND_FINISH_MESSAGE = "추천을 완료했습니다.";

    private OutputView() {
    }

    public static OutputView create() {
        return new OutputView();
    }

    public void printErrorMessage(String message) {
        printMessage(message);
    }

    public void printResultMessage() {
        printMessage(BLANK);
        printMessage(MENU_RECOMMEND_RESULT_MESSAGE);
        printMessage(MENU_RESULT_CLASSIFICATION);
    }

    public void printCategory(List<Category> categories) {
        List<String> collect = categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
        System.out.printf(MENU_CATEGORY, String.join(" | ", collect));
        printMessage(BLANK);
    }

    public void printRecommendMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<String> recommendMenus = coach.getRecommendMenus();
            System.out.printf(RECOMMEND_RESULT, coach.getName(), String.join(" | ", recommendMenus));
            printMessage(BLANK);
        }
        printMessage(BLANK);
    }

    public void printFinishMessage() {
        printMessage(RECOMMEND_FINISH_MESSAGE);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

}
