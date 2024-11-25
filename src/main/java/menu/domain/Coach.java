package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> unavailableMenus;
    private final List<String> recommendMenus;

    private Coach(String name) {
        this.name = name;
        this.unavailableMenus = new ArrayList<>();
        this.recommendMenus = new ArrayList<>();
    }

    public static Coach from(String name) {
        return new Coach(name);
    }

    public String getName() {
        return name;
    }

    public void addUnavailableMenu(String unavailableMenu){
        this.unavailableMenus.add(unavailableMenu);
    }

    public boolean hasUnavailableMenus(String menu) {
        return unavailableMenus.contains(menu);
    }

    public boolean hasMenu(String menu) {
        return recommendMenus.contains(menu);
    }

    public void addRecommendMenu(String menu) {
        this.recommendMenus.add(menu);
    }

    public List<String> getRecommendMenus() {
        return recommendMenus;
    }
}
