package com.jspiders.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springrest.pojo.AdminPOJO;
import com.jspiders.springrest.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository repository;

	public AdminPOJO createAdmin(AdminPOJO pojo) {
		AdminPOJO admin = repository.createAdmin(pojo);
		return admin;
	}

	public AdminPOJO loginAdmin(AdminPOJO pojo) {
		AdminPOJO admin =  repository.loginAdmin(pojo);
		return admin;
	}

}
