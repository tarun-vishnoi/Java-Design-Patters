package prototype;

import java.util.HashMap;
import java.util.Map;

public class Prototype {
	public static void main(String[] args) throws CloneNotSupportedException {
		ShapeStore.getShape("Circle").addColor();
		ShapeStore.getShape("Square").addColor();
		ShapeStore.getShape("Triangle").addColor();
	}
}

class ShapeStore {
	private static Map<String, Shape> map = new HashMap<String, Shape>();
	static {
		map.put("Circle", new Circle());
		map.put("Square", new Square());
		map.put("Triangle", new Triangle());
	}

	public static Shape getShape(String shape) throws CloneNotSupportedException {
		return (Shape) map.get(shape).clone();
	}
}

abstract class Shape implements Cloneable {
	protected String shape;

	abstract void addColor();

	@Override
	public Object clone() throws CloneNotSupportedException {
		Object clone = super.clone();
		return clone;
	}
}

class Circle extends Shape {
	public Circle() {
		this.shape = "Circle";
	}

	@Override
	void addColor() {
		System.out.println("Blue Color added to Circle");
	}
}

class Square extends Shape {
	public Square() {
		this.shape = "Square";
	}

	@Override
	void addColor() {
		System.out.println("Red Color added to Square");
	}
}

class Triangle extends Shape {
	public Triangle() {
		this.shape = "Triangle";
	}

	@Override
	void addColor() {
		System.out.println("Black Color added to Triangle");
	}
}
