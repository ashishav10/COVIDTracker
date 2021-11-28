package com.covidtracker.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.covidtracker.service.CovidTrackerService;

public class CovidTrackerController {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		CovidTrackerService tracker = new CovidTrackerService();
		
		outerLoop: while (true) {
			String[] cmdLine = scan.nextLine().split(" ");
			
			switch (cmdLine[0].toLowerCase()) {
			case "register":
				if (cmdLine[1].toLowerCase().equals("user")) {
					System.out.println(tracker.registerUser(cmdLine[2], cmdLine[3], cmdLine[4]));
				}
				else if (cmdLine[1].toLowerCase().equals("admin")) {
					System.out.println(tracker.registerAdmin(cmdLine[2], cmdLine[3], cmdLine[4]));
				}
				else
					System.out.println("Please enter a valid argument.");
				break;
			case "self_assessment":
				ArrayList<String> symptoms = new ArrayList<String>();
				int argsLength = cmdLine.length;
				for (int i = 2 ; ; i++) {
					if (cmdLine[i].toLowerCase().equals("true") || cmdLine[i].toLowerCase().equals("false"))
						break;
					symptoms.add(cmdLine[i]);
				}
				System.out.println(tracker.selfAssessment(Integer.parseInt(cmdLine[1]), symptoms,
						Boolean.parseBoolean(cmdLine[argsLength - 2]), Boolean.parseBoolean(cmdLine[argsLength - 1])));
				break;
			case "update_covid_result":
				System.out.println(tracker.updateCovidResult(Integer.parseInt(cmdLine[2]), Integer.parseInt(cmdLine[1]), cmdLine[3]));
				break;
			case "get_zone_info":
				System.out.println(tracker.getZoneInfo(cmdLine[1]));
				break;
			case "exit":
				break outerLoop;
			default:
				System.out.println("Please enter a valid argument.");
				break;
			}
		}

	}

}
