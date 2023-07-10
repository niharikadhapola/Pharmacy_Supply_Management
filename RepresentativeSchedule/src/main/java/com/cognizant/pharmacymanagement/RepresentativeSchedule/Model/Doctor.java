package com.cognizant.pharmacymanagement.RepresentativeSchedule.Model;



/**
 * Model class used to represent the details about the Doctor
 * Includes getters and setters
 */
public class Doctor {
	private String name;
	private String number;
	private String Treating;
	private boolean allotted;
	private String slot;
	
	public Doctor(String name2, String number2, String treating2,String sl) {
		// TODO Auto-generated constructor stub
		name=name2;
		number=number2;
		Treating=treating2;
		allotted=false;
		slot=sl;
	}
	public Doctor() {
		// TODO Auto-generated constructor stub
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTreating() {
		return Treating;
	}
	public void setTreating(String treating) {
		Treating = treating;
	}
	public boolean isAllotted() {
		return allotted;
	}
	public void setAllotted(boolean allotted) {
		this.allotted = allotted;
	}
	@Override
    public String toString() {
        return String.format(
                "Doctor[name=%s, PhoneNo=%s, Treating Ailment=%s, Slot=%s]", name,
                number, Treating, slot);
    }
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
}
