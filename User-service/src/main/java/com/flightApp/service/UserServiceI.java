package com.flightApp.service;

import com.flightApp.entity.User;

public interface UserServiceI {
	
	public User saveUser(User user);
	public boolean validateLogin(String emailid,String password);
	public Boolean valideUser(String emailid, String password);
	public Boolean valideAdmin(String emailid, String password);

}
