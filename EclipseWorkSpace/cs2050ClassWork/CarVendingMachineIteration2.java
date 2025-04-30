import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CarVendingMachineIteration2 {

	public static void main(String[] args) {
		CarVendingMachine vendingMachine = new CarVendingMachine(5, 5); 
		Scanner input = new Scanner(System.in);

		int choice;
		do {
			displayMenu();
			System.out.print("Enter your choice: ");
			choice = input.nextInt();
			input.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				try {
					System.out.print("Enter the filename: ");
					String filename = input.nextLine();
					loadCarsFromFile(vendingMachine, filename);
				} catch (FileNotFoundException e) {
					System.err.println("Error: File not found: " + e.getMessage());
				}
				break;
			case 2:
				vendingMachine.displayCarStorage();
				break;
			case 3:
				System.out.print("Enter floor: ");
				int floor = input.nextInt();
				System.out.print("Enter space: ");
				int space = input.nextInt();
				input.nextLine(); 
				Car retrievedCar = vendingMachine.retrieveCarByLocation(floor, space);
                if (retrievedCar != null) {
                    System.out.println("Retrieved car: " + retrievedCar);
                } else {
                    System.out.println("No car found at that location.");
                }
				break;
			case 4:
				vendingMachine.sortByPrice();
				vendingMachine.displayCarStorage();
				break;
			case 5:
				vendingMachine.sortByYear();
				vendingMachine.displayCarStorage();
				break;
			case 6:
				System.out.print("Enter Manufacturer: ");
			    String manufacturer = input.nextLine();
			    System.out.print("Enter car type (Basic, Premium): ");
			    String carType = input.nextLine();
			    vendingMachine.searchCars(manufacturer, carType);
			    break;
			case 7:
				System.out.print("Enter floor: ");
                int floor1 = input.nextInt();
                System.out.print("Enter space: ");
                int space1 = input.nextInt();
                input.nextLine(); 
                Car queueCar = vendingMachine.retrieveCarByLocation(floor1, space1);
                if (queueCar != null) {
                    System.out.println("Car retrieved: " + queueCar);
                    vendingMachine.addCarToWashQueue(floor1, space1);
                    System.out.println(" Car added to the queue");
                } else {
                    System.out.println("No car found at that location.");
                }
				break;
			case 8:
				vendingMachine.processCarWashQueue();
				break;
			case 9:
				System.out.print("Enter floor of the car to sell: ");
                int sellFloor = input.nextInt();
                System.out.print("Enter space of the car to sell: ");
                int sellSpace = input.nextInt();
                input.nextLine();
                vendingMachine.sellCar(sellFloor, sellSpace);
				break;
			case 10:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
			System.out.println(); // Add a newline for better readability
		} while (choice != 10);

		input.close();
	}

	// Method to display the menu
	public static void displayMenu() {
		System.out.println("=== Car Vending Machine Menu ===");
		System.out.println("1. Load Car Data from File");
		System.out.println("2. Display Vending Machine");
		System.out.println("3. Retrieve a Car by Location (Floor & Space)");
		System.out.println("4. Print Sorted Inventory (Price)");
		System.out.println("5. Print Sorted Inventory (Year)");
		System.out.println("6. Search for Cars (Manufacturer & Type)");
		System.out.println("7. Add Car to Wash Queue");
		System.out.println("8. Process Car Wash Queue");
		System.out.println("9. Sell a Car");
		System.out.println("10. Exit");
	}

	// Method to load cars from a file
	public static void loadCarsFromFile(CarVendingMachine vendingMachine, String filename) throws FileNotFoundException {
		File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String carType = scanner.next();
            int carFloor = scanner.nextInt();
            int carSpace = scanner.nextInt();
            int carYear = scanner.nextInt();
            double carPrice = scanner.nextDouble();
            String carMake = scanner.next();
            String carModel = scanner.next();

            Car car;
            if ("B".equalsIgnoreCase(carType)) {
                car = new BasicCar(carMake, carModel, carYear, carPrice, carFloor, carSpace, "Basic");
            } else if ("P".equalsIgnoreCase(carType)) {
                car = new PremiumCar(carMake, carModel, carYear, carPrice, carFloor, carSpace, "Premium");
            } else {
                System.out.println("Unknown car type: " + carType);
                continue;
            }

            vendingMachine.addCarToTower(carFloor, carSpace, car);
        }
        scanner.close();
	}

	public static class CarVendingMachine {
		private int numFloor;
		private int numSpace;

		LinkedList<Car> Tower = new LinkedList<>();
		Map<String, Car> Storage = new HashMap<>();
		Queue<Car> carWashQueue = new LinkedList<>();

		// Constructor
		public CarVendingMachine(int numFloor, int numSpace) {
			this.numFloor = numFloor;
			this.numSpace = numSpace;
		}

		// Method to add a car to the tower
		public void addCarToTower(int carFloor, int carSpace, Car car) {
			//Check if the car is valid
			if (car.getCarFloor() != carFloor || car.getCarSpace() != carSpace) {
				System.out.println("Car floor or space does not match");
				return;
			}
			if (Tower.contains(car)) {
				System.out.println("This space is already taken");
				return;
			}
			if (carFloor > numFloor || carSpace > numSpace) {
				System.out.println("Car floor or space is out of bounds");
				return;
			}
			Tower.add(car);
			Storage.put(carFloor + "-" + carSpace, car);
		}

		// Method to display car storage
		public void displayCarStorage() {
			if (Tower.isEmpty()) {
				System.out.println("The vending machine is empty.");
			} else {
				for (Car car : Tower) {
					System.out.println(car.toString() + " (Floor: "+ car.getCarFloor() + ", Space: " + car.getCarSpace() + ")");
				}
			}
		}
		
		// Method to retrieve a car by location
		public Car retrieveCarByLocation(int carFloor, int carSpace) {
            String locationKey = carFloor + "-" + carSpace;
            return Storage.get(locationKey);
        }
		 // Method to search for cars by manufacturer and type
	    public void searchCars(String carManufacturer, String carType) {
	        List<Car> searchResults = new ArrayList<>();
	        for (Car car : Tower) {
	            if (car.getManufacturer().equalsIgnoreCase(carManufacturer) ||
	                   (carType.equalsIgnoreCase("Basic") && car instanceof BasicCar) ||
	                   (carType.equalsIgnoreCase("Premium") && car instanceof PremiumCar)) {
	                searchResults.add(car);
	            }
	        }

	        if (searchResults.isEmpty()) {
	            System.out.println("No cars found matching the criteria.");
	            return;
	        }

	        // Sort the search results by car model
	        Collections.sort(searchResults, Comparator.comparing(Car::getModel));

	        System.out.println();
	        for (Car car : searchResults) {
	            System.out.println(car);
	        }
	    }
	    
	    // Method to add a car to the wash queue
        public void addCarToWashQueue(int carFloor, int carSpace) {
            Car car = retrieveCarByLocation(carFloor, carSpace);
            if (car != null) {
                carWashQueue.add(car);
                System.out.println("Car added to wash queue.");
            } else {
                System.out.println("No car found at that location.");
            }
        }
        
     // Method to process car wash queue
        public void processCarWashQueue() {
            if (carWashQueue.isEmpty()) {
                System.out.println("The car wash queue is empty.");
            } else {
                System.out.println("Processing Car Wash Queue:");
                while (!carWashQueue.isEmpty()) {
                    Car car = carWashQueue.poll();
                    System.out.println("Washing: " + car.toString() + " (Floor: " + car.getCarFloor() + ", Space: " + car.getCarSpace() + ")");
                }
            }
        }
        public void sellCar(int carFloor, int carSpace) {
            String locationKey = carFloor + "-" + carSpace;
            Car car = Storage.get(locationKey);

            if (car != null) {
                Tower.remove(car);
                Storage.remove(locationKey);
                System.out.println("Car Sold: " + car.toString() + " (Floor: " + car.getCarFloor() + ", Space: " + car.getCarSpace() + ")");
            } else {
                System.out.println("No car found at Floor: " + carFloor + " Space: " + carSpace);
            }
        }

		// Method to sort cars in the tower by year
		public void sortByYear() {
			Tower.sort(Comparator.comparingInt(Car::getYear));
		}

		// Method to sort cars in the tower by price
		public void sortByPrice() {
			Tower.sort(Comparator.comparingDouble(Car::getPrice));
		}

		public int getNumFloor() {
			return numFloor;
		}

		public int getNumSpace() {
			return numSpace;
		}
	}

	public abstract static class Car {
		private String carMake;
		private String carModel;
		private int carYear;
		private int carFloor;
		private int carSpace;
		private double carPrice;

		// Constructor
		public Car(String carMake, String carModel, int carYear, double carPrice, int carFloor, int carSpace) {
			this.carMake = carMake;
			this.carModel = carModel;
			this.carYear = carYear;
			this.carPrice = carPrice;
			this.carFloor = carFloor;
			this.carSpace = carSpace;
		}

		// Getters for the instance variables
		public int getYear() {
			return carYear;
		}

		public int getCarFloor() {
			return carFloor;
		}

		public int getCarSpace() {
			return carSpace;
		}

		public double getPrice() {
			return carPrice;
		}

		public String getManufacturer() {
			return carMake;
		}

		public String getModel() {
			return carModel;
		}

		// toString method to represent the object as a string
		@Override
		public String toString() {
			return carMake + " " + carModel + " " + 
					carYear + " $"+ carPrice;
		}
	}

	// Concrete Sub-Class BasicCar
	public static class BasicCar extends Car {
		private String essentialCar;

		//Constructor for the BasicCar class
		public BasicCar(String carMake, String carModel, int carYear, double carPrice, int carFloor, int carSpace, String essentialCar) {
			super(carMake, carModel, carYear, carPrice, carFloor, carSpace);
			this.essentialCar = essentialCar;
		}

		//Getter for the essentialCar instance variable
		public String getEssential() {
			return essentialCar;
		}

		//toString method to represent the object as a string
		@Override
		public String toString() {
			return "Basic Car:" + " " +super.toString();
		}
	}

	// Concrete Sub-Class PremiumCar
	public static class PremiumCar extends Car {
		private String deluxeCar;

		//Constructor for the PremiumCar class
		public PremiumCar(String carMake, String carModel, int carYear, double carPrice, int carFloor, int carSpace, String deluxeCar) {
			super(carMake, carModel, carYear, carPrice, carFloor, carSpace);
			this.deluxeCar = deluxeCar;
		}

		//Getter for the deluxeCar instance variable
		public String getDeluxe() {
			return deluxeCar;
		}

		//toString method to represent the object as a string
		@Override
		public String toString() {
			return "Premium Car:" + " " +super.toString();
		}
	}
}
