package com.cognizant.stockMedicineService.service;

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

import com.cognizant.stockMedicineService.dao.MedicineStockDAO;
import com.cognizant.stockMedicineService.model.Medicine;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineStockServiceImplTest {

    @InjectMocks
    private MedicineStockServiceImpl medicineServiceImpl;

    @Mock
    private MedicineStockDAO medicineDAO;

    @Mock
    private Medicine medicine;

    @Test
    public void testGetMedicineStockInformation() {
        assertNotNull(medicineServiceImpl.getMedicineStockInformation());
    }
    @Test
    public void testGetMedicineByTargetAilment() {
        assertNotNull(medicineServiceImpl.getMedicineByTargetAilment("Orthoherb"));
    }
    @Test
    public void testGetNumberOfTabletsInStockByName() {
    	int numberOfTabletsInStockByName = medicineServiceImpl.getNumberOfTabletsInStockByName("Orthoherb");
		assertNotNull(numberOfTabletsInStockByName);
    	//assertNotNull(medicineServiceImpl.getNumberOfTabletsInStockByName("Dolo-650"));
    }

}