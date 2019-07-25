package net.talaatharb.webapp.repository;

import java.util.List;
import java.util.Optional;

import net.talaatharb.webapp.domain.Resource;

public interface ResourceRepository {
	/**
	 * Gets all the resources
	 * 
	 * @return List of all the resources
	 */
	public abstract List<Resource> findAll();

	/**
	 * Get a resource by its ID if it exist
	 * 
	 * @param id ID of the resource to find
	 * @return An optional containing the resource if it exists
	 */
	public abstract Optional<Resource> findById(final Long id);

	/**
	 * Save a resource to the repository
	 * 
	 * @param resource The resource to save
	 */
	public abstract Resource save(final Resource resource);
}
