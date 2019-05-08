package webApp.Introvio;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IN_Dashboard extends WEBHelper{
	
	@FindBy(xpath=".//*[@id='side-menu']/li[3]/a/span")
	 WebElement Campaign_link;
	
	@FindBy(xpath=".//div[@class='col-md-12']/a")
	 WebElement AddNewCampaign_button;
	
	
	
	
	
	public IN_Dashboard() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@Then("^Ill be able to login successfully$")
	public void ill_be_able_to_login_successfully() throws Throwable {
	   
		Thread.sleep(1000);
		Assert.assertEquals("Dashboard", driver.getTitle());
		
	}
	
	
	@When("^I click Campaigns tab$")
	public void i_click_Campaigns_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Campaign_link.click();
	}
	
	
	@When("^I click Add_New_Campaign button$")
	public void i_click_Add_New_Campaign_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		AddNewCampaign_button.click();
	}


}
