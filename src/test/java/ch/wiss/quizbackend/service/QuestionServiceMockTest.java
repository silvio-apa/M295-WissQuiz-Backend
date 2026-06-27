package ch.wiss.quizbackend.service;

import ch.wiss.quizbackend.dto.QuestionFormDTO;
import ch.wiss.quizbackend.exception.QuestionNotFoundException;
import ch.wiss.quizbackend.model.Question;
import ch.wiss.quizbackend.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceMockTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private QuestionService service;

    @Test
    void getQuestionByIdThrowsWhenNotFound() {
        given(repository.findById("unbekannt")).willReturn(Optional.empty());

        assertThatThrownBy(() -> service.getQuestionById("unbekannt"))
                .isInstanceOf(QuestionNotFoundException.class);
    }

    @Test
    void createQuestionGeneratesIdAndSaves() {
        QuestionFormDTO dto = new QuestionFormDTO(
                "Wie heisst die Hauptstadt der Schweiz?",
                "Geographie",
                "leicht",
                List.of("Bern", "Zürich", "Genf", "Basel"),
                "Bern"
        );
        given(repository.save(any(Question.class)))
                .willAnswer(invocation -> invocation.getArgument(0));

        Question created = service.createQuestion(dto);

        assertThat(created.getId()).isNotBlank();

        ArgumentCaptor<Question> captor =
                ArgumentCaptor.forClass(Question.class);
        verify(repository).save(captor.capture());
        assertThat(captor.getValue().getCategory()).isEqualTo("Geographie");
    }
}
