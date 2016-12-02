package com.github.aha.poc.micro.district;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.Link;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.aha.poc.micro.district.persistence.domain.District;
import com.github.aha.poc.micro.district.rest.DistrictController;
import com.github.aha.poc.micro.district.rest.DistrictResource;
import com.github.aha.poc.micro.district.rest.DistrictResourceAssembler;
import com.github.aha.poc.micro.district.service.DistrictService;

/**
 * Tests of district's rest (controller) layer.
 */
@RunWith(SpringRunner.class)
@RestClientTest(DistrictController.class)
@Import(value=DistrictResourceAssembler.class)
public class DistrictControllerTests {

    @Autowired
    private DistrictController client;
 
    @MockBean
	private DistrictService service;

    @Before
    public void setUp() throws Exception {
    	District district = new District();
    	district.setCsuCode("CZ010");
    	district.setName("Hlavní město Praha");
    	
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
    	// prepare service response
        given(this.service.getItem("CZ010")).willReturn(district);    	
    }	

	@Test
	public void testItemById() {
		DistrictResource response = this.client.item("CZ010");
		// verify resource
		District district = response.getContent();
		assertThat(district.getCsuCode(), equalTo("CZ010"));
		assertThat(district.getName(), equalTo("Hlavní město Praha"));
		// verify added links
		List<Link> links = response.getLinks();
		assertThat(links.size(), equalTo(1));
		Link link = links.get(0);
		assertThat(link.getHref(), equalTo("http://localhost/district/CZ010/"));
	}

}
