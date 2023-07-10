package com.cognizant.pharmacymanagement.WebPortal.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.pharmacymanagement.WebPortal.Model.AuthResponse;
import com.cognizant.pharmacymanagement.WebPortal.Model.UserData;


/**
 * This interface communicates with authorization service to verify the token.
 * It takes the url of the service to whom we want to communicate and the name
 * attribute in annotation FeignClient must be the name we have specified in the
 * properties file of the service to whom we wants to communicate.
 * 
 */
@FeignClient(name = "authorization-service", url = "http://localhost:9095")
public interface AuthClient {

	/**
	 * This method is used to check the login credentials, if there are valid,
	 * by checking against the database.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UserData login(@RequestBody UserData userlogincredentials);
	
	/**
	 * This method validates the token {see @JwtUtils}
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);

}
