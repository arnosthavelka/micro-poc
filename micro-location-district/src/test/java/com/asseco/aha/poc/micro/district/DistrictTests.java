package com.asseco.aha.poc.micro.district;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.asseco.aha.poc.micro.district.domain.District;
import com.asseco.aha.poc.micro.district.repository.DistrictRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DistrictApplication.class)
public class DistrictTests {

	// @Autowired
	// JdbcTemplate jdbcTemplate;

	// @Test
	// public void testJdbcCount() {
	// Integer count = jdbcTemplate.queryForObject("select count(*) from district", Integer.class);
	// assertThat(count, equalTo(15));
	// }

	private static final String DISTRICT_A = "A";

	private static final String DISTRICT_NAME = "Hlavní město Praha";

	@Autowired
	private DistrictRepository districtRepository;

	@Test
	public void testCount() {
		long count = districtRepository.count();
		assertThat(count, equalTo(15L));
	}

	@Test
	public void testFindAll() {
		List<District> data = districtRepository.findAll(new Sort(Sort.Direction.ASC, "plateCode"));
		assertThat(data.size(), equalTo(15));
	}

	@Test
	public void testFindByPlate() {
		District data = districtRepository.findByPlateCodeIgnoringCase(DISTRICT_A);
		assertThat(data.getPlateCode(), equalTo(DISTRICT_A));
		assertThat(data.getName(), equalTo(DISTRICT_NAME));
	}

}
