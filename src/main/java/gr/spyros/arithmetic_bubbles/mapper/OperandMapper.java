package gr.spyros.arithmetic_bubbles.mapper;

import gr.spyros.arithmetic_bubbles.dto.OperandDto;
import gr.spyros.arithmetic_bubbles.model.Operand;
import org.springframework.stereotype.Component;

@Component
public class OperandMapper {
    public OperandDto convertToDto(Operand operand) {
        if (operand == null) {
            return null;
        }

        OperandDto dto = new OperandDto();
        dto.setId(operand.getId());
        dto.setName(operand.getName());

        return dto;
    }
}
