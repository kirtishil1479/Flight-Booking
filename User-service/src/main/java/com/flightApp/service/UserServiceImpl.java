package com.flightApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightApp.entity.User;
import com.flightApp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserRepo userRepository;
	
	@Override
	public User saveUser(User user) {
		List<User> findAll = userRepository.findAll();
		for(User u:findAll) {
			if(u.getEmailid().equals(user.getEmailid())){
			return user;
			}
		}
		return userRepository.save(user);	
	}

	@Override
	public boolean validateLogin(String emailid, String password) {
		User user = userRepository.findByEmailidAndPassword(emailid,password);
		if(user==null) {
			return false;
		}else {
			return true;
		}	
	}
	
	@Override
	public Boolean valideUser(String emailid, String password) {
		return userRepository.existsByEmailidAndPassword(emailid,password);	
	}

	@Override
	public Boolean valideAdmin(String emailid, String password) {
		return userRepository.existsByEmailidAndPassword(emailid,password);
	}
	


	
	

}
