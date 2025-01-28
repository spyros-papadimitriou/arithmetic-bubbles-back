package gr.spyros.arithmetic_bubbles.repository;

import gr.spyros.arithmetic_bubbles.model.Operand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperandRepository extends JpaRepository<Operand, Integer> {
}
