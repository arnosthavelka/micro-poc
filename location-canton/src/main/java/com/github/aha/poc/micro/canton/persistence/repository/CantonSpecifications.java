package com.github.aha.poc.micro.canton.persistence.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.aha.poc.micro.canton.persistence.domain.Canton;

public class CantonSpecifications {

	public static Specification<Canton> byName(final String name) {
		return new Specification<Canton>() {

            @Override
			public Predicate toPredicate(Root<Canton> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(cb.lower(root.get("name")), name.toLowerCase() + "%");
            }
        };
    }

	public static Specification<Canton> byCsuCode(final String code) {
		return new Specification<Canton>() {

            @Override
			public Predicate toPredicate(Root<Canton> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("csuCode"), code);
            }
        };
    }

	public static Specification<Canton> byDistrictCode(final String code) {
		return new Specification<Canton>() {

            @Override
			public Predicate toPredicate(Root<Canton> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("districtCode"), code);
            }
        };
    }
}
