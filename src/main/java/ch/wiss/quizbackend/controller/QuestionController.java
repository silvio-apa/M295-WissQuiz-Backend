package ch.wiss.quizbackend.controller;

import ch.wiss.quizbackend.dto.QuestionFormDTO;
import ch.wiss.quizbackend.model.Question;
import ch.wiss.quizbackend.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/questions/{id}")
    public Question getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(id);
    }

    @PostMapping("/api/questions")
    @ResponseStatus(HttpStatus.CREATED)
    public Question createQuestion(@RequestBody QuestionFormDTO form) {
        return questionService.createQuestion(form);
    }

    @PutMapping("/api/questions/{id}")
    public Question updateQuestion(
            @PathVariable String id,
            @RequestBody QuestionFormDTO form
    ) {
        return questionService.updateQuestion(id, form);
    }

    @DeleteMapping("/api/questions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable String id) {
        questionService.deleteQuestion(id);
    }
}