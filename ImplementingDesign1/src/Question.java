/**
 * 
 * This class stores a question ID along with the data for that question.
 * Question data is a string containing the question itself. This class can
 * update a question, return the question data, or return the question ID.
 *
 * 
 */
public class Question {

	private int id;
	private String data;

	public Question(int id, String data) {
		this.id = id;
		this.data = data;
	}

	/**
	 * 
	 * Updates question data to the provided parameter.
	 *
	 * @param data
	 */
	public void update(String data) {
		this.data = data;
	}

	/**
	 * 
	 * Returns the question ID.
	 *
	 * @return the question ID.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * Returns the data stored in the question.
	 *
	 * @return question data.
	 */
	public String getData() {
		return this.data;
	}
}
