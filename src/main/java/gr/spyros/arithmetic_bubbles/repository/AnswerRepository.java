package gr.spyros.arithmetic_bubbles.repository;

import gr.spyros.arithmetic_bubbles.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
