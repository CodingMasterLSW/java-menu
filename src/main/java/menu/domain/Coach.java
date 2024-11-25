package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> unavailableMenus;

    private Coach(String name) {
        this.name = name;
        this.unavailableMenus = new ArrayList<>();
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
}
