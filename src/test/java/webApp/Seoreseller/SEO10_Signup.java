package webApp.Seoreseller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SEO10_Signup extends WEBHelper{
	
	@FindBy(xpath="//div[@id='signup-box-title-container']/h3/strong[text()='Create Your Account']")
	WebElement CreateYourAccount_div;

	@FindBy(xpath="//div[@id='signup-box-title-container']/small[contains (text(), '2 minute setup to get started')]")
	WebElement TwoMinutesSetupToGetStarted_div;
	
	@FindBy(xpath="//button[@id='google-signup-btn']")
	WebElement SignInWithGoogle_button;	
	
	@FindBy(xpath="//div/input[@id='signup-first-name']")
	WebElement FirstName_textfield;
	
	@FindBy(xpath="//div/input[@id='signup-last-name']")
	WebElement LastName_textfield;	
	
	@FindBy(xpath="//div/input[@id='signup-email-address']")
	WebElement EmailAddress_textfield;		
	
	@FindBy(xpath="//div/input[@id='signup-password']")
	WebElement Password_textfield;		
	
	@FindBy(xpath="//div[@id='signup-box-info-fineprint']/small[contains(.,'By signing up, you agree to SEOReseller')]")
	WebElement TermsOfUseAndPrivacyPolicyVerbiage_div;

	@FindBy(xpath="//div/button[@id='signup-box-info-action-button']")
	WebElement CreateAccount_button;	
	
	@FindBy(xpath="//div/small[text()='Already have an account? ']")
	WebElement AlreadyhaveAnAccount_div;
	
	@FindBy(xpath="//div/small/a[text()='Log in']")
	WebElement Login_link;
	
	@FindBy(xpath="//div/small/a[text()='Terms of Use']")
	WebElement TermsOfUse_link;
	
	@FindBy(xpath="//div/small/a[text()='Privacy Policy']")
	WebElement PrivacyPolicy_link;
	
	
	
	public SEO10_Signup() {
		PageFactory.initElements(driver, this);
		
	}
	
	@Then("^Ill see the SEO010_SignUp Page$")
	public void ill_see_the_signup_page() throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, CreateYourAccount_div.isDisplayed());
	}
	
	@Then("^Ill see the SEO010_TwoMinutesSetupToGetStarted_div with \"(2 minute setup to get started with SEOReseller right away. Grow your agency by outsourcing your SEO, Web Design, Social Media, Link Building and more!)\"$")
	public void ill_see_the_twominute_setup_message(String Message) throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, TwoMinutesSetupToGetStarted_div.isDisplayed());
			Assert.assertEquals(Message, TwoMinutesSetupToGetStarted_div.getText());
	}
	
	@Then("^Ill see the SEO010_SignInWithGoogle button$")
	public void ill_see_the_signin_with_google_message() throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, SignInWithGoogle_button.isDisplayed());
	}
	
	@Then("^Ill see the SEO010_FirstName textfield$")
	public void ill_see_the_FirstName_textfield() throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, FirstName_textfield.isDisplayed());
	}
	
	@Then("^Ill see the SEO010_LastName textfield$")
	public void ill_see_the_LastName_textfield() throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, LastName_textfield.isDisplayed());
	}
	
	@Then("^Ill see the SEO010_EmailAddress textfield$")
	public void ill_see_the_email_textfield() throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, EmailAddress_textfield.isDisplayed());
	}
	
	@Then("^Ill see the SEO010_Password textfield$")
	public void ill_see_the_Password_textfield() throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, Password_textfield.isDisplayed());
	}
	
	@Then("^Ill see the SEO010_TermsOfUseAndPrivacyPolicyVerbiage_div with \"(By signing up, you agree to SEOReseller's Terms of Use and Privacy Policy)\"$")
	public void ill_see_the_terms_and_privacy_text(String Message) throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, TermsOfUseAndPrivacyPolicyVerbiage_div.isDisplayed());
			Assert.assertEquals(Message, TermsOfUseAndPrivacyPolicyVerbiage_div.getText());
	}

	@Then("^Ill see the SEO010_AlreadyhaveAnAccount_div with \"(Already have an account)\"$")
	public void ill_see_the_already_have_an_account_text(String Message) throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, AlreadyhaveAnAccount_div.isDisplayed());
			Assert.assertEquals(true, AlreadyhaveAnAccount_div.getText().contains(Message));
	}
	
	@Then("^Ill see the SEO010_CreateAccount button$")
	public void ill_see_the_create_account_button() throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, CreateAccount_button.isDisplayed());
	}
	
	
	@When("^I populate the SEO010_FirstName textfield with ([^\"]*)$")
	public void i_populate_firstname_field_with_firstname_value(String firstName) throws Throwable, UnhandledAlertException {
		FirstName_textfield.sendKeys(firstName);
        Thread.sleep(3000);
	}
	
	@Then("^I populate the SEO010_LastName textfield with ([^\"]*)$")
	public void i_populate_lastname_field_with_lastname_value(String lastName) throws Throwable, UnhandledAlertException {
		LastName_textfield.sendKeys(lastName);
        Thread.sleep(3000);
	}
	
	@Then("^I populate the SEO010_Email textfield with ([^\"]*)$")
	public void i_populate_email_field_with_email_value(String email) throws Throwable, UnhandledAlertException {
        if(GetTestEnv().contains("PRD")){
        	Date date = new Date();
			String dateNoMin = new SimpleDateFormat("yyMMddSSS").format(date);
	       	clearWriteTextfile("webApp.Seoreseller\\Registration_Date.txt", dateNoMin);
			
			String[] emailParts = email.split("@");
			String finalString = emailParts[0]+"+"+dateNoMin+"@"+emailParts[1];
			EmailAddress_textfield.sendKeys(finalString);			
			
		}else{
			EmailAddress_textfield.sendKeys(email);			
		}
        
        Thread.sleep(3000);
	}
	
	@Then("^I populate the SEO010_Password textfield with ([^\"]*)$")
	public void i_populate_password_field_with_password_value(String password) throws Throwable, UnhandledAlertException {
		Password_textfield.sendKeys(password);
        Thread.sleep(5000);
	}
	
	@Then("^I click SEO010_CreateAccount button$")
	public void i_click_create_account_button() throws Throwable, UnhandledAlertException {
		CreateAccount_button.click();
        Thread.sleep(5000);
        
	}
	
	@When("^I click the SEO010_SignInWithGoogle button$")
	public void i_click_the_signin_with_google_message() throws Throwable, UnhandledAlertException {
	    SignInWithGoogle_button.click();
	    Thread.sleep(3000);
	}
	
}
