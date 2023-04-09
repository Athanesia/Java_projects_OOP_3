import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class RuGame extends AbstractGame {
    private static final int WORD_LENGTH = 4;
    private String lastGuess;

    @Override
    protected List<Character> generateCharList() {
        List<Character> charList = new ArrayList<Character>(Arrays.asList(
                'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К',
                'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'));
        return charList;
    }

    @Override
    public Answer guess(String guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c == answer.charAt(i)) {
                bulls++;
            } else if (answer.indexOf(c) >= 0) {
                cows++;
            }
        }
        return new Answer(bulls, cows);
    }

    @Override
    public String getSecret() {
        List<Character> charList = generateCharList();
        String secret = "";
        for (int i = 0; i < WORD_LENGTH; i++) {
            int index = (int) (Math.random() * charList.size());
            secret += charList.get(index);
            charList.remove(index);
        }
        return secret;
    }

    @Override
    public String generateSecret() {
        int secretNumber = (int) (Math.random() * 100) + 1;
        return Integer.toString(secretNumber);
    }


    @Override
    public void restart() {
        lastGuess = "";
        answer = getSecret();
    }


    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public String inputValue() {
        return "русскую букву: ";
    }

    @Override
    public GameStatus getGameStatus() {
        if (answer.equals(lastGuess)) {
            return GameStatus.FINISHED_WIN;
        } else {
            return GameStatus.IN_PROGRESS;
        }
    }
}