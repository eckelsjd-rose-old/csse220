import java.math.BigInteger;

public class IsPrimeCategorizer extends Categorizer {

	public IsPrimeCategorizer() {
		super();
		this.name = "Prime";
	}

	@Override
	public void addNumber(int number) {
		if (BigInteger.valueOf(number).isProbablePrime(15)) {
			this.in.add(number);
		} else {
			this.out.add(number);
		}
	}
}
