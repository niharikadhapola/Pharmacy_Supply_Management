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
import org.springframework.web.bind.annotation.CrossOrigin;
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

import feign.FeignException;

/**
This class is handling the end points for medicine stock
information. This controller has only one mappings which will be
used to extract information of medicine stock. It will use an
interface MedicineStockService for extracting information
about medicine stock. 
*/

@RestController
@CrossOrigin
public class StockController {
	private static Logger LOGGER = LoggerFactory.getLogger(StockMedicineServiceApplication.class);
	
	/**
	 * An interface which has an implementation class
	 * MedicineStockServiceImpl that contains the business logic for extracting
	 * information about medicine stock
	 */
	@Autowired
	private MedicineStockService medicineStockService;
	
	@Autowired
	private Medicine medicineStock;
	
	/** this will return a list of all the medicines stored in the h2 database */
		
	@RequestMapping(value= "/MedicineStockInformation" , method=RequestMethod.GET)
	public List<Medicine> getMedicineStockInformation() {
		LOGGER.info("START");
		List<Medicine> medicineStockInformation = null;	
		medicineStockInformation = medicineStockService.getMedicineStockInformation();
		LOGGER.info("END1");
		return medicineStockInformation;
	}

	/**
	 * Based on the treating ailment this method will return the information about
	 * the medicine. After fetching details in a list, from the list one by one
	 * extract each medicineStock object and fetch medicine from it and store these
	 * in an array and return it.
	 */
	
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

	/**
	 * Fetch the stock count for the given medicine. Call the
	 * MedicineStockServiceImpl method to extract the result
	 */
	
	@RequestMapping(value = "/get-stock-count/{medicine}" , method = RequestMethod.GET)
	public ResponseEntity<?> getStockCountForMedicine(@PathVariable("medicine") String medicine) {
		LOGGER.info("START");
		LOGGER.info("END3");
		return new ResponseEntity<>(medicineStockService.getNumberOfTabletsInStockByName(medicine), HttpStatus.OK);
	}
	

	
}
