package menu.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 5;

    private RandomNumber() {
    }

    public static int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

}
