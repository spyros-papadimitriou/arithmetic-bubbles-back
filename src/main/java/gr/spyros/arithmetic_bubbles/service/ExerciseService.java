package gr.spyros.arithmetic_bubbles.service;

import gr.spyros.arithmetic_bubbles.dto.ExerciseDto;
import gr.spyros.arithmetic_bubbles.mapper.ExerciseMapper;
import gr.spyros.arithmetic_bubbles.model.Answer;
import gr.spyros.arithmetic_bubbles.model.Exercise;
import gr.spyros.arithmetic_bubbles.model.Member;
import gr.spyros.arithmetic_bubbles.model.Question;
import gr.spyros.arithmetic_bubbles.repository.ExerciseRepository;
import gr.spyros.arithmetic_bubbles.repository.OperandRepository;
import gr.spyros.arithmetic_bubbles.utils.NumberUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;
    private final OperandRepository operandRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, ExerciseMapper exerciseMapper, OperandRepository operandRepository) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseMapper = exerciseMapper;
        this.operandRepository = operandRepository;
    }

    public ExerciseDto findById(long id) {
        return exerciseMapper.convertToDto(exerciseRepository.findById(id).orElse(null));
    }

    public ExerciseDto createExercise() {
        Exercise exercise = new Exercise();
        exercise.setDateCreated(LocalDateTime.now());

        for (int j = 0; j < 5; j++) {
            Question question = new Question();
            question.setExercise(exercise);

            int result = 0;
            for (int i = 0; i < 2; i++) {
                Member member = new Member();
                member.setNum(NumberUtils.getRandomInteger(1, 10));
                member.setQuestion(question);
                question.getMembers().add(member);

                member.setOperand(operandRepository.findById(1).orElse(null));
                result += member.getNum();
            }
            question.setResult(result);

            List<Integer> results = new ArrayList<>();
            results.add(result);
            int correctResult = result;

            for (int i = 0; i < 3; i++) {
                while (results.contains(result)) {
                    result = NumberUtils.getRandomInteger(1, 10);
                }
                results.add(result);
            }
            Collections.shuffle(results);

            for (Integer num : results) {
                Answer answer = new Answer();
                answer.setCorrect(num == correctResult);
                answer.setResult(num);
                answer.setQuestion(question);

                question.getAnswers().add(answer);
            }

            exercise.getQuestions().add(question);
        }

        return exerciseMapper.convertToDto(exerciseRepository.save(exercise));
    }

    public void updateDateFinished(long id, LocalDateTime dateFinished) {
        exerciseRepository.updateDateFinished(id, dateFinished);
    }
}
