import java.util.ArrayList;

public abstract class Categorizer {

	ArrayList<Integer> in;
	ArrayList<Integer> out;
	String name;

	public Categorizer() {
		this.in = new ArrayList<Integer>();
		this.out = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getAllIn() {
		return in;
	}

	public ArrayList<Integer> getAllOut() {
		return out;
	}

	public double getInPercentage() {
		return (double) in.size() / (in.size() + out.size());
	}

	public void displaySummary() {
		System.out.println("Percent of numbers that are " + this.name + ": " + getInPercentage());
		System.out.println(this.name + " numbers: " + getAllIn());
		System.out.println("Other numbers: " + getAllOut());
	}

	public abstract void addNumber(int number);
}
// removed duplication in displaySummary to this abstract class by creating
// field "name" for each kind of Categorizer.
