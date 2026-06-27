package ch.wiss.quizbackend.service;

import ch.wiss.quizbackend.dto.QuestionFormDTO;
import ch.wiss.quizbackend.model.Question;
import ch.wiss.quizbackend.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void getAllQuestionsReturnsData() {
        List<Question> questions = questionService.getAllQuestions();

        assertFalse(questions.isEmpty());
    }

    @Test
    void getQuestionByIdReturnsCorrectQuestion() {
        Question question = questionService.getQuestionById("1");

        assertNotNull(question);
        assertEquals("1", question.getId());
    }

    @Test
    @Transactional
    void createQuestionPersistsToDb() {

        QuestionFormDTO form = new QuestionFormDTO(
                "Wie heisst die Hauptstadt der Schweiz?",
                "Geografie",
                "leicht",
                List.of("Bern", "Zürich", "Genf", "Basel"),
                "Bern"
        );

        Question saved = questionService.createQuestion(form);

        assertNotNull(saved.getId());
        assertTrue(
                questionRepository.findById(saved.getId()).isPresent()
        );
    }
}