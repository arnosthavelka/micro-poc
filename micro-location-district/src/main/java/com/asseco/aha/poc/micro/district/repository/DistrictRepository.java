package com.asseco.aha.poc.micro.district.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.asseco.aha.poc.micro.district.domain.District;


public interface DistrictRepository extends JpaRepository<District, Long>, JpaSpecificationExecutor<District> {

	// query is defined by @NamedQuery (in the entity City)
	District findByNameIgnoringCase(String name);

	// query is defined by @NamedQuery (in the entity City)
	District findByCsuCodeIgnoringCase(String name);

	// query is defined by @NamedQuery (in the entity City)
	District findByPlateCodeIgnoringCase(String name);
}
