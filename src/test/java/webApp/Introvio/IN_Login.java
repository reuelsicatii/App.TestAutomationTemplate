package webApp.Introvio;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IN_Login extends WEBHelper{
	
	@FindBy(xpath=".//my-libs-login-form/form/div[1]/input")
	 WebElement Username_txtfield;
	
	@FindBy(xpath=".//my-libs-login-form/form/div[2]/input")
	WebElement Password_txtfield;
	
	@FindBy(xpath=".//my-libs-login-form/form/button")
	WebElement Login_button;
	
	@FindBy(xpath=".//div[contains(@ng-show,'vm.alertShow')]/strong")
	WebElement Error_Message;

	
	
	public IN_Login() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@When("^I populate Email_Address textfield with \"([^\"]*)\"$")
	public void i_populate_Email_Address_textfield_with(String arg1) throws Throwable {

		Username_txtfield.sendKeys(arg1);
	}
	
	
	
	@When("^I populate Password textfield with \"([^\"]*)\"$")
	public void i_populate_Password_textfield_with(String arg1) throws Throwable {

		Password_txtfield.sendKeys(arg1);
	}

	@When("^I clicked Login button$")
	public void i_clicked_Login_button() throws Throwable {
		
		Login_button.click();
		
	}
	
	@Then("^I wont be able to login successfully$")
	public void i_wont_be_able_to_login_successfully() throws Throwable {
	   
		Thread.sleep(1000);
		Assert.assertEquals("There are errors on this page", Error_Message.getText());
		
		Assert.assertEquals("Invalid credentials.", driver.
				findElement(By.xpath(".//div[contains(@ng-show,'vm.alertShow')]//li")).getText());
		
		
		
	}
	
	
	


}
