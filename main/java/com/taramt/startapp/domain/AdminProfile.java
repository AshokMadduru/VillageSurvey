package com.taramt.startapp.domain;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@Cache
public class AdminProfile {

	@Id private String userId;
	@Index
	private String name;
	@Index
	private String userName;
	@Index
	private String phoneNo;
	@Index
	private String password;
	
	@Index
	private String address1;
	
	@Index
	private String address2;
	
	@Index
	private String city;
	
	@Index
	private String zip;
	

	private AdminProfile() {

	}

	public AdminProfile(String userId, String name, String userName,
			String phoneNo, String password, String address1,
			String address2,String city, String zip) {
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.password = password;
		this.city = city;
		this.address1 = address1;
		this.address2 = address2;
		this.zip = zip;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getAddress1() {
		return address1;
	}
	public String getAddress2() {
		return address2;
	}
	public String getCity() {
		return city;
	}
	public String getZip() {
		return zip;
	}
	public void update(String phoneNo, String password,String rePassword,
			String address1, String address2, String city, String zip) {

		if (phoneNo != null && phoneNo != "") {
			this.phoneNo = phoneNo;
		}
		if (password != null && password.equals(rePassword) && password != "") {
			this.password = password;
		}
		if (address1 != null && address1 != "") {
			this.address1 = address1;
		}
		if (address2 != null && address2 != "") {
			this.address2 = address2;
		}
		if (city != null && city != "") {
			this.city = city;
		}
		if (zip != null && zip != "") {
			this.zip = zip;
		}
	}
}
