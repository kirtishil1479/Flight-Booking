package com.flightApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightApp.entity.Admin;
import com.flightApp.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminServiceI{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Boolean valideAdmin(String emailid, String password) {
		return adminRepository.existsByEmailidAndPassword(emailid,password);
	}
	
	
	
	@Override
	public boolean validateLogin(String emailid, String password) {
		Admin admin = adminRepository.findByEmailidAndPassword(emailid,password);
		if(admin==null) {
			return false;
		}else {
			return true;
		}	
	}

}
