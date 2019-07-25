package net.talaatharb.webapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.talaatharb.webapp.domain.Resource;

public class ResourceRepositoryImpl implements ResourceRepository {

	private static final ResourceRepository INSTANCE = new ResourceRepositoryImpl();

	public static final synchronized ResourceRepository getInstance() {
		return INSTANCE;
	}

	/**
	 * Resources stored as a list
	 */
	private final List<Resource> resources;

	/**
	 * No arguments constructor for the repository
	 */
	private ResourceRepositoryImpl() {
		resources = new ArrayList<>();
	}

	@Override
	public List<Resource> findAll() {
		return resources;
	}

	@Override
	public Optional<Resource> findById(final Long id) {
		if (id == null) {
			return Optional.empty();
		}
		return resources.stream().filter(resource -> (id.equals(resource.getId()))).findFirst();
	}

	@Override
	public Resource save(final Resource resource) {
		resource.setId((long) (resources.size() + 1));
		resources.add(resource);
		return resource;
	}

}
