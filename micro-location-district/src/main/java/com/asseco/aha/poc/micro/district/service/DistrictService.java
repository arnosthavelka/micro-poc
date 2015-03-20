package com.asseco.aha.poc.micro.district.service;

import java.util.List;

import com.asseco.aha.poc.micro.district.persistence.domain.District;

public interface DistrictService {

	List<District> findAll(String name, String csuCode, String plateCode);

	District getItem(long id);

}