package com.cognizant.pharmacymanagement.RepresentativeSchedule.Controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.RepSchedule;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Service.RepScheduleService;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.feignClient.StockFeignClient;

/**
 * This class contains test cases for the MedicineSupplyController class which
 * are written using Junit and Mockito
 */
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest

public class RepSchedControllerTest {
	
	@InjectMocks
	private RepSchedController repSchedController;
	
	@Mock
	private RepScheduleService repService;
	
	/**
	 * @throws Exception  Tests the showschedule method and checks if
	 *  						the returned value is null or not
	 */
	@Test
	public void testshowschedule() throws Exception{
	when(repService.isSessionValid("token")).thenReturn(true);
	ResponseEntity<?> responseEntity = repSchedController.showSchedule("token","11-03-2021");
	HttpStatus status = responseEntity.getStatusCode();
	assertNotNull(status);
	assertEquals(HttpStatus.OK,status);
	}
}
