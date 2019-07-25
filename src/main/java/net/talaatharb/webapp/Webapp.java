package net.talaatharb.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.talaatharb.webapp.bootstrap.Bootstrap;

@SpringBootApplication
public class Webapp {

	public static void main(String[] args) {
		Bootstrap.getInstance().run();
		SpringApplication.run(Webapp.class, args);
	}

}
