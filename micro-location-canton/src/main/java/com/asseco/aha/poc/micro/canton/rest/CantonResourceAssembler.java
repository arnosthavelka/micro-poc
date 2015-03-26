package com.asseco.aha.poc.micro.canton.rest;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.asseco.aha.poc.micro.canton.persistence.domain.Canton;

@Component
public class CantonResourceAssembler extends ResourceAssemblerSupport<Canton, CantonResource> {

	public CantonResourceAssembler() {
		super(CantonController.class, CantonResource.class);
	}

	@Override
	public CantonResource toResource(Canton entity) {
		return new CantonResource(entity);
	}

}
