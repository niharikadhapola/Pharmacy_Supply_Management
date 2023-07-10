package com.cognizant.pharmacymanagement.RepresentativeSchedule.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.pharmacymanagement.RepresentativeSchedule.Model.AuthResponse;


/**
 * This interface communicates with authorization service to verify the token.
 * It takes the url of the service to whom we wants to communicate and the name
 * attribute in annotation FeignClient must be the name we have specified in the
 * properties file of the service to whom we wants to communicate.
 * 
 */
@FeignClient(name = "authorization-service", url = "http://localhost:9095")
public interface AuthClient {
	/**
	 * This method will verify whether the token is valid or expired.
	 * 
	 * @param token
	 * @return An object of type AuthResponse which has fields userid, username and
	 *         isValid.
	 */
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);

}
