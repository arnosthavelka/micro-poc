package com.asseco.aha.poc.micro.district.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asseco.aha.poc.micro.district.domain.District;
import com.asseco.aha.poc.micro.district.repository.DistrictRepository;

@RestController
@RequestMapping("/district")
public class DistrictController {

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private DistrictResourceAssembler assembler;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { "application/hal+json" })
	public Resources<DistrictResource> listAll() {
		List<District> data = districtRepository.findAll(new Sort(Sort.Direction.ASC, "name"));

		List<DistrictResource> resources = assembler.toResources(data);
		return new Resources<DistrictResource>(resources, linkTo(DistrictController.class).withSelfRel());
	}
}
