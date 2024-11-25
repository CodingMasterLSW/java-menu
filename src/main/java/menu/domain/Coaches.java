package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(List<Coach> coaches) {
        return new Coaches(coaches);
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }
}
