package com.cognizant.webportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ViewSchedule {
	
	private String startDate;
	
	public ViewSchedule(String date) {
		this.startDate = date;
	}

}
