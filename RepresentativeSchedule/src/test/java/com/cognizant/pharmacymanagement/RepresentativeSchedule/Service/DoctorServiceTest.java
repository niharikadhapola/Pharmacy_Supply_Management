package com.cognizant.pharmacymanagement.RepresentativeSchedule.Service;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.Doctor;

/**
 * This class contains test cases for the MedicineSupplyController class which
 * are written using Junit and Mockito
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorServiceTest {
	
	@InjectMocks
	private DoctorService doctorService;
	
	@Mock
	private Doctor doctor;
	
	/**
	 * @throws Exception  Tests the RetrieveDoc method and checks if
	 *  						the returned value is null or not
	 */
	@Test
	public void testRetrieveDocwhenAllottedisTrue() {
		doctor.setAllotted(true);
		Doctor doc1= doctorService.retrieveDoc();
		assertNotNull(doc1);
	}
	
	/**
	 * @throws Exception  Tests the RetrieveDoc method and checks if
	 *  						the returned value is null or not
	 */
	@Test
	public void testRetrieveDocNotNull() {
		Doctor doc1= doctorService.retrieveDoc("D1");
		assertNotNull(doc1);
	}
	
	/**
	 * @throws Exception  Tests the RetrieveDoc method and checks if
	 *  						the returned value is equal to the given value
	 */
	@Test
	public void testRetrieveDoc() {
		Doctor doc1= doctorService.retrieveDoc("D1");
		assertEquals(doc1.getName(),"D2");
	}
	
	/**
	 * @throws Exception  Tests the SetAllottment method and checks if
	 *  						the returned value is true
	 */
	@Test
	public void testSetAllottmentwhenTrue() {
		doctorService.setAllotment("D1");
		boolean allot = doctorService.getDoclist().get(0).isAllotted();
		assertTrue(allot);
	}

	/**
	 * @throws Exception  Tests the SetAllottment method and checks if
	 *  						the returned value is false
	 */
	@Test
	public void testSetAllottmentwhenFalse() {
		doctorService.setAllotment("D1");
		boolean allot = doctorService.getDoclist().get(1).isAllotted();
		assertFalse(allot);
	}
	
	/**
	 * @throws Exception  Tests the ResetAllotment method and checks if
	 *  						the returned value is false
	 */
	@Test
	public void testResetAllotment() {
		doctorService.setAllotment("D1");
		doctorService.resetAllotment();
		boolean allot = doctorService.getDoclist().get(0).isAllotted();
		assertFalse(allot);
		
	}
	
	/**
	 * @throws Exception  Tests the GetDocList method and checks if
	 *  						the returned value is null or not
	 */
	@Test
	public void testGetDocList() {
		assertNotNull(doctorService.getDoclist());
	}
	
	/**
	 * @throws Exception  Tests the GetDocCoun method and checks if
	 *  						the returned value is null or not
	 */
	@Test
	public void testGetDocCount() {
		assertNotNull(doctorService.getDocCount());
	}
	
	/**
	 * @throws Exception  Tests the SetDocCount method and checks if
	 *  						the returned value is equal to given value
	 */
	@Test
	public void testSetDocCount() {
		doctorService.setDocCount(3);
		assertEquals(doctorService.getDocCount(),3);
	}
}
