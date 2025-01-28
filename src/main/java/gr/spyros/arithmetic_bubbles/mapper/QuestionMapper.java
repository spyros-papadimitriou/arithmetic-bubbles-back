package gr.spyros.arithmetic_bubbles.mapper;

import gr.spyros.arithmetic_bubbles.dto.QuestionDto;
import gr.spyros.arithmetic_bubbles.model.Answer;
import gr.spyros.arithmetic_bubbles.model.Member;
import gr.spyros.arithmetic_bubbles.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {
    private final MemberMapper memberMapper;
    private final AnswerMapper answerMapper;

    public QuestionMapper(MemberMapper memberMapper, AnswerMapper answerMapper) {
        this.memberMapper = memberMapper;
        this.answerMapper = answerMapper;
    }

    public QuestionDto convertToDto(Question question) {
        if (question == null)
            return null;

        QuestionDto dto = new QuestionDto();
        dto.setId(question.getId());

        for (Member member : question.getMembers()) {
            dto.getMembers().add(memberMapper.convertToDto(member));
        }

        for (Answer answer : question.getAnswers()) {
            dto.getAnswers().add(answerMapper.convertToDto(answer));
        }

        return dto;
    }
}
