package net.talaatharb.webapp.bootstrap;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.talaatharb.webapp.domain.Resource;
import net.talaatharb.webapp.repository.ResourceRepository;
import net.talaatharb.webapp.repository.ResourceRepositoryImpl;

@Component
public class Bootstrap implements CommandLineRunner {

	private final ResourceRepository resourceRepository = ResourceRepositoryImpl.getInstance();

	@Override
	public void run(String... args) {

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
