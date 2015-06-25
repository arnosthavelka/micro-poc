package com.github.aha.poc.micro.canton;

import static com.github.aha.poc.micro.canton.persistence.repository.CantonSpecifications.byName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.data.jpa.domain.Specifications.where;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.github.aha.poc.micro.canton.CantonApplication;
import com.github.aha.poc.micro.canton.persistence.domain.Canton;
import com.github.aha.poc.micro.canton.persistence.repository.CantonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CantonApplication.class)
@Transactional(readOnly = true)
public class CantonPersistenceTests {

	private static final String DISTRICT_CZ010 = "CZ010";

	private static final String DISTRICT_CZ063 = "CZ063";

	private static final String DISTRICT_NAME = "Praha hlavní město";

	@Autowired
	private CantonRepository districtRepository;

	@Test
	public void testCount() {
		long count = districtRepository.count();
		assertThat(count, equalTo(90L));
	}

	@Test
	public void testFindAll() {
		List<Canton> data = districtRepository.findAll();
		assertThat(data.size(), equalTo(90));
	}

	@Test
	public void testFindByDistrict() {
		List<Canton> data = districtRepository.findByDistrictCodeIgnoringCase(DISTRICT_CZ010);
		assertThat(data.size(), equalTo(13));
		Canton canton = data.get(0);
		assertThat(canton.getDistrictCode(), equalTo(DISTRICT_CZ010));
		assertThat(canton.getName(), equalTo(DISTRICT_NAME));
	}

	@Test
	public void testFindDynamic() {
		List<Canton> data = districtRepository.findAll(where(byName("jih")), new Sort("name"));
		assertThat(data.size(), equalTo(1));
		Canton district = data.get(0);
		assertThat(district.getDistrictCode(), equalTo(DISTRICT_CZ063));
	}

}
