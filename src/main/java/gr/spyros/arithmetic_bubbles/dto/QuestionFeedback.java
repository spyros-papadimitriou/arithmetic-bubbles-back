package gr.spyros.arithmetic_bubbles.dto;

public class QuestionFeedback {
    private long id;
    private int answerGiven;
    private int answerCorrect;
    private boolean correct;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAnswerGiven() {
        return answerGiven;
    }

    public void setAnswerGiven(int answerGiven) {
        this.answerGiven = answerGiven;
    }

    public int getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(int answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
