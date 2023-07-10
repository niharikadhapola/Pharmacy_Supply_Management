package com.cognizant.pharmacymanagement.WebPortal.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.WebPortal.Model.RepSchedule;
/**
 * This interface communicates with RepresentativeSchedule service and helps call its methods.
 * It is used to display the viewSchedule page, accept the date and display the schedule through the showSchedule page.
 * 
 */
@FeignClient(url="http://localhost:8082", name="RepresentativeSchedule")
public interface RepScheduleFeignClient {
	/**
	 * @param token              It will come from the authorization header which
	 *                           will be sent to authorization service for
	 *                           validation. If token is valid then only we will
	 *                           continue further.
	 *
	 * Directs to the page that allows user to select date
	 */
	@GetMapping("/viewSchedule")
	public String showDate(@RequestHeader("Authorization") String token);
	
	/**
	 * @param token              It will come from the authorization header which
	 *                           will be sent to authorization service for
	 *                           validation. If token is valid then only we will
	 *                           continue further.
	 *
	 * Directs to the page that allows user to view schedule
	 */
	@GetMapping("/RepSchedule")
	public List<RepSchedule> showSchedule(@RequestHeader("Authorization") String token, @RequestParam String startdate);
}