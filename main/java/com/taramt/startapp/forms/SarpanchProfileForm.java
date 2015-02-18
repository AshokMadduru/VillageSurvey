package com.taramt.startapp.forms;

public class SarpanchProfileForm {
	private String name;
	private String phoneNumber;
	private String password;
	private String repassword;
	
	private SarpanchProfileForm(){
		
	}

	public SarpanchProfileForm(String name, String phoneNumber, String password, String repassword) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.repassword = repassword;
	}

	public String getName() {
		return name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRePassword() {
		return repassword;
	}
	
}
