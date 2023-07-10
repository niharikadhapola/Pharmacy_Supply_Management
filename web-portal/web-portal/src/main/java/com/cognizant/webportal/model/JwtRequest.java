package com.cognizant.webportal.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public JwtRequest() {
		
	}
	
	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
}
