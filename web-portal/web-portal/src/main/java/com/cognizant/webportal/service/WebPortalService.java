package com.cognizant.webportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.webportal.feign.AuthClient;
import com.cognizant.webportal.model.AuthResponse;

@Service
public class WebPortalService {
	
	@Autowired
	private AuthClient authClient;
	
	public Boolean isSessionValid(String token) {
		try {
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
