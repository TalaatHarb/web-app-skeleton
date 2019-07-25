package net.talaatharb.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.talaatharb.webapp.controller.dto.ResourceDtoV1;
import net.talaatharb.webapp.controller.dto.Views;
import net.talaatharb.webapp.service.ResourceServiceV1;

@RestController
@RequestMapping(path = "/resources")
@Api(tags = { "Resource" })
public class ResourceController {

	@Autowired
	private ResourceServiceV1 resourceServiceV1;

	/**
	 * Method to create a resource
	 * 
	 * @param resourceDto The resource to create
	 * @return The created resource
	 */
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Views.Detail.class)
	@ApiOperation(value = "Create a resource")
	public ResourceDtoV1 createResource(@RequestBody final ResourceDtoV1 resourceDto) {
		return resourceServiceV1.createResource(resourceDto);
	}

	/**
	 * Method to delete a resource
	 * 
	 * @param id The ID of the resource to be deleted
	 */
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete a resource")
	public void deleteResource(@PathVariable final Long id) {
		resourceServiceV1.deleteResource(id);
	}

	/**
	 * Method to get all resources
	 * 
	 * @return List of all resources
	 */
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@JsonView(Views.Basic.class)
	@ApiOperation(value = "Get all resources")
	public List<ResourceDtoV1> getAllResources() {
		return resourceServiceV1.getAllResources();
	}

	/**
	 * Method to get a resource given its ID
	 * 
	 * @param ID of the resource to get
	 * @return The resource to get if it is available
	 */
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@JsonView(Views.Detail.class)
	@ApiOperation(value = "Get a resource")
	public ResourceDtoV1 getResource(@PathVariable final Long id) {
		return resourceServiceV1.getResource(id);
	}

	/**
	 * Method to update a resource
	 * 
	 * @param id          The ID of the resource to update
	 * @param resourceDto The resource to update
	 * @return The updated resource
	 */
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@JsonView(Views.Detail.class)
	@ApiOperation(value = "Upadte a resource")
	public ResourceDtoV1 updateResource(@PathVariable final Long id, @RequestBody final ResourceDtoV1 resourceDto) {
		return resourceServiceV1.updateResource(id, resourceDto);
	}

}
