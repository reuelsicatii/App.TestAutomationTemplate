package webApp.Compass;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.SetUp;
import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM09_TaskDeployment extends WEBHelper{
	
	@FindBy(xpath=".//input[@value='Campaign']")
	 WebElement Campaign_txtfield;
	
	@FindBy(xpath=".//table[@id='deployments-table']/tbody/tr[1]//span")
	WebElement Deployment_button;
	
	@FindBy(xpath=".//input[@name='month_num']")
	WebElement MonthNo_textfield;
	
	@FindBy(xpath=".//button[text()='Deploy!']")
	WebElement Deploy_button;
	
	@FindBy(xpath="//h4[text()='Task Deployments ']")
	WebElement TaskDeployment_header;
	
	@FindBy(xpath="//input[@value='Campaign']")
	WebElement CampaignSearch_textfield;
	
	@FindBy(xpath="//input[@value='Last Deployment']")
	WebElement LastDeployment_textfield;
	
	@FindBy(xpath="//td[3][text()='-']//ancestor::tr//a[@class='btn btn-xs']")
	List<WebElement> DeployLatest_button;
		
	public COM09_TaskDeployment() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@When("^I populate COM09_Campaign textfield with \"([^\"]*)\"$")
	public void i_populate_Campaign_textfield_with(String arg1) throws Throwable, UnhandledAlertException {
		Campaign_txtfield.sendKeys(arg1);
	}
	
	@When("^I click COM09_Deployment button$")
	public void i_click_Deployment_button() throws Throwable, UnhandledAlertException {
		Deployment_button.click();
	}
	
	
	@Then("^I will see the COM09_TaskDeployments Header")
	public void ill_see_task_deployment_header() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, TaskDeployment_header.isDisplayed());
	}
	

	 @When("^I search the \"([^\"]*)\" in the COM09_CampaignSearch textfield$")
		public void i_search_campaign_in_campaign_search_bar(String campaignName) throws Throwable, UnhandledAlertException {
			String dateIdentifier = null;
			
			String scenario = SetUp.getScenarioName();
			
			if(scenario.contains("LocalSEO")){
				dateIdentifier = readTextfile("webApp.Compass\\LocalSEO_Date.txt");	 

			}else if(scenario.contains("OrganicSEO")){
				dateIdentifier = readTextfile("webApp.Compass\\OrganicSEO_Date.txt");	 

			}else if(scenario.contains("WebDesign")){
				dateIdentifier = readTextfile("webApp.Compass\\WebDesign_Date.txt");	 

			}
			
		 	CampaignSearch_textfield.sendKeys(campaignName+"_"+dateIdentifier);
			Thread.sleep(3000);
	}
	 
	 @When("^I search the \"([^\"]*)\" in the COM09_LastDeployment textfield$")
		public void i_search_campaign_in_last_deployment_search_bar(String lastDeployment) throws Throwable, UnhandledAlertException {
		 LastDeployment_textfield.sendKeys(lastDeployment);
			Thread.sleep(3000);
	}
	 
	 @When("^I click the COM09_Deploy button of latest campaign without Deploy Info$")
		public void i_click_deploy_latest_campaign() throws Throwable, UnhandledAlertException {
		 int latest = (DeployLatest_button.size()) - 1;
		 DeployLatest_button.get(latest).click();
	}
	 
}
