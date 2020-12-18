package solid;

/**
 * LSP - if class A is a subtype of class B, then we should be able to replace B
 * with A without disrupting the behavior of our program.
 * 
 * @author Tarun Vishnoi
 *
 */
public class LiskovSubstitutionPrinciple {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(5, 5);
		getArea(rectangle);

		// violated of Liskov substitution
		Rectangle square = new Square();
		square.setWidth(5);
		getArea(square);
	}

	static void getArea(Rectangle rectangle) {
		int width = rectangle.getWidth();
		rectangle.setHeight(10);
		System.out.println("Expected area -> " + (width * 10) + " but actually got -> " + rectangle.getArea());
	}
}

class Rectangle {
	public int height, width;

	public Rectangle() {
	}

	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getArea() {
		return width * height;
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}

}

class Square extends Rectangle {

	public Square(int size) {
		height = width = size;
	}

	public Square() {
	}

	// violated of Liskov substitution
	@Override
	public void setHeight(int height) {
		super.setHeight(height);
		super.setWidth(height);
	}

	@Override
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}

}