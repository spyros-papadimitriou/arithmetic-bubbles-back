package gr.spyros.arithmetic_bubbles.service;

import gr.spyros.arithmetic_bubbles.dto.AnswersSubmission;
import gr.spyros.arithmetic_bubbles.dto.ExerciseFeedback;
import gr.spyros.arithmetic_bubbles.dto.QuestionFeedback;
import gr.spyros.arithmetic_bubbles.exception.AnswersSubmissionException;
import gr.spyros.arithmetic_bubbles.model.Answer;
import gr.spyros.arithmetic_bubbles.model.Exercise;
import gr.spyros.arithmetic_bubbles.model.Question;
import gr.spyros.arithmetic_bubbles.repository.AnswerRepository;
import gr.spyros.arithmetic_bubbles.repository.ExerciseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final ExerciseRepository exerciseRepository;
    private final AnswerRepository answerRepository;

    public AnswerService(ExerciseRepository exerciseRepository, AnswerRepository answerRepository) {
        this.exerciseRepository = exerciseRepository;
        this.answerRepository = answerRepository;
    }

    @Transactional
    public ExerciseFeedback validateAnswers(AnswersSubmission answersSubmission) throws AnswersSubmissionException {
        Exercise exercise = exerciseRepository.findById(answersSubmission.getExerciseId()).orElseThrow((() -> new AnswersSubmissionException("Μη έγκυρη άσκηση.")));
        if (answersSubmission.getAnswers().size() < exercise.getQuestions().size()) {
            throw new AnswersSubmissionException("Δεν έχετε στείλει αρκετές απαντήσεις!");
        } else if (answersSubmission.getAnswers().size() > exercise.getQuestions().size()) {
            throw new AnswersSubmissionException("Έχετε στείλει παραπάνω απαντήσεις!");
        }

        ExerciseFeedback exerciseFeedback = new ExerciseFeedback();

        int numberOfAnswers = answersSubmission.getAnswers().size();
        int numberOfCorrectAnswers = 0;
        int numberOfIncorrectAnswers = 0;

        for (int i = 0; i < numberOfAnswers; i++) {
            Question question = exercise.getQuestions().get(i);
            Long answerGivenId = answersSubmission.getAnswers().get(i);
            Answer answerGiven = answerRepository.findById(answerGivenId).orElseThrow(() -> new AnswersSubmissionException("Δόθηκε μη έγκυρη απάντηση."));

            QuestionFeedback questionFeedback = new QuestionFeedback();
            questionFeedback.setId(question.getId());
            questionFeedback.setAnswerGiven(answerGiven.getResult());

            Answer correctAnswer = question.getAnswers().stream().filter(Answer::isCorrect).findFirst().orElse(new Answer());
            questionFeedback.setAnswerCorrect(correctAnswer.getResult());

            if (answerGivenId.equals(correctAnswer.getId())) {
                questionFeedback.setCorrect(true);
                numberOfCorrectAnswers++;
            } else {
                questionFeedback.setCorrect(false);
                numberOfIncorrectAnswers++;
            }

            exerciseFeedback.getQuestionFeedbackList().add(questionFeedback);
        }
        exerciseFeedback.setId(exercise.getId());
        exerciseFeedback.setDateCreated(exercise.getDateCreated());
        exerciseFeedback.setNumberOfCorrectAnswers(numberOfCorrectAnswers);
        exerciseFeedback.setNumberOfIncorrectAnswers(numberOfIncorrectAnswers);
        exerciseFeedback.setNumberOfQuestions(numberOfAnswers);
        exerciseFeedback.setPercentageCorrect((float) (100 * numberOfCorrectAnswers) / numberOfAnswers);

        return exerciseFeedback;
    }
}
