package singleton;

public class StaticBlock {

	public static void main(String[] args) {
		StaticBlockInit staticBlockInit1 = StaticBlockInit.getInstance();
		System.out.println(staticBlockInit1);
		StaticBlockInit staticBlockInit = StaticBlockInit.getInstance();
		System.out.println(staticBlockInit);
	}
}

class StaticBlockInit {
	private String name;

	private static StaticBlockInit staticBlockInit;

	private StaticBlockInit() {
		name = "tarun";
	}

	static {
		staticBlockInit = new StaticBlockInit();
	}

	public static StaticBlockInit getInstance() {
		return staticBlockInit;
	}
}