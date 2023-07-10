package com.cognizant.pharmacymanagement.RepresentativeSchedule.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;


import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.Doctor;

/**
 * This class is providing the implementation for DoctorService interface. 
 * It contains all the business logic related to the Doctor model.
 */
@Service
public class DoctorService {
	private static List<Doctor> doclist=new ArrayList<Doctor>();
	private static int docCount = 0;
	
	static{
		//adding doctors to list from flat file
		
		try {
			docCount=0;
			Scanner input = new Scanner(new File("doctor.text"));
			input.useDelimiter("-|\n");
			while(input.hasNext()){
				String name=input.next();
				String number=input.next();
				String treating=input.next();
				String sl=input.next().replace("\r", "");
				doclist.add(new Doctor(name,number,treating,sl));
				docCount++;
			}
			input.close();
		}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
//		doclist.add(new Doctor("D1","9884122113","Orthopaedics","1PM to 2PM"));
//		doclist.add(new Doctor("D2","9884122113","General","1PM to 2PM"));
//		doclist.add(new Doctor("D3","9884122113","Gynaecology","2PM to 3PM"));
//		doclist.add(new Doctor("D4","9884122113","Orthopaedics","1PM to 2PM"));
//		doclist.add(new Doctor("D5","9884122113","General","2PM to 3PM"));
//		docCount=5;
	}
	
	/**
	 * This method is used to retrieve the next doctor
	 * who is not allotted
	 * @return doc
	 */
	public Doctor retrieveDoc() {
        for (Doctor doc : doclist) {
            if(!doc.isAllotted()) {
                return doc;
            }
        }
        return null;
    }
	
	/**
	 * This method is used to check for the next available doctor
	 * @param n
	 * @return doc
	 */
	public Doctor retrieveDoc(String n) {
        for (Doctor doc : doclist) {
            if(!doc.isAllotted() && !doc.getName().equals(n)) {
                return doc;
            }
        }
        return null;
    }
	
	/**
	 * This method is used to set the allotment of a doctor
	 * @param n
	 */
	public void setAllotment(String n) {
		for (Doctor doc : doclist) {
            if(doc.getName().equals(n)) {
                doc.setAllotted(true);
                break;
            }
        }
	}
	
	/**
	 * This method resets the allotment to the default value
	 */
	public void resetAllotment() {
		for (Doctor doc : doclist) {
            doc.setAllotted(false);
        }
	}
	
	/**
	 * This method returns the Doctors list
	 * @return doclist
	 */
	public List<Doctor> getDoclist() {
		return doclist;
	}
	
	/**
	 * This method returns the doctor count
	 * @return DocCount
	 */
	public int getDocCount() {
		return docCount;
	}
	
	/**
	 * Sets DocCount value
	 * @param docCount
	 */
	public void setDocCount(int docCount) {
		DoctorService.docCount = docCount;
	}
	 
}
