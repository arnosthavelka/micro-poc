package com.asseco.aha.poc.micro.district.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;

import com.asseco.aha.poc.micro.district.domain.District;

public class DistrictResource extends Resource<District> {

	public DistrictResource(District entity) {
		super(entity, linkTo(methodOn(DistrictController.class).listAll()).withSelfRel(), linkTo(
				DistrictController.class).slash(entity.getId()).withRel("delete"));
	}
}
