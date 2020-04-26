import java.util.ArrayList;

/**
 * 
 * This class is used to store a list of questions under a quiz ID.
 *
 * 
 */
public class Quiz {

	private int id;
	private ArrayList<Question> questions;

	public Quiz(int id, ArrayList<Question> questions) {
		this.id = id;
		this.questions = questions;
	}

	/**
	 * 
	 * Returns the ID of the quiz.
	 *
	 * @return the ID of the quiz
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * Returns an array list of all the questions stored in the quiz.
	 *
	 * @return the questions stored in the quiz
	 */
	public ArrayList<Question> getQuestions() {
		return this.questions;
	}
}
