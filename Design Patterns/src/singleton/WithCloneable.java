package singleton;

class SuperClass implements Cloneable {
	int i = 10;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Singleton extends SuperClass {
	public static Singleton instance = new Singleton();

	private Singleton() {

	}

	public static Singleton getInstance() {
		return instance;
	}

	/*
	 * override clone() method and throw an exception from clone method that is
	 * CloneNotSupportedException. Now whenever user will try to create clone of
	 * singleton object, it will throw exception and hence our class remains
	 * singleton.
	 * 
	 * if you don't want to throw exception you can also return the same instance
	 * from clone method.
	 */

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// throw new CloneNotSupportedException("Invalid Operation...");
		return instance;
	}
}

public class WithCloneable {

	public static void main(String[] args) throws CloneNotSupportedException {
		Singleton instance1 = Singleton.getInstance();
		System.out.println(instance1);
		Singleton instance2 = (Singleton) instance1.clone();
		System.out.println(instance2);
	}

}