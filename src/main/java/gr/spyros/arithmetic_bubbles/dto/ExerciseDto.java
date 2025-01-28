package gr.spyros.arithmetic_bubbles.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDto {
    private long id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateFinished;

    private List<QuestionDto> questions = new ArrayList<>();

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

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public LocalDateTime getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(LocalDateTime dateFinished) {
        this.dateFinished = dateFinished;
    }


}
