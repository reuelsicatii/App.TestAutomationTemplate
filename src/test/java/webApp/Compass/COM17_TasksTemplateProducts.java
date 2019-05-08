package webApp.Compass;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class COM17_TasksTemplateProducts extends WEBHelper{

	@FindBy(xpath="//button/i[@class='fa fa-plus']")
	WebElement AddProductTemplate_button;
	
	@FindBy(xpath="//button/i[@class='fa fa-copy']")
	WebElement CopyProductTemplate_button;
	
	@FindBy(xpath="//input[@value='Template Name']")
	WebElement ProductTemplateSearch_textfield;
	
	@FindBy(xpath="//table[@id='products-template-tbl']//td[1]//i")
	WebElement ProductActivationStatus_icon;
	
	
	public static final WebElement Dropdown_button (String templateName){
		WebElement dropdown_button = driver.findElement(By.xpath("//table[@id='products-template-tbl']//td[1][contains(.,'"+templateName+"')]/..//button[@data-toggle='dropdown']"));
		return dropdown_button;
	}
	
	public static final WebElement Activate_button (String templateName){
		WebElement activate_button = driver.findElement(By.xpath("//table[@id='products-template-tbl']//td[1][contains(.,'"+templateName+"')]/..//a[text()=' Activate']"));
		return activate_button;
	}
		
	public COM17_TasksTemplateProducts() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	 @When("^I click COM17_Create button$")
		public void i_click_create_product_button() throws Throwable, UnhandledAlertException {
		 AddProductTemplate_button.click();
	 }
	 
	 @When("^I search ([^\"]*) in the COM17_SearchProduct Filter$")
		public void i_value_in_product_search_filter(String product) throws Throwable, UnhandledAlertException {
		 Thread.sleep(3000);
		 ProductTemplateSearch_textfield.clear();
		 ProductTemplateSearch_textfield.sendKeys(product+"_"+ dateNoSpace);
	 }
	 
	 @When("^I click the COM17_dropdown button of ([^\"]*)$")
		public void i_click_dropdown_button_of_value(String product) throws Throwable, UnhandledAlertException {
		 Thread.sleep(3000);
		 Dropdown_button(product+"_"+ dateNoSpace).click();
	 }
	 
	 @When("^I click COM17_Activate button of ([^\"]*)$")
		public void i_click_activate_button_of_value(String product) throws Throwable, UnhandledAlertException {
		 Activate_button(product+"_"+ dateNoSpace).click();
	 }
	 
	 @Then("^Ill see that the status of the template is Active$")
		public void ill_see_activate_status() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
    	Assert.assertEquals(true, ProductActivationStatus_icon.getAttribute("title").contains("Active"));
	 }
	 
}
