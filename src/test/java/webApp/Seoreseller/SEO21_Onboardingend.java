package webApp.Seoreseller;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;

public class SEO21_Onboardingend extends WEBHelper{
	@FindBy(xpath="(//div[@class='circle completed completed-success'])[1]")
	WebElement SuccessCheckerStepOne_icon;
	
	@FindBy(xpath="(//div[@class='circle completed completed-success'])[2]")
	WebElement SuccessCheckerStepTwo_icon;
	
	@FindBy(xpath="(//div[@class='circle completed completed-success'])[3]")
	WebElement SuccessCheckerStepThree_icon;
	
	@FindBy(xpath="//h4[text()='We’ll contact you at your chosen date and time and send you a reminder beforehand.']")
	WebElement WellContactYouAtYourChosenDate_header;
	
	@FindBy(xpath="//p[contains(.,'If you have any questions')]")
	WebElement IfYouHaveAnyQuestions_text;
	
	@FindBy(xpath="//a[text()='message']")
	WebElement Message_link;
	
	@FindBy(xpath="//button[contains(text(),'go to the dashboard')]")
	WebElement LetsGoToTheDashboard_button;
	
	public SEO21_Onboardingend() {
		PageFactory.initElements(driver, this);
	}
	
	
	@Then("^Ill see the SEO21_WellContactYou header with \"(We'll contact you at your chosen date and time and send you a reminder beforehand.)\"$")
	public void i_see_the_message_contact_you_at_chosen_date(String message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, WellContactYouAtYourChosenDate_header.isDisplayed());
		Assert.assertEquals(true, WellContactYouAtYourChosenDate_header.getText().replace("’", "'").contains(message));
	}
	
	
	 @Then("^Ill see the SEO21_IfYouHaveAnyQuestions text with \"(If you have any questions)\"$")
		public void i_see_the_message_if_you_have_questions(String message) throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, IfYouHaveAnyQuestions_text.isDisplayed());
			Assert.assertEquals(true, IfYouHaveAnyQuestions_text.getText().contains(message));
	 }
	 
	 @Then("^Ill see that the SEO21_Message text is a link")
		public void i_see_message_text_is_link() throws Throwable, UnhandledAlertException {
			String tagName = Message_link.getTagName();
			Assert.assertEquals("a", tagName);
	 }
	
	 @Then("^Ill see the SEO21_LetsGoToTheDashboard button")
		public void i_see_lets_go_to_dashboard_button() throws Throwable, UnhandledAlertException {
			Assert.assertEquals(true, LetsGoToTheDashboard_button.isDisplayed());
	 }
}
