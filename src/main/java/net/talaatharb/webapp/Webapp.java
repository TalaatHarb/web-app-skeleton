package net.talaatharb.webapp;

import net.talaatharb.webapp.bootstrap.Bootstrap;
import net.talaatharb.webapp.controller.ResourceController;

public class Webapp {

	public static void main(String[] args) {
		Bootstrap.getInstance().run();
		
		System.out.println("Hello, World!");

		final ResourceController controller = new ResourceController();

		System.out.println(controller.getAll());
	}

}
