import java.util.ArrayList;

/**
 * This class is used to demonstrate a functional design involving Quizzes and
 * Questions which can be updated and displayed
 * 
 */
public class QuizMain {

	private ArrayList<Question> questions;
	private ArrayList<Quiz> quizzes;

	// TODO add instance variables here

	public QuizMain() {
		// TODO In order to demonstrate functionality, please follow the TODOs
		// below
		// You will have to create questions and quizzes when a QuizMain is
		// created
		this.questions = new ArrayList<Question>();
		this.quizzes = new ArrayList<Quiz>();
	}

	public void addQuestion(Question question) {
		this.questions.add(question);
	}

	public void addQuiz(Quiz quiz) {
		this.quizzes.add(quiz);
	}

	// TODO 1 Create five questions (can be silly/basic questions) use id
	// 1,2,3,4,5 ...
	// TODO 2 Create three or more quizzes use id 1,2,3...
	// (One quiz should share at least one question with another )

	public static void main(String[] args) {
		// We want to use instance variables of the QuizMain class so we need to
		// construct a QuizMain object
		QuizMain myQuizSimulator = new QuizMain();

		Question question1 = new Question(1, "What is 1 + 1?");
		Question question2 = new Question(2, "What is 1 - 1?");
		Question question3 = new Question(3, "What is 1 x 1?");
		Question question4 = new Question(4, "What is 1 / 1?");
		Question question5 = new Question(5, "What is the meaning of life?");

		myQuizSimulator.addQuestion(question1);
		myQuizSimulator.addQuestion(question2);
		myQuizSimulator.addQuestion(question3);
		myQuizSimulator.addQuestion(question4);
		myQuizSimulator.addQuestion(question5);

		ArrayList<Question> quiz1Questions = new ArrayList<Question>();
		quiz1Questions.add(question1);
		quiz1Questions.add(question2);
		quiz1Questions.add(question3);

		ArrayList<Question> quiz2Questions = new ArrayList<Question>();
		quiz2Questions.add(question2);
		quiz2Questions.add(question3);
		quiz2Questions.add(question4);

		ArrayList<Question> quiz3Questions = new ArrayList<Question>();
		quiz3Questions.add(question3);
		quiz3Questions.add(question4);
		quiz3Questions.add(question5);

		Quiz quiz1 = new Quiz(1, quiz1Questions);
		Quiz quiz2 = new Quiz(2, quiz2Questions);
		Quiz quiz3 = new Quiz(3, quiz3Questions);

		myQuizSimulator.addQuiz(quiz1);
		myQuizSimulator.addQuiz(quiz2);
		myQuizSimulator.addQuiz(quiz3);

		// TODO 3 Display three or more different quizzes
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more original quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);

		// TODO 4 Change two quiz questions
		// A. (One should be shared with two or more quizzes)
		// B. (One should be unique to one quiz)
		myQuizSimulator.handleUpdateQuizQuestion(1, "What is different 1?");
		myQuizSimulator.handleUpdateQuizQuestion(2, "What is different 2?");

		// TODO 5 Display the same three (or more) quizzes
		// A. One that has a unique question which changed
		// B. Two which share a question that has been changed
		System.out.println("--------------------------------------------------");
		System.out.println("Showing three or more changed quizzes:");
		System.out.println("--------------------------------------------------");
		myQuizSimulator.handleDisplayQuiz(1);
		myQuizSimulator.handleDisplayQuiz(2);
		myQuizSimulator.handleDisplayQuiz(3);

	}

	/**
	 * This method should display a quiz in a very similar fashion to the output
	 * provided in example_output.txt, which is located in your repository
	 * 
	 * 
	 * @param quizId
	 */
	public void handleDisplayQuiz(int quizId) {
		// TODO complete this method
		for (Quiz quiz : this.quizzes) {
			if (quiz.getId() == quizId) {
				System.out.println("Quiz: " + quizId);
				for (Question question : quiz.getQuestions()) {
					System.out.println("  " + "Question[" + question.getId() + "]: " + question.getData());
				}
			}
		}
	}

	/**
	 * 
	 * This method should replace the data in the question with id=questionId
	 * with the new questionData
	 * 
	 * @param questionId
	 * @param questionData
	 */
	public void handleUpdateQuizQuestion(int questionId, String questionData) {
		// TODO complete this method
		for (Question question : this.questions) {
			if (question.getId() == questionId) {
				question.update(questionData);
				return;
			}
		}
		System.out.println("Question: " + questionId + " does not exist yet.");

	}

}
