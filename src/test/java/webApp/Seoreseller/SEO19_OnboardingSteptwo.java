package webApp.Seoreseller;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SEO19_OnboardingSteptwo extends WEBHelper{
	@FindBy(xpath="//h1[text()='Getting to know you']")
	WebElement GettingToKnowYou_header;
	
	@FindBy(xpath="(//div[@class='circle completed'])[1]")
	WebElement StepOneCompleted_icon;
	
	@FindBy(xpath="//h4[text()='How can we reach you?']")
	WebElement HowCanWeReachYou_header;
	
	@FindBy(xpath="//input[@type='tel']")
	WebElement ContactNumber_textfield;
	
	
	
	@FindBy(xpath="//p[text()='The Diagnosis call allowed me to start thinking differently about my agency and build a serious business plan. I’ve just passed my first million dollar in revenue!']")
	WebElement TheDiagnosisCallAllowed_text;
	
	@FindBy(xpath="//p[text()='In case we need to contact you about your campaigns, please provide us with a phone number where we can easily reach you.']")
	WebElement InCaseWeNeedToContact_text;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement Save_button;
	
	
	public SEO19_OnboardingSteptwo() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@Then("^I will see the SEO19_GettingToKnowYou header")
	public void i_see_getting_to_know_you_header() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		GettingToKnowYou_header.isDisplayed();
	}
	
	
	@Then("^I will see the SEO19_TheDiagnosisCallAllowed div with \"(The Diagnosis call allowed me to start thinking differently about my agency and build a serious business plan. I've just passed my first million dollar in revenue!)\"$")
	public void i_see_the_message_diagnosis_call_allowed(String message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, TheDiagnosisCallAllowed_text.isDisplayed());
		Assert.assertEquals(message, TheDiagnosisCallAllowed_text.getText().replace("’", "'"));
	}
	
	@Then("^I will see the SEO19_CheckMark Icon for Step One Page")
	public void i_see_check_mark_icon_for_step_one() throws Throwable, UnhandledAlertException {
		StepOneCompleted_icon.isDisplayed();
	}
	
	@Then("^I will see the SEO19_HowCanWeReachYou header")
	public void i_see_how_can_we_reach_you_header() throws Throwable, UnhandledAlertException {
		HowCanWeReachYou_header.isDisplayed();
	}
	
	
	@Then("^I will see the SEO19_InCaseWeNeedToContact div with \"(In case we need to contact you about your campaigns, please provide us with a phone number where we can easily reach you.)\"$")
	public void i_see_the_message_incase_we_need_to_contact(String message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, InCaseWeNeedToContact_text.isDisplayed());
		Assert.assertEquals(message, InCaseWeNeedToContact_text.getText());

	}
	
	@Then("^I will see the SEO19_ContactNumber textfield$")
	public void i_see_the_contact_num_field() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, ContactNumber_textfield.isDisplayed());
	}
	
	@When("^I populate SEO19_ContactNumber textfield with ([^\"]*)$")
	public void i_populate_contact_num_field_with_value(String contactNumber) throws Throwable, UnhandledAlertException {
	   ContactNumber_textfield.sendKeys(contactNumber);
	}
	
	@When("^I click the SEO19_Save button$")
	public void i_click_save_button() throws Throwable, UnhandledAlertException {
		Save_button.click();
	}
	
	
	
}
