package ch.wiss.quizbackend.service;

import  ch.wiss.quizbackend.model.Question;
import  org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    public List<Question> getAllQuestions() {
        return List.of(
                new Question(
                        "1",
                        "Welches Land hat die meisten FIFA-WMs gewonnen ? ",
                        "Sport",
                        "leicht",
                        List.of("Brasilien", "Italien", "Frankreich", "Deutschland"),
                        "Brasilien"


                )
        );
    }
}