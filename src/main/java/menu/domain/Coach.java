package menu.domain;

public class Coach {

    private final String name;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(String name) {
        return new Coach(name);
    }

    public String getName() {
        return name;
    }
}
