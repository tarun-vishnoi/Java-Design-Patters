package adapter;

public class AdapterTest {
	public static void main(String[] args) {
		Sparrow sparrow = new Sparrow();
		sparrow.fly();
		sparrow.makeSound();
		ToyDuck toyDuck = new PlasticToyDuck();
		toyDuck.squeak();
		ToyDuck toyDuck2 = new BirdAdapter(sparrow);
		toyDuck2.squeak();
	}
}

class BirdAdapter implements ToyDuck {
	Bird bird;

	public BirdAdapter(Bird bird) {
		this.bird = bird;
	}

	@Override
	public void squeak() {
		bird.makeSound();
	}
}

interface Bird {
	public void fly();

	public void makeSound();
}

class Sparrow implements Bird {
	@Override
	public void fly() {
		System.out.println("Flying");
	}

	@Override
	public void makeSound() {
		System.out.println("Chirp Chirp");
	}
}

interface ToyDuck {
	public void squeak();
}

class PlasticToyDuck implements ToyDuck {
	@Override
	public void squeak() {
		System.out.println("Squeak");
	}
}