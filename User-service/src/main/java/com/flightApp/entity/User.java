package com.flightApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class User {
	
	
	@Id
	@Column(unique = true)
	private String emailid;
    private String firstname;
	private String lastname;
	private Long mobno;
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String emailid, String firstname, String lastname, Long mobno, String password) {
		super();
		this.emailid = emailid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobno = mobno;
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [emailid=" + emailid + ", firstname=" + firstname + ", lastname=" + lastname + ", mobno=" + mobno
				+ ", password=" + password + "]";
	}
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
	
	
	

}
