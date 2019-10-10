package com.akshayamedicals.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.akshayamedicals.model.Medicines;
import com.akshayamedicals.model.Receipt;
import com.akshayamedicals.repository.CustomSearch;
import com.akshayamedicals.repository.MedicinesRepo;

@Service
public class MedicinesService {

	@Autowired
	MedicinesRepo medicineRepository;
	
	@Autowired
	CustomSearch cuust;
	
	

	public List<Medicines> getMedicineAvailableList() {
		List<Medicines> medList = (List<Medicines>) medicineRepository.findAllList();
		return medList;
	}

	public void addMedicineData(Medicines medicines) {
		medicineRepository.save(medicines);
	}

	public List<Medicines> searchMedicineByItem(String inputForSearch,String item) {
		Specification<Medicines> specRes = cuust.byColumnNameAndValue(inputForSearch,item);
		return medicineRepository.findAll(specRes);
	}

	public void deleteMedice(Medicines medicines) {
		medicineRepository.delete(medicines);
	}

	public void updateMedicineData(Medicines medicines) {
		System.out.println("Medicine Update");
		medicineRepository.save(medicines);
		
	}

	public int calculateReceipt(Receipt[] fieldArray) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=0;i<fieldArray.length;i++) {
			int cost = medicineRepository.getCost(fieldArray[i].getItem());
			String type = medicineRepository.getType(fieldArray[i].getItem());
			
			if(type.equalsIgnoreCase("branded")) {
				if(fieldArray[i].getPerStrip() == fieldArray[i].getQuantity()) {
					int dis = discount(cost);
					sum+=dis;
				}
				else if(fieldArray[i].getPerStrip() < fieldArray[i].getQuantity()) {
					int count = 1;
					int dat = fieldArray[i].getQuantity() - fieldArray[i].getPerStrip();
					sum+=cost;
					while(dat>fieldArray[i].getPerStrip()) {
						dat = dat - fieldArray[i].getPerStrip();
						sum+=cost;
					}
					if(dat != 0) {
						int cos = calCost(cost,fieldArray[i].getPerStrip(),dat);
						sum+=cos;
					}
				}
				else {
					int cos = calCost(cost,fieldArray[i].getPerStrip(),fieldArray[i].getQuantity());
					sum+=cos;
				}
			}
			else {
				int cos = calCost(cost,fieldArray[i].getPerStrip(),fieldArray[i].getQuantity());
				sum+=cos;
			}
		}
		return 0;
	}

	private int calCost(int cost, int perStrip, int quantity) {
		if(cost == 0) {
			cost = 10;
		}
		int onetabCost = perStrip/cost;
		return quantity*onetabCost;
	}

	private int discount(int cost) {
		return cost*(10/100);
	}
}
