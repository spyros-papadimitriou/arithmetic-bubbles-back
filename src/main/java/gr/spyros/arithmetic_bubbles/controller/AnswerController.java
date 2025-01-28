package gr.spyros.arithmetic_bubbles.controller;

import gr.spyros.arithmetic_bubbles.dto.AnswersSubmission;
import gr.spyros.arithmetic_bubbles.exception.AnswersSubmissionException;
import gr.spyros.arithmetic_bubbles.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/submit-answers")
    public ResponseEntity<?> submitAnswers(@RequestBody AnswersSubmission answersSubmission) {
        try {
            return new ResponseEntity<>(answerService.validateAnswers(answersSubmission), HttpStatus.OK);
        } catch (AnswersSubmissionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
