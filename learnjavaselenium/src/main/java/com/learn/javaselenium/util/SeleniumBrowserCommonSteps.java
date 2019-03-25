package com.learn.javaselenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumBrowserCommonSteps
{

	private static String browser;
	
	// thread local driver object for webdriver
	public static ThreadLocal<WebDriver> driv = new ThreadLocal<WebDriver>();
//	WebDriver driv;
	public void setDriver(WebDriver driver) { 
		System.out.println("Setting up the driver based on driver returned...");
		System.out.println(driver);
		driv.set(driver);
		}
	
	public WebDriver getDriver() {
		return driv.get();
	}
	
	public WebDriver getBrowser(String browserName){
		System.out.println("Assigning driver based on browser name passed.."+ browserName);
		WebDriver driver = null;
		String Driverpath = System.getProperty("user.dir")+ "\\Drivers\\";
		switch(browserName){
		case "Firefox":
			//driver = driver.get("Firefox");
			if(driver==null){
//				FirefoxOptions options = new FirefoxOptions();
//				options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
				System.setProperty("webdriver.gecko.driver", Driverpath+"\\geckodriver.exe");
//				System.setProperty("webdriver.gecko.driver","C:\\Cucumber-selenium\\geckodriver-v0.19.0-win32\\geckodriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				driver = new FirefoxDriver(capabilities);
			}
			break;
		case "IE":
			//driver = drivers.get("IE");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability("diasble-popup-blocking","true");
			capabilities.setCapability("Window.onbeforeunload","null");
			if (driver == null){
				System.setProperty("webdriver.ie.driver", Driverpath+"\\IEDriverServer.exe");
				driver = new InternetExplorerDriver (capabilities);
			}
			break;
		case "Chrome":
			//driver = driver.get("Chrome");
			if (driver==null){
				System.setProperty("webdriver.chrome.driver", Driverpath+"chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				options.addArguments("start-maximized");
				options.addArguments("--js-flags=--expose-gc");
				options.addArguments("--enable-precise-memory-info");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-default-apps");
				options.addArguments("--enable-automation");
				options.addArguments("test-type=browser");
				options.addArguments("disable-infobars");
				options.addArguments("disable-extensions");
				
				driver = new ChromeDriver(options);
			}
			break;
		}
		return driver;
	}
	
	public void closeAllDriverInstance(){
		getDriver().close();
		driv.get();
	}
	public static void waitSeconds(int seconds){
		try{
			Thread.sleep(seconds * 1000);
		}
		catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
	}

	public static String getBrowser() {
		return browser;
	}

	public static void setBrowser(String browser) {
		SeleniumBrowserCommonSteps.browser = browser;
	}
}

