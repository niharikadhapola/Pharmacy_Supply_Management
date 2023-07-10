package com.cognizant.webportal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.webportal.model.PharmacyMedicineSupply;

@FeignClient(url="http://localhost:8083", name="medicineSupply")
public interface MedicineSupplyFeignClient {
	
	@GetMapping("/SupplyAvailed/{name}/{demand}")
	public List<PharmacyMedicineSupply> showList(@RequestHeader("Authorization") String token, @PathVariable String name, @PathVariable int demand);

}
