package net.talaatharb.webapp.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Resource data transfer object
 * @author mharb
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "Resource", description = "Resource DTO")
public class ResourceDtoV1 {

	/**
	 * List of strings to represent the data of this resource
	 */
	@JsonView(Views.Detail.class)
	private List<String> data = new ArrayList<>();

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
