package com.flightApp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserServiceFeignClient {
	
	@GetMapping(value ="/valideAdmin/{emailid}/{password}")
	public Boolean valideAdmin(@PathVariable String emailid, @PathVariable String password);
	
	@GetMapping(value ="/user/valideUser/{emailid}/{password}")
	public Boolean valideUser(@PathVariable String emailid, @PathVariable String password);
}