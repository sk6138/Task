package com.Task;

import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {
  
	
	public boolean isauthen(String user ,String pass) {
		boolean isvalidId = user.equalsIgnoreCase("sahil Kumar");
		boolean isvalidPass = pass.equalsIgnoreCase("sahil");
		return (isvalidId && isvalidPass);
	}
}
