package ch.wiss.quizbackend.service;

import  ch.wiss.quizbackend.model.Question;
import  ch.wiss.quizbackend.repository.QuestionRepository;
import  org.springframework.stereotype.Service;
import ch.wiss.quizbackend.dto.QuestionFormDTO;
import ch.wiss.quizbackend.mapper.QuestionMapper;
import java.util.UUID;

import java.util.List;

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
        return questionRepository.findById(id).orElse(null);
    }

    public Question createQuestion(QuestionFormDTO form) {
        String id = UUID.randomUUID().toString();
        Question question = QuestionMapper.toEntity(id, form);
        return questionRepository.save(question);
    }

    public Question updateQuestion(String id, QuestionFormDTO form) {
        Question question = QuestionMapper.toEntity(id, form);
        return questionRepository.save(question);
    }

    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }

}
