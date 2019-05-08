package test.Runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.Framework.WEBHelper;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import test.Utilities.Mail;




@RunWith(Cucumber.class)
@CucumberOptions(
		
		format = { "pretty", "html:target/cucumber","json:target/JSON/R1_LumenSmokeTestReport.json" },
		features = {"."},
		glue = {"webApi.Lumen", "restassured.Framework"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/R1_LumenSmokeTestReport.html","rerun:target/rerun_apilumen.txt"},
        tags = {"@LUMENSMOKETEST"}
   

)


public class R1_LumenSmokeTest extends WEBHelper {
	
	@BeforeClass
	public static void BeforeClass() throws Exception
	{
		log.info("Execution is started from First Runner Test - BeforeClass Annotation");
	}	
		
 	
	@AfterClass
	public static void AfterClass() throws IOException, Throwable
	{	
		Mail.SendReport("R1_LumenSmokeTestReport.html", "LumenDEVURL", "[SMOKE TEST]: LUMEN - ");		
		log.info("Execution is ended from First Runner - Test AfterClass Annotation");
		
	}
}


