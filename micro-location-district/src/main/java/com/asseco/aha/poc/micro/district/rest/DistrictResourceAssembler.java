package com.asseco.aha.poc.micro.district.rest;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.asseco.aha.poc.micro.district.domain.District;

@Component
public class DistrictResourceAssembler extends ResourceAssemblerSupport<District, DistrictResource> {

	public DistrictResourceAssembler() {
		super(DistrictController.class, DistrictResource.class);
	}

	@Override
	public DistrictResource toResource(District entity) {
		return new DistrictResource(entity);
	}

}
