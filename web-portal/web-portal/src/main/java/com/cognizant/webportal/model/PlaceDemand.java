package com.cognizant.webportal.model;

import lombok.Data;

@Data
public class PlaceDemand {
	
	private String medicineName;
	private int demand;
	
	public PlaceDemand(String medicineName, int demand) {
		this.medicineName = medicineName;
		this.demand = demand;
	}

}
