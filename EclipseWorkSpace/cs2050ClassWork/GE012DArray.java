
public class GE012DArray {

	static class Carz { 
		private String make;  

		public Carz() {  
			this.make = "Unknown";  
		} 
		
	//It will then refer to the created String object and store it on the heap
		public Carz(String make) { 
			this.make = make; 
		} 

		public void printMake() { 
			System.out.print(this.make + " "); 
		} 

	} 

	
	public static void main(String[] args) {
		
	//it will first initialize the 2D Array
		Carz [][] storedCars = new Carz [2][3];

	// Then it will check what is going to be stored in that spot 
	//in array then go to Carz Class
		storedCars[0][0] = new Carz ("Ford");
		storedCars[0][1] = new Carz ("Dodge");
		storedCars[0][2] = new Carz ("Toyota");
		storedCars[1][0] = new Carz ("Hyundai");
		storedCars[1][1] = new Carz ("Chevrolet");
		storedCars[1][2] = new Carz ("Subaru");

	// the nested for loop will iterate through every car and print it out using 
	// the printMake() method in thCarz Class
		for (int row = 0; row < storedCars.length; row++) { 
			for (int column = 0; column < storedCars[row].length; column++) {
				storedCars[row][column].printMake();
			}
			System.out.println();
		}

	}
}
