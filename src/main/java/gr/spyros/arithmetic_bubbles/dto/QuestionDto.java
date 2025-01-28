package gr.spyros.arithmetic_bubbles.dto;

import gr.spyros.arithmetic_bubbles.model.Answer;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    private long id;
    private List<MemberDto> members = new ArrayList<>();
    private List<AnswerDto> answers = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<MemberDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberDto> members) {
        this.members = members;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}
