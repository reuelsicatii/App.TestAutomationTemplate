package webApp.Seoreseller;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SEO08_Forgotpassword extends WEBHelper{
	
	@FindBy(xpath="//div//img")
	WebElement SrsBanner_Image;
	
	@FindBy(xpath="//div[@class='form-group']/input[@id='email']")
	WebElement EmailAddress_Textfield;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Submit_Button;
	
	@FindBy(xpath="//p/a[text()='Back to Login page']")
	WebElement BackToLogin_Link;
	
	@FindBy(xpath="//p[contains(., 'You are almost in your account')]")
	WebElement YouAreAlmostInYourAccount_Alert;
	
	public SEO08_Forgotpassword() {
		PageFactory.initElements(driver, this);
		
	}
	
	@Then("^Ill see the SEO08_ForgotPassword page$")
	public void ill_see_forgot_password_page() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Submit_Button));
		Assert.assertEquals(true, EmailAddress_Textfield.isDisplayed());
	}
	
	@Then("^Ill see the SEO08_SRS banner$")
	public void ill_see_the_srs__banner() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, SrsBanner_Image.isDisplayed());
	}
	
	@When("^I enter ([^\"]*) in the SEO08_EnterEmail textfield$")
	public void i_enter_password_value_in_password_field_forgot_password_page(String arg1) throws Throwable, UnhandledAlertException {
		EmailAddress_Textfield.sendKeys(arg1);
        Thread.sleep(3000);
	}
	
	@When("^I click the SEO08_Submit button$")
	public void i_click_submit_button() throws Throwable, UnhandledAlertException {
		Submit_Button.click();
	}
	
	@Then("^Ill see the SEO08_Message div with \"(You are almost in your account! Please check your email to reset your password)\"$")
	public void ill_see_the_you_are_almost_in_your_account(String Message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, YouAreAlmostInYourAccount_Alert.isDisplayed());
		Assert.assertEquals(Message, YouAreAlmostInYourAccount_Alert.getText());
	}
}
