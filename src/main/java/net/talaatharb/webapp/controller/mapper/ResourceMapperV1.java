package net.talaatharb.webapp.controller.mapper;

import org.springframework.stereotype.Component;

import net.talaatharb.webapp.controller.dto.ResourceDtoV1;
import net.talaatharb.webapp.domain.Resource;

/**
 * An implementation of a mapper for resources
 * @author mharb
 *
 */
@Component
public class ResourceMapperV1 implements EntityMapper<Resource, ResourceDtoV1> {

	@Override
	public ResourceDtoV1 toDto(final Resource entity) {
		final ResourceDtoV1 dto = new ResourceDtoV1();
		dto.setData(entity.getData());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	public Resource toEntity(final ResourceDtoV1 dto) {
		final Resource entity = new Resource();
		entity.setData(dto.getData());
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

}
