package com.akshayamedicals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genericmedicines")
public class Medicines {

	@Id
	int id;
	@Column(name = "item")
	String item;
	@Column(name = "company")
	String company;
	@Column(name = "dealer")
	String dealer;
	@Column(name="medtype")
	String medtype;
	@Column(name = "invoicenumber")
	String invoice;
	@Column(name = "batchnumber")
	String batchnumber;
	@Column(name = "expirydate")
	String expirydate;
	@Column(name = "quantityreceived")
	int quantityreceived;
	@Column(name = "totalstock")
	int totalStock;
	@Column(name = "mrp")
	int mrp;
	@Column(name = "rate")
	int rate;
	@Column(name = "receivedon")
	String receivedon;
	@Column(name = "sellingprice")
	int sellingprice;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getBatchnumber() {
		return batchnumber;
	}

	public void setBatchnumber(String batchnumber) {
		this.batchnumber = batchnumber;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	public int getQuantityreceived() {
		return quantityreceived;
	}

	public void setQuantityreceived(int quantityreceived) {
		this.quantityreceived = quantityreceived;
	}

	public int getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(int totalStock) {
		this.totalStock = totalStock;
	}

	public int getMrp() {
		return mrp;
	}

	public void setMrp(int mrp) {
		this.mrp = mrp;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getReceivedon() {
		return receivedon;
	}

	public void setReceivedon(String receivedon) {
		this.receivedon = receivedon;
	}

	public int getSellingprice() {
		return sellingprice;
	}

	public void setSellingprice(int sellingprice) {
		this.sellingprice = sellingprice;
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public String getMedtype() {
		return medtype;
	}

	public void setMedtype(String medtype) {
		this.medtype = medtype;
	}
	
}