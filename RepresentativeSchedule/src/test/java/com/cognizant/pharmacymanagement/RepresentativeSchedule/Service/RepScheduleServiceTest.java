package com.cognizant.pharmacymanagement.RepresentativeSchedule.Service;

import static org.junit.Assert.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.RepSchedule;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.feignClient.StockFeignClient;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Service.*;

/**
 * This class contains test cases for the MedicineSupplyController class which
 * are written using Junit and Mockito
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepScheduleServiceTest {
	
	@InjectMocks
	private RepScheduleService repScheduleService;
	
	
	@Mock
	private RepService repService;
	
	@Mock
	private Doctor doctor;
	
	@Mock
	private DoctorService doctorService;
	

	/**
	 * @throws Exception  Tests the ReturnSchedule method and checks if
	 *  						the returned value is null or not
	 */
	@Test
	public void testReturnSchedule() throws ParseException {
		
		assertNotNull(repScheduleService.returnschedule("2021-03-12"));
	}
	
	/**
	 * @throws Exception  Tests the StringtoDate method and checks if
	 *  						the returned value is equal to given value
	 */
	@Test
	public void testStringtoDate() throws ParseException {
		
		Date date = repScheduleService.StringtoDate("2021-03-12");
		assertEquals(date,new SimpleDateFormat("dd-MM-yyyy").parse("12-03-2021"));
	}
	
	/**
	 * @throws Exception  Tests the findNextDay method and checks if
	 *  						the returned value is equal to given value
	 */
	@Test
	public void testFindNextDay() throws ParseException {
		
		assertEquals(repScheduleService.findNextDay(new SimpleDateFormat("dd-MM-yyyy").parse("12-03-2021")),new SimpleDateFormat("dd-MM-yyyy").parse("13-03-2021"));
	}
}
