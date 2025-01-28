package gr.spyros.arithmetic_bubbles.mapper;

import gr.spyros.arithmetic_bubbles.dto.MemberDto;
import gr.spyros.arithmetic_bubbles.model.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    private final OperandMapper operandMapper;

    public MemberMapper(OperandMapper operandMapper) {
        this.operandMapper = operandMapper;
    }

    public MemberDto convertToDto(Member member) {
        if (member == null)
            return null;

        MemberDto dto = new MemberDto();
        dto.setId(member.getId());
        dto.setNum(member.getNum());
        dto.setOperand(operandMapper.convertToDto(member.getOperand()));

        return dto;
    }
}
