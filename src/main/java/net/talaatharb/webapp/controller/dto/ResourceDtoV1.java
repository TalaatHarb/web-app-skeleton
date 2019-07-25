package net.talaatharb.webapp.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Resource", description = "Resource DTO")
public class ResourceDtoV1 {

	/**
	 * List of strings to represent the data of this resource
	 */
	@JsonView(Views.Detail.class)
	private List<String> data;

	/**
	 * ID of the resource
	 */
	@JsonView(Views.Basic.class)
	private Long id;

	/**
	 * A string to represent the name of the resource
	 */
	@JsonView(Views.Basic.class)
	private String name;
}
