package com.github.aha.poc.micro.canton;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.github.aha.poc.micro.canton.persistence.domain.Canton;

/**
 * Configuration and discovery (Eureka) servers must be running for this integration test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CantonApplication.class)
@WebAppConfiguration
@Ignore
public class ContonControllerTests {

	@Value("${server.port}")
	private int port;

	@Test
	public void testItemById() {
		//assertThat(port, equalTo(8090));
		String URI = String.format("http://localhost:%d/canton/{id}/", port);
		RestTemplate restTemplate = new RestTemplate();
		Canton canton = restTemplate.getForObject(URI, Canton.class, "3100");
		assertThat(canton.getName(), equalTo("Praha hlavní město"));
	}

}
