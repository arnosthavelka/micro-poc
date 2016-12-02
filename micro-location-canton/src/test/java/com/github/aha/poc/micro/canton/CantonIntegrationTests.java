package com.github.aha.poc.micro.canton;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.aha.poc.micro.canton.persistence.domain.Canton;

/**
 * Testing of full canton feature (with running Tomcat).
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CantonIntegrationTests {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void testItemById() {
		Canton canton = restTemplate.getForObject("/canton/{id}/", Canton.class, "CZ0100");
		assertThat(canton.getName(), equalTo("Praha hlavní město"));
	}

}
