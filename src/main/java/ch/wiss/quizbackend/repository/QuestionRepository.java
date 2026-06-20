package ch.wiss.quizbackend.repository;

import ch.wiss.quizbackend.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, String> {
}
