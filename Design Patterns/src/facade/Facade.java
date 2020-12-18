package facade;

public class Facade {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawSqaure();
		shapeMaker.drawTriangle();
	}
}

class ShapeMaker {
	private Shape circle;
	private Shape triangle;
	private Shape square;

	public ShapeMaker() {
		circle = new Circle();
		square = new Square();
		triangle = new Triangle();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawTriangle() {
		triangle.draw();
	}

	public void drawSqaure() {
		square.draw();
	}
}

interface Shape {
	void draw();
}

class Circle implements Shape {
	@Override
	public void draw() {
		System.out.println("Class -- Circle");
	}
}

class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Class -- Square");
	}
}

class Triangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Class -- Triangle");
	}
}