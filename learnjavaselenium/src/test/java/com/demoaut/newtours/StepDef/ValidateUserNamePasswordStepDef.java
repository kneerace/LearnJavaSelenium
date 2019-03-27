package com.demoaut.newtours.StepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import cucumber.api.java.en.Then;

@SuppressWarnings("deprecation")
public class ValidateUserNamePasswordStepDef
{
	@Given ("^User log into newtours site$")
	public void access_site(){
		// code to access driver and pass site name
	}
	
	@When ("^User lands into homepage$") 
	public void validate_landingpage(){
		// code to log activity
	}
	
	@Then ("^User should see "Mercury Tours" logo$")
	public void validate_status_sitename(){
		//code to log activity - html response status and site details
		//asserting image and capture image
	}
	@Then ("^User checks Username label is present$")
	public void validte_username_label(){
		//code to log activity - html response status and site details
		//asserting image and capture image
	}
	@Then ("^User checks Password label is present$")
	public void validte_password_label(){
		//code to log activity - html response status and site details
		//asserting image and capture image
	}
	@Then ("^User checks input box for Username is present$")
	public void validte_username_inputbox(){
		//code to log activity - html response status and site details
		//asserting image and capture image
	}
	@Then ("^User checks input box for password tab is present$")
	public void validte_password_input(){
		//code to log activity - html response status and site details
		//asserting image and capture image
	}
	
	public void close_broswer(){
		driver.close();
	}
	
}
