package net.talaatharb.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A class for the entry point of the spring boot application
 * @author mharb
 *
 */
@SpringBootApplication
public class Webapp {

	/**
	 * Main entry point of the application
	 * @param args Any command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Webapp.class, args);
	}

}
