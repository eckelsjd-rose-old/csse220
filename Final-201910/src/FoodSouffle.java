

public class FoodSouffle implements Food {

	public FoodSouffle() {
		// Nothing to do
	}

	@Override
	public void prepare() {
		System.out.println("mixing cream eggs and spices to make souffle");
	}
	
	@Override
	public void bake() {
		// if the souffle doesn't rise I have to
		// make it from scratch again
		while(true) {
			System.out.print("attempting to bake 1 souffle...");
			if(Math.random() < 0.5) {
				System.out.println("success!");
				break;
			} else {
				System.out.println("but it didn't rise");
				prepare();
			}
		}
	}
	
}
