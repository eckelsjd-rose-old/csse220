
public class PolyPractice {

	public static interface Plastic {
		void methodA();
	}

	public static class Gold implements Plastic {
		public void methodA() {
			System.out.println("GoldA");
		}

		public void methodC() {
			System.out.println("GoldC");
		}
	}

	public static class Silver extends Gold {
		public void methodA() {
			System.out.println("SilverA");
			methodB();
		}

		public void methodB() {
			System.out.println("SilverB");
		}
	}

	public static class Bronze extends Silver {
		private Plastic plastic;

		public void methodB() {
			System.out.println("BronzeB");
		}
	}

	public static void main(String[] args) {
		Gold x = new Silver();
		Silver x2 = new Bronze();
		
	}
}
