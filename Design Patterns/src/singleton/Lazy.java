package singleton;

public class Lazy {

	public static void main(String[] args) {
		LazyInit lazyInit1 = LazyInit.getInstance();
		System.out.println(lazyInit1);
		LazyInit lazyInit = LazyInit.getInstance();
		System.out.println(lazyInit);
	}

}

class LazyInit {
	private String name;

	private static LazyInit LAZY_INIT;

	private LazyInit() {
		name = "tarun";
	}

	public static LazyInit getInstance() {
		if (LAZY_INIT == null) {
			LAZY_INIT = new LazyInit();
		}
		return LAZY_INIT;
	}
}