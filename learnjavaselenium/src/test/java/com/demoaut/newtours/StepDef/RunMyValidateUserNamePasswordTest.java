package com.demoaut.newtours.StepDef;

//import java.io.*;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
//import com.cucumber.listener.Reporter;
import com.learn.javaselenium.util.SeleniumDriverCommonStep;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import learnjavaselenium.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true, // this helps in reducing junk character in the logs
//		dryRun = true, // when true runs to check the code validity
//		tags ={"@feature1,@feature2"}, //runs only the Scenario tagged with mentioned tag.
		tags ={"@feature2"},
		features={"src/test/resources/com/demoaut/newtours/CreatingUserFF/"},
		glue={"com/demoaut/newtours/StepDef"},
		plugin={"pretty",
				"html:target/cucumber-htmlreport", 
				"json:target/cucumber-report.json"
		}
//		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports"}
		)

public class RunMyValidateUserNamePasswordTest
{
//	@AfterClass
//	public static void writeExtentReport() {
//		SeleniumDriverCommonStep s = new SeleniumDriverCommonStep();
////		Reporter.loadXMLConfig(new File(s.getReportConfigPath()));
//		System.out.println("Config file added: "+ s.getReportConfigPath());
//	}
}
