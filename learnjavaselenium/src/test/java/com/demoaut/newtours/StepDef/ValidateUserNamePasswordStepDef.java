package com.demoaut.newtours.StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import com.learn.javaselenium.util.SeleniumDriverCommonStep;

import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.junit.Assert.*;
import cucumber.api.java.en.Then;

@SuppressWarnings("deprecation")
public class ValidateUserNamePasswordStepDef extends SeleniumDriverCommonStep
{
	
	SeleniumDriverCommonStep stepdef = new SeleniumDriverCommonStep();
	WebDriver driv= stepdef.selectedDriver("Chrome");	
	
	@Given ("^User log into newtours site \"([^\"]*)\"$")
	public void access_site(String site) throws InterruptedException{
		// code to access driver and pass site name
		try{
			System.out.println("\n****Accessing site via Chrome Browser****");
			driv.get(site);
			driv.manage().window().maximize();
			System.out.println("Site Details: "+ driv.getCurrentUrl());
			stepdef.waitSeconds(2);
			}
		catch(Exception e)
			{ System.out.println(e.getMessage());
			stepdef.closeAllDriver();}
		
		}
	
	@When ("^User lands into homepage$") 
	public void user_lands_into_homepage() throws InterruptedException{
		// code to log activity
		try{
				System.out.println("\n****Validating landing page****");
			if (driv.getPageSource() != null){
				System.out.println("landing page found");
				stepdef.waitSeconds(2);}
			else {System.out.println("landing page not found");}
		}
		catch(Exception e ){ System.out.println(e.getMessage());
				stepdef.closeAllDriver();}
		}
	
	@When ("^User enters UserName$")
	public void user_enters_username(){
		System.out.println("\n****Entering Username******");
		driv.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("Niresh");
		stepdef.waitSeconds(3);
		}
	
	@When("^User enters Password$")
	public void user_enters_password(){
		System.out.println("\n****Entering Password*****");
		driv.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).sendKeys("Niresh");
		stepdef.waitSeconds(3);
		}
	
	@Then ("^User should see \"([^\"]*)\" page title$")
	public void user_should_see_page_title(String title) throws InterruptedException{
		//code to log activity - html response status and site details
		//asserting image and capture image
		try{
			System.out.println("\n****Accessing Page Title****");
			System.out.println(driv.getTitle());
			stepdef.waitSeconds(2);
			}
		catch(Exception e )
			{System.out.println(e.getMessage());
			}
		}
	
	@Then ("^User checks Username label is present$")
	public void user_checks_username_label_is_present() throws InterruptedException{
		System.out.println("\n****Validating Username Label******");
		System.out.println(driv.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/font")).getText());
		stepdef.waitSeconds(2);
	}
	
	@Then ("^User checks Password label is present$")
	public void user_checks_password_label_is_present() throws InterruptedException{
		System.out.println("\n****Validating password Label******");
		System.out.println(driv.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[1]/font")).getText());
		stepdef.waitSeconds(2);
	}
	
	@Then ("^User checks input box for Username is present$")
	public void user_checks_input_box_for_Username_is_present() throws InterruptedException{
		System.out.println("\n****Validating input box for Username******");
		System.out.println("Tagname: " + driv.findElement(By.name("userName")).getTagName());
		Assert.assertEquals("input", driv.findElement(By.name("userName")).getTagName());
		stepdef.waitSeconds(2);
	}
	
	@Then ("^User checks input box for password tab is present$")
	public void user_checks_input_box_for_password_is_present() throws InterruptedException{
		System.out.println("\n****Validating input box for Password******");
		System.out.println("Tagname: " + driv.findElement(By.name("password")).getTagName());
		Assert.assertEquals("input", driv.findElement(By.name("password")).getTagName());
		stepdef.waitSeconds(2);
		
//		System.out.println("User checks input box -->" + driv.findElement(By.name("password"))); //"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input']")).isEnabled());
//		stepdef.waitSeconds(2);
	}
	
	@Then("^User checks UserName is present$")
	public void user_checks_username_is_present(){
		System.out.println("\n****Validating input Username******");
		String username = driv.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).getAttribute("value");
		Assert.assertEquals("Validating username","Niresh",username);
	}
	
	@Then("^User checks Password is present$")
	public void user_checks_password_is_present(){
		try{
			System.out.println("\n****Validating input Password******");
			String passwd = driv.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).getAttribute("value");
			Assert.assertEquals("Niresh", passwd);
		}catch(Exception e){
			System.out.println(e.getStackTrace());}
		}
	
	@But("^User Password should be masked$")
	public void user_password_masked(){
		System.out.println("\n****Validating field input type******");
		String inputtype =driv.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).getAttribute("type");
		Assert.assertEquals("password", inputtype);
	}
	
	@Then ("^User exit the browser$")
	public void user_exist_the_browser() throws InterruptedException{
		System.out.println("\n****Closing the browser******");
		if(driv !=null)	
		stepdef.closeAllDriver();
		}
	
}
