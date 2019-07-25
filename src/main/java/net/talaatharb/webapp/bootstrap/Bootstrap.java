package net.talaatharb.webapp.bootstrap;

public class Bootstrap implements Runnable {

	/**
	 * Private constructor
	 */
	private Bootstrap() {
	}

	/**
	 * Singleton instance
	 */
	private static final Bootstrap INSTANCE = new Bootstrap();

	/**
	 * Get the singleton instance of this class
	 * @return Singleton instance
	 */
	public static final synchronized Bootstrap getInstance() {
		return INSTANCE;
	}

	public void run() {
		System.out.println("Bootstrap");
	}

}
