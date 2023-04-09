import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Выберите игру (1 - \"Быки и коровы\" на числах, 2 - \"Быки и коровы\" на английских буквах, 3 - \"Быки и коровы\" на русских буквах):");
            int gameType = scanner.nextInt();
            Game game;
            switch (gameType) {
                case 1:
                    game = new NumberGame();
                    break;
                case 2:
                    game = new EnGame();
                    break;
                case 3:
                    game = new RuGame();
                    break;
                default:
                    System.out.println("Неверный выбор");
                    return;
            }
            game.start();
            while (game.getGameStatus() == GameStatus.IN_PROGRESS) {
                System.out.print("Введите ");
                if (game instanceof EnGame) {
                    System.out.print("английскую букву: ");
                } else if (game instanceof RuGame) {
                    System.out.print("русскую букву: ");
                } else {
                    System.out.print("число: ");
                }
                String input = scanner.next();
                Answer answer = game.guess(input);
                System.out.printf("Быки: %d, Коровы: %d\n", answer.getBulls(), answer.getCows());
            }
            if (game.getGameStatus() == GameStatus.FINISHED_LOSS) {
                System.out.printf("Вы проиграли. Было загадано %s\n", game.getAnswer());
            } else {
                System.out.println("Вы выиграли!");
            }
        }
    }
}