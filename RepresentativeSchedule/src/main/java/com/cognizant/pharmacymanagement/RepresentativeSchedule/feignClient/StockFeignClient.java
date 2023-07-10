package com.cognizant.pharmacymanagement.RepresentativeSchedule.feignClient;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.cloud.openfeign.FeignClient(url="http://localhost:8081", name="stockMedicine")
public interface StockFeignClient {
	
	/**
	 * Connects to getMedicineByTreatingAilment method in the StockMedicine microservice 
	 * @param treatingAilment
	 */
	@GetMapping(value="/byTreatingAilment/{treatingAilment}")
	public List<String> getMedicineByTreatingAilment(@PathVariable("treatingAilment") String treatingAilment);
}
