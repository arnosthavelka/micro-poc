package com.github.aha.poc.micro.district;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.aha.poc.micro.district.persistence.domain.District;
import com.github.aha.poc.micro.district.rest.DistrictController;
import com.github.aha.poc.micro.district.rest.DistrictResourceAssembler;
import com.github.aha.poc.micro.district.service.DistrictService;

/**
 * Tests of district's rest (controller) layer.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DistrictController.class)
@AutoConfigureRestDocs("target/generated-snippets")
@Import(value = DistrictResourceAssembler.class)
public class DistrictRestDocumentation {

	private static final String CZ010 = "CZ010";

	@MockBean
	private DistrictService service;

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    ObjectMapper objectMapper;
    
	private District district;

	@Before
	public void setUp() throws Exception {
		district = new District();
		district.setCsuCode(CZ010);
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
	}

	@Test
	public void testFindAll() throws Exception {
		// prepare service response
		when(this.service.findAll(null, null, null)).thenReturn(Arrays.asList(district, district));

		String restUrl = "/district/";
		mockMvc.perform(get(restUrl).accept(APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$._embedded.districts", hasSize(2)))
		.andExpect(jsonPath("$._embedded.districts[0].name", equalTo("Hlavní město Praha")))
		.andExpect(jsonPath("$._embedded.districts[0].csuCode", equalTo(CZ010)))
		.andExpect(jsonPath("$._links.self.href", equalTo("http://localhost:8080/district")))
//		.andExpect(content().string("...complete response as string ..."))
		.andDo(document(restUrl,
			preprocessRequest(prettyPrint()),
			preprocessResponse(prettyPrint())
		));			
	}
	
	@Test
	public void testItemById() throws Exception {
		// prepare service response
		when(this.service.getItem(CZ010)).thenReturn(district);
		
		String restUrl = String.format("/district/%s/", CZ010);
		mockMvc.perform(get(restUrl).accept(APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name", equalTo("Hlavní město Praha")))
		.andExpect(jsonPath("$.csuCode", equalTo(CZ010)))
		.andExpect(jsonPath("$.plateCode", nullValue()))
		.andExpect(jsonPath("$._links.self.href", equalTo("http://localhost:8080" + restUrl)))
//		.andExpect(content().string("...complete response as string ..."))
		.andDo(document(restUrl,
			preprocessRequest(prettyPrint()),
			preprocessResponse(prettyPrint())
		));		
	}

}
