public interface Game {
    void start();
    void restart();
    String inputValue();
    GameStatus getGameStatus();
    Answer guess(String guess);
    String getAnswer();
    String getSecret();
}