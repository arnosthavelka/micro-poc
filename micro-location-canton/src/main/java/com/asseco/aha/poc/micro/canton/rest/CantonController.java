package com.asseco.aha.poc.micro.canton.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asseco.aha.poc.micro.canton.persistence.domain.Canton;
import com.asseco.aha.poc.micro.canton.service.CantonService;

@RestController
@RequestMapping("/district")
public class CantonController {

	@Autowired
	private CantonService service;

	@Autowired
	private CantonResourceAssembler assembler;

	/**
	 * Find all cantons filtered by name, codes or both. The data are sorted by the name.
	 * 
	 * Example URLs:
	 * <ul>
	 * <li>all data - http://localhost:8090/canton/</li>
	 * <li>Just "XYZ" district - http://localhost:8090/canton/?name=p&districtCode=CZ010</li>
	 * </ul>
	 * 
	 * @return instance <code>Resources&lt;DistrictResource&gt;</code> with all resources of found entities
	 *         <code>District</code>.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/hal+json" })
	public Resources<CantonResource> findAll(String name, String csuCode, String plateCode) {
		List<Canton> data = service.findAll(name, csuCode, plateCode);

		List<CantonResource> resources = assembler.toResources(data);
		return new Resources<CantonResource>(resources, linkTo(CantonController.class).withSelfRel());
	}

	/**
	 * Find district by its ID.
	 * 
	 * @param id
	 *            ID of desired canton
	 * @return instance of <code>CantonResource</code>
	 */
	@RequestMapping(value = "/{id}/", method = RequestMethod.GET, produces = { "application/hal+json" })
	public CantonResource item(@PathVariable long id) {
		return assembler.toResource(service.getItem(id));
	}
}
