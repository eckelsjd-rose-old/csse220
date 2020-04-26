public class IsOddCategorizer extends Categorizer {

	public IsOddCategorizer() {
		super();
		this.name = "Odd";
	}

	@Override
	public void addNumber(int number) {
		if (number % 2 == 1) {
			this.in.add(number);
		} else {
			this.out.add(number);
		}
	}
}
