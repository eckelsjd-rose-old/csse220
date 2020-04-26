import java.util.ArrayList;

public class UMLpractice {
	
	public class OtherExample {
		private String name;
		
	}
	
	public class Example {
		private int accessCount;
		private ArrayList<OtherExample> test;
		
		private int increaseAccessCount() {
			return accessCount;
		}
	}
}