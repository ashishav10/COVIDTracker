package com.covidtracker.model;

public class Zone {

	private String pincode, covidStatus;
	private int covidCases;

	public int getCovidCases() {
		return covidCases;
	}

	public void setCovidCases(int covidCases) {
		this.covidCases = covidCases;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCovidStatus() {
		return covidStatus;
	}

	public void setCovidStatus(String covidStatus) {
		this.covidStatus = covidStatus;
	}

	public Zone(String pincode, String covidStatus) {
		super();
		this.pincode = pincode;
		this.covidStatus = covidStatus;
		this.covidCases = 0;
	}
	
	public String toString() {
		return "No. of Cases - " + this.covidCases + ", " + "Zone status - " + this.covidStatus;
	}
	
}
