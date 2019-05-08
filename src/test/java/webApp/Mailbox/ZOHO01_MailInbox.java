package webApp.Mailbox;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ZOHO01_MailInbox extends WEBHelper{
	@FindBy(xpath=".//input[@id='lid']")
	WebElement ZohoEmail_textfield;

	@FindBy(xpath=".//input[@id='pwd']")
	WebElement ZohoPassword_textfield;
	
	@FindBy(xpath="//div[text()='Sign In']")
	WebElement ZohoSignIn_button;
	
	@FindBy(xpath="(.//a[@class='zgh-login'])[1]")
	WebElement Login_link;
	
	@FindBy(xpath="//span[text()='SEOReseller']")
	WebElement ZohoSEOReseller_button;
	
	@FindBy(xpath="//div//a[text()='Reset your Password']")
	WebElement ResetYourPassword_button;
	
	@FindBy(xpath="//div[@class='ii gt']//div/a[contains(text(),'account')]")
	WebElement ResetYourPassword_link;
	
	@FindBy(xpath="//p[contains(text(),'Thank you for registering at SEOReseller.com ')]")
	WebElement ThankYouForRegistering_div;	
	
	@FindBy(xpath="//a[text()='GO TO MY DASHBOARD']")
	WebElement GoToDashBoard_button;	
	
	@FindBy(xpath="//a[contains(.,'account.seoreseller')]")
	WebElement GoToDashBoard_link;
	
	public static final List<WebElement> getdivList(String keyword){
		List<WebElement> divList = driver.findElements(By.xpath("//div[contains(text(),'" + keyword + "')]"));
		return divList;
	}
	
	public static final WebElement SearchEmail(String keyword){
		WebElement EmailSubject = driver.findElement(By.xpath("(//span[contains(.,'"+keyword+"')])[1]"));
		return EmailSubject;
	}
	
	public static final WebElement SearchEmailAge(String keyword){
		WebElement SearchEmailAge = driver.findElement(By.xpath("(//span[contains(.,'"+keyword+"')])[1]"));
		return SearchEmailAge;
	}
	
	public ZOHO01_MailInbox() {
		PageFactory.initElements(driver, this);
		
	}
	
	@When("^I navigate to ZOHO$")
	public void i_navigate_to_ZOHO() throws Throwable, UnhandledAlertException {
		driver.get("https://www.zoho.com/mail/");
	}

	@When("^I click the ZOHO01_Login link$")
	public void i_click_the_ZOHO__GoogleHomeSignIn_link() throws Throwable, UnhandledAlertException {
		Login_link.click();
	}

	@When("^I populate the ZOHO01_Email textField with ([^\"]*)$")
	public void i_populate_the_ZOHO__GoogleEmail_textField_with_Email(String Email) throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		ZohoEmail_textfield.sendKeys(Email);
	}

	@When("^I populate the ZOHO01_Password textField with ([^\"]*)$")
	public void i_populate_the_ZOHO__GooglePassword_textField_with_Password(String Password) throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		ZohoPassword_textfield.sendKeys(Password);
	}
	
	@When("^I click the ZOHO01_SignIn button$")
	public void i_click_the_ZOHO_GoogleNext_button() throws Throwable, UnhandledAlertException {
		ZohoSignIn_button.click();
	}
	
	@When("^I click the ZOHO01_SEOReseller button$")
	public void i_click_the_ZOHO_Inbox_button() throws Throwable, UnhandledAlertException {
		Thread.sleep(10000);
		ZohoSEOReseller_button.click();
	}
	
	@Then("^I see the ZOHO01_EmailSubject div with \"(Please Confirm Your Email Address)\"$")
	public void i_see_the_ZOHO_EmailSubject_with_Subject(String subject) throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, SearchEmail(subject).isDisplayed());
		Assert.assertEquals(subject, SearchEmail(subject).getText());
	}

	@When("^I click the ZOHO01_EmailSubject div with \"(Please Confirm Your Email Address)\"$")
	public void i_click_the_ZOHO_EmailSubject_with_Subject(String subject) throws Throwable, UnhandledAlertException {
		loop:
		for(int i=0;i<3; i++){
			Thread.sleep(5000);
			if(SearchEmail(subject).isDisplayed()){
				SearchEmail(subject).click();
				break loop;
			}else{
				if(i==2){
					fail("Expected to receive the email with subject: "+subject );
				}
			}
		}
	}

	@Then("^Ill see the ZOHO01_Message div with \"(To reset your password please click on the button below. Link will only be valid for 24 hours:)\"$")
	public void ill_see_the_ZOHO__Message_div_with_Hi_Partner_To_reset_your_password_please_click_on_the_button_below_Link_will_only_be_valid_for_hours(String Message) throws Throwable, UnhandledAlertException {
			
		for (WebElement div : getdivList(Message)) {			
			if (div.isDisplayed()) {
				Assert.assertEquals(Message, div.getText());
				break;
			}			
		}		
	}
	
	@Then("^Ill see the ZOHO01_Message div with \"(This message is to confirm that you changed your password.)\"$")
	public void ill_see_the_ZOHO__Message_div_with_Hello_This_message_is_to_confirm_that_you_changed_your_password(String Message) throws Throwable, UnhandledAlertException {
		
		for (WebElement div : getdivList(Message)) {			
			if (div.isDisplayed()) {
				Assert.assertEquals(Message, div.getText());
				break;
			}			
		}		
	}

	@Then("^Ill see the ZOHO01_ResetYourPassword ([^\"]*)$")
	public void ill_see_the_ZOHO__ResetYourPassword_button(String ElementName) throws Throwable, UnhandledAlertException {
	
		switch(ElementName) {
		    case "button":
		    	Assert.assertEquals(true, ResetYourPassword_button.isDisplayed());
		        break;
		    case "link":
		    	Assert.assertEquals(true, ResetYourPassword_link.isDisplayed());
		        break;
			}
	}

	@When("^I click the ZOHO01_ResetYourPassword ([^\"]*)$")
	public void i_click_the_ZOHO__ResetYourPassword_ElementName(String ElementName) throws Throwable, UnhandledAlertException {

		switch(ElementName) {
	    case "button":
	    	ResetYourPassword_button.click();
	        break;
	    case "link":
	    	ResetYourPassword_link.click();
	        break;
		}
		
	}
	

	
	@Then("^Ill not see the ZOHO01_GooglePopUp window$")
	public void google_signin_window_will_close() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
	}
	
	@Then("^Ill see the ZOHO01_ThankYouForRegistering div with \"(Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below.)\"$")
	public void ill_see_email_thankyou_for_registering_text(String Message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, ThankYouForRegistering_div.isDisplayed());
		Assert.assertEquals(Message, ThankYouForRegistering_div.getText());

	}
	
	@Then("^Ill see the ZOHO01_GotoMyDashboard ([^\"]*)$")
	public void ill_see_the_ZOHO01_GoToDashboard_ElementName(String ElementName) throws Throwable, UnhandledAlertException {
	
		switch(ElementName) {
		    case "button":
		    	Assert.assertEquals(true, GoToDashBoard_button.isDisplayed());
		        break;
		    case "link":
		    	Assert.assertEquals(true, GoToDashBoard_link.isDisplayed());
		        break;
			}
	}

	@When("^I click the ZOHO01_GotoMyDashboard ([^\"]*)$")
	public void i_click_the_ZOHO01_GoToDashboard_ElementName(String ElementName) throws Throwable, UnhandledAlertException {

		switch(ElementName) {
	    case "button":
	    	GoToDashBoard_button.click();
	        break;
	    case "link":
	    	GoToDashBoard_link.click();
	        break;
		}
		
	}
	
}
