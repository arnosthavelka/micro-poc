package com.asseco.aha.poc.micro.canton.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.asseco.aha.poc.micro.canton.persistence.domain.Canton;

@Transactional(propagation = Propagation.MANDATORY)
public interface CantonRepository extends JpaRepository<Canton, Long>, JpaSpecificationExecutor<Canton> {

	// query is defined by @NamedQuery (in the entity City)
	Canton findByNameIgnoringCase(String name);

	// query is defined by @NamedQuery (in the entity City)
	Canton findByCsuCodeIgnoringCase(String name);

	// query is defined by @NamedQuery (in the entity City)
	List<Canton> findByDistrictCodeIgnoringCase(String name);
}
