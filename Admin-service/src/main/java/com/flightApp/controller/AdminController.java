package com.flightApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightApp.service.AdminServiceI;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceI adminService;
	
	@GetMapping(value ="/loginAdmin/{emailid}/{password}")
	public Boolean loginCheckAdmin(@PathVariable String emailid, @PathVariable String password) {
		return adminService.valideAdmin(emailid, password);
	}
	
	
	
	
	
	
	

}
