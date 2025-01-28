package gr.spyros.arithmetic_bubbles.dto;

import java.util.List;

public class AnswersSubmission {
    private long exerciseId;
    private List<Long> answers;

    public long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public List<Long> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Long> answers) {
        this.answers = answers;
    }
}
