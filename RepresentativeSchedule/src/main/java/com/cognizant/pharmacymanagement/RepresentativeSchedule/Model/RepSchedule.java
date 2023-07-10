package com.cognizant.pharmacymanagement.RepresentativeSchedule.Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Model class used to represent the details about the RepSchedule.
 * Includes getters and setters
 */
public class RepSchedule {	
	private String name;
	private String doc;
	private String ailment;
	private String meds;
	private String slot;
	private String date;
	private String number;
	
	public RepSchedule(String name2, String doc, String treating, List<String> med, String time,
			Date date, String number2) {
		// TODO Auto-generated constructor stub
		name=name2;
		this.doc=doc;
		ailment=treating;
		for(String m:med) {
			if(meds==null) {
				meds=m;
			}
			else {
				meds+=", "+m;
			}
		}
		slot=time;
		this.date=datetostr(date);
		number=number2;
		//System.out.println(Name+DocName+Ailment+meds+MeetingSlot+meetingDate+number);
	}
	
	public RepSchedule(String name2, String doc, String treating, String med, String time,
			Date date, String number2) {
		// TODO Auto-generated constructor stub
		name=name2;
		this.doc=doc;
		ailment=treating;
		meds=med;
		slot=time;
		this.date=datetostr(date);
		number=number2;
	}

	public static String datetostr(Date date)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	    return formatter.format(date);  
	}
	
	@Override
    public String toString() {
        return String.format(
                "Rep name: %s, Doctor name: %s, Treating Ailment: %s, Medicine: %s, Slot: %s, Date: %s, Doctor Contact#: %s"
        				,name,doc,ailment,meds,slot,date,number);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getAilment() {
		return ailment;
	}

	public void setAilment(String ailment) {
		this.ailment = ailment;
	}

	public String getMeds() {
		return meds;
	}

	public void setMeds(String meds) {
		this.meds = meds;
	}

	

	public void setMeetingDate(Date date) {
		this.date = datetostr(date);
	}
	
	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}

/*
public void setMeetingSlot(Date meetingSlot) {
		MeetingSlot = datetostr(meetingSlot);
	}





<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Representative Schedule</title>
</head>
<body>
	<BR/>
	<table class="table table-striped">
			<caption>Here are the list of details:</caption>
			<thead>
				<tr>
					<th>Rep Name</th>
					<th>Doctor's Name</th>
					<th>Treating Ailment</th>
					<th>Medicine</th>
					<th>Slot</th>
					<th>Date</th>
					<th>Doctor Contact#</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${details}" var="detail">
					<tr>
						<td>${detail.Name}</td>
						<td>${detail.DocName}</td>
						<td>${detail.Ailment}</td>
						<td>${detail.meds}</td>
						<td>${detail.MeetingSlot}</td>
						<td>${detail.meetingDate}</td>
						<td>${detail.number}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
</body>
</html>

*/