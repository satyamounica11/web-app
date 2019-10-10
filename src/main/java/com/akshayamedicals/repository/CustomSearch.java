package com.akshayamedicals.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.akshayamedicals.model.Medicines;

@Service
public class CustomSearch {

	public static Specification<Medicines> byColumnNameAndValue(String columnName, String value) {
	    return new Specification<Medicines>() {
	        @Override
	        public Predicate toPredicate(Root<Medicines> root,
	                CriteriaQuery<?> query, CriteriaBuilder builder) {
	        	Predicate hasValue = builder.like(root.<String>get(columnName), "%"+value+"%");
	            return hasValue;
	        }
	    };
	}
}
