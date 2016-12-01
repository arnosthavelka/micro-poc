package com.github.aha.poc.micro.district;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.aha.poc.micro.district.persistence.domain.District;

/**
 * Configuration and discovery (Eureka) servers must be running for this integration test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class DistrictControllerTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void testItemById() {
		District district = restTemplate.getForObject("/district/{id}/", District.class, "CZ010");
		assertThat(district.getName(), equalTo("Hlavní město Praha"));
	}

}
