public class Answer {
    private int bulls;
    private int cows;
    private String message;

    public Answer(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
        this.message = "";
    }

    public Answer(String message, int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
        this.message = message;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}