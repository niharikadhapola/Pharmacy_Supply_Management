package com.cognizant.webportal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.webportal.WebPortalApplication;
import com.cognizant.webportal.feign.MedicineSupplyFeignClient;
import com.cognizant.webportal.model.PharmacyMedicineSupply;
import com.cognizant.webportal.model.PlaceDemand;
import com.cognizant.webportal.service.WebPortalService;

@RestController
@CrossOrigin
public class PlaceDemandController {
	
	@Autowired
	private WebPortalService webPortalService;
	
	@Autowired
	private MedicineSupplyFeignClient medicineSupplyFeign;
	
	private static Logger LOGGER = LoggerFactory.getLogger(WebPortalApplication.class);
	
	@GetMapping(value="/SupplyAvailed/{name}/{demand}")
	public ResponseEntity<?> showList(@RequestHeader("Authorization") String token, @PathVariable String name, @PathVariable int demand){
		
		LOGGER.info("Starting showList");
		if (webPortalService.isSessionValid(token)) {
			
			if(demand <= 0) {
				return new ResponseEntity<>("Demand should not be zero", HttpStatus.FORBIDDEN);
			}
			List<PharmacyMedicineSupply> list=medicineSupplyFeign.showList(token , name, demand);
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		
		return null;
	}

}
