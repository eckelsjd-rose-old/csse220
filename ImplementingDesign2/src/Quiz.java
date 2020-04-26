import java.util.ArrayList;

/**
 * 
 * Quiz class has an ID and stores a list of questions. Can return its questions
 * or ID. Can add new questions.
 *
 * @author eckelsjd. Created Sep 29, 2018.
 */
public class Quiz {

	private int id;
	private ArrayList<Question> questions;

	public Quiz(int quizid) {
		this.id = quizid;
		this.questions = new ArrayList<Question>();
	}

	/**
	 * 
	 * Adds a new question to the quiz.
	 *
	 * @param question
	 */
	public void addQuestion(Question question) {
		this.questions.add(question);
	}

	/**
	 * 
	 * Returns all questions contained within the quiz.
	 *
	 * @return List of questions
	 */
	public ArrayList<Question> getQuestions() {
		return this.questions;
	}

	/**
	 * 
	 * Gets ID of the quiz
	 *
	 * @return Quiz ID
	 */
	public int getId() {
		return this.id;
	}
}
