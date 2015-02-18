package com.taramt.startapp.forms;

public class AdminProfileForm {
	
	private String name;
	
	private String userName;
	
	private String password;
	
	private String rePassword;
	
	private String phoneNo;
	
	public AdminProfileForm() {
		
	}

	public AdminProfileForm(String name, String userName, String password,
			String rePassword, String phoneNo) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.rePassword = rePassword;
		this.phoneNo = phoneNo;
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
	public String getRePassword() {
		return rePassword;
	}
	public String getPhoneNo() {
		return phoneNo;
	}

	
	

}
