
public class LastnameTestSimpleRectangle {
	static class SimpleRectangle {

		private double length;
		private double width;

		/**
		 * contains getters and setters for width and length
		 */
		public void setWidth(double newWidth) {
			this.width = newWidth;
		}

		public void setLength(double newLength) {
			this.length = newLength;
		}

		/**
		 * @return Area and Perimeter
		 */
		public double getArea() {
			return length * width;
		}

		public double getPerimeter() {
			return 2 * (length * width);
		}

		/**
		 * this is for the non-parameter rectangle
		 */
		public SimpleRectangle() {
			this.length = 1;
			this.width = 1;
		}

		/**
		 * this is making sure that length and width is a positive number for parameter
		 * rectangles
		 */
		public SimpleRectangle(double newLength, double newWidth) {

			if (newLength > 0) {
				this.length = newLength;
			} else {
				this.length = 1;
			}
			if (newWidth > 0) {
				this.width = newWidth;
			} else {
				this.width = 1;
			}
		}
	}

	public static void main(String[] args) {
		SimpleRectangle rectangleP = new SimpleRectangle();
		SimpleRectangle rectangleB = new SimpleRectangle(2, 6);
		SimpleRectangle rectangleC = new SimpleRectangle(5, -2);

		System.out.println("Rectangle A:");
		System.out.println("Area:" + rectangleP.getArea());
		System.out.println("Perimeter:" + rectangleP.getPerimeter());

		System.out.println("Rectangle B:");
		System.out.println("Area:" + rectangleB.getArea());
		System.out.println("Perimeter:" + rectangleB.getPerimeter());

		System.out.println("Rectangle C:");
		System.out.println("Area:" + rectangleC.getArea());
		System.out.println("Perimeter:" + rectangleC.getPerimeter());
	}

}


