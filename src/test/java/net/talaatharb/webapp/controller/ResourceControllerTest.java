package net.talaatharb.webapp.controller;

import java.util.Arrays;

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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ResourceControllerTest {

	private static final String DELETE_RESOURCE = "/2";
	private static final String GET_UPDATE_RESOURCE = "/1";
	private static final String NON_EXISTING = "/1000";
	private static final String RESOURCE_URL = "/resources";

	private ResourceDtoV1 createdResource;

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	private ResourceDtoV1 updatedResource;

	@Before
	public void setup() {
		createdResource = new ResourceDtoV1();
		createdResource.setData(Arrays.asList("Seven", "Eight", "Nine"));
		createdResource.setName("The three after that");

		updatedResource = new ResourceDtoV1();
		updatedResource.setData(Arrays.asList("One", "Two", "Three"));
		updatedResource.setName("First three");

	}

	@Test
	public void testCreateResource() throws Exception {
		final ResultActions result = mvc
				.perform(MockMvcRequestBuilders.post(RESOURCE_URL).contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(createdResource)));

		result.andExpect(MockMvcResultMatchers.status().isCreated()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testCreateResourceInvalidData() throws Exception {
		ResultActions result = mvc.perform(MockMvcRequestBuilders.post(RESOURCE_URL)
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(null)));

		result.andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testDeleteResource() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.delete(RESOURCE_URL + DELETE_RESOURCE));

		result.andExpect(MockMvcResultMatchers.status().isNoContent()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testGetAllResources() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.get(RESOURCE_URL));

		result.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testGetResource() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.get(RESOURCE_URL + GET_UPDATE_RESOURCE));

		result.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testGetResourceNonExisting() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.get(RESOURCE_URL + NON_EXISTING));

		result.andExpect(MockMvcResultMatchers.status().isNotFound()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testUpdateResource() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.put(RESOURCE_URL + GET_UPDATE_RESOURCE)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(updatedResource)));

		result.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testUpdateResourceInvalidData() throws Exception {
		final ResultActions result = mvc.perform(MockMvcRequestBuilders.put(RESOURCE_URL + GET_UPDATE_RESOURCE)
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(null)));

		result.andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(MockMvcResultHandlers.print());
	}

}
