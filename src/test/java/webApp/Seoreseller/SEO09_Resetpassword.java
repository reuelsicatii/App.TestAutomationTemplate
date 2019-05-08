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

public class SEO09_Resetpassword extends WEBHelper{
	
	@FindBy(xpath="//div//img")
	WebElement SrsBanner_Image;
	
	@FindBy(xpath="//div[@class='form-group']/input[@id='password']")
	WebElement Password_textfield;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Submit_button;
	
	@FindBy(xpath="//p/a[text()='Back to Login page']")
	WebElement BackToLoginpage_link;
	
	@FindBy(xpath="//i[@class='fa fa-eye toggle-password-visibility']")
	WebElement TogglePasswordVisibility_button;	
	
	@FindBy(xpath="//p[text()='The Password field must be at least 8 characters in length.']")
	WebElement PasswordAtleast8Characters_Paragraph;	
	
	
	public SEO09_Resetpassword() {
		PageFactory.initElements(driver, this);
		
	}
	
	@Then("^Ill see the SEO09_ResetPassword page$")
	public void ill_see_the_you_are_almost_in_your_account() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Password_textfield));
		Assert.assertEquals(true, Password_textfield.isDisplayed());
		Assert.assertEquals(true, driver.getCurrentUrl().contains("/reset-password"));
	}
	
	@Then("^Ill see the SEO09_Message input with \"(Should be at least 8 characters)\"$")
	public void ill_see_the_password_verbiage(String Message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Password_textfield.getAttribute("placeholder").contains(Message));
	}
	
	@Then("^Ill see the SEO09_Toggle button$")
	public void ill_see_the_toggle_for_visibility() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, TogglePasswordVisibility_button.isDisplayed());
	}
	
	@Then("^Ill see the SEO09_BacktoLoginpage link$")
	public void ill_see_the_back_to_login() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, BackToLoginpage_link.isDisplayed());
	}
	
	@When("^I populate SEO09_Password textfield with ([^\"]*)$")
	public void i_enter_new_valid_password_value_in_password_field(String NewPassword) throws Throwable, UnhandledAlertException {
		Password_textfield.sendKeys(NewPassword);
        Thread.sleep(10000);
	}
	
	@When("^I click the SEO09_Submit button$")
	public void i_click_Submit_button_of_reset_pass_page() throws Throwable, UnhandledAlertException {
		Submit_button.click();
	}
	
	@Then("^Ill see the SEO09_Message div with \"(The Password field must be at least 8 characters in length.)\"$")
	public void ill_see_the_atleast_eight_characters_message(String Message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, PasswordAtleast8Characters_Paragraph.isDisplayed());
		Assert.assertEquals(Message, PasswordAtleast8Characters_Paragraph.getText());
	}
	
	@When("^I click the SEO09_BacktoLoginpage link$")
	public void i_click_the_back_to_login_link() throws Throwable, UnhandledAlertException {
		BackToLoginpage_link.click();
	}
}
