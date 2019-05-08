package webApp.Seoreseller;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SEO06_Login extends WEBHelper{
	
	@FindBy(xpath="//div//img")
	WebElement SrsBanner_image;
	
	@FindBy(xpath="//div[@class='form-group']/input[@id='email']")
	WebElement EmailAddress_textfield;
	
	@FindBy(xpath="//div[@class='form-group']/input[@id='password']")
	WebElement Password_textfield;
	
	@FindBy(xpath="//div[@id='remember-me-formgroup']/input[@name='remember']")
	WebElement RememberMe_checkbox;
	
	@FindBy(xpath="//span[@id='forgot-password-span']/a")
	WebElement ForgotYourPassword_link;
	
	@FindBy(xpath="//button[@class='login_button btn btn-primary text-uppercase']")
	WebElement LoginToYourDashBoard_button;
	
	@FindBy(xpath="//button[@id='google-signin']")
	WebElement SignInWithGoogle_button;
	
	@FindBy(xpath="//span[@id='dont-have-acct-span']/following-sibling::a")
	WebElement SignUp_link;
	
	@FindBy(xpath="//div[@class='alert alert-info text-center']/p")
	WebElement UsernamePasswordRequired_alert;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement IncorrectEmailPassCombination_Alert;
	
	@FindBy(xpath="//div[@class='terms-condition-container']")
	WebElement TermsOfUseAndPrivacyPolicyVerbiage_Text;
	
	@FindBy(xpath="//a[text()='Terms of Use']")
	WebElement TermsOfUse_link;
	
	@FindBy(xpath="//a[text()='Privacy Policy']")
	WebElement PrivacyPolicy_link;
	
	public SEO06_Login() {
		PageFactory.initElements(driver, this);
		
	}
	
	@Then("^Ill see the SEO06_EmailAddress textfield$")
	public void ill_see_the_email_address_field() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, EmailAddress_textfield.isDisplayed());
	}
	
	@When("^Ill see the SEO06_Password textfield$")
	public void ill_see_the_password_address_field() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Password_textfield.isDisplayed());
	}
	
	@When("^Ill see the SEO06_LogIntoyouDashboard button$")
	public void ill_see_the_login_to_dashboard_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, LoginToYourDashBoard_button.isDisplayed());
	}
	
	@When("^Ill see the SEO06_SigninwithGoogle button$")
	public void ill_see_the_signin_with_google_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, SignInWithGoogle_button.isDisplayed());
	}
	
	
	@When("^I populate the SEOE6_EmailAddress textfield with ([^\"]*)$")
	public void i_enter_email_value_in_emailaddress_field(String EmailAddress) throws Throwable, UnhandledAlertException {
		if(GetTestEnv().contains("PRD") & loginRunStatus.contains("no")){
			String dateIdentifier = readTextfile("webApp.Seoreseller\\Registration_Date.txt");	 

			String[] emailParts = EmailAddress.split("@");
			String finalString = emailParts[0]+"+"+dateIdentifier+"@"+emailParts[1];
			EmailAddress_textfield.sendKeys(finalString);			
			
		}else{
			EmailAddress_textfield.sendKeys(EmailAddress);			
		}
	}
	
	@When("^I populate the SEOE6_Password textfield with ([^\"]*)$")
	public void i_enter_password_value_in_password_field(String Password) throws Throwable, UnhandledAlertException {
		Password_textfield.sendKeys(Password);        
	}
	
	@When("^I click the SEO06_LoginToYourDashBoard button$")
	public void i_click_the_login_to_your_dashboard_button() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		LoginToYourDashBoard_button.click();
	}
	
	@When("^Ill see the SEO06_Error div with ([^\"]*)$")
	public void ill_see_the_error(String arg1) throws Throwable, UnhandledAlertException {
		if(arg1.equals("Incorrect")){
			Assert.assertEquals(true, IncorrectEmailPassCombination_Alert.isDisplayed());
		}else{
			Assert.assertEquals(true, UsernamePasswordRequired_alert.isDisplayed());
		}
	}
	
	@When("^I click the SEO06_SigninwithGoogle button$")
	public void i_click_the_sign_in_with_google() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(SignInWithGoogle_button));
		SignInWithGoogle_button.click();
	}
	
	@When("^I click the SEO06_ForgotPassword link$")
	public void i_click_the_forgot_password_link() throws Throwable, UnhandledAlertException {
		ForgotYourPassword_link.click();
	}
	
	@When("^Ill see the SEO06_TermsofUseandPrivacyPolicy div with message \"(By logging in, you agree to SEOReseller's Terms of Use and Privacy Policy)\"$")
	public void i_see_the_terms_of_use_and_privacy_policy_verbiage(String Message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(Message, TermsOfUseAndPrivacyPolicyVerbiage_Text.getText());
	}
	
	@Then("^Ill see the SEO06_SeoReseller Banner$")
	public void ill_see_the_seoreseller_banner() throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, SrsBanner_image.isDisplayed());
	}
	
	@When("^I click SEO06_SignUp link$")
	public void i_click_the_signup_link() throws Throwable, UnhandledAlertException {
		SignUp_link.click();
	}
	
	@Then("^Ill see the SEO06_LogIn page$")
	public void ill_see_login_page() throws Throwable, UnhandledAlertException {
		for(int i = 0; i <=4; i++){
			Thread.sleep(3000);
			if(SrsBanner_image.isDisplayed()){
				Assert.assertEquals(true, SrsBanner_image.isDisplayed());
			}else{
				System.out.println("SEO Banner not yet completely displayed");
				Thread.sleep(5000);
			}
		}
	}
	
	@Then("^Ill see that the SEO06_TermsofUse link will direct to /terms-use upon click$")
	public void ill_see_correct_redirection_of_TermsOfUSe_link() throws Throwable, UnhandledAlertException {
			TermsOfUse_link.click();
			Thread.sleep(3000);
			ReUsablesKeyword.switchToLatestTab();
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals(true, currentUrl.contains("terms-use"));
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");  
			ReUsablesKeyword.switchWindowTab(0);
	}
	
	@Then("^Ill see that the SEO06_PrivacyPolicy link will direct to /privacy-policy upon click$")
	public void ill_see_correct_redirection_of_PrivacyPolicy_link() throws Throwable, UnhandledAlertException {
			PrivacyPolicy_link.click();
			Thread.sleep(3000);
			ReUsablesKeyword.switchToLatestTab();
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals(true, currentUrl.contains("privacy-policy"));
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");  
			ReUsablesKeyword.switchWindowTab(0);
	}
	
}
