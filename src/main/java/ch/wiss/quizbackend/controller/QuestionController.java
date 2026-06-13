package ch.wiss.quizbackend.controller;
import ch.wiss.quizbackend.service.QuestionService;
import ch.wiss.quizbackend.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import  java.util.List;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/api/questions")
    public List<Question> getQuestions() {
        return questionService.getAllQuestions();


    }

}

