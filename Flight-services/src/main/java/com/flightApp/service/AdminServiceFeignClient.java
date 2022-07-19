package com.flightApp.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("admin-service")
public interface AdminServiceFeignClient {
	
	@GetMapping(value ="/admin/valideAdmin/{emailid}/{password}")
	public Boolean valideAdmin(@PathVariable String emailid, @PathVariable String password);
	
}
