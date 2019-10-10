package com.akshayamedicals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akshayamedicals.model.Medicines;
import com.akshayamedicals.model.Receipt;
import com.akshayamedicals.service.MedicinesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {

	@Autowired
	MedicinesService medicinesService;
	
	@GetMapping(path="/medicinesAvailableList")
	public List<Medicines> getMedicinesAvailableList(){
		return medicinesService.getMedicineAvailableList();
	}
	
	@PostMapping(path="/addMedicine")
	void addMedicine(@RequestBody Medicines medicines) {
		System.out.println("mouni -> "+medicines.getItem());
		medicinesService.addMedicineData(medicines);
    }
	
	@GetMapping(path="/searchMedicine")
	public List<Medicines> searchMedicines(@RequestParam(value="inputForSearch") String inputForSearch,@RequestParam(value="item") String item){
		System.out.println("inputForSearch -> "+inputForSearch+" "+"item -> "+item.toString());
		List<Medicines> list = medicinesService.searchMedicineByItem(inputForSearch,item);
		System.out.println(list.size());
		return list;
	}
	
	@PostMapping(path="/deleteMedicine")
	public void deleteMedicine(@RequestBody Medicines medicines){
		System.out.println("item -> "+medicines.getItem());
		medicinesService.deleteMedice(medicines);
	}
	
	@PostMapping(path="/updateMedicine")
	void updateMedicine(@RequestBody Medicines medicines) {
		System.out.println("mouni -> "+medicines.getId());
		System.out.println("New Item -> "+medicines.getItem());
		medicinesService.updateMedicineData(medicines);
    }
	
	@PostMapping(path="/calReceipt")
	public int calculateReceipt(@RequestBody Receipt[] fieldArray){
		int val = medicinesService.calculateReceipt(fieldArray);
		System.out.println(val);
		return val;
	}
}
