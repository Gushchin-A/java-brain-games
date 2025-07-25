package hexlet.code.games.interfaces;

public interface Game {

    String gameDescription();
    String getQuestion();
    String getCorrectAnswer();
    boolean checkAnswer(String userAnswer);

}
