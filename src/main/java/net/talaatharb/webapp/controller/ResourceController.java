package net.talaatharb.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.talaatharb.webapp.domain.Resource;
import net.talaatharb.webapp.repository.ResourceRepository;

@RestController
public class ResourceController {

	@Autowired
	private ResourceRepository resourceRepository;

	/**
	 * Method to get all resources
	 * 
	 * @return List of all resources
	 */
	@GetMapping(path = "/resources")
	public List<Resource> getAll() {
		return resourceRepository.findAll();
	}

}
