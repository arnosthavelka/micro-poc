package com.asseco.aha.poc.micro.district.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asseco.aha.poc.micro.district.persistence.domain.District;
import com.asseco.aha.poc.micro.district.service.DistrictService;

@RestController
@RequestMapping("/district")
public class DistrictController {

	@Autowired
	private DistrictService service;

	@Autowired
	private DistrictResourceAssembler assembler;

	/**
	 * Find all districts filtered by name, codes or both. The data are sorted by the name.
	 * 
	 * Example URLs: http://localhost:8090/district/
	 * 
	 * @return instance <code>Resources&lt;DistrictResource&gt;</code> with all resources of found entities
	 *         <code>District</code>.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/hal+json" })
	public Resources<DistrictResource> findAll(String name, String csuCode, String plateCode) {
		List<District> data = service.findAll(name, csuCode, plateCode);

		List<DistrictResource> resources = assembler.toResources(data);
		return new Resources<DistrictResource>(resources, linkTo(DistrictController.class).withSelfRel());
	}

	@RequestMapping(value = "/{id}/", method = RequestMethod.GET, produces = { "application/hal+json" })
	public DistrictResource item(@PathVariable long id) {
		return assembler.toResource(service.getItem(id));
	}
}
