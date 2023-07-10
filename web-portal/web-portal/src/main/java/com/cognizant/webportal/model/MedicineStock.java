package com.cognizant.webportal.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicineStock {
	
	private String name;
	private String chemicalComposition;
	private String targetAilment;
	private LocalDate dateOfExpiry;
	private int numberOfStock;

}
