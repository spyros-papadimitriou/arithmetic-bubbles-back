package gr.spyros.arithmetic_bubbles.mapper;

import gr.spyros.arithmetic_bubbles.dto.AnswerDto;
import gr.spyros.arithmetic_bubbles.model.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {
    public AnswerDto convertToDto(Answer answer) {
        if (answer == null)
            return null;

        AnswerDto dto = new AnswerDto();
        dto.setId(answer.getId());
        dto.setResult(answer.getResult());

        return dto;
    }
}
