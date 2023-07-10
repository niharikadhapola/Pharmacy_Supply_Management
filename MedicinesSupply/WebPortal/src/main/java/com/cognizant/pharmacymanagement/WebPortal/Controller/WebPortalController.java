package com.cognizant.pharmacymanagement.WebPortal.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pharmacymanagement.WebPortal.WebPortalApplication;
import com.cognizant.pharmacymanagement.WebPortal.FeignClient.MedicineSupplyFeignClient;
import com.cognizant.pharmacymanagement.WebPortal.FeignClient.RepScheduleFeignClient;
import com.cognizant.pharmacymanagement.WebPortal.FeignClient.StockFeignClient;
import com.cognizant.pharmacymanagement.WebPortal.Model.PharmacyMedicineSupply;
import com.cognizant.pharmacymanagement.WebPortal.Model.UserData;
import com.cognizant.pharmacymanagement.WebPortal.service.WebportalService;
/**
 * This class is handling all the end points for entire web portal.
 * This controller has mappings which will be used to login, authenticate and call the other microservices whenever required. 
 * WebportalService is used to verify the login.
 * 
 */
@RestController
public class WebPortalController {
	
	/** Object to which login information is stored */
	@Autowired
	UserData admin;
	
	/** List used to store logged out tokens */
	private static List<String> revokedTokens=new ArrayList<String>();

	/** Logger object */
	private static Logger LOGGER = LoggerFactory.getLogger(WebPortalApplication.class);
	
	/** Object used for token validation */
	@Autowired
	WebportalService webportalService;
	
	/**
	 * This method is providing the implementation of logout functionality. 
	 */
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public ModelAndView getLogout(HttpSession session) {
		if (session != null && (String) session.getAttribute("token") != null
				&& webportalService.isSessionValid((String) session.getAttribute("token"))) {
			revokedTokens.add((String) session.getAttribute("token"));
			return new ModelAndView("login");
		}
		return new ModelAndView("Home");
	}
	
	/**
	 * This method is providing the implementation of login functionality. 
	 */
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView getLogin(HttpSession session) {
		LOGGER.info("Starting getLogin");
		if (session != null && (String) session.getAttribute("token") != null
				&& webportalService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			LOGGER.info("Ending getLogin");
			return new ModelAndView("Home");
		}
		LOGGER.info("Ending getLogin");
		return new ModelAndView("login");
	}
	
	/**
	 * This method is providing the implementation of post login action. 
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public <user> ModelAndView postLogin(HttpSession session, ModelMap model, @ModelAttribute UserData user, ModelMap warning) {
		LOGGER.info("Starting postLogin");
		LOGGER.info("Ending postLogin");
		return new ModelAndView(webportalService.postLogin(user, session, warning));
	}

	/**
	 * This method is used to redirect to the home page after login. 
	 */
	@GetMapping("/Home")
	public ModelAndView getHomePage(HttpSession session) {
		LOGGER.info("Starting getHomePage");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			LOGGER.info("Ending getHomePage");
			return new ModelAndView("Home");
		}
		LOGGER.info("Ending getHomePage");
		return new ModelAndView("login");
	}
	
	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	
	/** Object used for communicate with MedicinesSuppl microservice */
	@Autowired
	private MedicineSupplyFeignClient medicineSupplyFeign;

	/**
	 * This method is used to return the /showDemand page. 
	 */
	@RequestMapping(value="/viewDemand", method = RequestMethod.GET)
	public ModelAndView showSupplyPage(HttpSession session){
		LOGGER.info("Starting showSupplyPage");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			LOGGER.info("Ending showSupplyPage");
			return new ModelAndView(medicineSupplyFeign.showSupplyHomePage((String) session.getAttribute("token")));
		}
		LOGGER.info("Ending showSupplyPage");
		return new ModelAndView("login");
	}

	@Autowired
	private StockFeignClient stockFeignClient;
	/**
	 * This method is used to return the /SupplyAvailed page after accepting the medicine details from /showDemand. 
	 */
	@GetMapping(value="/SupplyAvailed")
	public ModelAndView showList(HttpSession session, @RequestParam String name, @RequestParam long demand,ModelMap model){
		LOGGER.info("Starting showList");
		int stock = stockFeignClient.getStockCountForMedicine(name);
		if (webportalService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			List<PharmacyMedicineSupply> list=medicineSupplyFeign.showList((String) session.getAttribute("token"), name, demand);
			if(list==null) {
				model.put("errorMessage", "PAGE EXPIRED");
				LOGGER.info("Ending showList");
				return new ModelAndView ("viewDemand");				
			}
			if(demand<5) {
				model.put("errorMessage", "Invalid Input!");
				LOGGER.info("Ending showList");
				return new ModelAndView ("viewDemand");
			}
			if(list.isEmpty()) {
				model.put("errorMessage", "Stock not available!");
				LOGGER.info("Ending showList");
				return new ModelAndView ("viewDemand");
			}
			if(demand>stock) {
				model.put("pharmacyList", list);
				LOGGER.info("Ending showList");
				model.put("stock",stock);
				model.put("errorMessage", "demand>stock");
				return new ModelAndView ("SupplyAvailed");
			}
			model.put("pharmacyList", list);
			LOGGER.info("Ending showList");
			model.put("stock",stock);
			return new ModelAndView ("SupplyAvailed");
		}
		LOGGER.info("Ending showList");
		return new ModelAndView("login");
	}
	
	//-------------------------------------------------------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------------------------------------------------------
	/** Object used for communicate with RepresentativeSchedule microservice */
	@Autowired
	private RepScheduleFeignClient repScheduleClient;

	/**
	 * This method is used to return the /SupplySchedule page that accepts date details for /RepSchedule. 
	 */
	@RequestMapping(value ="/viewSchedule", method = RequestMethod.GET)
	public ModelAndView showRepSch(HttpSession session) {
		LOGGER.info("Starting showRepSch");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			LOGGER.info("Ending showRepSch");
			return new ModelAndView(repScheduleClient.showDate((String) session.getAttribute("token")));
		}
		LOGGER.info("Ending showRepSch");
		return new ModelAndView("login");
	}
	
	/**
	 * This method is used to accept date from user and then return the schedule to display in /returnSchedule. 
	 */
	@RequestMapping(value ="/RepSchedule", method = RequestMethod.GET)
	public ModelAndView showRepSch(HttpSession session, @RequestParam String startdate,ModelMap model) {
		LOGGER.info("Starting showRepSch");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))&&!revokedTokens.contains((String) session.getAttribute("token"))) {
			model.put("details",repScheduleClient.showSchedule((String) session.getAttribute("token"),startdate));
			LOGGER.info("Ending showRepSch");
			return new ModelAndView("returnSchedule");
		}
		LOGGER.info("Ending showRepSch");
		return new ModelAndView("login");
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
}
