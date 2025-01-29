package gr.spyros.arithmetic_bubbles.service;

import gr.spyros.arithmetic_bubbles.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void updateAnswer(Long questionId, int answer) {
        questionRepository.updateAnswer(questionId, answer);
    }
}
