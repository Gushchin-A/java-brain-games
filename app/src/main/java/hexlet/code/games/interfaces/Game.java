package hexlet.code.games.interfaces;

/*
Game — интерфейс всех игр в меню (кроме Greet и Exit)
- метод с описанием игры
- методы с получение вопроса
- метод проверки ответа от пользователи
- метод возврата правильного ответа
*/

public interface Game {

    String gameDescription();
    String getQuestion();
    String getCorrectAnswer();
    boolean checkAnswer(String userAnswer);

}
