package factory;

public class Factory {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape shape = shapeFactory.getShape("triangle");
		shape.draw();
	}

}

class ShapeFactory {
	public Shape getShape(String shape) {
		if (shape.equals("circle")) {
			return new Circle();
		} else if (shape.equals("square")) {
			return new Square();
		} else if (shape.equals("triangle")) {
			return new Triangle();
		} else {
			return null;
		}
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