package com.demoaut.newtours.StepDef;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true, // this helps in reducing junk character in the logs
//		dryRun = true, // when true runs to check the code validity
		
		features={"src/test/resources/com/demoaut/newtours/CreatingUserFF/"},
		glue={"com/demoaut/newtours/StepDef"},
		plugin={"pretty",
				"html:target/cucumber-htmlreport", 
				"json:target/cucumber-report.json",
		}
		)
public class RunMyValidateUserNamePasswordTest
{

}
