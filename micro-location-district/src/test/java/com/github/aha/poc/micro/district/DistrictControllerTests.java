package com.github.aha.poc.micro.district;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.github.aha.poc.micro.district.DistrictApplication;
import com.github.aha.poc.micro.district.persistence.domain.District;

/**
 * Configuration and discovery (Eureka) servers must be running for this integration test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DistrictApplication.class)
@WebAppConfiguration
@IntegrationTest
@Ignore
public class DistrictControllerTests {

	@Value("${server.port}")
	private int port;

	@Test
	public void testItemById() {
		assertThat(port, equalTo(8090));
		String URI = String.format("http://localhost:%d/district/{id}/", port);
		RestTemplate restTemplate = new RestTemplate();
		District district = restTemplate.getForObject(URI, District.class, "14");
		assertThat(district.getName(), equalTo("Hlavní město Praha"));
	}

}
