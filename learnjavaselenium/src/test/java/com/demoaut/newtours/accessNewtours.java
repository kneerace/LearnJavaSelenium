package com.demoaut.newtours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.learn.javaselenium.util.SeleniumBrowserCommonSteps;

public class accessNewtours 
{
		static WebDriver driver;
		static String Driverpath = System.getProperty("user.dir")+"\\Drivers\\";
		
	public WebDriver selectedDriver(String browser){
		
		switch(browser){
		case "Chrome":
			if (driver == null){
				System.setProperty("webdriver.chrome.driver",Driverpath+"\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("http://newtours.demoaut.com");
	    }
		break;
		case"Firefox":
			if(driver == null){
				System.setProperty("webdriver.gecko.driver",Driverpath+"\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get("http://newtours.demoaut.com");
				System.out.println("Via Firefoc driver, WebPage title: " +driver.getTitle());
		}
	    break;
		case "IE":
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability("diasble-popup-blocking","true");
			capabilities.setCapability("Window.onbeforeunload","null");
			if(driver == null){
				System.setProperty("webdriver.ie.driver", Driverpath+"\\IEDriverServer.exe");
				driver = new InternetExplorerDriver(capabilities);
		        driver.get("http://newtours.demoaut.com");
		}
		break;
		}
		return driver;
	}
	public void closeAllDriver(){
		driver.close();
	}
	
	public void waitSeconds(int seconds){
		try{
			Thread.sleep(seconds * 1000);
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
	}
//public void AccessViaChrome(){
//	try{
//		SeleniumBrowserCommonSteps sbcs = new SeleniumBrowserCommonSteps();
//	
//	sbcs.getBrowser("Firefox");
//	sbcs.getDriver().navigate().to("http://newtours.demoaut.com");
//	System.out.println("now letting to wait for 3 sec....");
//	SeleniumBrowserCommonSteps.waitSeconds(3);
//	System.out.println("After wait seconds for 3 sec.....");
//System.out.println(SeleniumBrowserCommonSteps.getBrowser());
//sbcs.closeAllDriverInstance();
//System.out.println("Browser Closed");
//	}
//	catch(Exception e){
//		System.out.println(e.getMessage());
//	}
//}
public static void main (String args []){
	accessNewtours chrome = new accessNewtours();
	System.out.println(System.getProperty("user.dir")+"\\Drivers\\");
	chrome.selectedDriver("Firefox");
	chrome.waitSeconds(10);
	chrome.closeAllDriver();
}
}