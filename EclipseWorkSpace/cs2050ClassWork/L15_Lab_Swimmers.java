
public class L15_Lab_Swimmers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	interface canSwim {
		void Swimmers();
	}

	abstract class Bird {
		private String type;
		private String name;
		private int speed;

		public abstract void birdFacts();

		public Bird (String type, String name, int speed) {
			this.type = type;	
			this.name = name;
			this.speed = speed;
		}

		public String getType() {
			return type;
		}

		public String getName() {
			return name;
		}

		public int getSpeed() {
			return speed;
		}

	}

	class Duck extends Bird implements canSwim {

		public Duck(String type, String name, int speed) {
			super(type, name, speed);
		}

		@Override
		public void Swimmers() {
		}

		@Override
		public void birdFacts() {
		}

	class Penguin extends Bird implements canSwim {

			public Penguin(String type, String name, int speed) {
				super(type, name, speed);
			}

			@Override
			public void Swimmers() {
			}

			@Override
			public void birdFacts() {
			}
		}

	class Sooty extends Bird implements canSwim {

			public Sooty(String type, String name, int speed) {
				super(type, name, speed);
			}

			@Override
			public void Swimmers() {
			}

			@Override
			public void birdFacts() {
			}
		}

	class Ostrich extends Bird {

			public Ostrich(String type, String name, int speed) {
				super(type, name, speed);
			}

			@Override
			public void birdFacts() {
				System.out.println("")
			}
		}

	}
}
