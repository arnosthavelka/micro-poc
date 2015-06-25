package com.github.aha.poc.micro.district.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.aha.poc.micro.district.persistence.domain.District;

@Transactional(propagation = Propagation.MANDATORY)
public interface DistrictRepository extends JpaRepository<District, Long>, JpaSpecificationExecutor<District> {

	// query is defined by @NamedQuery (in the entity City)
	District findByNameIgnoringCase(String name);

	// query is defined by @NamedQuery (in the entity City)
	District findByCsuCodeIgnoringCase(String name);

	// query is defined by @NamedQuery (in the entity City)
	District findByPlateCodeIgnoringCase(String name);
}
