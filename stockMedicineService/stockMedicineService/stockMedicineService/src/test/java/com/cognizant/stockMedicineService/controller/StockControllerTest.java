package com.cognizant.stockMedicineService.controller;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.stockMedicineService.StockMedicineServiceApplication;
import com.cognizant.stockMedicineService.dao.MedicineStockDAO;
import com.cognizant.stockMedicineService.model.Medicine;
import com.cognizant.stockMedicineService.service.MedicineStockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockControllerTest {

	@InjectMocks
	private StockController stockController;
	
	@Mock
	private MedicineStockDAO medicineDAO;
	
	@Mock
	private Medicine medicineStock;
	
	@Mock
	private MedicineStockService medicineStockService;
	
	@Test
	public void testGetMedicineStockInformation() {
		ResponseEntity<?> responseEntity = stockController.getMedicineStockInformation();
		HttpStatus status = responseEntity.getStatusCode();
		assertNotNull(status);
		assertEquals(HttpStatus.OK,status);
	}
	@Test
	public void testGetMedicineByTreatingAilment() {
		ResponseEntity<?> responseEntity = stockController.getMedicineByTreatingAilment("Gynaecology");
		HttpStatus status = responseEntity.getStatusCode();
		assertNotNull(status);
		assertEquals(HttpStatus.OK,status);
	}
	@Test
	public void testGetStockCountForMedicine() {
		ResponseEntity<?> responseEntity = stockController.getStockCountForMedicine("Orthoherb");
		HttpStatus status = responseEntity.getStatusCode();
		assertNotNull(status);
		assertEquals(HttpStatus.OK,status);
	}
}
