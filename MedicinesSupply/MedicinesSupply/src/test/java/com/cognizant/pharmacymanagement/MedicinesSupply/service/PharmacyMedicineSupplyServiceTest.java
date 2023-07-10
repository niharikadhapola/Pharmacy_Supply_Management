package com.cognizant.pharmacymanagement.MedicinesSupply.service;

/**
 * This class contains test cases for the MedicineSupplyController class which
 * are written using Junit and Mockito.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.pharmacymanagement.MedicinesSupply.model.*;
import com.cognizant.pharmacymanagement.MedicinesSupply.service.PharmacyMedicineSupplyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PharmacyMedicineSupplyServiceTest {

	@Mock
	private PharmacyMedicineSupplyService pharmacyService;
	
	@Mock
	private PharmacyMedicineSupply pharmacyMedicine;
	
	/**
	 * @throws Exception  Tests the retrievePharmacies method and checks if
	 *  						the returned value is null or not
	 */
	@Test
	public void testRetrievePharmaciesNotNull() throws Exception{
		when(pharmacyService.isSessionValid("token")).thenReturn(true);
		List<PharmacyMedicineSupply> pharmList = pharmacyService.retrievePharmacies("token",1000, "Orthoherb", 30000);
		assertNotNull(pharmList);
	}
	
	/**
	 * @throws Exception  Tests whether the retrievePharmacies method with InvalidInput
	 *  						returns an empty string
	 */
	@Test
	public void testRetrievePharmacieswithInvalidInput() throws Exception{
		when(pharmacyService.isSessionValid("token")).thenReturn(true);
		List<PharmacyMedicineSupply> empty = new ArrayList<PharmacyMedicineSupply>();
		List<PharmacyMedicineSupply> pharmList = pharmacyService.retrievePharmacies("token",10000, "Orthoherb", 3000);
		assertEquals(pharmList,empty);
	}
	
}
