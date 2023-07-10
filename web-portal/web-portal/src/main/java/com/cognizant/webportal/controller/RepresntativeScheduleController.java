package com.cognizant.webportal.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.webportal.WebPortalApplication;
import com.cognizant.webportal.feign.RepresentativeSchedulerClient;
import com.cognizant.webportal.model.RepSchedule;
import com.cognizant.webportal.model.ViewSchedule;
import com.cognizant.webportal.service.WebPortalService;

@RestController
@CrossOrigin
public class RepresntativeScheduleController {
	
	@Autowired
	private RepresentativeSchedulerClient repScheduleClient;
	
	@Autowired
	private WebPortalService webPortalService;
	
	private static List<String> revokedTokens=new ArrayList<String>();

	private static Logger LOGGER = LoggerFactory.getLogger(WebPortalApplication.class);
//	
//	@RequestMapping(value ="/RepSchedule/{startdate}", method = RequestMethod.GET)
//	public List<RepSchedule> showRepSch(@RequestHeader("Authorization") String token, @PathVariable String startdate) {
//		LOGGER.info("Starting showRepSch");
//		if (webPortalService.isSessionValid(token)&&!revokedTokens.contains(token)) {
//			
//			List<RepSchedule> list = repScheduleClient.showSchedule(token ,startdate);
//			return list;
//			
//			
//		}
//	
//		return null;
//		
//	}
	
	@RequestMapping(value ="/RepSchedule/{startdate}", method = RequestMethod.GET)
	public ResponseEntity<?> showRepSch(@RequestHeader("Authorization") String token, @PathVariable String startdate) {
		LOGGER.info("Starting showRepSch");
		if (webPortalService.isSessionValid(token)&&!revokedTokens.contains(token)) {
			
			List<RepSchedule> list;
			try {
				list = repScheduleClient.showSchedule(token ,startdate);
			} catch (ParseException e) {
				return new ResponseEntity<>("Please Enter Valid Date in dd/mm/yyyy format", HttpStatus.FORBIDDEN);
			}
			
				return new ResponseEntity<>(list, HttpStatus.OK);
			
			
			
			
			
		}
	
		return null;
		
	}
	
	
	
}
