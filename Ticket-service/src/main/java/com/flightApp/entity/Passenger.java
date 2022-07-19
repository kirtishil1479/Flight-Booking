package com.flightApp.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Passenger {
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer id;
	    
	    private String firstname;
	    private String lastname;
	    private String gender;
	    private Integer age;
	    
	    @ManyToOne(targetEntity = Booking.class, fetch = FetchType.LAZY)
	    @JoinColumn(name="bookingid")
	    @JsonIgnore
	    private Booking booking;
	    
		public long getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
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

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Booking getBooking() {
			return booking;
		}

		public void setBooking(Booking booking) {
			this.booking = booking;
		}

		public Passenger(Integer id, String firstname, String lastname, String gender, Integer age, Booking booking) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.gender = gender;
			this.age = age;
			this.booking = booking;
		}

		public Passenger() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public String toString() {
			return "Passenger [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
					+ ", age=" + age + "]";
		}
	    

}
