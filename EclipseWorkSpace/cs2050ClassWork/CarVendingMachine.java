
public class CarVendingMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class VendingMachine {
		
		Car [][] tower;
		
		public VendingMachine(int floor, int space) {
            tower = new Car[floor][space];
        }
		
		// Method to add a car to a specific location in the vending machine
        public void addCar(Car car, int floor, int space) {
            if (floor >= 0 && floor < tower.length && space >= 0 && space < tower[floor].length) {
                tower[floor][space] = car;
            } else {
                System.out.println("Invalid location. Car not added.");
            }
        }

        // Method to view the car at a specific location
        public void viewLocation(int floor, int space) {
            if (floor >= 0 && floor < tower.length && space >= 0 && space < tower[floor].length) {
                Car car = tower[floor][space];
                if (car != null) {
                    System.out.println("Floor: " + floor + ", Space: " + space + " - " + car.getcarName());
                } else {
                    System.out.println("Floor: " + floor + ", Space: " + space + " - Empty"); // Display if empty
                }
            } else {
                System.out.println("Invalid location.");
            }
        }

        // Method to generate an inventory report
        public void inventoryReport() {
            System.out.println("Inventory Report:");
            for (int i = 0; i < tower.length; i++) {
                for (int j = 0; j < tower[i].length; j++) {
                    viewLocation(i, j); // Reuse viewLocation for the report
                }
            }
        }
        
        
	}
	
	class Car {
		private String carName;
		private String carMake;
		private String carModel;
		private int carYear;
		private double carPrice;
		
		public Car (String carName, String carMake, String carModel, int carYear, double carPrice) {
			this.carName = carName;
			this.carMake = carMake;
			this.carModel = carModel;
			this.carYear = carYear;
			this.carPrice = carPrice;
		}
		
		public String getcarName() {
			return carName;
		}
		public String getcarMake() {
			return carMake;
		}
		public String getcarModel() {
			return carModel;
		}
		public int getcarYear() {
			return carYear;
		}
		public double getcarPrice() {
			return carPrice;
		}
	}
}
