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
	 * will store in the Medicine type object.
	 */
	@Query(name = "SELECT number_Of_Stock FROM medicine where name = :medicine", nativeQuery = true)
	Medicine getNumberOfTabletsInStockByName(@PathParam("medicine") String medicine);
}
