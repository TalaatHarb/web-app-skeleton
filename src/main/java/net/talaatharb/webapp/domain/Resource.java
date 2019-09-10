package net.talaatharb.webapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Resource entity
 * @author mharb
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Resource {

	/**
	 * List of strings to represent the data of this resource
	 */
	@ElementCollection
	private List<String> data = new ArrayList<>();

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
