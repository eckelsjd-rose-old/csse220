

public class FoodPizza implements Food {

	String topping;
	
	public FoodPizza(String topping) {
		this.topping = topping;
	}

	@Override
	public void prepare() {
		System.out.println("mixing flour and water to make dough");
		System.out.println("adding tomato sauce, cheese, and " + topping);
	}
	
	@Override
	public void bake() {
		System.out.println("baked 1 " + topping + " pizza!");
	}
}
