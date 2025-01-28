package gr.spyros.arithmetic_bubbles.controller;

import gr.spyros.arithmetic_bubbles.service.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/exercise/create")
    public ResponseEntity<?> createExercise() {
        return new ResponseEntity<>(exerciseService.createExercise(), HttpStatus.OK);
    }

    @GetMapping("/exercise/{id}")
    public ResponseEntity<?> getExercise(@PathVariable int id) {
        return new ResponseEntity<>(exerciseService.createExercise(), HttpStatus.OK);
    }
}
