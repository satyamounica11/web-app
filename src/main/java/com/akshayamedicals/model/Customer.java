package com.akshayamedicals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopCustomer")
public class Customer {

	@Id
	int id;
	@Column(name = "customer_name")
	String customerName;
	@Column(name = "amount_pending")
	int amountPending;
	@Column(name = "last_paid_amount")
	int lastPaidAmount;
	@Column(name = "medicines_list")
	String medicineList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAmountPending() {
		return amountPending;
	}
	public void setAmountPending(int amountPending) {
		this.amountPending = amountPending;
	}
	public int getLastPaidAmount() {
		return lastPaidAmount;
	}
	public void setLastPaidAmount(int lastPaidAmount) {
		this.lastPaidAmount = lastPaidAmount;
	}
	public String getMedicineList() {
		return medicineList;
	}
	public void setMedicineList(String medicineList) {
		this.medicineList = medicineList;
	}
	
	
	
}
