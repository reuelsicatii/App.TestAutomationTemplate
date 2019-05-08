package webApp.Compass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM03_ClientsBucketSiteidUseridCampaigns extends WEBHelper{
	
	@FindBy(xpath=".//*[@id='create_project_btn']")
	WebElement COM_CreateCampaign_button;
	
	@FindBy(xpath="//input[@value='Project Name']")
	WebElement ProjectNameSearch_textfield;
	
	
	public COM03_ClientsBucketSiteidUseridCampaigns() {
		PageFactory.initElements(driver, this);
	}	

	@When("^I click COM03_CreateCampaign button$")
	public void i_click_COM_CreateCampaign_button() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		COM_CreateCampaign_button.click();
	}
	
	
	@When("^I click \"([^\"]*)\" link$")
	public void i_click_link(String arg1) throws Throwable, UnhandledAlertException {
		driver.findElement(By.xpath(".//a[text()='"+ arg1 +"']")).click();
	}
	
	@Then("^Ill see the Campaign Page$")
	public void i_see_campaign_page() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, COM_CreateCampaign_button.isDisplayed());
	}
	
	@When("^I search the \"([^\"]*)\" in the COM03_ProjectNameSearch textfield$")
	public void i_search_campaign_in_campaign_search_bar(String campaignName) throws Throwable, UnhandledAlertException {
		ProjectNameSearch_textfield .sendKeys(campaignName+dateNoSpace);
		Thread.sleep(3000);
	}
	
}
