import java.util.List;

public abstract class AbstractGame implements Game {

    private String secret;
    public abstract String generateSecret();

    protected String answer;
    protected List<Character> charList;

    protected abstract List<Character> generateCharList();

    protected void generateWord() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charList.size(); i++) {
            int randomIndex = (int) (Math.random() * charList.size());
            sb.append(charList.get(randomIndex));
            charList.remove(randomIndex);
        }
        answer = sb.toString();
    }

    @Override
    public void start() {
        charList = generateCharList();
        generateWord();
    }

    @Override
    public abstract Answer guess(String guess);

    @Override
    public void restart() {
        start();
    }
    
    @Override
    public String getSecret() {
        return secret;
    }
}