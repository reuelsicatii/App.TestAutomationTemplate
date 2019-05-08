package webApp.Mailbox;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GMAIL01_MailInbox extends WEBHelper{
	@FindBy(xpath="//input[@type='email']")
	WebElement GoogleEmail_textField;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement GooglePassword_textField;
	
	@FindBy(xpath="//div[@id='identifierNext']//span[1]")
	WebElement GoogleEmailNext_button;
	
	@FindBy(xpath="//div[@id='passwordNext']//span[1]")
	WebElement GooglePasswordNext_button;
	
	@FindBy(xpath="//a[@data-g-label='Sign in']")
	WebElement GoogleHomeSignIn_link;
	
	@FindBy(xpath="//img[@alt='Print all']")
	WebElement GooglePrintAll_img;
	
	@FindBy(xpath="//a[@title='Gmail']/img")
	WebElement Google_hyperlink;
	
	@FindBy(xpath="//div[@class='J-J5-Ji J-JN-M-I-Jm']/span")
	WebElement Google_AllCheckbox;
	
	@FindBy(xpath="//div[@class='ar9 T-I-J3 J-J5-Ji']")
	WebElement Google_Delete;
	
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
	
	@FindBy(xpath="//p[text()='One moment please...']")
	WebElement OneMomentPlease_text;
	
	public static final List<WebElement> getdivList(String keyword){
		List<WebElement> divList = driver.findElements(By.xpath("//div[contains(text(),'" + keyword + "')]"));
		return divList;
	}
	
	public static final List<WebElement> getspanList(String keyword){
		List<WebElement> spanList = driver.findElements(By.xpath("//span[@class='bog']/span[contains(text(),'" + keyword + "')]"));
		return spanList;
	}
	
	public static final WebElement SearchEmail(String keyword){
		WebElement EmailSubject = driver.findElement(By.xpath("(//td[@class='xY a4W']//span[@class='bqe'][contains(.,'"+keyword+"')])[1]"));
		return EmailSubject;
	}
	
	public static final WebElement SearchEmailAge(String keyword){
		WebElement SearchEmailAge = driver.findElement(By.xpath("//span[contains(.,'"+keyword+"')]"));
		return SearchEmailAge;
	}
	
	public GMAIL01_MailInbox() {
		PageFactory.initElements(driver, this);
		
	}
	
	@When("^I navigate to GMAIL$")
	public void i_navigate_to_GMAIL() throws Throwable, UnhandledAlertException {
		driver.get("https://mail.google.com");
	}

	@When("^I click the GMAIL01_GoogleHomeSignIn link$")
	public void i_click_the_GMAIL__GoogleHomeSignIn_link() throws Throwable, UnhandledAlertException {
		GoogleHomeSignIn_link.click();
	}

	@When("^I populate the GMAIL01_GoogleEmail textField with ([^\"]*)$")
	public void i_populate_the_GMAIL__GoogleEmail_textField_with_Email(String Email) throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		GoogleEmail_textField.sendKeys(Email);
	}

	@When("^I click the GMAIL01_GoogleEmailNext button$")
	public void i_click_the_GMAIL__GoogleEmailNext_button() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		GoogleEmailNext_button.click();
	}

	@When("^I click the GMAIL01_GooglePasswordNext button$")
	public void i_click_the_GMAIL__GooglePasswordNext_button() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		GooglePasswordNext_button.click();
	}

	@When("^I populate the GMAIL01_GooglePassword textField with ([^\"]*)$")
	public void i_populate_the_GMAIL__GooglePassword_textField_with_Password(String Password) throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		GooglePassword_textField.sendKeys(Password);
	}
	
	@Then("^I see the GMAIL01_EmailSubject div with \"(Please Confirm Your Email Address)\"$")
	public void i_see_the_GMAIL_EmailSubject_with_Subject(String subject) throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		for (WebElement span : getspanList(subject)) {		
			if (span.isDisplayed()) {
				Assert.assertEquals(subject, span.getText());
				break;
			}			
		}	
	}

	@When("^I click the GMAIL01_EmailSubject div with \"(Please Confirm Your Email Address)\"$")
	public void i_click_the_GMAIL_EmailSubject_with_Subject_Please_Confirm_Your_Email_Address(String subject) throws Throwable, UnhandledAlertException {
		loop:
			for(int i=0;i<3; i++){
				Google_hyperlink.click();
				Thread.sleep(5000);
				if(SearchEmail(subject).isDisplayed()){
					SearchEmail(subject).click();
					break loop;
				}else{
					if(i==2){
						fail("Expected to receive the email with subject: "+subject );
					}
					Thread.sleep(10000);
				}
			}
	}
	
	@When("^I click the GMAIL01_EmailSubject div with \"(Reset Account Password Request)\"$")
	public void i_click_the_GMAIL_EmailSubject_with_Subject_Reset_Account_Password_Request(String subject) throws Throwable, UnhandledAlertException {
		loop:
		for(int i=0;i<3; i++){
			Google_hyperlink.click();
			Thread.sleep(5000);
			if(SearchEmail(subject).isDisplayed()){
				SearchEmail(subject).click();
				break loop;
			}else{
				if(i==2){
					fail("Expected to receive the email with subject: "+subject );
				}
				Thread.sleep(10000);
			}
		}
	}
	
	@When("^I click the GMAIL01_EmailSubject div with \"(Account Password successfully updated)\"$")
	public void i_click_the_GMAIL_EmailSubject_with_Subject_Account_Password_Successfully_Updated(String subject) throws Throwable, UnhandledAlertException {
		loop:
		for(int i=0;i<3; i++){
			Google_hyperlink.click();
			Thread.sleep(5000);
			if(SearchEmail(subject).isDisplayed()){
				SearchEmail(subject).click();
				break loop;
			}else{
				if(i==2){
					fail("Expected to receive the email with subject: "+subject );
				}
				Thread.sleep(10000);
			}
		}
	}

	@Then("^Ill see the GMAIL01_Message div with \"(To reset your password please click on the button below. Link will only be valid for 24 hours:)\"$")
	public void ill_see_the_GMAIL__Message_div_with_Hi_Partner_To_reset_your_password_please_click_on_the_button_below_Link_will_only_be_valid_for_hours(String Message) throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		for (WebElement div : getdivList(Message)) {
			if (div.isDisplayed()) {
				Assert.assertEquals(Message, div.getText());
				break;
			}			
		}		
	}
	
	@Then("^Ill see the GMAIL01_Message div with \"(This message is to confirm that you changed your password. Please see details:)\"$")
	public void ill_see_the_GMAIL__Message_div_with_Hello_This_message_is_to_confirm_that_you_changed_your_password(String Message) throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		for (WebElement div : getdivList(Message)) {			
			if (div.isDisplayed()) {
				Assert.assertEquals(Message, div.getText());
				break;
			}			
		}		
	}

	@Then("^Ill see the GMAIL01_ResetYourPassword ([^\"]*)$")
	public void ill_see_the_GMAIL__ResetYourPassword_button(String ElementName) throws Throwable, UnhandledAlertException {
	
		switch(ElementName) {
		    case "button":
		    	Assert.assertEquals(true, ResetYourPassword_button.isDisplayed());
		        break;
		    case "link":
		    	Assert.assertEquals(true, ResetYourPassword_link.isDisplayed());
		        break;
			}
	}

	@When("^I click the GMAIL01_ResetYourPassword ([^\"]*)$")
	public void i_click_the_GMAIL__ResetYourPassword_ElementName(String ElementName) throws Throwable, UnhandledAlertException {

		switch(ElementName) {
	    case "button":
	    	ResetYourPassword_button.click();
	        break;
	    case "link":
	    	ResetYourPassword_link.click();
	        break;
		}
		
	}

	
	@Then("^Ill not see the GMAIL01_GooglePopUp window$")
	public void google_signin_window_will_close() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
	}
	
	@Then("^Ill see the GMAIL01_ThankYouForRegistering div with \"(Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below.)\"$")
	public void ill_see_email_thankyou_for_registering_text(String Message) throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, ThankYouForRegistering_div.isDisplayed());
		Assert.assertEquals(Message, ThankYouForRegistering_div.getText());
	}
	
	@Then("^Ill see the GMAIL01_GotoMyDashboard ([^\"]*)$")
	public void ill_see_the_GMAIL01_GoToDashboard_ElementName(String ElementName) throws Throwable, UnhandledAlertException {
		switch(ElementName) {
	    case "button":
	    	Assert.assertEquals(true, GoToDashBoard_button.isDisplayed());
	        break;
	    case "link":
	    	Assert.assertEquals(true, GoToDashBoard_link.isDisplayed());
	        break;
		}
	}

	@When("^I click the GMAIL01_GotoMyDashboard ([^\"]*)$")
	public void i_click_the_GMAIL01_GoToDashboard_ElementName(String ElementName) throws Throwable, UnhandledAlertException {
		switch(ElementName) {
	    case "button":
	    	GoToDashBoard_button.click();
	        break;
	    case "link":
	    	GoToDashBoard_link.click();
	        break;
		}		
	}
	@Then("^Ill see the GMAIL01_GooglePopUp window")
	public void ill_see_the_google_signin_page() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(GoogleEmailNext_button));
		Assert.assertEquals(true, GoogleEmailNext_button.isDisplayed());
	}
	
}
