package gr.spyros.arithmetic_bubbles.repository;

import gr.spyros.arithmetic_bubbles.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
