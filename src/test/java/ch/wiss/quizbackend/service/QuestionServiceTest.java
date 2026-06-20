package ch.wiss.quizbackend.service;

import ch.wiss.quizbackend.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Test
    void getAllQuestionsReturnsData() {
        List<Question> questions= questionService.getAllQuestions();
        assertEquals(6, questions.size());
    }

    @Test
    void getQuestionsByIdReturnsCorrectQuestion() {
        Question question= questionService.getQuestionById("1");
        assertNotNull(question);
        assertEquals("1", question.getId());
    }
}

