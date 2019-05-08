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

public class SEO12_SettingsEmail extends WEBHelper{
	
	@FindBy(xpath="//h3[text()='Email Address']")
	WebElement EmailAddress_header;
	
	@FindBy(xpath="//label[text()='Email Address']/../..//button[text()='Update']")
	WebElement Update_button;
	
	@FindBy(xpath="//input[@id='email_mail_settings']")
	WebElement EmailAddressReadOnly_textfield;
	
	@FindBy(xpath="//small[contains(.,'This is an auto-generated signature for your convenience')]")
	WebElement ThisIsAnAutoGen_text;
	
	@FindBy(xpath="//html[@dir='ltr']//body")
	WebElement EmailSignatureEditor_body;
	
	@FindBy(xpath="//small[contains(.,'Please make sure to include your company address')]")
	WebElement PleaseMakeSure_text;
	
	@FindBy(xpath="//button[contains(.,'Save')]")
	WebElement Save_button;
	
	@FindBy(xpath="//h4[text()='Email Setup Wizard']")
	WebElement EmailSetupWizard_header;
	
	@FindBy(xpath="//input[@placeholder='Email Address']")
	WebElement FromEmailAddress_textfield;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement Next_button;
	
	@FindBy(xpath="//p[@class='form-description nomargin']")
	WebElement OpppsWeDontSupport_text;
	
	@FindBy(xpath="//h3[@class='dialog-icon']/i")
	WebElement SadFace_image;
	
	@FindBy(xpath="//button[text()='Retry']")
	WebElement Retry_button;
	
	@FindBy(xpath="//input[@id='account_password']")
	WebElement Password_textfield;
	
	@FindBy(xpath="//input[@id='incoming_email_server']")
	WebElement IMAPserver_textfield;
	
	@FindBy(xpath="//input[@id='incoming_email_server_port']")
	WebElement IMAPserverPort_textfield;
	
	@FindBy(xpath="//input[@id='outgoing_email_server']")
	WebElement SMTPserver_textfield;
	
	@FindBy(xpath="//input[@id='outgoing_email_server_port']")
	WebElement SMTPserverPort_textfield;
	
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement SignIn_button;
	
	@FindBy(xpath="//h1[text()='Success!']")
	WebElement Success_header;
	
	@FindBy(xpath="//button[contains(.,'Roll')]")
	WebElement LetsRoll_button;
	
	@FindBy(xpath="//p[@class='form-description']")
	WebElement SEOResellerWillSendItsEmails_text;
	
	@FindBy(xpath="//label[text()='Email Address']/../..//button[text()='Add']")
	WebElement Add_button;
	
	@FindBy(xpath="//*[@id='settings_email']")
	WebElement EmailAddress_textfield;
	
	@FindBy(xpath="//input[@id='account_username']")
	WebElement Username_textfield;
	
	

	public SEO12_SettingsEmail() {
		PageFactory.initElements(driver, this);
	}
	
	@Then("^Ill see the Email Settings Page$")
	public void ill_see_the_email_settings_page() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, EmailAddress_header.isDisplayed());
		Assert.assertEquals("http://staging.account.seoreseller.com/settings/email", driver.getCurrentUrl());
	}

	@When("^I click SEO12_Update button$")
	public void i_click_SEO12_update_button() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Update_button));
		Update_button.click();
	}
	
	@Then("^Ill see the Email Setup Wizard Modal$")
	public void ill_see_email_setup_wizard() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		Assert.assertEquals(true, EmailSetupWizard_header.isDisplayed());
	}
	
	@Then("^Ill see the \"SEOReseller will send its emails using your email account. Please confirm the email address you will be using.\"$")
	public void ill_see_seoreseller_will_send_its_ermail_verbiage() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		Assert.assertEquals(true, SEOResellerWillSendItsEmails_text.isDisplayed());
	}
	
	@Then("^Ill see the SEO12_EmailAddress textfield$")
	public void ill_see_email_address_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, FromEmailAddress_textfield.isDisplayed());
	}
	
	@Then("^Ill see the SEO12_Next button$")
	public void ill_see_next_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Next_button.isDisplayed());
	}
	
	@When("^I enter ([^\"]*) in the SEO12_EmailAddress textfield$")
	public void i_enter_safeemail_value_in_email_address_textfield(String safeEmail) throws Throwable, UnhandledAlertException {
		FromEmailAddress_textfield.clear();
		FromEmailAddress_textfield.sendKeys(safeEmail);
        Thread.sleep(3000);
	}
	
	@Then("^I click SEO12_Next button$")
	public void ill_click_next_button() throws Throwable, UnhandledAlertException {
		Next_button.click();
	}

	@Then("^Ill see the \"We currently dont support Yahoo and Microsoft emails.\" Message$")
	public void ill_see_oops_message() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Retry_button));
		Assert.assertEquals(true, OpppsWeDontSupport_text.isDisplayed());
	}
	
	@Then("^Ill see the SEO12_Retry button$")
	public void ill_see_retry_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Retry_button.isDisplayed());
	}
	
	
	@Then("^Ill see the \"This is an auto-generated signature for your convenience.\" text$")
	public void ill_see_the_AutoGeneratedSignature_verbiage() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, ThisIsAnAutoGen_text.isDisplayed());
	}
	
	@Then("^Ill see the \"Please make sure to include your company address.\" text$")
	public void ill_see_the_CompanyAddress_verbiage() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, PleaseMakeSure_text.isDisplayed());
	}
	
	@Then("^I ([^\"]*) my Email Signature$")
	public void i_SetUpCondition_my_Email_Signature(String arg1) throws Throwable, UnhandledAlertException {
		//CodeHere
	}
	
	@When("^I click the SEO12_Add button$")
	public void ill_click_the_SEO12_Add_button() throws Throwable, UnhandledAlertException {
		Add_button.click();
	}
	
	@When("^I populate ([^\"]*) in the SEO12_EmailAddress textfield$")
	public void i_populate_variable_in_the_EmailAddress_textfield(String arg1) throws Throwable, UnhandledAlertException {
		EmailAddress_textfield.sendKeys(arg1);;
	}
	
	@When("^I click the SEO12_Next button$")
	public void ill_click_the_SEO12_Next_button() throws Throwable, UnhandledAlertException {
		Next_button.click();
	}
	
	@When("^I populate SEO12_Username textfield with ([^\"]*)$")
	public void i_populate_SEO12_Username_textfield_with_variable(String arg1) throws Throwable, UnhandledAlertException {
		Username_textfield.sendKeys(arg1);;
	}
	
	@When("^I populate SEO12_Password textfield with ([^\"]*)$")
	public void i_populate_SEO12_Password_textfield_with_variable(String arg1) throws Throwable, UnhandledAlertException {
		Password_textfield.sendKeys(arg1);;
	}
	
	@When("^I populate SEO12_IMAP textfield with ([^\"]*)$")
	public void i_populate_SEO12_IMAPserver_textfield_with_variable(String arg1) throws Throwable, UnhandledAlertException {
		IMAPserver_textfield.sendKeys(arg1);;
	}
	
	@When("^I populate SEO12_IMAPport textfield with ([^\"]*)$")
	public void i_populate_SEO12_IMAPserverPort_textfield_with_variable(String arg1) throws Throwable, UnhandledAlertException {
		IMAPserverPort_textfield.sendKeys(arg1);;
	}
	
	@When("^I populate SEO12_SMTP textfield with ([^\"]*)$")
	public void i_populate_SEO12_SMTPserver_textfield_with_variable(String arg1) throws Throwable, UnhandledAlertException {
		SMTPserver_textfield.sendKeys(arg1);;
	}	
	
	@When("^I populate SEO12_SMTPport textfield with ([^\"]*)$")
	public void i_populate_SEO12_SMTPserverPort_textfield_with_variable(String arg1) throws Throwable, UnhandledAlertException {
		SMTPserverPort_textfield.sendKeys(arg1);;
	}
	
	@When("^I click the SEO12_SignIn button$")
	public void ill_click_the_SEO12_SignIn_button() throws Throwable, UnhandledAlertException {
		SignIn_button.click();
	}
	
	@Then("^Ill see the Let's Roll Modal$")
	public void ill_see_the_Let_s_Roll_Modal() throws Throwable, UnhandledAlertException {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	
	
	
}
