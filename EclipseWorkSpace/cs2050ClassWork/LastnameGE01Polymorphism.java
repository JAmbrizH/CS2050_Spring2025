//From Jorge Ambriz - This code is incomplete and full of exception errors


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LastnameGE01Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Animalz[] animals = read[7];
			/**
			 * this Opens the file Animals
			 */
            File inputFile = new File("Animals.txt");
            Scanner fileScanner = new Scanner(inputFile);
            
            /**
			 * This will read the array size
			 */
            int arraySize = fileScanner.nextInt();
            fileScanner.nextLine();

            /**
			 * this will Read and create animal objects
			 */
            for (int i = 0; i < animals.length; i++) {
            	
            	/**
    			 * this reads the animal data
    			 */
                String type = fileScanner.next();
                String name = fileScanner.next();
                String food = fileScanner.next();
                int weight = fileScanner.nextInt();
                int sleep = fileScanner.nextInt();
                String location = fileScanner.next();
                
                /**
                *Create specific animal based on type
                */
                switch (type) {
                    case "Bear":
                        animals[i] = new Bear(name, food, weight, sleep, location);
                        break;
                    case "Elephant":
                        animals[i] = new Elephant(name, food, weight, sleep, location);
                        break;
                    case "Monkey":
                        animals[i] = new Monkey(name, food, weight, sleep, location);
                        break;
                    case "Sloth":
                        animals[i] = new Sloth(name, food, weight, sleep, location);
                        break;
                }
            }

            fileScanner.close();
            
            /**
            * Display animal types and details
            */
            
            for (int i = 0; i < arraySize; i++) {
            	
            	/**
                * Determine animal type using instanceof
                */
            	
                if (animals[i] instanceof Bear) {
                    System.out.println("Animal[" + i + "] is a Bear");
                    
                } else if (animals[i] instanceof Elephant) {
                    System.out.println("Animal[" + i + "] is an Elephant");
                    
                } else if (animals[i] instanceof Monkey) {
                    System.out.println("Animal[" + i + "] is a Monkey");
                    
                } else if (animals[i] instanceof Sloth) {
                    System.out.println("Animal[" + i + "] is a Sloth");
                }

                // Display animal details
                System.out.println(animals[i]);

                // Call methods
                animals[i].eat();
                animals[i].sleep();
                animals[i].swim();
                System.out.println(); // Blank line for readability
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}

/**
 * Superclass
 */

class Animalz {
	private String name;
	private String food;
	private int weight;
	private int sleep;
	private String location;

	public String getName() {
		return name;
	}

	public String getFood() {
		return food;
	}

	public int getWeight() {
		return weight;
	}

	public int getSleep() {
		return sleep;
	}

	public String getLocation() {
		return location;
	}

	public Animalz (String name, String food, int weight, int sleep, String location) {
		this.name = name;
		this.food = food;
		this.weight = weight;
		this.sleep = sleep;
		this.location = location;
	}

	public void eat() {
		System.out.println("Animal is eating");
	}

	public void swim() {
		System.out.println("Animal is swiming");
	}

	public void sleep() {
		System.out.println("Animal is sleeping");
	}

	@Override
	public String toString() {
		return "Name: " + name + 
				", Food: " + food + 
				", Weight: " + weight + 
				", Sleep: " + sleep + 
				", Location: " + location;
	}
}

/**
 * Subclasses
 */
class Bear extends Animalz {

	public Bear (String name, String food, int weight, int sleep, String location) {
		super (name, food, weight, sleep, location);

	}

	@Override
	public void eat() {
		System.out.println("Bear is Eating");
	}

	@Override
	public void swim() {
		System.out.println("Bear is Swimming");
	}

	@Override
	public void sleep() {
		System.out.println("Bear is Sleeping");
	}
}

class Elephant extends Animalz {

	public Elephant (String name, String food, int weight, int sleep, String location) {
		super (name, food, weight, sleep, location);

	}

	@Override
	public void sleep() {
		System.out.println("Elephant is Sleeping");
	}
}
class Monkey extends Animalz {

	public Monkey (String name, String food, int weight, int sleep, String location) {
		super (name, food, weight, sleep, location);

	}

	@Override
	public void eat() {
		System.out.println("Monkey is Eating");
	}

	@Override
	public void swim() {
		System.out.println("Monkey is Swimming");
	}
}

class Sloth extends Animalz {

	public Sloth (String name, String food, int weight, int sleep, String location) {
		super (name, food, weight, sleep, location);

	}
}


