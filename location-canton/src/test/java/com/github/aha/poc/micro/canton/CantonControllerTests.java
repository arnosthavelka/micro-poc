package com.github.aha.poc.micro.canton;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.aha.poc.micro.canton.persistence.domain.Canton;
import com.github.aha.poc.micro.canton.rest.CantonController;
import com.github.aha.poc.micro.canton.rest.CantonResource;
import com.github.aha.poc.micro.canton.rest.CantonResourceAssembler;
import com.github.aha.poc.micro.canton.service.CantonService;

/**
 * Tests of canton's rest (controller) layer.
 */
@RunWith(SpringRunner.class)
@RestClientTest(CantonController.class)
@Import(value = CantonResourceAssembler.class)
public class CantonControllerTests {

	/**
	 * Canton's constant for Prague.
	 */
	private static final String CZ0100 = "CZ0100";

	@Autowired
	private CantonController client;

	@MockBean
	private CantonService service;

	@MockBean
	private DiscoveryClient dc;

	private Canton canton;

	@Before
	public void setUp() throws Exception {
		canton = new Canton();
		canton.setCsuCode(CZ0100);
		canton.setDistrictCode("CZ010");
		canton.setName("Praha hlavní město");

		// prepare HTTP request (due to links)
		String localHost = "http://localhost";
		HttpServletRequest httpServletRequestMock = mock(HttpServletRequest.class);
		when(httpServletRequestMock.getRequestURL()).thenReturn(new StringBuffer(localHost));
		when(httpServletRequestMock.getHeaderNames()).thenReturn(Collections.emptyEnumeration());
		when(httpServletRequestMock.getRequestURI()).thenReturn(localHost);
		when(httpServletRequestMock.getContextPath()).thenReturn(StringUtils.EMPTY);
		when(httpServletRequestMock.getServletPath()).thenReturn(StringUtils.EMPTY);
		ServletRequestAttributes servletRequestAttributes = new ServletRequestAttributes(httpServletRequestMock);
		RequestContextHolder.setRequestAttributes(servletRequestAttributes);
	}

	@Test
	public void testFindAll() {
		// prepare service response
		when(this.service.findAll(null, null, null)).thenReturn(Arrays.asList(canton, canton));

		// start testing
		Resources<CantonResource> resources = this.client.findAll(null, null, null);
		// verify resource
		assertThat(resources.getContent().size(), equalTo(2));
		// verify links
		List<Link> links = resources.getLinks();
		assertThat(links.size(), equalTo(1));
		Link link = links.get(0);
		assertThat(link.getHref(), equalTo("http://localhost/canton"));
	}

	@Test
	public void testItemByIdWithoutDistrictLink() {
		verifyCanton(CZ0100, 1);
	}

	@Test
	public void testItemByIdWithDistrictLink() throws Exception {
		// prepare discovery client empty response (no link is added)
		ServiceInstance si = mock(ServiceInstance.class);
		when(si.getUri()).thenReturn(new URI("http://localhost"));
		when(this.dc.getInstances(any())).thenReturn(Arrays.asList(si));

		List<Link> links = verifyCanton(CZ0100, 2);
		Link link = links.get(1);
		assertThat(link.getHref(), equalTo("http://localhost/district/CZ010/"));
		assertThat(link.getRel(), equalTo("district"));
	}

	private List<Link> verifyCanton(String cantonCode, int linkSize) {
		// prepare service response
		when(this.service.getItem(cantonCode)).thenReturn(canton);

		// start testing
		CantonResource response = this.client.item(cantonCode);
		// verify resource
		Canton canton = response.getContent();
		assertThat(canton.getCsuCode(), equalTo(cantonCode));
		assertThat(canton.getName(), equalTo("Praha hlavní město"));
		// verify links
		List<Link> links = response.getLinks();
		assertThat(links.size(), equalTo(linkSize));
		Link link = links.get(0);
		assertThat(link.getHref(), equalTo(String.format("http://localhost/canton/%s/", cantonCode)));
		assertThat(link.getRel(), equalTo(Link.REL_SELF));
		return links;
	}

}
