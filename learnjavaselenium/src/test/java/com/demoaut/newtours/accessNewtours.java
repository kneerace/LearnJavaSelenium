package com.demoaut.newtours;

//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class accessNewtours
{
		static WebDriver driver;
		
	public void AccessViaChrome(){
		System.setProperty("webdriver.chrome.driver","C:\\Cucumber-selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		try {
	        driver.get("http://newtours.demoaut.com");
	        System.out.println("Via Chrome Driver, WebPage title: " + driver.getTitle());
	    } finally {
	        driver.quit();
	    }
	}
	
		
	public void AccessViaFirefox(){
		System.setProperty("webdriver.gecko.driver","C:\\Cucumber-selenium\\geckodriver-v0.19.0-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
	    try {
	        driver.get("http://newtours.demoaut.com");
	        System.out.println("Via Firefoc driver, WebPage title: " +driver.getTitle());
	    } finally {
	        driver.quit();
	    }
	}
public static void main (String args []){
	accessNewtours chrome = new accessNewtours();
	
	chrome.AccessViaChrome();
}
}