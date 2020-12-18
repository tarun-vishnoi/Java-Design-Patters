package abstractFactory;

public class AbstractFactoryTest {
	public static void main(String[] args) {
		AbstractFactory abstractFactory1 = FactoryProducer.getFactory(true);
		Shape shape1 = abstractFactory1.getShape("Rectangle");
		shape1.draw();
		Shape shape2 = abstractFactory1.getShape("Square");
		shape2.draw();
		AbstractFactory abstractFactory2 = FactoryProducer.getFactory(false);
		Shape shape3 = abstractFactory2.getShape("Rectangle");
		shape3.draw();
		Shape shape4 = abstractFactory2.getShape("Square");
		shape4.draw();
	}
}

class FactoryProducer {
	public static AbstractFactory getFactory(boolean rounded) {
		if (rounded) {
			return new RoundedShapeFactory();
		} else {
			return new ShapeFactory();
		}
	}
}

interface AbstractFactory {
	Shape getShape(String shapeType);
}

class ShapeFactory implements AbstractFactory {
	@Override
	public Shape getShape(String shapeType) {
		if (shapeType.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("Square")) {
			return new Square();
		}
		return null;
	}
}

class RoundedShapeFactory implements AbstractFactory {
	@Override
	public Shape getShape(String shapeType) {
		if (shapeType.equalsIgnoreCase("Rectangle")) {
			return new RoundedRectangle();
		} else if (shapeType.equalsIgnoreCase("Square")) {
			return new RoundedSquare();
		}
		return null;
	}
}

interface Shape {
	void draw();
}

class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Class -- Rectangle");
	}
}

class Square implements Shape {
	@Override
	public void draw() {
		System.out.println("Class -- Square");
	}
}

class RoundedRectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Class -- RoundedRectangle");
	}
}

class RoundedSquare implements Shape {
	@Override
	public void draw() {
		System.out.println("Class -- RoundedSquare");
	}
}