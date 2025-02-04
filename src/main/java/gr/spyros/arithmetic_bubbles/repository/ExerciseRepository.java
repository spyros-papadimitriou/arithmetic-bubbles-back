package gr.spyros.arithmetic_bubbles.repository;

import gr.spyros.arithmetic_bubbles.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    @Modifying
    @Query("update Exercise set dateFinished = :dateFinished where id = :id")
    void updateDateFinished(@Param("id") Long exerciseId, @Param("dateFinished") LocalDateTime dateFinished);
}
