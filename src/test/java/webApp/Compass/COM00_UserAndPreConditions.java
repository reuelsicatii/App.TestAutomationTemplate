package webApp.Compass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Given;

public class COM00_UserAndPreConditions extends WEBHelper{
	
	@FindBy(xpath=".//my-libs-login-form/form/div[1]/input")
	 WebElement Username;
	
	@FindBy(xpath=".//my-libs-login-form/form/div[2]/input")
	WebElement Password;
	

	
	
	public COM00_UserAndPreConditions () {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@Given("^Im an Account Manager$")
	public void im_an_Account_Manager() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
		Thread.sleep(3000);
	}
	
	@Given("^Im a Workforce Specialist$")
	public void im_a_Workforce_Specialist() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Given("^I am an SEO Specialist$")
	public void im_a_SEO_Specialist() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Given("^I am a Content Specialist$")
	public void im_a_Content_Specialist() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	
	@Given("^I am a DMG Specialist$")
	public void im_a_DMG_Specialist() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Given("^I am an Account Manager or a Web Dev Specialist$")
	public void im_an_account_manager_or_web_dev_specialist() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

}
