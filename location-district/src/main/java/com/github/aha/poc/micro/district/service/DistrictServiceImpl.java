package com.github.aha.poc.micro.district.service;

import static com.github.aha.poc.micro.district.persistence.repository.DistrictSpecifications.byCsuCode;
import static com.github.aha.poc.micro.district.persistence.repository.DistrictSpecifications.byName;
import static com.github.aha.poc.micro.district.persistence.repository.DistrictSpecifications.byPlateCode;
import static org.springframework.data.jpa.domain.Specifications.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.aha.poc.micro.district.persistence.domain.District;
import com.github.aha.poc.micro.district.persistence.repository.DistrictRepository;

@Service
@Transactional(readOnly = true)
public class DistrictServiceImpl implements DistrictService {

	private static final String DEFAULT_SORTING = "name";

	private Sort sorting = new Sort(Sort.Direction.ASC, DEFAULT_SORTING);

	@Autowired
	private DistrictRepository districtRepository;

	/* (non-Javadoc)
	 * @see com.asseco.aha.poc.micro.district.service.DistrictService#findAll(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<District> findAll(String name, String csuCode, String plateCode) {
		Specifications<District> spec = null;

		if (!StringUtils.isEmpty(name)) {
			spec = where(byName(name));
		}
		if (!StringUtils.isEmpty(csuCode)) {
			Specification<District> localSpec = byCsuCode(csuCode);
			spec = spec == null ? where(localSpec) : spec.and(localSpec);
		}
		if (!StringUtils.isEmpty(plateCode)) {
			Specification<District> localSpec = byPlateCode(plateCode);
			spec = spec == null ? where(localSpec) : spec.and(localSpec);
		}

		return districtRepository.findAll(spec, sorting);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asseco.aha.poc.micro.district.service.DistrictService#getItem(java.lang.String)
	 */
	public District getItem(String code) {
		return districtRepository.findByCsuCodeIgnoringCase(code);
	}

}
