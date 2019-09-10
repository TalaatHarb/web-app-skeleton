package net.talaatharb.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.talaatharb.webapp.domain.Resource;

/**
 * Resource repository interface
 * @author mharb
 *
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

	/**
	 * A method to get all resources where the name property partially matches the given name
	 * @param name Name to filter by
	 * @return List of all resources where the name property partially matches the given name
	 */
	public abstract List<Resource> findAllByNameContainingIgnoreCase(final String name);
}
