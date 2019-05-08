package webApp.PayPerContent;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.WEBHelper;
import cucumber.Framework.SetUp;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PPC01_Login extends WEBHelper{
	
	@FindBy(xpath=".//input[@id='identity']")
	 WebElement Username_txtfield;
	
	@FindBy(xpath=".//input[@id='password']")
	WebElement Password_txtfield;
	
	@FindBy(xpath=".//button[text()='Log me in']")
	WebElement Login_button;
	

		
	public PPC01_Login() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@When("^I populate PPC01_Username with ([^\"]*)$")
	public void i_populate_Username_with_value(String arg1) throws Throwable, UnhandledAlertException {
	    Username_txtfield.sendKeys(arg1);
	}
	
	@When("^I populate PPC01_Username with \"([^\"]*)\"$")
	public void i_populate_Username_with_variable(String arg1) throws Throwable, UnhandledAlertException {
	    Username_txtfield.sendKeys(arg1);
	}
	
	@When("^I populate PPC01_Password with ([^\"]*)$")
	public void i_populate_Password_with_value(String arg1) throws Throwable, UnhandledAlertException {
	    Password_txtfield.sendKeys(arg1);
	}

	@When("^I populate PPC01_Password with \"([^\"]*)\"$")
	public void i_populate_Password_with_variable(String arg1) throws Throwable, UnhandledAlertException {
	    Password_txtfield.sendKeys(arg1);
	}

	@When("^I click PPC01_LogIn button$")
	public void i_click_LogIn_button() throws Throwable, UnhandledAlertException {
		Login_button.click();
	}
	
	@Then("^Ill see that Ive login successfully over Paypercontent$")
	public void ill_see_that_Ive_login_successfully_over_Paypercontent() throws Throwable, UnhandledAlertException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	


}
