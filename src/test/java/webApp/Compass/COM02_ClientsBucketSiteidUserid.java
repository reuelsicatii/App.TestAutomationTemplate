package webApp.Compass;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM02_ClientsBucketSiteidUserid extends WEBHelper{
	
	@FindBy(xpath=".//*[@id='projects_button']")
	 WebElement Campaigns_tab;
	
	@FindBy(xpath=".//button[@class='btn btn-success btn-xs']")
	 WebElement LogInAsClient_button;
	
	@FindBy(xpath="//a[@id='overview_button']")
	 WebElement ClientsOverviewTab_button;
	
	
	public COM02_ClientsBucketSiteidUserid() {
		PageFactory.initElements(driver, this);
	}
	
	@When("^I click COM02_Campaigns tab$")
	public void i_click_Campaigns_tab() throws Throwable, UnhandledAlertException {
		Campaigns_tab.click();
	}
	
	
	@When("^I click COM02_LogInAsClient button$")
	public void i_click_COM02_LogInAsClient_button() throws Throwable, UnhandledAlertException {
		
		WD.until(ExpectedConditions.elementToBeClickable(LogInAsClient_button));
		LogInAsClient_button.click();		
		
	}

	@When("^I switch to child window tab$")
	public void i_switch_to_child_window_tab() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		ReUsablesKeyword.switchtochildwindow();	
	}
	
	@Then("^Ill see the Client Overview$")
	public void i_see_clients_overview() throws Throwable, UnhandledAlertException {
		ClientsOverviewTab_button.click();
	}

}
