package com.jspiders.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jspiders.springrest.pojo.AdminPOJO;
import com.jspiders.springrest.responce.AdminResponse;
import com.jspiders.springrest.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping(path = "/createAccount",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> createAccount(@RequestBody AdminPOJO pojo){
		AdminPOJO admin = service.createAdmin(pojo);
		//success flow
		if (admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Account Created Successfully.",admin),HttpStatus.ACCEPTED);
		}
		//failure flow
		return new ResponseEntity<AdminResponse>(new AdminResponse("Account not Created",null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping(path = "/login",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse>loginAdmin(@RequestBody AdminPOJO pojo){
		AdminPOJO admin = service.loginAdmin(pojo);
		
		//success flow
		if (admin != null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("LoggedIn Successfully.!!",admin),HttpStatus.OK);
		}
		//failure flow
		return new ResponseEntity<AdminResponse>(new AdminResponse("Login Failed..!!",null),HttpStatus.NOT_FOUND);
	}
}
