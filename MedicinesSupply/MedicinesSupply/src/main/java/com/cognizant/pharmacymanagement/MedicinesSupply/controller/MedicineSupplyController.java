package com.cognizant.pharmacymanagement.MedicinesSupply.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.*;
import com.cognizant.pharmacymanagement.MedicinesSupply.MedicineSupplyApplication;
import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.StockFeignClient;
import com.cognizant.pharmacymanagement.MedicinesSupply.model.Medicine;
import com.cognizant.pharmacymanagement.MedicinesSupply.model.PharmacyMedicineSupply;
import com.cognizant.pharmacymanagement.MedicinesSupply.service.PharmacyMedicineSupplyService;

/**
 * This class is handling all the end points for PharmacyMedicineSupply and MedicineDemand
 * This controller has mappings which will be used to extract medicine
 * supply based on medicine demand and medicine name. 
 * It will use an interface {@link StockFeignClient} for extracting stock count from Medicine. 
 * AuthClient is used to verify the token.
 * 
 */
@RestController
@CrossOrigin
public class MedicineSupplyController {
	
	
	private static Logger LOGGER = LoggerFactory.getLogger(MedicineSupplyApplication.class);
	
	/**
	 * An interface which has an implementation class
	 * {@link PharmacyMedicineSupplyService} that contains the business logic about
	 * medicine supply
	 */
	@Autowired
	PharmacyMedicineSupplyService service;
	
	/**
	 * It provides feign service. It connects the MedicinesSupply microservice
	 * to the StockMedicine microservice to extract stock count.
	 * 
	 * @see AuthFeignClient
	 */
	@Autowired
	private StockFeignClient stockFeignClient;
	
	/**
	 * @param token              It will come from the authorization header which
	 *                           will be sent to authorization service for
	 *                           validation. If token is valid then only we will
	 *                           continue further.
	 *
	 * Directs to the page that allows user to select medicine name and demand
	 */
	@RequestMapping(value="/viewDemand", method = RequestMethod.GET)
	public String showSupplyHomePage(@RequestHeader("Authorization") String token){
		LOGGER.info("Starting showSupplyHomePage");
		if (service.isSessionValid(token)) {
			return "viewDemand";
		}
		LOGGER.info("Ending showSupplyHomePage");
		return "login";
	}

	/**
	 * @param token              It will come from the authorization header which
	 *                           will be sent to authorization service for
	 *                           validation. If token is valid then only we will
	 *                           continue further.
	 * 
	 * Accepts the values given by user for medicine name and string, and directs to the page 
	 * that displays the table of pharmacies with the supply distributed
	 * 
	 * stockFeignClient accepts the name to extract the stock from Medicine
	 */
	
	@GetMapping(value="/SupplyAvailed/{name}/{demand}")
	public ResponseEntity<?> showList(@RequestHeader("Authorization") String token,@PathVariable String name, @PathVariable long demand){
		LOGGER.info("Starting showList");
		if (service.isSessionValid(token)) {
			LOGGER.info(name);
			LOGGER.info("demand: " + demand);
			 int stock = stockFeignClient.getStockCountForMedicine(name);
//			 model.put("stock","Hello");
			 
			
			//service.stockDivide(demand,name,stock);
			//model.put("pharmacyList", service.retrievePharmacies());
			//return new ModelAndView ("SupplyAvailed");
			LOGGER.info("Ending showList");
			return new ResponseEntity<>(service.retrievePharmacies(token,demand,name,stock), HttpStatus.OK);
		}
		LOGGER.info("Ending showList");
		return null;
	}
	
	
	
}
	
	