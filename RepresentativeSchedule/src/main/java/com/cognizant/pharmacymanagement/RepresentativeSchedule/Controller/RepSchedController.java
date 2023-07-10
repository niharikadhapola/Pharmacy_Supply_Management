package com.cognizant.pharmacymanagement.RepresentativeSchedule.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.cognizant.pharmacymanagement.RepresentativeSchedule.RepresentativeScheduleApplication;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.RepSchedule;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.StartDate;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.UserData;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.Service.RepScheduleService;
import com.cognizant.pharmacymanagement.RepresentativeSchedule.feignClient.StockFeignClient;


/**
 * This class is handling all the end points for RepScheduleService.
 * This controller has mappings which will be used to display schedule based on date provided. 
 * AuthClient is used to verify the token.
 * 
 */
@RestController
@CrossOrigin
public class RepSchedController {

	/**
	 * This method is used to format dates that 
	 * is then sent to the jsp
	 * @param binder
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
	private static Logger LOGGER = LoggerFactory.getLogger(RepresentativeScheduleApplication.class);
	
	@Autowired
	UserData admin;
	
	/**
	 *This is the object of the class that
	 *contains the business logic for generating the schedule
	 */
	@Autowired
	private RepScheduleService service;
	

	/**
	 * @param token              It will come from the authorization header which
	 *                           will be sent to authorization service for
	 *                           validation. If token is valid then only we will
	 *                           continue further.
	 *
	 * Directs to the page that allows user to select date
	 */
	@RequestMapping(value ="/viewSchedule", method = RequestMethod.GET)
	public String showDate(@RequestHeader("Authorization") String token) {
		LOGGER.info("Starting showDate");
		//return new ModelAndView("viewSchedule");
		//return new ResponseEntity<>(new ModelAndView("viewSchedule"), HttpStatus.OK);
		if (service.isSessionValid(token)) {
			LOGGER.info("Ending showDate");
			return "viewSchedule";
		}
		LOGGER.info("Ending showDate");
		return "login";
	}
	
	/**
	 * @param token              It will come from the authorization header which
	 *                           will be sent to authorization service for
	 *                           validation. If token is valid then only we will
	 *                           continue further.
	 *
	 * Directs to the page that allows user to view schedule
	 */
	@GetMapping("/RepSchedule/{startdate}")
	public ResponseEntity<?> showSchedule(@RequestHeader("Authorization") String token,@PathVariable String startdate) throws ParseException{    
		//model.put("details",service.returnschedule(startdate));
		//String startDate = startdate.getStartdate();
		LOGGER.info("Starting showschedule");
		if (service.isSessionValid(token)) {	
			LOGGER.info("Ending showschedule");
			LOGGER.info(startdate);
			return new ResponseEntity<>(service.returnschedule(startdate), HttpStatus.OK);
		}
		LOGGER.info("Ending showSchedule");
		return null;
	}
	
}
