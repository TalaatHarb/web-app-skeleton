package net.talaatharb.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public List<Resource> getAllResources() {
		return resourceRepository.findAll();
	}

	/**
	 * Method to get a resource given its ID
	 * 
	 * @param ID of the resource to get
	 * @return The resource to get if it is available
	 */
	@GetMapping(path = "/resources/{id}")
	public Resource getResource(@PathVariable final Long id) {
		final Optional<Resource> possibleResource = resourceRepository.findById(id);
		if (possibleResource.isPresent()) {
			return possibleResource.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

}
