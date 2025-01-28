package gr.spyros.arithmetic_bubbles.mapper;

import gr.spyros.arithmetic_bubbles.dto.ExerciseDto;
import gr.spyros.arithmetic_bubbles.model.Exercise;
import gr.spyros.arithmetic_bubbles.model.Question;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper {
    private final QuestionMapper questionMapper;

    public ExerciseMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    public ExerciseDto convertToDto(Exercise exercise) {
        if (exercise == null)
            return null;

        ExerciseDto dto = new ExerciseDto();
        dto.setId(exercise.getId());
        dto.setDateCreated(exercise.getDateCreated());
        dto.setDateFinished(exercise.getDateFinished());
        for (Question question : exercise.getQuestions()) {
            dto.getQuestions().add(questionMapper.convertToDto(question));
        }

        return dto;
    }
}
