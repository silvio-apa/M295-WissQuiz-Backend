package ch.wiss.quizbackend.controller;

import ch.wiss.quizbackend.exception.QuestionNotFoundException;
import ch.wiss.quizbackend.model.Question;
import ch.wiss.quizbackend.service.QuestionService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {

    @Autowired
    private MockMvcTester mvc;

    @MockitoBean
    private QuestionService service;

    @Test
    void getByIdReturns200WithBody() {
        Question q = new Question();
        q.setId("1");
        q.setText("Wie viele Spieler hat ein Fussballteam auf dem Feld?");
        q.setCategory("Sport");
        q.setDifficulty("leicht");
        q.setAnswers(List.of("11", "9", "7", "5"));
        q.setCorrectAnswer("11");
        given(service.getQuestionById("1")).willReturn(q);

        assertThat(mvc.get().uri("/api/questions/1"))
                .hasStatusOk()
                .bodyJson()
                .extractingPath("$.text")
                .isEqualTo("Wie viele Spieler hat ein Fussballteam auf dem Feld?");
    }

    @Test
    void getByIdReturns404WhenServiceThrows() {
        given(service.getQuestionById("999"))
                .willThrow(new QuestionNotFoundException("999"));

        assertThat(mvc.get().uri("/api/questions/999"))
                .hasStatus(HttpStatus.NOT_FOUND);
    }
}
