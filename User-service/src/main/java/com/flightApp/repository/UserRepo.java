package com.flightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightApp.entity.User;

public interface UserRepo extends JpaRepository<User, String> {
	
	public User findByEmailidAndPassword(String emailid,String password);
	public Boolean existsByEmailidAndPassword(String emailid,String password);

}
