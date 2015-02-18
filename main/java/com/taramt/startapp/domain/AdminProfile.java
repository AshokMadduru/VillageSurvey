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

	private AdminProfile() {

	}

	public AdminProfile(String userId, String name, String userName,
			String phoneNo, String password) {
		this.userId = userId;
		this.name = name;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.password = password;
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
	public void update( String name, String userName,
			String phoneNo, String password,String rePassword) {
		if (name != null) {
			this.name = name;
		}
		if (userName != null) {
			this.userName = userName;
		}
		if (phoneNo != null) {
			this.phoneNo = phoneNo;
		}
		if (password != null && password.equals(rePassword)) {
			this.password = password;
		}
	}
}
