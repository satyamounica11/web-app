package com.akshayamedicals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akshayamedicals.model.Customer;
import com.akshayamedicals.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping(path = "/customerList")
	public List<Customer> getMedicinesAvailableList() {
		return customerService.getMedicineAvailableList();
	}

	@PostMapping(path = "/addCustomer")
	void addMedicine(@RequestBody Customer customer) {
		System.out.println("mouni -> " + customer.getMedicineList());
		customerService.addCustomerData(customer);
	}

	@GetMapping(path = "/searchByCustomerName")
	public List<Customer> getCustomerListByName(@RequestParam(value = "customerName") String customerName) {
		System.out.println("customerName -> " + customerName);
		List<Customer> list = customerService.getCustomerListByName(customerName);
		System.out.println(list.size());
		return list;
	}

	@PostMapping(path = "/searchCustomer")
	public List<Customer> getCustomerList() {
		return customerService.getMedicineAvailableList();
	}

	@PostMapping(path = "/payAmount")
	public List<Customer> payAmount(@RequestBody Customer customer, @RequestParam(value = "medList") String medList,
			@RequestParam(value = "amount") String amount) {
		System.out.println("amount -> " + amount);
		System.out.println(medList);
		int amountCur = Integer.parseInt(amount);
		return customerService.payAmount(customer, medList, amountCur);
	}

	@PostMapping(path = "/addAmount")
	public List<Customer> addAmount(@RequestBody Customer customer, @RequestParam(value = "medList") String medList,
			@RequestParam(value = "amount") String amount) {
		System.out.println("amount -> " + amount);
		System.out.println(medList);
		int amountCur = Integer.parseInt(amount);
		return customerService.addAmount(customer, medList, amountCur);
	}

	@PostMapping(path = "/deleteCustomer")
	public List<Customer> deleteCustomer(@RequestBody Customer customer) {
		return customerService.deleteCustomer(customer);
	}
}
