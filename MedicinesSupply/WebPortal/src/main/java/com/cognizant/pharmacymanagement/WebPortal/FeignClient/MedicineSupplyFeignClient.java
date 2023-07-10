package com.cognizant.pharmacymanagement.WebPortal.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.WebPortal.Model.PharmacyMedicineSupply;

/**
 * This interface communicates with MedicinesSupply service and helps call its methods.
 * It is used to display the viewDemand page, accept the demand and medicine name and display through the supply available.
 * 
 */
@FeignClient(url="http://localhost:8083", name="medicineSupply")
public interface MedicineSupplyFeignClient {
	
	/**
	 * @param token              It will come from the authorization header which
	 *                           will be sent to authorization service for
	 *                           validation. If token is valid then only we will
	 *                           continue further.
	 *
	 * Directs to the page that allows user to select medicine name and demand
	 */
	@GetMapping("/viewDemand")
	public String showSupplyHomePage(@RequestHeader("Authorization") String token);
	
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
	@GetMapping("/SupplyAvailed")
	public List<PharmacyMedicineSupply> showList(@RequestHeader("Authorization") String token, @RequestParam String name, @RequestParam long demand);
}
