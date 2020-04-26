import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * QuizTester class has an ID, a "search" string, and a list of quizzes.
 * QuizTester can "take" any given quiz by checking if its search string is
 * contained within a question prompt. QuizTester stores its scores on each quiz
 * in a HashMap. QuizTester can then return its average score on all of its
 * quizzes.
 *
 * @author eckelsjd. Created Sep 29, 2018.
 */
public class QuizTester {

	private int id;
	private String searchString;
	private HashMap<Integer, Double> quizScores;
	private double averageScore;
	private ArrayList<Quiz> quizzes;

	public QuizTester(int testerId, String search) {
		this.id = testerId;
		this.searchString = search;
		this.quizScores = new HashMap<Integer, Double>();
		this.averageScore = 0.0;
		this.quizzes = new ArrayList<Quiz>();
	}

	/**
	 * 
	 * Returns Id of the QuizTester
	 *
	 * @return QuizTester ID
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * Gets all the quizzes stored in the QuizTester
	 *
	 * @return List of Quiz objects
	 */
	public ArrayList<Quiz> getQuizzes() {
		return this.quizzes;
	}

	/**
	 * 
	 * Adds new quiz to QuizTester.
	 *
	 * @param quiz
	 */
	public void addQuiz(Quiz quiz) {
		this.quizzes.add(quiz);
	}

	/**
	 * 
	 * Iterates through every question in the given quiz. "Answers" each
	 * question by checking if the question prompt contains the QuizTester's
	 * search String. If the prompt does contain the search string, then
	 * QuizTester answers "true" ; if not, then QuizTester answers "false."
	 * Totals up the correct answers and stores the QuizTester's score on the
	 * quiz in a HashMap with the given Quiz ID.
	 *
	 * @param quizId
	 */
	public void takeQuiz(int quizId) {
		for (Quiz quiz : this.quizzes) {
			if (quiz.getId() == quizId) {
				Quiz currentQuiz = quiz;
				double rightAnswers = 0.0;
				double totalQuestions = 0.0;
				boolean answer = false;
				ArrayList<Question> currentQuestions = currentQuiz.getQuestions();
				for (Question currentQuestion : currentQuestions) {
					String currentPrompt = currentQuestion.getPrompt();
					if (currentPrompt.contains(this.searchString)) {
						answer = true;
					} else {
						answer = false;
					}

					if (answer == currentQuestion.getAnswer()) {
						rightAnswers++;
					}
					totalQuestions++;
				}
				double score = rightAnswers / totalQuestions;
				this.quizScores.put(currentQuiz.getId(), score);
			}
		}

	}

	/**
	 * 
	 * Finds and returns QuizTester's score on a given quiz.
	 *
	 * @param quizId
	 * @return QuizTester score (double)
	 */
	public double getScore(int quizId) {
		for (Integer id : this.quizScores.keySet()) {
			if (id == quizId) {
				return this.quizScores.get(id);
			}
		}
		return 0.0;
	}

	/**
	 * 
	 * Calculates and stores QuizTester's average score on all of the quizzes it
	 * contains.
	 *
	 */
	public void calculateAvergeScore() {
		ArrayList<Integer> quizIds = new ArrayList<Integer>();
		double total = 0.0;
		double n = 0.0;
		for (Quiz quiz : this.quizzes) {
			quizIds.add(quiz.getId());
		}
		for (int currentId : quizIds) {
			this.takeQuiz(currentId);
		}
		for (Integer id : this.quizScores.keySet()) {
			total += this.quizScores.get(id);
			n++;
		}
		this.averageScore = total / n;
	}

	/**
	 * 
	 * Returns QuizTester's average score on its quizzes.
	 *
	 * @return Average Score (double)
	 */
	public double getAverageScore() {
		return this.averageScore;
	}
}
