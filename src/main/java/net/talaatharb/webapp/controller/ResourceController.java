package net.talaatharb.webapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.talaatharb.webapp.bootstrap.Bootstrap;
import net.talaatharb.webapp.domain.Resource;

@RestController
public class ResourceController {

	/**
	 * Method to get all resources
	 * 
	 * @return List of all resources
	 */
	@GetMapping(path = "/resources")
	public List<Resource> getAll() {
		return Bootstrap.getInstance().getResourceRepository().findAll();
	}

}
