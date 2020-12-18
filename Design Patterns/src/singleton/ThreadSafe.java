package singleton;

public class ThreadSafe {

	public static void main(String[] args) {
		ThreadSafeInit threadSafeInit = ThreadSafeInit.getInstance();
		System.out.println(threadSafeInit);
		ThreadSafeInit threadSafeInit1 = ThreadSafeInit.getInstance();
		System.out.println(threadSafeInit1);
	}
}

class ThreadSafeInit {
	private String name;

	private static ThreadSafeInit threadSafeInit;

	private ThreadSafeInit() {
		name = "tarun";
	}

	public static synchronized ThreadSafeInit getInstance() {
		if (threadSafeInit == null) {
			threadSafeInit = new ThreadSafeInit();
		}
		return threadSafeInit;
	}
}