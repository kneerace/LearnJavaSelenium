package com.demoaut.newtours;

import org.openqa.selenium.WebDriver;

import com.learn.javaselenium.util.SeleniumDriverCommonStep;

public class accessNewtours extends SeleniumDriverCommonStep
{
public static void main (String args []){
	
	accessNewtours chrome = new accessNewtours();
	try{
	System.out.println("Getting Started..........");
	System.out.println(System.getProperty("user.dir")+"\\Drivers\\");
	System.out.println("Setting brower property for the driver.....");
	WebDriver webdriv = chrome.selectedDriver("Chrome");
	webdriv.get("http://newtours.demoaut.com");
	System.out.println("Opening Browser... and passing the site: \""+webdriv.getCurrentUrl());
	System.out.println(webdriv.getPageSource());
	System.out.println(webdriv.getTitle());
//	Another way to call browser ".navigate()to(<url>)"
//	chrome.selectedDriver("Chrome").navigate().to("http://newtours.demoaut.com");
	
	chrome.waitSeconds(10);
	}
	catch(Exception e){
		System.out.println("Some issue with the run: \n" + e.getMessage());
	}
	finally{
	System.out.println("Finally closing the Browser...");
	chrome.closeAllDriver();
}
}
}
