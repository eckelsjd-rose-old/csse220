

public class FoodCookies implements Food {
	
	public int num;
	
	public FoodCookies(int num) {
		this.num = num;
	}

	@Override
	public void prepare() {
		System.out.println("mixing flour, sugar, butter, and chocolate chips to make dough");
	}
	
	@Override
	public void bake() {
		// I can make 2 dozen at a time
		// and I don't mind a few extra
		int baked = 0;
		while(baked < num) {
			System.out.println("baked 24 cookies");
			baked += 24;
		}
	}
	
}
