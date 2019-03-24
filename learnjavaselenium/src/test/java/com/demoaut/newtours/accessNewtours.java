package com.demoaut.newtours;

import com.learn.javaselenium.util.SeleniumDriverCommonStep;

public class accessNewtours extends SeleniumDriverCommonStep
{
public static void main (String args []){
	
	accessNewtours chrome = new accessNewtours();
	try{
	System.out.println(System.getProperty("user.dir")+"\\Drivers\\");
	chrome.selectedDriver("Chrome").get("http://newtours.demoaut.com");
//	Another way to call browser ".navigate()to(<url>)"
//	chrome.selectedDriver("Chrome").navigate().to("http://newtours.demoaut.com");
	
	chrome.waitSeconds(10);
	}
	catch(Exception e){
		System.out.println("Some issue with the run: \n" + e.getMessage());
	}
	finally{
	chrome.closeAllDriver();
}
}
}
