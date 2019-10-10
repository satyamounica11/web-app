package com.akshayamedicals.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.akshayamedicals.model.Medicines;

@Repository
public interface MedicinesRepo extends CrudRepository<Medicines, Integer>{

	List<Medicines> findAll(Specification<Medicines> specRes);

	@Query("select m from Medicines m order by m.item asc")
	List<Medicines> findAllList();

	@Query("select m.sellingprice from Medicines m where m.item = :item")
	int getCost(String item);

	@Query("select m.medtype from Medicines m where m.item = :item")
	String getType(String item);
}