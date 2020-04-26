import java.util.ArrayList;

public class Team {

	private String teamName;
	private ArrayList<Double> teamGrades;
	private ArrayList<Student> students;

	/**
	 * 
	 * Constructs a Team object with the given name; initializes fields to a
	 * blank value
	 *
	 * @param teamName
	 */
	public Team(String teamName) {
		this.teamName = teamName;
		this.students = new ArrayList<>();
		this.teamGrades = new ArrayList<>();
	}

	/**
	 * 
	 * Adds each student in an Array List to the team
	 *
	 * @param newStudents
	 *            (ArrayList)
	 */
	public void addStudents(ArrayList<Student> newStudents) {
		if (newStudents.size() == 0) {
			return;
		}
		for (Student student : newStudents) {
			this.students.add(student);
		}
	}

	/**
	 * 
	 * Gets the name for the team
	 *
	 * @return the name of the team (String)
	 */
	public String getName() {
		return this.teamName;
	}

	/**
	 * 
	 * Takes in a double value for a grade and gives that grade to each of the
	 * students in the team
	 *
	 * @param grade
	 *            (double)
	 */
	public void addGrades(double grade) {
		this.teamGrades.add(grade);
		for (Student student : this.students) {
			student.addGrade(grade);
		}
	}

	/**
	 * 
	 * Calculates the value of the team average grade, (not the average grade of
	 * each student in the team, but the overall team average.)
	 *
	 * @return the average team grade (double)
	 */
	public double getTeamAverage() {
		double sum = 0.0;
		for (double grade : this.teamGrades) {
			sum = sum + grade;
		}
		if (sum == 0.0) {
			return 0.0;
		}
		return sum / this.teamGrades.size();
	}
}
