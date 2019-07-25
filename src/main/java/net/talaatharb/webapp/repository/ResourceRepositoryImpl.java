package net.talaatharb.webapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.talaatharb.webapp.domain.Resource;

public class ResourceRepositoryImpl implements ResourceRepository {

	/**
	 * Resources stored as a list
	 */
	private final List<Resource> resources;

	/**
	 * No arguments constructor for the repository
	 */
	public ResourceRepositoryImpl() {
		resources = new ArrayList<>();
	}

	public List<Resource> findAll() {
		return resources;
	}

	public Optional<Resource> findById(final Long id) {
		if (id == null) {
			return Optional.empty();
		}
		return resources.stream().filter(resource -> (id.equals(resource.getId()))).findFirst();
	}

	public Resource save(final Resource resource) {
		resource.setId((long) (resources.size() + 1));
		resources.add(resource);
		return resource;
	}

}
