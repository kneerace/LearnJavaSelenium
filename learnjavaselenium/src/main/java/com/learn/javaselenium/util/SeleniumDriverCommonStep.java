package com.learn.javaselenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumDriverCommonStep
{
		static WebDriver driver;
		static String Driverpath = System.getProperty("user.dir")+"\\Drivers\\";
		
	public WebDriver selectedDriver(String browser){
		
		switch(browser){
		case "Chrome":
			if (driver == null){
				System.setProperty("webdriver.chrome.driver",Driverpath+"\\chromedriver.exe");
				driver = new ChromeDriver();
	    }
		break;
		case"Firefox":
			if(driver == null){
				System.setProperty("webdriver.gecko.driver",Driverpath+"\\geckodriver.exe");
				driver = new FirefoxDriver();
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
		}
		break;
		}
		return driver;
	}
	public void closeAllDriver(){
		driver.close();
		driver.quit(); 
//	    webDriver.Close() // Close the browser window that the driver has focus of
//	    webDriver.Quit() // Calls Dispose()
//	    webDriver.Dispose() Closes all browser windows and safely ends the session

		if (driver != null)driver = null;
	}
	
	public void waitSeconds(int seconds){
		try{
			Thread.sleep(seconds * 1000);
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
	}
}
