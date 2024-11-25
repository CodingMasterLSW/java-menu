package menu.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class CategoryResult {

    private static final int MAX_SELECT_CATEGORY_COUNT = 2;
    private final Map<Category, Integer> selectCount;

    private CategoryResult() {
        selectCount = new LinkedHashMap<>();
        for (Category category : Category.values()) {
            selectCount.put(category, 0);
        }
    }

    public static CategoryResult create() {
        return new CategoryResult();
    }

    public boolean increaseCount(Category category) {
        if (selectCount.get(category) < MAX_SELECT_CATEGORY_COUNT) {
            selectCount.put(category, selectCount.get(category)+1);
            return true;
        }
        return false;
    }

}
