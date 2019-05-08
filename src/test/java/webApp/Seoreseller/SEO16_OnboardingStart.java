package webApp.Seoreseller;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SEO16_OnboardingStart extends WEBHelper{
	@FindBy(xpath="//button[contains(.,'get started')]")
	WebElement LetsGetStarted_button;
	
	@FindBy(xpath="//h1[contains(.,'Hey there! ')]")
	WebElement HeyThere_text;
	
	@FindBy(xpath="//div[@class='circle'][text()='1']")
	WebElement StepperOne_icon;
	
	@FindBy(xpath="//div[@class='circle'][text()='2']")
	WebElement StepperTwo_icon;
	
	@FindBy(xpath="//div[@class='circle'][text()='3']")
	WebElement StepperThree_icon;
	
	@FindBy(xpath="//p[text()='By far the best SEO reseller provider we’ve worked with. Their plans are reasonably priced and staff is phenomenal. I highly recommend them.']")
	WebElement SearchGiantQuote_div;
	
	@FindBy(xpath="//div[@class='body-wrapper']//p[text()='It’s great to have you onboard with SEOReseller.']")
	WebElement Title_text;
	
	@FindBy(xpath="//div[@class='body-wrapper']//p[contains(text(),'We’re excited to work with you and be your partner in growth')]")
	WebElement SubText_text;
	
	public SEO16_OnboardingStart() {
		PageFactory.initElements(driver, this);
	}
	

	@When("^I click the SEO16_LetsGetStarted button$")
	public void i_click_lets_get_started_button() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		LetsGetStarted_button.click();
	}
	
	
	@Then("^Ill be redirected to the SEO16_HeyThere Page$")
	public void ill_be_redirected_to_SEO16_HeyThere_Page() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, HeyThere_text.isDisplayed());
	}
	
	@Then("^Ill be able to see a SEO16_StepCounter with numbers 1 to 3$")
	public void ill_be_able_to_see_ste_counters() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, StepperOne_icon.isDisplayed());
		Assert.assertEquals(true, StepperTwo_icon.isDisplayed());
		Assert.assertEquals(true, StepperThree_icon.isDisplayed());

	}
	
	@Then("^Ill see the SEO16_SearchGiantQuote div with \"(By far the best SEO reseller provider we've worked with. Their plans are reasonably priced and staff is phenomenal. I highly recommend them.)\"$")
	public void i_see_the_quote_by_search_giant_quote(String message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, SearchGiantQuote_div.isDisplayed());
		Assert.assertEquals(message, SearchGiantQuote_div.getText().replace("’", "'"));
	}
	
	@Then("^Ill see the SEO16_Title text with \"(It's great to have you onboard with SEOReseller.)\"$")
	public void i_see_the_message_its_great_to_have_you_onboard(String message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Title_text.isDisplayed());
		Assert.assertEquals(message, Title_text.getText().replace("’", "'"));
	}
	

	@Then("^Ill see the SEO16_SubText with \"(We're excited to work with you and be your partner in growth. We've helped thousands of clients improve rankings, and helped marketers build powerful digital marketing agencies.)\"$")
	public void i_see_the_message_were_excited_to_work_with_you(String message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, SubText_text.isDisplayed());
		Assert.assertEquals(message, SubText_text.getText().replace("’", "'"));
	}
	
	
	@Then("^Ill see the SEO16_LetsGetStarted button$")
	public void i_see_the_lets_get_started_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, LetsGetStarted_button.isDisplayed());
	}
	
}

