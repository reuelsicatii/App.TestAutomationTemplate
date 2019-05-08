package webApp.Compass;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;

public class COM27_ClientsBucketSiteidUseridProjectBusinessinfoEdit extends WEBHelper{
	
	@FindBy(xpath=".//a[@id='products_button']")
	WebElement Product_tab;
	
	@FindBy(xpath=".//a[text()='Project Management ']")
	WebElement ProjectManagement_tab;
	
	@FindBy(xpath=".//div[@id='pcont']//a[@id='subprojects_button']")
	WebElement Project_dropdown;	
	
	@FindBy(xpath="//a[text()='Business Info']")
	WebElement BusinessInfo_link;	
	
	@FindBy(xpath="//a[text()='Edit Business Info']")
	WebElement EditBusinessInfo_link;	
	
	@FindBy(xpath="//input[@placeholder='Business Name']")
	WebElement BusinessName_textfield;	
	
	@FindBy(xpath="//input[@name='business_location_url']")
	WebElement Website_textfield;	
	
	@FindBy(xpath="//textarea[@placeholder='Desription']")
	WebElement Descriprion_textarea;	
		
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement FirstName_textfield;	
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement LastName_textfield;	
	
	@FindBy(xpath="//a[text()='Edit']")
	WebElement EditBreadcrumbs_link;	
	
	
	
	public COM27_ClientsBucketSiteidUseridProjectBusinessinfoEdit() {
		PageFactory.initElements(driver, this);
	}
 

	@Then("^Ill see the Business Info Edit Page$")
	public void ill_see_the_business_info_edit_page() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, EditBreadcrumbs_link.isDisplayed());

	}
	
}
