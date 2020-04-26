/**
 * 
 * Question class has a Question ID, a correct answer (true or false), and a
 * prompt that specifies the question itself in string format. Can return any of
 * its fields. Can update the answer and prompt of the given question.
 *
 * @author eckelsjd. Created Sep 29, 2018.
 */
public class Question {

	private int id;
	private boolean answer;
	private String prompt;

	public Question(int questionid, boolean answer, String prompt) {
		this.id = questionid;
		this.answer = answer;
		this.prompt = prompt;
	}

	/**
	 * 
	 * Returns the prompt of the question, (the question itself).
	 *
	 * @return Question Prompt (String)
	 */
	public String getPrompt() {
		return this.prompt;
	}

	/**
	 * 
	 * Returns Question ID
	 *
	 * @return Question ID (int)
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * Returns the answer of a question
	 *
	 * @return Question answer (boolean)
	 */
	public boolean getAnswer() {
		return this.answer;
	}

	/**
	 * 
	 * Changes the answer and prompt of a question to new values
	 *
	 * @param answer
	 * @param prompt
	 */
	public void update(boolean answer, String prompt) {
		this.answer = answer;
		this.prompt = prompt;
	}
}
