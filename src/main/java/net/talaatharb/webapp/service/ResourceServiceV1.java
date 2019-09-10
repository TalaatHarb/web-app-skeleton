package net.talaatharb.webapp.service;

import java.util.List;

import net.talaatharb.webapp.controller.dto.ResourceDtoV1;

/**
 * An interface for performing resource related tasks in the back-end
 * @author mharb
 *
 */
public interface ResourceServiceV1 {
	/**
	 * Method to create a resource
	 * 
	 * @param resourceDto The resource to create
	 * @return The created resource
	 */
	public ResourceDtoV1 createResource(final ResourceDtoV1 resourceDto);

	/**
	 * Method to delete a resource
	 * 
	 * @param id The ID of the resource to be deleted
	 */
	public void deleteResource(final Long id);

	/**
	 * Method to get all resources
	 * 
	 * @param name
	 * 
	 * @return List of all resources
	 */
	public List<ResourceDtoV1> getAllResources(final String name);

	/**
	 * Method to get a resource given its ID
	 * 
	 * @param id ID of the resource to get
	 * @return The resource to get if it is available
	 */
	public ResourceDtoV1 getResource(final Long id);

	/**
	 * Method to update a resource
	 * 
	 * @param id          The ID of the resource to update
	 * @param resourceDto The resource to update
	 * @return The updated resource
	 */
	public ResourceDtoV1 updateResource(final Long id, final ResourceDtoV1 resourceDto);
}
