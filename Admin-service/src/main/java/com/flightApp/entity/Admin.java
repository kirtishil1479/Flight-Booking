package com.flightApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@Column(unique = true)
	private String emailid;
    private String firstname;
	private String lastname;
	private String password;
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [emailid=" + emailid + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + "]";
	}
	public Admin(String emailid, String firstname, String lastname, String password) {
		super();
		this.emailid = emailid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
