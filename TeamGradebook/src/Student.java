import java.util.ArrayList;

public class Student {
	private String name;
	private ArrayList<Double> grades;
	private int absenceCount;

	/**
	 * makes a new student object
	 * 
	 * @param newName
	 *            the name of the student
	 */
	public Student(String newName) {
		// TODO: initialize fields here
		this.name = newName;
		this.absenceCount = 0;
		this.grades = new ArrayList<>();
	}

	/**
	 * gets the name of the student
	 * 
	 * @return the name of the student
	 */
	public String getName() {
		// TODO your code here
		return this.name;
	}

	/**
	 * Increases the amount of absences of a student by 1
	 * 
	 * @return none
	 */
	public void handleAbsence() {
		this.absenceCount += 1;
	}

	/**
	 * @return the absence count of a student
	 */
	public int handleGetAbsences() {
		return this.absenceCount;
	}

	/**
	 * 
	 * adds a grade under the Student's name (in their "grades" field)
	 *
	 * @param grade
	 * @return none
	 */
	public void addGrade(double grade) {
		this.grades.add(grade);
	}

	/**
	 * 
	 * calculates the average grade of the student
	 *
	 * @return the average grade of the student
	 */
	public double getAverage() {
		double sum = 0;
		if (this.grades.size() == 0) {
			return 0.0;
		}
		for (double grade : this.grades) {
			sum = sum + grade;
		}
		if (sum == 0.0) {
			return 0.0;
		}
		return sum / this.grades.size();
	}
}
