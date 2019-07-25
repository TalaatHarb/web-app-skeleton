package net.talaatharb.webapp.domain;

import java.util.List;

public class Resource {

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

	public List<String> getData() {
		return data;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", name=" + name + ", data=" + data + "]";
	}
}
