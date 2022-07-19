package com.flightApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightApp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
	public Admin findByEmailidAndPassword(String emailid,String password);
	public Boolean existsByEmailidAndPassword(String emailid,String password);

}
