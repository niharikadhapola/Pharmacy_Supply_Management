package com.cognizant.pharmacymanagement.MedicinesSupply.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.AuthClient;
import com.cognizant.pharmacymanagement.MedicinesSupply.feingClient.StockFeignClient;
import com.cognizant.pharmacymanagement.MedicinesSupply.model.*;


/**
 * This class contains the business logic to extract the details related
 * to medicine name and demand provided.
 */
@Service
public class PharmacyMedicineSupplyService {
	
	private static int supply=0;
	
	private static String medName;
	
	/**
	 * Used to call the method present in {@link StockFeignClient} interface
	 */
	@Autowired
	private StockFeignClient stockFeignClient;
	
	/**
	 * AuthFeignClient is used to verify the token.
	 */
	@Autowired
	private AuthClient authClient;
	
	private static int stock;
	
	/**
	 * Creates a list of type PharmacyMedicineSupply.
	 */
	private static List<PharmacyMedicineSupply> pharmacyList = new ArrayList<PharmacyMedicineSupply>();
	
    
	/**
	 *  Method that accepts the medicine name and demand count from Controller class
	 * @param token
	 * @param demand
	 * @param medicine
	 * @param stock
	 * @return list of pharmacies with the stock distributed
	 * @throws Exception 
	 */
    public List<PharmacyMedicineSupply> retrievePharmacies(String token, long demand,String medicine, int stock)  {
    	if (isSessionValid(token)) {	
    		pharmacyList.clear();
	    	if (demand>stock) {
	    		supply=stock/5;
	    		
	    		
	    	}
	    	else {
	    		supply=(int) (demand/5);
	    	}
	    	medName = medicine;
	    	pharmacyList.add(new PharmacyMedicineSupply("MedCity",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("Med 7",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("PharmaOne",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("MediLane",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("Pharma Plus",medName,supply));
	    	return pharmacyList;

    	}
    	
    	return null;
    
    }

    /**
     * Checks whether token is valid
     * @param token
     * @return boolean true or false
     */
    public Boolean isSessionValid(String token) {
    	try {
    		AuthResponse authResponse = authClient.getValidity(token);
    	} catch (Exception e) {
    		return false;
    	}
    	return true;
    }
    	
   
}

