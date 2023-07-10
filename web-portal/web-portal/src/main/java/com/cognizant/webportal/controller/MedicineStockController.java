package com.cognizant.webportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.webportal.feign.MedicineStockClient;
import com.cognizant.webportal.model.MedicineStock;

@RestController
@CrossOrigin
public class MedicineStockController {
	
	@Autowired
	private MedicineStockClient medicineStockClient;
	
	@GetMapping("/MedicineStockInformation")
	public ResponseEntity<?> getMedicineStockInformation(){
		
		List<MedicineStock> list = medicineStockClient.getMedicineStockInformation();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}


}
