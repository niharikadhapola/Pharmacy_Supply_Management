package com.cognizant.stockMedicineService.dao;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.stockMedicineService.model.Medicine;


public interface MedicineStockDAO extends JpaRepository<Medicine, String>{

	@Query(name = "select * from medicine where target_Ailment = :targetAilment", nativeQuery = true)
	List<Medicine> getMedicineByTargetAilment(@PathParam("targetAilment") String targetAilment);

	/**
	 * Based on the given medicine, query will return medicine information which we
	 * will store in the {@link MedicineStock} type object.
	 * 
	 * @param medicine
	 * @return number of tablets present in stock for a given medicine
	 * 
	 * @see MedicineStock
	 */
	@Query(name = "SELECT number_Of_Stock FROM medicine where name = :medicine", nativeQuery = true)
	Medicine getNumberOfTabletsInStockByName(@PathParam("medicine") String medicine);

	/**
	 * After providing supply for the required demands, the count of tablets in the
	 * stock will be updated using this query
	 * 
	 * @param medicine which is supplied by pharmacy
	 * @param count    number of tablets supplied by pharmacy
	 */
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE MEDICINE M SET M.NUMBER_OF_STOCK =?2 where M.NAME =?1", nativeQuery = true)
	void updateNumberOfTabletsInStockByName(String medicine, int count);
}
