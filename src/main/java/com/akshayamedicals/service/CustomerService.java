package com.akshayamedicals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshayamedicals.model.Customer;
import com.akshayamedicals.model.Medicines;
import com.akshayamedicals.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public void addCustomerData(Customer customer) {
		customerRepository.save(customer);
	}

	public List<Customer> getMedicineAvailableList() {
		return customerRepository.findAll();
		}

	public List<Customer> getCustomerListByName(String customerName) {
		return customerRepository.getListByCustomerName(customerName);
	}

	public List<Customer> payAmount(Customer customer, String medList, int amount) {
		System.out.println(customer.getMedicineList()+" Medicine List");
		customer.setLastPaidAmount(amount);
		customer.setAmountPending(customer.getAmountPending()-amount);
		customer.setMedicineList(medList);
		customerRepository.save(customer);
		return customerRepository.findAll();
	}

	public List<Customer> addAmount(Customer customer, String medList, int amount) {
		//System.out.println(customer.getMedicineList()+" Medicine List");
		customer.setAmountPending(customer.getAmountPending()+amount);
		customer.setMedicineList(medList);
		customerRepository.save(customer);
		return customerRepository.findAll();
	}

	public List<Customer> deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
		return customerRepository.findAll();
	}

}
