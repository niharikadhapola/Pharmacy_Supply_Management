package com.cognizant.pharmacymanagement.RepresentativeSchedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is responsible for creating all objects, dependency
 *          injection and managing the life cycle of all beans
 */
@SpringBootApplication
@org.springframework.cloud.openfeign.EnableFeignClients
public class RepresentativeScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepresentativeScheduleApplication.class, args);
	}

}
