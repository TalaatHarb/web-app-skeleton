package net.talaatharb.webapp.controller.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResourceDtoV1 {

	/**
	 * List of strings to represent the data of this resource
	 */
	private List<String> data;

	/**
	 * ID of the resource
	 */
	private Long id;

	/**
	 * A string to represent the name of the resource
	 */
	private String name;
}
