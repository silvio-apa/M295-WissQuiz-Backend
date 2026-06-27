package ch.wiss.quizbackend.controller;

import ch.wiss.quizbackend.dto.QuestionFormDTO;
import ch.wiss.quizbackend.model.Question;
import ch.wiss.quizbackend.service.QuestionService;
import jakarta.validation.Valid;
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
    public Question createQuestion(@Valid @RequestBody QuestionFormDTO form) {
        return questionService.createQuestion(form);
    }

    @PutMapping("/api/questions/{id}")
    public Question updateQuestion(@PathVariable String id, @Valid @RequestBody QuestionFormDTO form) {
        return questionService.updateQuestion(id, form);
    }

    @DeleteMapping("/api/questions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable String id) {
        questionService.deleteQuestion(id);
    }

    @GetMapping("/api/questions/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionByCategory(category);
    }

    @GetMapping("/api/questions/difficulty/{difficulty}")
    public List<Question> getQuestionsByDifficulty(@PathVariable String difficulty) {
        return questionService.getQuestionsByDifficulty(difficulty);
    }

    @GetMapping("/api/questions/random")
    public List<Question> getRandomQuestions(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String difficulty,
            @RequestParam(defaultValue = "10") int count) {
        return questionService.getRandomQuestions(category, difficulty, count);
    }
}
