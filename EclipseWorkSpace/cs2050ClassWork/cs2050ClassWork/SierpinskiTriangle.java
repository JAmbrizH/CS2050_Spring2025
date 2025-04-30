package cs2050ClassWork;

public class SierpinskiTriangle {

	public class MainClass {
		  public static void main(String[] args) {

		    printStars(5);
		  }
		  public static void printStars(int n) {
		     if (n == 0) return;
		     printStars(n - 1);
		     System.out.println(repeat('*',n));
		  } 
		  public static String repeat(char printChar, int times) {
		      if (times == 0) return "";
		      return printChar + repeat(printChar, times - 1);
		  }
		}


}
