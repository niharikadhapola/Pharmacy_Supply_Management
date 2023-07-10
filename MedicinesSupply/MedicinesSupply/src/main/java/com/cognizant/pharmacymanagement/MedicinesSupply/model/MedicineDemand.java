package com.cognizant.pharmacymanagement.MedicinesSupply.model;

/**
 * Model class used to represent the details about the medicine demand.
 * Includes getters and setters
 */
public class MedicineDemand {
	private String medicine;
	private int demandCount;
	
	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	
	public int getDemandCount() {
		return demandCount;
	}
	
	public void setDemandCount(int demandCount) {
		this.demandCount = demandCount;
	}
	
	public MedicineDemand(String medicine, int demandCount) {
		super();
		this.medicine = medicine;
		this.demandCount = demandCount;
	}
	
	public MedicineDemand() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return String.format(
                "MedicineDemand [medicine=%s, demandCount=%d]",
                medicine, demandCount);
	
}
	
}
