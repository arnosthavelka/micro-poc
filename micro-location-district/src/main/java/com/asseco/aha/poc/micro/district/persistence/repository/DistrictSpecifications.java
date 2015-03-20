package com.asseco.aha.poc.micro.district.persistence.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.asseco.aha.poc.micro.district.persistence.domain.District;

public class DistrictSpecifications {

	public static Specification<District> byName(final String name) {
		return new Specification<District>() {

            @Override
			public Predicate toPredicate(Root<District> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(cb.lower(root.get("name")), name.toLowerCase() + "%");
            }
        };
    }

	public static Specification<District> byCsuCode(final String code) {
		return new Specification<District>() {

            @Override
			public Predicate toPredicate(Root<District> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("csuCode"), code);
            }
        };
    }

	public static Specification<District> byPlateCode(final String code) {
		return new Specification<District>() {

            @Override
			public Predicate toPredicate(Root<District> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("plateCode"), code);
            }
        };
    }
}
