package ch.wiss.quizbackend.service;

import ch.wiss.quizbackend.dto.QuestionFormDTO;
import ch.wiss.quizbackend.exception.QuestionNotFoundException;
import ch.wiss.quizbackend.mapper.QuestionMapper;
import ch.wiss.quizbackend.model.Question;
import ch.wiss.quizbackend.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(String id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException(id));
    }

    public Question createQuestion(QuestionFormDTO form) {
        String id = UUID.randomUUID().toString();
        Question question = QuestionMapper.toEntity(id, form);
        return questionRepository.save(question);
    }

    public Question updateQuestion(String id, QuestionFormDTO form) {
        if (!questionRepository.existsById(id)) {
            throw new QuestionNotFoundException(id);
        }

        Question question = QuestionMapper.toEntity(id, form);
        return questionRepository.save(question);
    }

    public void deleteQuestion(String id) {
        if (!questionRepository.existsById(id)) {
            throw new QuestionNotFoundException(id);
        }
        questionRepository.deleteById(id);
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public List<Question> getQuestionsByDifficulty(String difficulty) {
        return questionRepository.findByDifficulty(difficulty);
    }

    public List<Question> getRandomQuestions(String category, String difficulty, int count) {
        List<Question> pool;

        if (category != null && difficulty != null) {
            pool = questionRepository.findByCategoryAndDifficulty(category, difficulty);
        } else if (category != null) {
            pool = questionRepository.findByCategory(category);
        } else if (difficulty != null) {
            pool = questionRepository.findByDifficulty(difficulty);
        } else {
            pool = questionRepository.findAll();
        }

        List<Question> shuffledPool = new ArrayList<>(pool);
        Collections.shuffle(shuffledPool);
        return shuffledPool.stream().limit(count).toList();
    }
}
