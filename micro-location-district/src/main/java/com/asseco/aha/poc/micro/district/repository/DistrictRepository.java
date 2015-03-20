package com.asseco.aha.poc.micro.district.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.asseco.aha.poc.micro.district.domain.District;


public interface DistrictRepository extends JpaRepository<District, Long>, JpaSpecificationExecutor<District> {

	// Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name, String country, Pageable
	// pageable);
	//
	// City findByNameAndCountryAllIgnoringCase(String name, String country);
	//
	// // query is defined by @NamedQuery (in the entity City)
	// City findByName(String name);
	//
	// // query is defined by @NamedQuery (in the entity City)
	// List<City> findByNameAndCountry(String name, String country);
	//
	// @Query("SELECT c FROM City c WHERE LOWER(c.name) = LOWER(:name)")
	// City retrieveByName(@Param("name") String name);

}
