package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controller {
    private static final String THREE_STRIKE = "3스트라이크";

    private static final String MSG_START = "숫자 야구 게임을 시작합니다.";
    private static final String MSG_INPUT = "숫자를 입력해주세요 : ";
    private static final String MSG_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String MSG_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    private Game game;
    private Computer computer;

    public Controller(Game game, Computer computer) {
        this.game = game;
        this.computer = computer;
    }

    public void play() {
        System.out.println(MSG_START);
        boolean restart;

        do {
            List<Integer> answer = computer.generate();
            playOneRound(answer);
            restart = askRestart();
        } while (restart);
    }

    private void playOneRound(List<Integer> answer) {
        while (true) {
            List<Integer> query = readQuery();
            String result = game.match(query, answer);
            System.out.println(result);

            if (THREE_STRIKE.equals(result)) {
                System.out.println(MSG_END);
                return;
            }
        }
    }

    private List<Integer> readQuery() {
        System.out.println(MSG_INPUT);
        String input = Console.readLine();
        validateInput(input);
        return parse(input);
    }

    private void validateInput(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리여야 합니다.");
        }

        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
            if (seen.contains(c)) {
                throw new IllegalArgumentException("중복된 숫자는 사용할 수 없습니다.");
            }
            
            seen.add(c);
        }
    }

    private List<Integer> parse(String input) {
        List<Integer> list = new ArrayList<>(3);
        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i) - '0');
        }
        return list;
    }

    private boolean askRestart() {
        System.out.println(MSG_RESTART);
        String input = Console.readLine();

        if ("1".equals(input)) {
            return true;
        }
        if ("2".equals(input)) {
            return false;
        }

        throw new IllegalArgumentException("재시작 입력은 1 또는 2만 가능합니다.");
    }
}
