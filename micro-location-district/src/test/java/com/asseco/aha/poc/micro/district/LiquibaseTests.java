package com.asseco.aha.poc.micro.district;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.asseco.aha.poc.micro.district.repository.DistrictRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DistrictApplication.class)
public class LiquibaseTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
	public void testJdbcCount() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from district", Integer.class);
		assertThat(count, equalTo(15));
    }

	@Autowired
	DistrictRepository districtRepository;

	@Test
	public void testJpaCount() {
		long count = districtRepository.count();
		assertThat(count, equalTo(15));
	}

}
