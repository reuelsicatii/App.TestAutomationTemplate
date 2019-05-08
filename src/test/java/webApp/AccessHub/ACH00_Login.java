package webApp.AccessHub;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class ACH00_Login extends WEBHelper{
	
	@FindBy(xpath="//button[text()='Login']")
	 WebElement Login_button;
	
	@FindBy(xpath="//input[@id='username']")
	 WebElement Username_textfield;

	@FindBy(xpath="//input[@id='password']")
	 WebElement Password_textfield;
	
	public ACH00_Login () {
		PageFactory.initElements(driver, this);
	}
	
	
	@Then("^Ill see the ACH00_BrandedDashboardLogin page")
	public void ill_see_branded_dashboard_login_page() throws Throwable {
		ReUsablesKeyword.switchToLatestTab();
		Assert.assertEquals(true, Login_button.isDisplayed());
	}
	
	@Given("^I populate ACH00_Username textfield with ([^\"]*)")
	public void i_populate_username_textfield_with_value(String username) throws Throwable {
		Username_textfield.sendKeys(username);
	}
	
	@Given("^I populate ACH00_Password textfield with ([^\"]*)")
	public void i_populate_password_textfield_with_value(String username) throws Throwable {
		Password_textfield.sendKeys(username);
	}
	
	@Given("^I click the ACH00_Login button")
	public void i_click_login_button(){
		Login_button.click();
	}
	

}
