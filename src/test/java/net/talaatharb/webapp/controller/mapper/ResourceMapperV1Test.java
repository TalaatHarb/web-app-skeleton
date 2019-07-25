package net.talaatharb.webapp.controller.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import net.talaatharb.webapp.controller.dto.ResourceDtoV1;
import net.talaatharb.webapp.domain.Resource;

public class ResourceMapperV1Test {

	private static final Random RANDOM = new Random();

	private ResourceDtoV1 dto;

	private List<ResourceDtoV1> dtos;

	private List<Resource> entities;

	private Resource entity;

	private EntityMapper<Resource, ResourceDtoV1> resourceMapperV1;

	/**
	 * Assert equal entity and DTO
	 * 
	 * @param entity Entity to assert
	 * @param dto    DTO to assert
	 */
	private void assertEqualEntityDto(final Resource entity, final ResourceDtoV1 dto) {
		if (entity == null) {
			assertThat(dto).isNull();
		}

		if (entity.getId() == null) {
			assertThat(dto.getId()).isNull();
		} else {
			assertThat(entity.getId()).isSameAs(dto.getId());
		}

		if (entity.getName() == null) {
			assertThat(dto.getName()).isNull();
		} else {
			assertThat(entity.getName()).isSameAs(dto.getName());
		}

		assertThat(entity.getData()).isNotNull();
		assertThat(dto.getData()).isNotNull();
		assertThat(dto.getData()).hasSameSizeAs(entity.getData());
		assertThat(dto.getData()).hasSameElementsAs(entity.getData());
	}

	@Before
	public void setup() {
		resourceMapperV1 = new ResourceMapperV1();

		entity = new Resource();
		entity.setId(RANDOM.nextLong());
		entity.setName(RANDOM.nextLong() + "");
		entity.setData(Arrays.asList(RANDOM.nextLong() + "", RANDOM.nextLong() + ""));

		dto = new ResourceDtoV1();
		dto.setId(RANDOM.nextLong());
		dto.setName(RANDOM.nextLong() + "");
		dto.setData(Arrays.asList(RANDOM.nextLong() + "", RANDOM.nextLong() + ""));

		entities = Arrays.asList(entity, new Resource());
		dtos = Arrays.asList(dto, new ResourceDtoV1());
	}

	@Test
	public void testToDto() {
		final ResourceDtoV1 resultDto = resourceMapperV1.toDto(entity);
		assertEqualEntityDto(entity, resultDto);
	}

	@Test
	public void testToDtoList() {
		final List<ResourceDtoV1> resultDtos = resourceMapperV1.toDto(entities);
		for (int i = 0; i < entities.size(); i++) {
			assertEqualEntityDto(entities.get(i), resultDtos.get(i));
		}
	}

	@Test
	public void testToEntity() {
		final Resource resultEntity = resourceMapperV1.toEntity(dto);
		assertEqualEntityDto(resultEntity, dto);
	}

	@Test
	public void testToEntityList() {
		final List<Resource> resultEntities = resourceMapperV1.toEnity(dtos);
		for (int i = 0; i < dtos.size(); i++) {
			assertEqualEntityDto(resultEntities.get(i), dtos.get(i));
		}
	}

}
