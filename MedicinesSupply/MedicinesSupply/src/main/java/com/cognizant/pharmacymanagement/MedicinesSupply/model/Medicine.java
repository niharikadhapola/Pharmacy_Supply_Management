package com.cognizant.pharmacymanagement.MedicinesSupply.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Model class used to represent the details about the medicine stock.
 * Includes getters and setters
 */
@Entity
public class Medicine {
	
	@Id
	private String name;
	private String chemicalComposition;
	private String targetAilment;
	private LocalDate dateOfExpiry;
	private int numberOfStock;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChemicalComposition() {
		return chemicalComposition;
	}
	public void setChemicalComposition(String chemicalComposition) {
		this.chemicalComposition = chemicalComposition;
	}
	public String getTargetAilment() {
		return targetAilment;
	}
	public void setTargetAilment(String targetAilment) {
		this.targetAilment = targetAilment;
	}
	public LocalDate getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(LocalDate dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public int getNumberOfStock() {
		return numberOfStock;
	}
	public void setNumberOfStock(int numberofStock) {
		this.numberOfStock = numberOfStock;
	}
	@Override
	public String toString() {
		return "Medicine [name=" + name + ", chemicalComposition=" + chemicalComposition + ", targetAilment="
				+ targetAilment + ", dateOfExpiry=" + dateOfExpiry + ", numberofstock=" + numberOfStock + "]";
	}
	
	
}
