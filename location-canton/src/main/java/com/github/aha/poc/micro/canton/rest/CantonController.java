package com.github.aha.poc.micro.canton.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.aha.poc.micro.canton.persistence.domain.Canton;
import com.github.aha.poc.micro.canton.service.CantonService;

@RestController
@RequestMapping("/canton")
public class CantonController {

	@Autowired
	private CantonService service;

	@Autowired
	private CantonResourceAssembler assembler;

	/**
	 * Find all cantons filtered by name, codes or both. The data are sorted by the name.
	 * 
	 * Sample URLs:
	 * <ul>
	 * <li>all data - http://localhost:8091/canton/</li>
	 * <li>Just "XYZ" district - http://localhost:8091/canton/?name=p&districtCode=CZ010</li>
	 * </ul>
	 * 
	 * @return instance <code>Resources&lt;DistrictResource&gt;</code> with all resources of found entities
	 *         <code>District</code>.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Resources<CantonResource> findAll(String name, String csuCode, String districtCode) {
		List<Canton> data = service.findAll(name, csuCode, districtCode);

		List<CantonResource> resources = assembler.toResources(data);
		return new Resources<CantonResource>(resources, linkTo(CantonController.class).withSelfRel());
	}

	/**
	 * Find district by its ID.
	 * 
	 * Sample URLs:
	 * <ul>
	 * <li>canton "Praha hlavní město" - http://localhost:8091/canton/CZ0100/</li>
	 * </ul>
	 * 
	 * @param code
	 *            ČSÚ code of desired canton
	 * @return instance of <code>CantonResource</code>
	 */
	@RequestMapping(value = "/{code}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CantonResource item(@PathVariable String code) {
		return assembler.toResource(service.getItem(code));
	}
}
