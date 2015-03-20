package com.asseco.aha.poc.micro.district.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asseco.aha.poc.micro.district.persistence.domain.District;
import com.asseco.aha.poc.micro.district.persistence.repository.DistrictRepository;

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

		return districtRepository.findAll(spec, sorting);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asseco.aha.poc.micro.district.service.DistrictService#getItem(long)
	 */
	public District getItem(long id) {
		return districtRepository.getOne(id);
	}

}
