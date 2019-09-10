package net.talaatharb.webapp.controller;

import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.talaatharb.webapp.controller.dto.ResourceDtoV1;
import net.talaatharb.webapp.domain.Resource;
import net.talaatharb.webapp.repository.ResourceRepository;

/**
 * Tests for the resource controller class
 * @author mharb
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ResourceControllerTest {

	private static final String DELETE_RESOURCE = "/2";
	private static final String GET_UPDATE_RESOURCE = "/1";
	private static final String NON_EXISTING = "/1000";
	private static final String RESOURCE_URL = "/resources";
	private static final String SEARCH_TERM = "next";

	private ResourceDtoV1 createdResource;

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ResourceRepository resourceRepository;

	private ResourceDtoV1 updatedResource;

	/**
	 * Setup method for the tests
	 */
	@Before
	public void setup() {
		// Create some resources and save them in the database
		final Resource r1 = new Resource();
		r1.setData(Arrays.asList("one", "two", "three"));
		r1.setName("first three");

		resourceRepository.save(r1);

		final Resource r2 = new Resource();
		r2.setData(Arrays.asList("Four", "Five", "Six"));
		r2.setName("Next three");

		resourceRepository.save(r2);

		// Create resources for the tests
		createdResource = new ResourceDtoV1();
		createdResource.setData(Arrays.asList("Seven", "Eight", "Nine"));
		createdResource.setName("The three after that");

		updatedResource = new ResourceDtoV1();
		updatedResource.setData(Arrays.asList("One", "Two", "Three"));
		updatedResource.setName("First three");

	}

	/**
	 * Testing the creation of resources
	 * @throws Exception It throws exception in case of test unable to perform request
	 */
	@Test
	public void testCreateResource() throws Exception {
		final ResultActions result = mvc
				.perform(MockMvcRequestBuilders.post(RESOURCE_URL).contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(createdResource)));

		result.andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());
	}

	/**
	 * Testing the creation of a resource in case of invalid data
	 * @throws Exception It throws exception in case of test unable to perform request
	 */
	@Test
	public void testCreateResourceInvalidData() throws Exception {
		ResultActions result = mvc.perform(MockMvcRequestBuilders.post(RESOURCE_URL)
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(null)));

		result.andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(MockMvcResultHandlers.print());
	}

	/**
	 * Testing deletion of a resource
	 * @throws Exception It throws exception in case of test unable to perform request
	 */
	@Test
	public void testDeleteResource() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.delete(RESOURCE_URL + DELETE_RESOURCE));

		result.andExpect(MockMvcResultMatchers.status().isNoContent()).andDo(MockMvcResultHandlers.print());
	}

	/**
	 * Testing getting a list of all the resources
	 * @throws Exception It throws exception in case of test unable to perform request
	 */
	@Test
	public void testGetAllResources() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.get(RESOURCE_URL));

		result.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()", Matchers.greaterThan(1)))
				.andDo(MockMvcResultHandlers.print());
	}

	/**
	 * Testing getting all the resources with parameter filters
	 * @throws Exception It throws exception in case of test unable to perform request
	 */
	@Test
	public void testGetAllResourcesWithParameters() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.get(RESOURCE_URL).param("name", SEARCH_TERM));

		result.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()", CoreMatchers.is(1)))
				.andDo(MockMvcResultHandlers.print());
	}

	/**
	 * Testing getting a single resource
	 * @throws Exception It throws exception in case of test unable to perform request
	 */
	@Test
	public void testGetResource() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.get(RESOURCE_URL + GET_UPDATE_RESOURCE));

		result.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	/**
	 * Testing getting a non existing resource
	 * @throws Exception It throws exception in case of test unable to perform request
	 */
	@Test
	public void testGetResourceNonExisting() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.get(RESOURCE_URL + NON_EXISTING));

		result.andExpect(MockMvcResultMatchers.status().isNotFound()).andDo(MockMvcResultHandlers.print());
	}

	/**
	 * Testing updating an existing resource
	 * @throws Exception It throws exception in case of test unable to perform request
	 */
	@Test
	public void testUpdateResource() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.put(RESOURCE_URL + GET_UPDATE_RESOURCE)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(updatedResource)));

		result.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	/**
	 * Testing updating a resource with invalid data
	 * @throws Exception It throws exception in case of test unable to perform request
	 */
	@Test
	public void testUpdateResourceInvalidData() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.put(RESOURCE_URL + GET_UPDATE_RESOURCE)
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(null)));

		result.andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(MockMvcResultHandlers.print());
	}

}
