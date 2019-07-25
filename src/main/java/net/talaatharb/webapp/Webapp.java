package net.talaatharb.webapp;

import java.util.List;

import net.talaatharb.webapp.bootstrap.Bootstrap;
import net.talaatharb.webapp.domain.Resource;

public class Webapp {

	public static void main(String[] args) {
		Bootstrap.getInstance().run();
		System.out.println("Hello, World!");

		List<Resource> resources = Bootstrap.getInstance().getResourceRepository().findAll();

		System.out.println(resources);
	}

}
