package com.demoaut.newtours.StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learn.javaselenium.util.SeleniumDriverCommonStep;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class ValidateUserNamePasswordStepDef extends SeleniumDriverCommonStep
{
	
	SeleniumDriverCommonStep stepdef = new SeleniumDriverCommonStep();
	WebDriver driv= stepdef.selectedDriver("Chrome");	
	@Given ("^User log into newtours site \"([^\"]*)\"$")
	public void access_site(String site) throws InterruptedException{
		// code to access driver and pass site name
		try{
			System.out.println("****Accessing site via Chrome Browser****");
			driv.get(site);
			driv.manage().window().maximize();
			System.out.println("Site Details: "+ driv.getCurrentUrl());
			stepdef.waitSeconds(2);
		}
		catch(Exception e){ System.out.println(e.getMessage());
		stepdef.closeAllDriver();}
		
	}
	
	@When ("^User lands into homepage$") 
	public void user_lands_into_homepage() throws InterruptedException{
		// code to log activity
		try{System.out.println("****Validating landing page****");
			if (driv.getPageSource() != null){
				System.out.println("landing page found");
				stepdef.waitSeconds(2);}
			else {System.out.println("landing page not found");}
		}
		catch(Exception e ){ System.out.println(e.getMessage());
				stepdef.closeAllDriver();}
	}
	
	@Then ("^User should see \"([^\"]*)\" page title$")
	public void user_should_see_page_title(String title) throws InterruptedException{
		//code to log activity - html response status and site details
		//asserting image and capture image
		try{
			System.out.println("****Accessing Page Title****");
			System.out.println(driv.getTitle());
			stepdef.waitSeconds(2);
		}
		catch(Exception e ){System.out.println(e.getMessage());
		}
	}
	
	@Then ("^User checks Username label is present$")
	public void user_checks_username_label_is_present() throws InterruptedException{
//		System.out.println(driv.findElement(By.cssSelector("User")).getText());
		stepdef.waitSeconds(2);
	}
	@Then ("^User checks input box for Username is present$")
	public void user_checks_input_box_for_Username_is_present() throws InterruptedException{
		System.out.println(driv.findElement(By.xpath("//[@name='userName']")).getClass());
		stepdef.waitSeconds(2);
	}
	
		@Then ("^User exit the browser$")
	public void user_exist_the_browser() throws InterruptedException{
			stepdef.closeAllDriver();
		}
	
}
