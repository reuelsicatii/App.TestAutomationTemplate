package webApp.Introvio;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.WEBHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IN_UserAndPreConditions extends WEBHelper{
	
	@FindBy(xpath=".//my-libs-login-form/form/div[1]/input")
	 WebElement Username;
	
	@FindBy(xpath=".//my-libs-login-form/form/div[2]/input")
	WebElement Password;
	

	
	
	public IN_UserAndPreConditions () {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@Given("^Im an Account Manager$")
	public void im_an_Account_Manager() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	


}
