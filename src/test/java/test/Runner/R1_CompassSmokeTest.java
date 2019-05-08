package test.Runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.jetty.html.Break;

import cucumber.Framework.WEBHelper;
import cucumber.Framework.SetUp;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import test.Utilities.Mail;

import com.cucumber.listener.*;



@RunWith(Cucumber.class)
@CucumberOptions(
		
		format = { "pretty", "html:target/cucumber","json:target/JSON/R1_CompassSmokeTestReport.json" },
		features = {"."},
		glue = {"cucumber.Framework","webApp.Compass", "webApp.Seoreseller", "webApp.PayPerContent"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/R1_CompassSmokeTestReport.html","rerun:target/rerun.txt"},
        tags = {"@LocalSEO_TS01"}
   

)


public class R1_CompassSmokeTest extends WEBHelper{
	
	@BeforeClass
	public static void BeforeClass() throws Exception
	{

		log.info("Execution is started from First Runner Test - BeforeClass Annotation");
		

	}	
		
 	
	@AfterClass
	public static void AfterClass() throws IOException, Throwable
	{	
	
		Mail.SendReport("R1_CompassSmokeTestReport.html", GetApplication() + GetTestEnv(), "[SMOKE TEST]: " + GetApplication() + GetTestEnv() + " - ");
		log.info("Execution is ended from Second Runner - Test AfterClass Annotation");
		
	}
	
}


