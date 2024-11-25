package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public enum Category {

    JAPANESE_FOOD("일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREA_FOOD("한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINA_FOOD("중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN_FOOD("아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    ITALIAN_FOOD("양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")),

    전체메뉴("전체메뉴", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼",
            "김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음",
            "깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채",
            "팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜",
            "라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"
            ));

    private final String name;
    private final List<String> menus;

    Category(String name, List<String> menus) {
        this.name = name;
        this.menus = menus;
    }

    public static Category decideCategory(int number) {
        if (number == 1) {
            return JAPANESE_FOOD;
        }
        if (number == 2) {
            return KOREA_FOOD;
        }

        if (number == 3) {
            return CHINA_FOOD;
        }

        if (number == 4) {
            return ASIAN_FOOD;
        }
        return ITALIAN_FOOD;
    }

    public static String decideMenu(Category category) {
        List<String> menus = category.getMenus();
        List<String> shuffle = Randoms.shuffle(menus);
        return shuffle.get(0);
    }

    public List<String> getMenus() {
        return menus;
    }

    public String getName() {
        return name;
    }

    public static boolean hasMenu(String menu) {
        return 전체메뉴.menus.contains(menu);
    }

}
