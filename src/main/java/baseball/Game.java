package baseball;

import java.util.List;

public class Game {

    public String match(List<Integer> query, List<Integer> answer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < answer.size(); i++) {
            int q = query.get(i);

            if (answer.get(i) == q) {
                strike++;
            } else if (answer.contains(q)) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball).append("볼");
        }

        if (strike != 0) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(strike).append("스트라이크");
        }

        return sb.toString();
    }
}
