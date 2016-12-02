package com.github.aha.poc.micro.district;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

	@MockBean
	private DistrictService service;

    @Autowired
    private MockMvc mockMvc;
    
	private District district;

	@Before
	public void setUp() throws Exception {
		district = new District();
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
	}

	@Test
	public void generateDoc() throws Exception {
		// prepare service response
		when(this.service.getItem("CZ010")).thenReturn(district);
		
		String restUrl = String.format("/district/%s/", "CZ010");
		mockMvc.perform(get(restUrl).accept(APPLICATION_JSON))
		.andExpect(status().isOk())
//		.andExpect(content().string("abc"))
		.andDo(document(restUrl,
			preprocessRequest(prettyPrint()),
			preprocessResponse(prettyPrint())
		));		
	}

}
