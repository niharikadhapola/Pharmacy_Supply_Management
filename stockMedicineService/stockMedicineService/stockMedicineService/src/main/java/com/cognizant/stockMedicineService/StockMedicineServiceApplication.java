package com.cognizant.stockMedicineService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StockMedicineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMedicineServiceApplication.class, args);
	}

}
