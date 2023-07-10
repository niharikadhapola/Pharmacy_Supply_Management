package com.cognizant.stockMedicineService.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.stockMedicineService.StockMedicineServiceApplication;
import com.cognizant.stockMedicineService.dao.MedicineStockDAO;
import com.cognizant.stockMedicineService.model.Medicine;
import com.cognizant.stockMedicineService.service.MedicineStockService;


@RestController
public class StockController {
	private static Logger LOGGER = LoggerFactory.getLogger(StockMedicineServiceApplication.class);
	
	@Autowired
	private MedicineStockService medicineStockService;
	
	@Autowired
	private Medicine medicineStock;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping(value= "/MedicineStockInformation" , method=RequestMethod.GET)
	public ResponseEntity<?> getMedicineStockInformation() {
		LOGGER.info("START");
		List<Medicine> medicineStockInformation = null;	
		medicineStockInformation = medicineStockService.getMedicineStockInformation();
		LOGGER.info("END1");
		return new ResponseEntity<>(medicineStockInformation, HttpStatus.OK);
	}

	@RequestMapping(value= "/byTreatingAilment/{treatingAilment}" , method=RequestMethod.GET)
	public ResponseEntity<?> getMedicineByTreatingAilment(@PathVariable("treatingAilment") String treatingAilment) {
		LOGGER.info("START");
		List<String> medicines = new ArrayList<>();
		List<Medicine> medicineByTargetAilment = medicineStockService.getMedicineByTargetAilment(treatingAilment);		
		for (Iterator iterator = medicineByTargetAilment.iterator(); iterator.hasNext();) {
			Medicine medicineStock = (Medicine) iterator.next();
			medicines.add(medicineStock.getName());
		}
		LOGGER.info("END2");
		return new ResponseEntity<>(medicines.toArray(new String[0]), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/get-stock-count/{medicine}" , method = RequestMethod.GET)
	public ResponseEntity<?> getStockCountForMedicine(@PathVariable("medicine") String medicine) {
		LOGGER.info("START");
		LOGGER.info("END3");
		return new ResponseEntity<>(medicineStockService.getNumberOfTabletsInStockByName(medicine), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update-stock/{medicine}/{count}", method = RequestMethod.GET)
	public Boolean updateNumberOfTabletsInStockByName(@PathVariable("medicine") String medicine, @PathVariable("count") int count) {
		LOGGER.info("START");
		Boolean ans = false;
		ans = medicineStockService.updateNumberOfTabletsInStockByName(medicine, count);
		LOGGER.info("END4");
		return ans;
		
	}
	
	

	
}
