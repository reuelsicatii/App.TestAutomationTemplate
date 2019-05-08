package webApp.Seoreseller;



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

public class SEO02_NewcampaignWizard extends WEBHelper{
	
	@FindBy(xpath=".//a[@href='/new-campaign/wizard']")
	WebElement AddCampaign_button;
	
	@FindBy(xpath=".//input[@id='business_url']")
	WebElement DomainUrl_textfield;
	
	@FindBy(xpath=".//button[@id='new-business-create-btn']")
	WebElement CheckDomain_button;
	
	@FindBy(xpath=".//button[@id='new-business-save-btn']")
	WebElement CreateCampaign_button;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement ClickToGetStarted_button;
	


		
	public SEO02_NewcampaignWizard() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	

	@When("^I click SEO02_CheckDomain button$")
	public void i_click_SEO01_CheckDomain_button() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(CheckDomain_button));
		CheckDomain_button.click();
		
	}
	
	@When("^I click SEO02_CreateCampaign button$")
	public void i_click_SEO01_CreateCampaign_button() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(CreateCampaign_button));
		CreateCampaign_button.click();
	}
	
	@When("^I click SEO02_ClickToGetStarted button$")
	public void i_click_SEO01_ClickToGetStarted_button() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(ClickToGetStarted_button));
		ClickToGetStarted_button.click();
	}
	
	
	@Then("^Ill see campaign successfully created in SEO$")
	public void ill_see_campaign_successfully_created() throws Throwable, UnhandledAlertException {
		
		//Validation here
		
	}

	
	


}
