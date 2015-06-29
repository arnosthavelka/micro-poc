package com.github.aha.poc.micro.district;

import static com.github.aha.poc.micro.district.persistence.repository.DistrictSpecifications.byName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.data.jpa.domain.Specifications.where;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.github.aha.poc.micro.district.persistence.domain.District;
import com.github.aha.poc.micro.district.persistence.repository.DistrictRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestRepositoryApplication.class)
@Transactional(readOnly = true)
@ComponentScan(basePackageClasses = DistrictPersistenceTests.class)
public class DistrictPersistenceTests {

	// @Autowired
	// JdbcTemplate jdbcTemplate;

	// @Test
	// public void testJdbcCount() {
	// Integer count = jdbcTemplate.queryForObject("select count(*) from district", Integer.class);
	// assertThat(count, equalTo(15));
	// }

	private static final String DISTRICT_A = "A";

	private static final String DISTRICT_B = "B";

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

	@Test
	public void testFindDynamic() {
		List<District> data = districtRepository.findAll(where(byName("jih")), new Sort("name"));
		assertThat(data.size(), equalTo(2));
		District district = data.get(0);
		assertThat(district.getPlateCode(), equalTo(DISTRICT_B));
	}

}
