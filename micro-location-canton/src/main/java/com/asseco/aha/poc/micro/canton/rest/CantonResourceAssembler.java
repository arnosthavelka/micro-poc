package com.asseco.aha.poc.micro.canton.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.asseco.aha.poc.micro.canton.persistence.domain.Canton;

@Component
public class CantonResourceAssembler extends ResourceAssemblerSupport<Canton, CantonResource> {

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(CantonResourceAssembler.class);

	@Autowired
	private DiscoveryClient dc;

	public CantonResourceAssembler() {
		super(CantonController.class, CantonResource.class);
	}

	@Override
	public CantonResource toResource(final Canton entity) {
		CantonResource cr = new CantonResource(entity);

		dc.getInstances("MICRO-LOCATION-DISTRICT").forEach(
				(ServiceInstance s) -> {
			String distrLink = String.format("%s/district/%s/", s.getUri(), entity.getDistrictCode());
			LOG.debug("Adding district's link: {}", distrLink);
			cr.add(new Link(distrLink).withRel("district"));
		});

		return cr;
	}

}
