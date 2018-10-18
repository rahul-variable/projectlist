package com.demoapp.vo;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class UserVO {
	private int id;
	@NotEmpty(message="First Name can't be blank")
	@Size(min=10)
	private String firstName;
	@Null(message="Last Name should be null")
	private String lastName;
	//@Min(value=10,message="Mobile Number should have 10 digits")
	private long mobile;
	private String city;
	private String country;
	private String pincode;
	private Date dob;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return String.format("UserVO [firstName=%s, lastName=%s, mobile=%s, city=%s, country=%s, pincode=%s, dob=%s]",
				firstName, lastName, mobile, city, country, pincode, dob);
	}
	
	
	
}
