package gr.spyros.arithmetic_bubbles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExerciseFeedback {
    private long id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateFinished;

    @JsonProperty("questions")
    private List<QuestionFeedback> questionFeedbackList = new ArrayList<>();

    private int numberOfQuestions;
    private int numberOfCorrectAnswers;
    private int numberOfIncorrectAnswers;
    private float percentageCorrect;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(LocalDateTime dateFinished) {
        this.dateFinished = dateFinished;
    }

    public List<QuestionFeedback> getQuestionFeedbackList() {
        return questionFeedbackList;
    }

    public void setQuestionFeedbackList(List<QuestionFeedback> questionFeedbackList) {
        this.questionFeedbackList = questionFeedbackList;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public void setNumberOfCorrectAnswers(int numberOfCorrectAnswers) {
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
    }

    public int getNumberOfIncorrectAnswers() {
        return numberOfIncorrectAnswers;
    }

    public void setNumberOfIncorrectAnswers(int numberOfIncorrectAnswers) {
        this.numberOfIncorrectAnswers = numberOfIncorrectAnswers;
    }

    public float getPercentageCorrect() {
        return percentageCorrect;
    }

    public void setPercentageCorrect(float percentageCorrect) {
        this.percentageCorrect = percentageCorrect;
    }
}
