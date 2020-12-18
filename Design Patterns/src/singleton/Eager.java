package singleton;

public class Eager {

	public static void main(String[] args) {
		EagerInit eagerInit1 = EagerInit.getInstance();
		System.out.println(eagerInit1);
		EagerInit eagerInit = EagerInit.getInstance();
		System.out.println(eagerInit);
	}
}

class EagerInit {
	private String name;

	private static EagerInit EAGER_INIT = new EagerInit();

	private EagerInit() {
		name = "tarun";
	}

	public static EagerInit getInstance() {
		return EAGER_INIT;
	}
}
