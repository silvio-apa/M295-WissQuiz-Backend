package ch.wiss.quizbackend.exception;

public class QuestionNotFoundException extends RuntimeException {

    public QuestionNotFoundException(String id) {
        super("Keine Frage mit der id " + id + " gefunden!");
    }
}
