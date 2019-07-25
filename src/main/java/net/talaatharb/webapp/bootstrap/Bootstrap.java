package net.talaatharb.webapp.bootstrap;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.talaatharb.webapp.domain.Resource;
import net.talaatharb.webapp.repository.ResourceRepository;

@Component
public class Bootstrap implements CommandLineRunner {

	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public void run(String... args) {

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
