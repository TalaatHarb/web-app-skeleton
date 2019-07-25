package net.talaatharb.webapp.bootstrap;

import java.util.Arrays;

import lombok.Getter;
import net.talaatharb.webapp.domain.Resource;
import net.talaatharb.webapp.repository.ResourceRepository;
import net.talaatharb.webapp.repository.ResourceRepositoryImpl;

@Getter
public class Bootstrap implements Runnable {

	/**
	 * Singleton instance
	 */
	private static final Bootstrap INSTANCE = new Bootstrap();

	/**
	 * Get the singleton instance of this class
	 * 
	 * @return Singleton instance
	 */
	public static final synchronized Bootstrap getInstance() {
		return INSTANCE;
	}

	private final ResourceRepository resourceRepository;

	/**
	 * Private constructor
	 */
	private Bootstrap() {
		resourceRepository = new ResourceRepositoryImpl();
	}

	public void run() {
		System.out.println("Bootstrap");

		// Create some resources
		final Resource r1 = new Resource();
		r1.setData(Arrays.asList("One", "Two", "Three"));
		r1.setName("First three");

		resourceRepository.save(r1);

		final Resource r2 = new Resource();
		r2.setData(Arrays.asList("Four", "Five", "Six"));
		r2.setName("Next three");

		resourceRepository.save(r2);
	}

}
