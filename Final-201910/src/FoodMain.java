

import java.util.ArrayList;

public class FoodMain {

	private ArrayList<Food> orders;
	
	public FoodMain() {
		orders = new ArrayList<>();
		setupOrders();
	}

	public void setupOrders() {
		// you should not need to change this function
		orders.add(new FoodPizza("pepperoni"));
		orders.add(new FoodCookies(100));
		orders.add(new FoodPizza("olive"));
		orders.add(new FoodPizza("mushroom"));
		orders.add(new FoodSouffle());
	}
	
	public void makeAllOrders() {
		while(!orders.isEmpty()) {
			Food order = orders.remove(0);
			order.prepare();
			order.bake();
		}
	}
	
	public static void main(String[] args) {
		FoodMain main = new FoodMain();
		main.makeAllOrders();
	}
}
