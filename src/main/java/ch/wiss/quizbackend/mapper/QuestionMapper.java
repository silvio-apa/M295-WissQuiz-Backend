package ch.wiss.quizbackend.mapper;

import ch.wiss.quizbackend.dto.QuestionFormDTO;
import ch.wiss.quizbackend.model.Question;

public class QuestionMapper {

    public static Question toEntity(String id, QuestionFormDTO dto) {
        Question question = new Question();

        question.setId(id);
        question.setText(dto.text());
        question.setCategory(dto.category());
        question.setDifficulty(dto.difficulty());
        question.setAnswers(dto.answers());
        question.setCorrectAnswer(dto.correctAnswer());

        return question;
    }
}
