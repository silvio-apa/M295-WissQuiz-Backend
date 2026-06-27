package ch.wiss.quizbackend.repository;

import ch.wiss.quizbackend.model.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QuestionRepositorySliceTest {

    @Autowired
    private QuestionRepository repository;

    @Test
    void findByCategoryReturnsMatchingQuestions() {
        Question sport = new Question();
        sport.setId("test-sport-1");
        sport.setText("Wie viele Spieler hat ein Fussballteam auf dem Feld?");
        sport.setCategory("Sport");
        sport.setDifficulty("leicht");
        sport.setAnswers(List.of("11", "9", "7", "5"));
        sport.setCorrectAnswer("11");
        repository.save(sport);

        List<Question> result = repository.findByCategory("Sport");

        assertThat(result).isNotEmpty();
        assertThat(result).allMatch(q -> q.getCategory().equals("Sport"));
    }

    @Test
    void findByIdReturnsEmptyForUnknownId() {
        Optional<Question> result =
                repository.findById("gibt-es-garantiert-nicht");

        assertThat(result).isEmpty();
    }
}
