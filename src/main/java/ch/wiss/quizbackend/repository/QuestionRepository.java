package ch.wiss.quizbackend.repository;

import ch.wiss.quizbackend.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, String> {
    List<Question> findByCategory(String category);
    List<Question> findByDifficulty(String difficulty);
    Long countByCategory(String category);
    List<Question> findByCategoryAndDifficulty(String category, String difficulty);
}
