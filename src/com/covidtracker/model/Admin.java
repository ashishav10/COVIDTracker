package com.covidtracker.model;

public class Admin {

	private int id;
	private String name, mobile, pincode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Admin(int id, String name, String mobile, String pincode) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public boolean updateCovidResult(User currentUser, String result) {
		try {
			if (result.equals("positive"))
				currentUser.setPositive(true);
			else if (result.equals("negative"))
				currentUser.setPositive(false);
			else
				return false;
		}
		catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
