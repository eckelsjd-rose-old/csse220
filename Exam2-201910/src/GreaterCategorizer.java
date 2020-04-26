public class GreaterCategorizer extends Categorizer {

	int cutoff;

	public GreaterCategorizer(int cutoff) {
		super();
		this.cutoff = cutoff;
		this.name = ">" + this.cutoff;
	}

	@Override
	public void addNumber(int number) {
		if (number > this.cutoff) {
			this.in.add(number);
		} else {
			this.out.add(number);
		}
	}
}
