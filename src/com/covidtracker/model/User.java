package com.covidtracker.model;

import java.util.ArrayList;

public class User {

	private int id, riskPercentage;

	public int getRiskPercentage() {
		return riskPercentage;
	}

	public void setRiskPercentage(int riskPercentage) {
		this.riskPercentage = riskPercentage;
	}

	private String name, mobile, pincode;
	private ArrayList<String> symptoms;
	private boolean travelHistory, contactWithCovidPatient, isPositive;
	private Zone zone;

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public boolean isPositive() {
		return isPositive;
	}

	public void setPositive(boolean isPositive) {
		this.isPositive = isPositive;
	}

	public User(int id, String name, String mobile, String pincode, Zone zone) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.pincode = pincode;
		this.zone = zone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(ArrayList<String> symptoms) {
		this.symptoms = symptoms;
	}

	public boolean isTravelHistory() {
		return travelHistory;
	}

	public void setTravelHistory(boolean travelHistory) {
		this.travelHistory = travelHistory;
	}

	public boolean isContactWithCovidPatient() {
		return contactWithCovidPatient;
	}

	public void setContactWithCovidPatient(boolean contactWithCovidPatient) {
		this.contactWithCovidPatient = contactWithCovidPatient;
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

	public int selfAssessment(ArrayList<String> symptoms, boolean travelHistory, boolean contactHistory) {
		
		if (symptoms.size() == 0 && !travelHistory && !contactHistory)
			this.setRiskPercentage(5);
		else if(travelHistory || contactHistory) {
			if (symptoms.size() == 1 )
				this.setRiskPercentage(50);
			else if (symptoms.size() == 2)
				this.setRiskPercentage(75);
			else
				this.setRiskPercentage(95);
		}
		
		return this.getRiskPercentage();
	}
	
}
