package ch.wiss.quizbackend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import  java.util.List;

@RestController
public class QuestionController {
    @GetMapping("/api/questions")
    public List<Question> getQuestions() {
        return List.of(
                new Question(
                        "1",
                        "Welches Land hat die meisten FIFA-WMs gewonnen?",
                        "Sport",
                        "Leicht",
                        List.of("Brasilien", "Italien", "Frankreich", "Deutschland"),
                        "Brasilien"
                )

        );
    }

}

