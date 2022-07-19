package com.flightApp.model;

public class User {
	
	private String emailid;
	private String firstname;
	private String lastname;
	private Long mobno;
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
	public Long getMobno() {
		return mobno;
	}
	public void setMobno(Long mobno) {
		this.mobno = mobno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String emailid, String firstname, String lastname, Long mobno, String password) {
		super();
		this.emailid = emailid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobno = mobno;
		this.password = password;
		
	}
	public User() {
		// TODO Auto-generated constructor stub
	}

}
