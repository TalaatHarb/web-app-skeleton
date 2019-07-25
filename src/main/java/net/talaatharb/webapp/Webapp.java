package net.talaatharb.webapp;

import java.util.Arrays;

import net.talaatharb.webapp.domain.Resource;

public class Webapp {

	public static void main(String[] args) {
		System.out.println("Hello, World!");
		final Resource resource = new Resource();
		resource.setData(Arrays.asList("One", "Two", "Three"));
		resource.setId(1L);
		resource.setName("Resource");
		System.out.println(resource);
	}

}
