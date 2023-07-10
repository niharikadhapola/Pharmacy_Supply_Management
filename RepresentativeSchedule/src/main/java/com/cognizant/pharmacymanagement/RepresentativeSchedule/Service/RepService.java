package com.cognizant.pharmacymanagement.RepresentativeSchedule.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pharmacymanagement.RepresentativeSchedule.feignClient.AuthClient;

/**
 *This class is providing the implementation for RepService
 *interface. It contains all the business logic to extract the details
 *related to representatives.
 */
@Service
public class RepService {
	
	@Autowired
	private AuthClient authClient;
	
	private static List<String> replist=new ArrayList<String>();
	private static int repMark=0;
	private static int repCount;
	static {
		replist.add(new String("R1"));
		replist.add(new String("R2"));
		replist.add(new String("R3"));
		repCount=3;
	}
	public void initialMark() {
		repMark=0;
	}
	/**
	 * Method is used to iterate through repList
	 * @return repList.get(ind)
	 */
	public String retrieveRep() {
		int ind=repMark;
		if(++repMark==repCount) {
			repMark=0;
		}
        return replist.get(ind);
    }
}
