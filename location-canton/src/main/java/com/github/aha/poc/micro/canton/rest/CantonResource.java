package com.github.aha.poc.micro.canton.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;

import com.github.aha.poc.micro.canton.persistence.domain.Canton;

public class CantonResource extends Resource<Canton> {


	public CantonResource(Canton entity) {
		super(entity, linkTo(methodOn(CantonController.class).item(entity.getCsuCode())).withSelfRel());
	}
}
