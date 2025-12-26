package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generate() {
        List<Integer> randoms = new ArrayList<>();

        while (randoms.size() < 3) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);

            if (!randoms.contains(pickedNumber)) {
                randoms.add(pickedNumber);
            }
        }

        return randoms;
    }
}
