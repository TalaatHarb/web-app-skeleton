package net.talaatharb.webapp.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Resource {

	/**
	 * List of strings to represent the data of this resource
	 */
	@ElementCollection
	private List<String> data;

	/**
	 * ID of the resource
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * A string to represent the name of the resource
	 */
	private String name;
}
