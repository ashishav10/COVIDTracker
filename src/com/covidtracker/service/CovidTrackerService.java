package com.covidtracker.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.covidtracker.model.Admin;
import com.covidtracker.model.User;
import com.covidtracker.model.Zone;

public class CovidTrackerService {

	List<User> usersList;
	List<Admin> adminList;
	Map<String, Zone> zones;
	
	public CovidTrackerService() {
		this.usersList = new ArrayList<User>();
		this.adminList = new ArrayList<Admin>();
		this.zones = new HashMap<String, Zone>();
	}
	
	public String registerUser(String name, String mobile, String pincode) {
		if (zones.containsKey(pincode))
			usersList.add(new User(usersList.size(), name, mobile, pincode, zones.get(pincode)));
		else
		{
			Zone userZone = new Zone(pincode, "Green");
			usersList.add(new User(usersList.size(), name, mobile, pincode, userZone));
			zones.put(pincode, userZone);
		}
		return "User ID - " + usersList.get(usersList.size() - 1).getId();
	}
	
	public String registerAdmin(String name, String mobile, String pincode) {
		adminList.add(new Admin(adminList.size(), name, mobile, pincode));
		return "Admin ID - " + adminList.get(adminList.size() - 1).getId();
	}

	public String selfAssessment(int userId, ArrayList<String> symptoms, boolean travelHistory, boolean contactHistory) {
		if (userId < 0 || userId >= usersList.size())
			return "No such user exist.";
		
		User currentUser = usersList.get(userId);
		
		return "Risk Percentage - " + currentUser.selfAssessment(symptoms, travelHistory, contactHistory);
	}
	
	public String updateCovidResult(int adminId, int userId, String result) {
		if (adminId < 0 || adminId >= adminList.size())
			return "No such admin exist.";

		if (userId < 0 || userId >= usersList.size())
			return "No such user exist.";

		result = result.toLowerCase();
		User currentUser = usersList.get(userId);
		Admin currentAdmin = adminList.get(adminId);

		if (currentAdmin.updateCovidResult(currentUser, result)) {
			if (result.equals("positive"))
				currentUser.getZone().setCovidCases(currentUser.getZone().getCovidCases() + 1);
			else
				currentUser.getZone().setCovidCases(currentUser.getZone().getCovidCases() - 1);

			if (currentUser.getZone().getCovidCases() <= 5)
				currentUser.getZone().setCovidStatus("Orange");
			else
				currentUser.getZone().setCovidStatus("Red");
			return "Updated: true";
		}

		return "Updated: false";
	}
	
	public String getZoneInfo(String pincode) {
		if (zones.containsKey(pincode))
			return zones.get(pincode).toString();
		return "No such zone exists.";
	}
	
}
