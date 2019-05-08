package test.Runner;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.Framework.WEBHelper;
import cucumber.Framework.SetUp;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import test.Utilities.*;

@RunWith(Cucumber.class)

@CucumberOptions(
		format = { "pretty", "html:target/cucumber","json:target/JSON/R2_CompassSmokeTestReport.json" },
        features = {"@target/rerun.txt"},
        glue = {"cucumber.Framework","webApp.Compass", "webApp.Seoreseller", "webApp.PayPerContent"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/R2_CompassSmokeTestReport.html","rerun:target/rerun1.txt"}
   

)


public class R2_CompassSmokeTest extends WEBHelper{
	
	@BeforeClass
	public static void SecondBeforeClass() throws Exception 
	{
		
		log.info("Execution is started from First Runner Test - BeforeClass Annotation");
		  
	}
	
	
	
 	
	@AfterClass
	public static void SecondAfterClass() throws Exception
	{		
		
		
		BufferedReader br = new BufferedReader(new FileReader("target/rerun.txt"));
		if (br.readLine() == null) 
		{
		    System.out.println("File is EMPTY");

		}
		else 
		{
		    System.out.println("File is not EMPTY");
			Mail.SendReport("R2_CompassSmokeTestReport.html", GetApplication() + GetTestEnv(), "[SMOKE TEST - RERUN]: " + GetApplication() + GetTestEnv() + " - ");
			log.info("Execution is ended from Second Runner - Test AfterClass Annotation");
		}		
	}
	
}


