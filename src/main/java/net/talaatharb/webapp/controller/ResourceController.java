package net.talaatharb.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import net.talaatharb.webapp.controller.dto.ResourceDtoV1;
import net.talaatharb.webapp.controller.mapper.EntityMapper;
import net.talaatharb.webapp.domain.Resource;
import net.talaatharb.webapp.repository.ResourceRepository;

@RestController
public class ResourceController {

	@Autowired
	private EntityMapper<Resource, ResourceDtoV1> resourceMapperV1;

	@Autowired
	private ResourceRepository resourceRepository;

	/**
	 * Method to get all resources
	 * 
	 * @return List of all resources
	 */
	@GetMapping(path = "/resources")
	public List<ResourceDtoV1> getAllResources() {
		return resourceMapperV1.toDto(resourceRepository.findAll());
	}

	/**
	 * Method to get a resource given its ID
	 * 
	 * @param ID of the resource to get
	 * @return The resource to get if it is available
	 */
	@GetMapping(path = "/resources/{id}")
	public ResourceDtoV1 getResource(@PathVariable final Long id) {
		final Optional<Resource> possibleResource = resourceRepository.findById(id);
		if (possibleResource.isPresent()) {
			return resourceMapperV1.toDto(possibleResource.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

}
