package gr.spyros.arithmetic_bubbles.repository;

import gr.spyros.arithmetic_bubbles.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Modifying
    @Query("update Question set answerGiven = :answer where id = :id")
    void updateAnswer(@Param("id") Long questionId, @Param("answer") int answer);
}
