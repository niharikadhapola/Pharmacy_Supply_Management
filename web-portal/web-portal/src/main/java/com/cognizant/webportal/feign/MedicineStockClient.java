package com.cognizant.webportal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.cognizant.webportal.model.MedicineStock;

@FeignClient(name="MedicineStock", url="http://localhost:8081")
public interface MedicineStockClient {
	
	@RequestMapping(value= "/MedicineStockInformation" , method=RequestMethod.GET)
	public List<MedicineStock> getMedicineStockInformation();

}
