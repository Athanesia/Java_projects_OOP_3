import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberGame extends AbstractGame {
    private GameStatus status;
    private Answer answer;

    @Override
    public String inputValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        String input = scanner.nextLine();
        scanner.close(); // закрыть сканнер после ввода числа
        return input;
    }

    @Override
    public String generateSecret() {
        int secretNumber = (int) (Math.random() * 100) + 1;
        return Integer.toString(secretNumber);
    }

    @Override
    protected List<Character> generateCharList() {
        List<Character> charList = new ArrayList<>();
        for (char i = '0'; i <= '9'; i++) {
            charList.add(i);
        }
        return charList;
    }

    @Override
    public Answer guess(String guess) throws IllegalArgumentException {
        int bulls = 0;
        int cows = 0;
        String value = getValueAsString();
        for (int i = 0; i < 4; i++) {
            char c1 = value.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bulls++;
            } else if (value.indexOf(c2) != -1) {
                cows++;
            }
        }
        if (bulls == 4) {
            status = GameStatus.FINISHED_WIN;
        } else {
            status = GameStatus.IN_PROGRESS;
        }
        answer = new Answer(guess, bulls, cows);
        return answer; // добавить возврат ответа
    }

    private String getValueAsString() { // добавить метод получения загаданного числа в виде строки
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            value.append(getSecret().charAt(i));
        }
        return value.toString();
    }

    @Override
    public String getAnswer() {
        return answer.toString();
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }

    @Override
    public void restart() {
        super.start(); // вызвать метод start() родительского класса
        status = GameStatus.IN_PROGRESS;
        answer = null;
    }
}