package webApp.Introvio;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IN_Campaigns_create extends WEBHelper{
	
	@FindBy(xpath=".//div[@class='input-group m-b']/input")
	 WebElement DomainURL_txtfield;
	
	@FindBy(xpath=".//div[@class='text-right']/button")
	 WebElement CheckDomain_button;
	
	@FindBy(xpath=".//input[contains(@ng-model,'vm.businessName')]")
	 WebElement BusinessName_txtfield;	

	@FindBy(xpath=".//input[contains(@ng-model,'vm.businessEmail')]")
	 WebElement BusinessEmail_txtfield;
	
	@FindBy(xpath=".//input[contains(@ng-model,'vm.businessAddress')]")
	 WebElement Address_txtfield;
	
	@FindBy(xpath=".//input[contains(@ng-model,'vm.businessCity')]")
	 WebElement City_txtfield;
	
	@FindBy(xpath=".//input[contains(@ng-model,'vm.businessZip')]")
	 WebElement PostalCode_txtfield;
	
	@FindBy(xpath=".//input[contains(@ng-model,'vm.businessPhone')]")
	 WebElement BusinessPhone_txtfield;
	
	@FindBy(xpath=".//select[@id='txtBusAddCountry']")
	WebElement Country_dropbox;
	
	@FindBy(xpath=".//select[@id='txtBusAddState']")
	WebElement State_dropbox;
	
	@FindBy(xpath=".//button[contains(@ng-click,'createCampaign')]")
	 WebElement CreateCampaign_button;	
	
	@FindBy(xpath=".//div[contains(@ng-if,'custommessage')]/span")
	 WebElement Alert_Message;	
	
	
	
	
	public IN_Campaigns_create() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@When("^I populate Domain txtfield with ([^\"]*)$")
	public void i_populate_Domain_txtfield_with_https_www_williamhill_com_au_horse_racing(String arg1) throws Throwable {
	    
		DomainURL_txtfield.sendKeys(arg1);
	}
	
	
	@When("^I click Check_Domain button$")
	public void i_click_Check_Domain_button() throws Throwable {
	    
	    CheckDomain_button.click();
	}


	@When("^I populate Business_Name textfield with ([^\"]*)$")
	public void i_populate_Business_Name_textfield_with_Business_Name(String arg1) throws Throwable {
	    
	    BusinessName_txtfield.sendKeys(arg1);
	}

	@When("^I populate Business_Email textfield with ([^\"]*)$")
	public void i_populate_Business_Email_textfield_with_Business_Email(String arg1) throws Throwable {
	    
		BusinessEmail_txtfield.sendKeys(arg1);
	}

	@When("^I populate Address textfield with ([^\"]*)$")
	public void i_populate_Address_textfield_with_Address(String arg1) throws Throwable {
	    
		Address_txtfield.sendKeys(arg1);
	}

	@When("^I populate City textfield with ([^\"]*)$")
	public void i_populate_City_textfield_with_City(String arg1) throws Throwable {
	    
		City_txtfield.sendKeys(arg1);
	}

	@When("^I choose a selection from  Country drop-down$")
	public void i_choose_a_selection_from_Country_drop_down() throws Throwable {
	    
		
		JS.executeScript("$('#txtBusAddCountry').show();", Country_dropbox);
		Select S = new Select(Country_dropbox);
		S.selectByVisibleText("Afghanistan"); 
		
	}

	@When("^I choose a selection from  State drop-down$")
	public void i_choose_a_selection_from_State_drop_down() throws Throwable {
	    
		JS.executeScript("$('#txtBusAddState').show();", Country_dropbox);
		Select S = new Select(State_dropbox);
		S.selectByVisibleText("Alaska"); 

	}

	@When("^I populate Postal_Code textfield with ([^\"]*)$")
	public void i_populate_Postal_Code_textfield_with_Postal_Code(String arg1) throws Throwable {
	    
		PostalCode_txtfield.sendKeys(arg1);
	}

	@When("^I populate Business_Phone textfield with ([^\"]*)$")
	public void i_populate_Business_Phone_textfield_with_Business_Phone(String arg1) throws Throwable {
	    
		BusinessPhone_txtfield.sendKeys(arg1);
	}

	@When("^I click Create_Campaign button$")
	public void i_click_Create_Campaign_button() throws Throwable {
	    
	    CreateCampaign_button.click();
	}

	@Then("^Ive successfully added a new campaign$")
	public void i_ve_successfully_added_a_new_campaign() throws Throwable {
	    
		Assert.assertEquals("Successfully added new campaign.", Alert_Message.getText());
	}
	
	@Then("^Ive not successfully added a new campaign$")
	public void i_ve_not_successfully_added_a_new_campaign() throws Throwable {
	    
		Assert.assertEquals("There are errors on this page:", Alert_Message.getText());
	}
	
	
}
