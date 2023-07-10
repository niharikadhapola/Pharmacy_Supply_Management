package com.cognizant.stockMedicineService.service;

import java.util.List;

import com.cognizant.stockMedicineService.model.Medicine;



public interface MedicineStockService {
	/**
	 * Get the medicine stock information from the database
	 */
	List<Medicine> getMedicineStockInformation();

	/**
	 * Get the medicines by target ailment
	 */
	List<Medicine> getMedicineByTargetAilment(String treatingAilment);

	/**
	 * Get the count of tablets present in the stock for a given medicine
	 */
	int getNumberOfTabletsInStockByName(String medicine);

}
