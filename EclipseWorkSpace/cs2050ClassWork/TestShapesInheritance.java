import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TestShapesInheritance
{

	public static void main(String[] args) throws IOException{
		RectangleFromSimpleGeometricShape rect1 = new RectangleFromSimpleGeometricShape();
		RectangleFromSimpleGeometricShape rect2 = new RectangleFromSimpleGeometricShape();
		RectangleFromSimpleGeometricShape rect3 = new RectangleFromSimpleGeometricShape();

		System.out.println("Rectangle 1 to String: " + rect1.toString());
		System.out.println("The width is " + rect1.getWidth());
		System.out.printf("The height is  %.2f \n", rect1.getHeight());
		System.out.printf("The area is  %.2f \n", rect1.getArea());
		System.out.printf("The perimeter is  %.2f \n", rect1.getPerimeter());

		System.out.println("Rectangle 2 to String: " + rect2.toString());
		System.out.println("The width is " + rect2.getWidth());
		System.out.printf("The height is  %.2f \n", rect2.getHeight());
		System.out.printf("The area is  %.2f \n", rect2.getArea());
		System.out.printf("The perimeter is  %.2f \n", rect2.getPerimeter());

		System.out.println("Rectangle 3 to String: " + rect3.toString());
		System.out.println("The width is " + rect3.getWidth());
		System.out.printf("The height is  %.2f \n", rect3.getHeight());
		System.out.printf("The area is  %.2f \n", rect3.getArea());
		System.out.printf("The perimeter is  %.2f \n", rect3.getPerimeter());
		
		System.out.println("\nNumber of rectangles created: " + RectangleFromSimpleGeometricShape.getrectaCount());
		
		try {
            RectangleFromSimpleGeometricShape.writeRectangleInfoToFile(rect1);
            RectangleFromSimpleGeometricShape.writeRectangleInfoToFile(rect2);
            RectangleFromSimpleGeometricShape.writeRectangleInfoToFile(rect3);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
	}//end main

}//end TestShapeInheritance Class

/**
 * Simple Geometric Shape Superclass
 */
class SimpleGeometricShape {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	

	/**
	 * Construct a default geometric object
	 */
	public SimpleGeometricShape() {
		dateCreated = new java.util.Date();
	}


	/**
	 * Construct a geometric object with the specified color and filled 
	 * @param String color
	 * @param boolean filled
	 */
	public SimpleGeometricShape(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}

	/**
	 * get current color
	 * @return String color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Set new color
	 * @param String color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Since filled is boolean, 
	 *    its get method is named isFilled
	 * get current filled value 
	 * @return boolean filled 
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * Set a new filled
	 * @param boolean filled
	 */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/**
	 * Get dateCreated
	 * @return dateCreated
	 */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}

}//end SimpleGeometricShape class


/**
 * Add comments
 */
class CircleFromSimpleGeometricShape 
extends SimpleGeometricShape {
	private double radius;

	/**
	 * Construct a default circle object
	 */
	public CircleFromSimpleGeometricShape() {
	}

	/**
	 * 
	 * @param radius
	 */
	public CircleFromSimpleGeometricShape(double radius) {
		this.radius = radius;
	}

	public CircleFromSimpleGeometricShape(double radius, 
			String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}


	/**
	 * Get radius
	 * @return double radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 *  Set a new radius
	 * @param double radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * Get Area 
	 * @return double 
	 */
	public double getArea() {
		return radius * radius * Math.PI;
	}

	/**
	 * Get Diameter 
	 * @return double 
	 */
	public double getDiameter() {
		return 2 * radius;
	}

	/**
	 * Get Perimeter 
	 * @return double 
	 */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

}

//end CircleFromSimpleGeometricShape class

/**
 * Add comments
 */
class RectangleFromSimpleGeometricShape 
extends SimpleGeometricShape {
	private double width;
	private double height;
	static int rectaCount = 0;

	/**
	 * counting rectangles
	 */
	static void rectaIncrease () {
		rectaCount++;
	}

	/**
	 * constructing a default rectangle object
	 */
	public RectangleFromSimpleGeometricShape() {
		rectaIncrease();
	}

	/**
	 * @param width
	 * @param height
	 * increases rectangle count
	 */
	public RectangleFromSimpleGeometricShape(double width, double height) {
		this.width = width;
		this.height = height;
		rectaIncrease();
	}

	/**
	 * @param color
	 * @param filled
	 */
	public RectangleFromSimpleGeometricShape(double width, 
			double height, String color, boolean filled) {
		this.width = width;
		this.height = height;
		setColor(color);
		setFilled(filled);
		rectaIncrease();
	}

	public RectangleFromSimpleGeometricShape(int i) {
	}

	/**
	 * @return width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * get Area
	 * @return double
	 */
	public double getArea() {
		return width * height;
	}

	/**
	 * get Perimeter
	 * @return double
	 */
	public double getPerimeter() {
		return 2 * (width + height);
	}

	/**
	 * @return rectangle Count
	 */
	public static double getRectacount() {
		return rectaCount;
	}

	@Override
	public String toString() {
		return "A rectangle with width " + width + " and height " + height + " which is a subclass of " + super.toString();
	}

	/**
	 * @param rect
	 * @throws IOException
	 */
	public static void writeRectangleInfoToFile(RectangleFromSimpleGeometricShape rect) throws IOException {
		File resultFile = new File ("rectangle.txt");
		PrintWriter printResultwriter = new PrintWriter(resultFile);
		printResultwriter.println("Area:" + rect.getArea() + 
				"Perimeter:" + rect.getPerimeter());
		printResultwriter.close();
		System.out.println("\nFile located at" + resultFile.getAbsolutePath());
	}
}

	