package com.taramt.startapp.domain;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@Cache
public class SarpanchProfile {
	
	@Id private String userId;
	@Index
	private String phoneNumber;
	@Index
	private String Name;
	@Index
	private String village;
	@Index
	private String mandal;
	@Index
	private String district;
	@Index
	private String state;
	@Index
	private String password;
	
	//private SecureRandom random = new SecureRandom();
	
	/*private String createPassword() {
		return new BigInteger(130, random).toString(32);
	}*/
	
	private SarpanchProfile() {
		
	}
	
	public SarpanchProfile(String userId, String phoneNumber,String Name,
			String password, String village, String mandal, String district,
			String state) {
		this.Name = Name;
		this.phoneNumber = phoneNumber;
		this.village = village;
		this.mandal = mandal;
		this.district = district;
		this.state = state;
		this.userId = userId;
		this.password = password;
		sendPassword(phoneNumber);
	}
	
	
	
	public String getUserId() {
		return userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getName() {
		return Name;
	}

	public String getVillage() {
		return village;
	}

	public String getMandal() {
		return mandal;
	}

	public String getDistrict() {
		return district;
	}

	public String getState() {
		return state;
	}


	public String getPassword() {
		return password;
	}

	public void update(String  phoneNumber, String password) {
		if (phoneNumber != null) {
			this.phoneNumber = phoneNumber;
		}
		if (password != null) {
			this.password = password;
		}
	}
	
	public void sendPassword(String phoneNumber) {
		
		// TODO
		// Send the password to the user
	}
}
