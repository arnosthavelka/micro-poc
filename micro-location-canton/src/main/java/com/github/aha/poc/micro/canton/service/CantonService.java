package com.github.aha.poc.micro.canton.service;

import java.util.List;

import com.github.aha.poc.micro.canton.persistence.domain.Canton;

public interface CantonService {

	List<Canton> findAll(String name, String csuCode, String districtCode);

	Canton getItem(String code);

}