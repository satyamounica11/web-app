package com.akshayamedicals.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.akshayamedicals.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("select cust from Customer cust where customerName like %:customerName%")
	List<Customer> getListByCustomerName(String customerName);

}
