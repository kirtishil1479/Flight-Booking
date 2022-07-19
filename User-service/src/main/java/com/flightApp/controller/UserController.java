package com.flightApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightApp.entity.User;
import com.flightApp.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	
	
	@PostMapping(value = "/saveUser")
	public User saveTraveller(@RequestBody User user) {
		User save = userService.saveUser(user);
		return save;
	}
	@PostMapping(value = "/saveAdmin")
	public User saveAdmin(@RequestBody User user)  {
		User save = userService.saveUser(user);
		return save;
	} 
	
	@GetMapping(value ="/validate/{emailid}/{password}")
	public boolean validateUser(@PathVariable String emailid, @PathVariable String password) {
		return userService.validateLogin(emailid,password);
	}
	
	@GetMapping(value ="/valideUser/{emailid}/{password}")
	public Boolean valideUser(@PathVariable String emailid, @PathVariable String password) {
		return userService.valideUser(emailid, password);
	}
	
	@GetMapping(value ="/valideAdmin/{emailid}/{password}")
	public Boolean valideAdmin(@PathVariable String emailid, @PathVariable String password) {
		return userService.valideAdmin(emailid, password);
	}
	
	
	
	

}
