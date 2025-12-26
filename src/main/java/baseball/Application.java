package baseball;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        Computer computer = new Computer();
        Controller controller = new Controller(game, computer);

        controller.play();
    }
}
