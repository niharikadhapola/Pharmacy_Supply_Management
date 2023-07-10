package com.cognizant.pharmacymanagement.MedicinesSupply.feingClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.pharmacymanagement.MedicinesSupply.model.Medicine;

@FeignClient(url="http://localhost:8081/", name="stockMedicine")
public interface StockFeignClient {

	/**
	 * Based on the provided medicine this method will fetch the supply count
	 * @param medicine
	 * @return count of a particular medicine present in stock based on its name
	 */
	@GetMapping(value="/get-stock-count/{medicine}")
	public int getStockCountForMedicine(
			@PathVariable("medicine") String medicine);

	/**
	 * Updates the number of tablets in stock by name of medicine.
	 * 
	 * @param token    It will come from the authorization header which will be sent
	 *                 to authorization service for validation. If token is valid
	 *                 then only we will continue further.
	 * @param medicine which is supplied by pharmacy
	 * @param count    number of tablets supplied by pharmacy
	 */
	@GetMapping("/update-stock/{medicine}/{count}")
	public Boolean updateNumberOfTabletsInStockByName(
			@PathVariable("medicine") String medicine, @PathVariable("count") int count);

	
}
