package ch.wiss.quizbackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    private String id;
    private String text;
    private String category;
    private String difficulty;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> answers;
    private String correctAnswer;

    public Question() {

    }


    public Question(String id, String text, String category, String difficulty, List<String> answers, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.category = category;
        this.difficulty = difficulty;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }


    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}

