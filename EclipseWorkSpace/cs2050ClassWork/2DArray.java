public class 2DArray {
    public static void main(String[] args) {
        // Declare a 2D array of integers with 2 rows and 3 columns
        int[][] simpleGrid = new int[2][3];

        // Placing values into the 2D array
        simpleGrid[0][0] = 10; 
        simpleGrid[0][1] = 20; 
        simpleGrid[0][2] = 30; 

        simpleGrid[1][0] = 40; 
        simpleGrid[1][1] = 50; 
        simpleGrid[1][2] = 60; 

        // Iterating the 2D array
        for (int row = 0; row < simpleGrid.length; row++) { //Iterates through each row
            for (int col = 0; col < simpleGrid[row].length; col++) { //Iterates through each column
                System.out.print(simpleGrid[row][col] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}