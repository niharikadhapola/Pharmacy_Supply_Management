package com.cognizant.stockMedicineService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.stockMedicineService.dao.MedicineStockDAO;
import com.cognizant.stockMedicineService.model.Medicine;


@Service
public class MedicineStockServiceImpl implements MedicineStockService{

	@Autowired
	private MedicineStockDAO medicineStockRepository;

	/**
	 * Get the medicine stock information from the database.
	 * 
	 * @see MedicineStockDAO
	 */
	@Override
	public List<Medicine> getMedicineStockInformation() {
		return medicineStockRepository.findAll();
	}

	/**
	 * Get the medicines by target ailment from database based on the provided
	 * treating ailment
	 * 
	 * @see MedicineStockDAO
	 */
	@Override
	public List<Medicine> getMedicineByTargetAilment(String treatingAilment) {
		return medicineStockRepository.getMedicineByTargetAilment(treatingAilment);
	}

	/**
	 * Get the count of tablets present in the stock for a given medicine
	 * 
	 * @see MedicineStock
	 * @see MedicineStockRepository
	 */
	@Override
	public int getNumberOfTabletsInStockByName(String medicine) {
		return medicineStockRepository.getNumberOfTabletsInStockByName(medicine).getNumberOfStock();
	}

}
