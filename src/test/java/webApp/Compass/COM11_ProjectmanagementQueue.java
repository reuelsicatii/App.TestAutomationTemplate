package webApp.Compass;

import static org.junit.Assert.assertEquals;

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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM11_ProjectmanagementQueue extends WEBHelper{
	
	@FindBy(xpath=".//input[@value='Campaign']")
	 WebElement Campaign_txtfield;
	
	@FindBy(xpath=".//table[@id='deploy-queue-table']/tbody/tr[1]//a[@title='Deploy']")
	WebElement Deployment_button;
	

		
	public COM11_ProjectmanagementQueue() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@When("^I populate COM11_Campaign textfield with \"([^\"]*)\"$")
	public void i_populate_Campaign_textfield_with(String arg1) throws Throwable, UnhandledAlertException {
		Campaign_txtfield.sendKeys(arg1);
	}
	
	@When("^I click COM11_Deploy button$")
	public void i_click_Deployment_button() throws Throwable, UnhandledAlertException {
		
		action.moveToElement(Deployment_button)
		.click()
		.build()
		.perform();
		
	}
	
	

	
	
}
