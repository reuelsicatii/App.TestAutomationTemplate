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
		
		format = { "pretty", "html:target/cucumber","json:target/JSON/R1_KratosSmokeTestReport.json" },
		features = {"."},
		glue = {"webApi.Kratos", "restassured.Framework"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/R1_KratosSmokeTestReport.html","rerun:target/rerun_apikratos.txt"},
        tags = {"@KRATOSSMOKETEST"}

   

)


public class R1_KratosSmokeTest extends WEBHelper {
	
	@BeforeClass
	public static void BeforeClass() throws Exception
	{
		log.info("Execution is started from First Runner Test - BeforeClass Annotation");
	}	
		
 	
	@AfterClass
	public static void AfterClass() throws IOException, Throwable
	{	
		Mail.SendReport("R1_KratosSmokeTestReport.html", "KratosDEVURL", "[SMOKE TEST]: KRATOS - ");		
		log.info("Execution is ended from First Runner - Test AfterClass Annotation");
		
	}
}


