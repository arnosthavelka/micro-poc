package com.github.aha.poc.micro.canton.service;

import static com.github.aha.poc.micro.canton.persistence.repository.CantonSpecifications.byCsuCode;
import static com.github.aha.poc.micro.canton.persistence.repository.CantonSpecifications.byDistrictCode;
import static com.github.aha.poc.micro.canton.persistence.repository.CantonSpecifications.byName;
import static org.springframework.data.jpa.domain.Specifications.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.aha.poc.micro.canton.persistence.domain.Canton;
import com.github.aha.poc.micro.canton.persistence.repository.CantonRepository;

@Service
@Transactional(readOnly = true)
public class CantonServiceImpl implements CantonService {

	private static final String DEFAULT_SORTING = "name";

	private Sort sorting = new Sort(Sort.Direction.ASC, DEFAULT_SORTING);

	@Autowired
	private CantonRepository cantonRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asseco.aha.poc.micro.canton.service.CantonService#findAll(java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Canton> findAll(String name, String csuCode, String plateCode) {
		Specifications<Canton> spec = null;

		if (!StringUtils.isEmpty(name)) {
			spec = where(byName(name));
		}
		if (!StringUtils.isEmpty(csuCode)) {
			Specification<Canton> localSpec = byCsuCode(csuCode);
			spec = spec == null ? where(localSpec) : spec.and(localSpec);
		}
		if (!StringUtils.isEmpty(plateCode)) {
			Specification<Canton> localSpec = byDistrictCode(plateCode);
			spec = spec == null ? where(localSpec) : spec.and(localSpec);
		}

		return cantonRepository.findAll(spec, sorting);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asseco.aha.poc.micro.canton.service.CantonService#getItem(java.lang.String)
	 */
	public Canton getItem(String code) {
		return cantonRepository.findByCsuCodeIgnoringCase(code);
	}

}
