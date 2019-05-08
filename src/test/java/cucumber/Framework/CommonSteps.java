package cucumber.Framework;

import static io.restassured.RestAssured.post;
import static io.restassured.RestAssured.requestSpecification;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;





public class CommonSteps extends WEBHelper {

	
	@When("^I navigate to \"([^\"]*)\"$")
	public void i_navigate_to_URL_variable(String Path) throws Throwable {
		Thread.sleep(2000);
		log.info("User Navigate to :" + GetPropertValue("Data/TestProperties.xml", GetApplication() + GetTestEnv() + "_" + Path));
		driver.get(GetPropertValue("Data/TestProperties.xml", GetApplication() + GetTestEnv() + "_" + Path));
		Thread.sleep(5000);
			  
	}
	
	
	@Then("^Ill see that Ive navigated to \"([^\"]*)\"$")
	public void ill_see_that_ive_navigated_to_URL_variable(String Path) throws Throwable {
		Thread.sleep(5000);		
		assertEquals(GetPropertValue("Data/TestProperties.xml", GetApplication() + GetTestEnv() + "_" + Path).toString(), driver.getCurrentUrl());
			  
	}
	
	
	
	@When("^I navigate back to \"([^\"]*)\"$")
	public void i_navigate_back_to_URL_variable(String Path) throws Throwable {
		
		Thread.sleep(5000);
		log.info("User Navigate to :" + GetPropertValue("Data/TestProperties.xml", GetApplication() + GetTestEnv() + "_" + Path));
		driver.get(GetPropertValue("Data/TestProperties.xml", GetApplication() + GetTestEnv() + "_" + Path));
	  
	}
	
	@When("^I navigate to ParentWindow$")
	public void i_navigate_to_ParentWindow() throws Throwable, UnhandledAlertException {
		ReUsablesKeyword.switchtoparentwindow();
	}
	
	@When("^I navigate to ChildWindow$")
	public void i_navigate__to_ChildWindow() throws Throwable, UnhandledAlertException {
		ReUsablesKeyword.switchtochildwindow();
	}
	
	@When("^I wait for (\\d+) millisecond$")
	public void i_wait_for_digit_millisecond(long millisecond) throws Throwable, UnhandledAlertException {
		Thread.sleep(millisecond);
	}
	
	@When("^I wait for page to load$")
	public void i_wait_for_page_to_load() throws Throwable, UnhandledAlertException {
		while (!JS.executeScript("return document.readyState").toString().equals("complete"))
		{
			Thread.sleep(1500);
			System.out.println(JS.executeScript("return document.readyState").toString() + "... Waiting for the page to load...");			
		}		
	}
	
	@Given("^I navigate to the application exact ([^\"]*)$")
	public void i_navigate_to_the_application_exact_value(String URL) throws Throwable {
		Thread.sleep(2000);
		driver.get(URL);
		Thread.sleep(5000);
		log.info("User navigate to the application exact URL " + URL);

	}
	
	
	@Given("^I navigate to the application exact \"([^\"]*)\"$")
	public void i_navigate_to_the_application_exact_variable(String URL) throws Throwable {
		Thread.sleep(2000);
		driver.get(URL);
		Thread.sleep(5000);
		log.info("User navigate to the application exact URL " + URL);

	}
	
	@Then("^Ill see that Ive navigated to the application exact ([^\"]*)$")
	public void ill_see_that_ive_navigated_to_the_application_exact_value(String URL) throws Throwable {
		Thread.sleep(5000);		
		assertEquals(URL, driver.getCurrentUrl());
			  
	}
	
	
	@Then("^Ill see that Ive navigated to the application exact \"([^\"]*)\"$")
	public void ill_see_that_ive_navigated_to_the_application_exact_variable(String URL) throws Throwable {
		Thread.sleep(5000);		
		assertEquals(URL, driver.getCurrentUrl());
			  
	}
	
	
	
	@Then("^I ensure that ([^\"]*) does not exist$")
	public void ii_check_email_value_not_existing(String email) throws Throwable, UnhandledAlertException {
		if(GetTestEnv().contains("PRD")){
			System.out.println("Do Nothing");
		}else{
			String ToEmail = UUID.randomUUID().toString().replace("-", "");
			RequestSpecBuilder reqB = new RequestSpecBuilder();
			reqB.setBaseUri(GetPropertValue("Data/TestProperties.xml", "Lumen" + GetTestEnv()));
			reqB.setBasePath("admin/tools/email-updater");
			reqB.addParam("site_id", "1");
			reqB.addParam("from_email", email);
			reqB.addParam("to_email", ToEmail + "@gmail.com");		
			reqB.addParam("username", ToEmail + "@gmail.com");
			requestSpecification = reqB.build();
			Response Resp = post();
			if (Resp.getStatusCode() == 200) {
				System.out.println("Successfully updated registered EmailAdress");
				
			} else {
				System.out.println("Unsuccessfully updated registered EmailAdress");
			}
		}
	
	}
	
	
	@When("^User click the \"([^\"]*)\"$")
	public void user_click_the_Object(String arg1) throws Throwable {
	
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		try{
			ReUsablesKeyword.ClickonObject(ReUsablesKeyword.FindObject(arg1));
		}
		catch(Exception e)
		{
			Assert.fail(e.toString());
			log.error("Exception got occured at User click the object ::" + e.toString());
		}
				
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		ReUsablesKeyword.WaitforPageLoad();
	
	} 
		
	@Then("^User Application should be navigated to the \"([^\"]*)\" Page$")
	public void user_Application_should_be_navigated_to_the_Page(String arg1) throws Throwable {
		try{
		WD.until(ExpectedConditions.titleContains(arg1));
		}
		
		catch (Exception e) {
			System.out.println(driver.getTitle());
			log.error("Page Title Validation got failed for Page Name::" +arg1+ " Actual ::"+driver.getTitle());
			Assert.fail("Page Title Validation got failed for Page Name::" +arg1+ " Actual ::"+driver.getTitle());
			
		}
		
	}

	@Then("^User is able to see the \"([^\"]*)\" from Page$")
	public void user_is_able_to_see_the_from_Page(String arg1) throws Throwable {
	/*	try{
		WD.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathBuilder(arg1))));
		}
		catch (Exception e) {
			Assert.fail("Field Validation got failed for field" +arg1);
		}
		*/
		
		if (!driver.findElement(By.tagName("html")).getText().toLowerCase().contains(arg1.toLowerCase().trim())) {
            System.out.println("verifyTextPresent failed expected ::"+arg1.toLowerCase().trim());
            //System.out.println(driver.findElement(By.tagName("html")).getText().toLowerCase());
            log.error("verifyTextPresent in a page failed expected ::"+arg1.toLowerCase().trim());
            Assert.fail("verifyTextPresent in a page failed expected ::"+arg1.toLowerCase().trim());
        }
	}

	@When("^User click the links$")
	public void user_click_Events(List<String>  name) throws Throwable {
		for(String S:name)
		{
			System.out.println(S);
			user_click_the_Object(S);
		}
		
	}
		
}
