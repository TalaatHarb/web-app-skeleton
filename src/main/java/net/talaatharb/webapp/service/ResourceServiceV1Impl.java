package net.talaatharb.webapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import net.talaatharb.webapp.controller.dto.ResourceDtoV1;
import net.talaatharb.webapp.controller.mapper.EntityMapper;
import net.talaatharb.webapp.domain.Resource;
import net.talaatharb.webapp.repository.ResourceRepository;

@Service
public class ResourceServiceV1Impl implements ResourceServiceV1 {

	@Autowired
	private EntityMapper<Resource, ResourceDtoV1> resourceMapperV1;

	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public ResourceDtoV1 createResource(final ResourceDtoV1 resourceDto) {
		if (resourceDto != null && resourceDto.getId() == null) {
			final Resource resource = resourceRepository.save(resourceMapperV1.toEntity(resourceDto));
			return resourceMapperV1.toDto(resource);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have to have a valid resource with no ID");
		}
	}

	@Override
	public void deleteResource(final Long id) {
		resourceRepository.deleteById(id);
	}

	@Override
	public List<ResourceDtoV1> getAllResources(final String name) {
		if (name == null) {
			return resourceMapperV1.toDto(resourceRepository.findAll());
		} else {
			return resourceMapperV1.toDto(resourceRepository.findAllByNameContainingIgnoreCase(name));
		}
	}

	@Override
	public ResourceDtoV1 getResource(final Long id) {
		final Optional<Resource> possibleResource = resourceRepository.findById(id);
		if (possibleResource.isPresent()) {
			return resourceMapperV1.toDto(possibleResource.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@Override
	public ResourceDtoV1 updateResource(final Long id, final ResourceDtoV1 resourceDto) {
		if (resourceDto != null) {
			resourceDto.setId(id);
			final Resource resource = resourceRepository.save(resourceMapperV1.toEntity(resourceDto));
			return resourceMapperV1.toDto(resource);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have to have a valid resource");
		}
	}
}
