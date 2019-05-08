package webApp.Seoreseller;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SEO14_Webaudits extends WEBHelper{
	
	@FindBy(xpath="//input[@id='audit-url']")
	WebElement AuditUrl_textfield;
	
	@FindBy(xpath="//button[text()='Run audit']")
	WebElement RunAudit_button;

	@FindBy(xpath="//a[@id='audit-competitor-btn']")
	WebElement AddRemoveCompetitors_link;
	
	@FindBy(xpath="//input[@placeholder='http://www.competitor-1.com']")
	WebElement FirstCompetitor_textfield;
	
	@FindBy(xpath="//input[@placeholder='http://www.competitor-2.com']")
	WebElement SecondCompetitor_textfield;
	
	@FindBy(xpath="//input[@placeholder='http://www.competitor-3.com']")
	WebElement ThirdCompetitor_textfield;
	
	@FindBy(xpath="//button[text()='Run new audit (beta)']")
	WebElement RunAuditBeta_button;
	
	public SEO14_Webaudits() {
		PageFactory.initElements(driver, this);
	}
	
	@When("^I populate SEO14_website textfield with ([^\"]*)$")
	public void i_populate_SEO14_website_with_value(String url) throws Throwable, UnhandledAlertException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AuditUrl_textfield.sendKeys(url);
		
	}
	
	@When("^I click SEO14_RunAuditbutton$")
	public void i_click_SEO14_RunAuditbutton() throws Throwable, UnhandledAlertException {
		RunAudit_button.click();
		
	}
	
	@When("^I click SEO14_AddCompetitors link$")
	public void i_click_SEO14_AddCompetitors_link() throws Throwable, UnhandledAlertException {
		AddRemoveCompetitors_link.click();
		Thread.sleep(3000);
	}
	
	@When("^I click SEO14_RemoveCompetitors link$")
	public void i_click_SEO14_RemoveCompetitors_link() throws Throwable, UnhandledAlertException {
		AddRemoveCompetitors_link.click();
		Thread.sleep(3000);
	}
	
	@Then("^Ill see SEO14_CompetitorOne textfield$")
	public void i_see_SEO14_CompetitorOne_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, FirstCompetitor_textfield.isDisplayed());
		
	}
	
	@Then("^Ill see SEO14_CompetitorTwo textfield$")
	public void i_see_SEO14_CompetitorTwo_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, SecondCompetitor_textfield.isDisplayed());
		
	}
	
	@Then("^Ill see SEO14_CompetitorThree textfield$")
	public void i_see_SEO14_CompetitorThree_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, ThirdCompetitor_textfield.isDisplayed());
		
	}
	
	@When("^I populate SEO14_CompetitorOne textfield with ([^\"]*)$")
	public void i_populate_SEO14_CompetitorOne_textfield(String url) throws Throwable, UnhandledAlertException {
		if(url.equals("blank")){
		}else{
			FirstCompetitor_textfield.clear();
			FirstCompetitor_textfield.sendKeys(url);
		}
	}
	
		
	@When("^I populate SEO14_CompetitorTwo textfield with ([^\"]*)$")
	public void i_populate_SEO14_CompetitorTwo_textfield(String url) throws Throwable, UnhandledAlertException {
		if(url.equals("blank")){
		}else{
			SecondCompetitor_textfield.clear();
			SecondCompetitor_textfield.sendKeys(url);
		}
	}
	
	@When("^I populate SEO14_CompetitorThree textfield with ([^\"]*)$")
	public void i_populate_SEO14_CompetitorThree_textfield(String url) throws Throwable, UnhandledAlertException {
		if(url.equals("blank")){
		}else{
			ThirdCompetitor_textfield.clear();
			ThirdCompetitor_textfield.sendKeys(url);
		}
	}
	
	@When("^I click SEO14_RunNewAuditBeta button$")
	public void i_click_SEO14_RunNewAuditBeta_button() throws Throwable, UnhandledAlertException {
		RunAuditBeta_button.click();
	}
	
	@Then("^Ill not see SEO14_CompetitorOne textfield$")
	public void ill_not_see_SEO14_CompetitorOne_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(false, FirstCompetitor_textfield.isDisplayed());
		
	}
	
	@Then("^Ill not see SEO14_CompetitorTwo textfield$")
	public void ill_not_see_SEO14_CompetitorTwo_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(false, SecondCompetitor_textfield.isDisplayed());
		
	}
	
	@Then("^Ill not see SEO14_CompetitorThree textfield$")
	public void ill_not_see_SEO14_CompetitorThree_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(false, ThirdCompetitor_textfield.isDisplayed());
		
	}
	
}
