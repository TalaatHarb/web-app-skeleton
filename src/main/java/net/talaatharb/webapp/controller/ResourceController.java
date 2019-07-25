package net.talaatharb.webapp.controller;

import java.util.List;

import lombok.NoArgsConstructor;
import net.talaatharb.webapp.bootstrap.Bootstrap;
import net.talaatharb.webapp.domain.Resource;

@NoArgsConstructor
public class ResourceController {

	/**
	 * Method to get all resources
	 * 
	 * @return List of all resources
	 */
	public List<Resource> getAll() {
		return Bootstrap.getInstance().getResourceRepository().findAll();
	}

}
