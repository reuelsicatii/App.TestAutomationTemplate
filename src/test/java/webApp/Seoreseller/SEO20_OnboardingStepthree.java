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

public class SEO20_OnboardingStepthree extends WEBHelper{
	@FindBy(xpath="//h2[text()='Let’s schedule your onboarding call']")
	WebElement LetsScheduleCall_header;
	
	@FindBy(xpath="//p[contains(.,'We’ll discuss our future partnership, how we will be working together')]")
	WebElement DiscussFuturePartnership_text;
	
	@FindBy(xpath="//iframe[@class='calendly']")
	WebElement Calendly_iframe;
	
	@FindBy(xpath="//button[text()='Done with Booking my Call']")
	WebElement DoneWithMyBooking_button;
	
	@FindBy(xpath="//span[text()='Nah, I’ll do it later']")
	WebElement IllDotItLater_link;
	
	@FindBy(xpath="(//div[@class='fraction js-day-wrapper available']/div[@class='day js-show-picker'])[1]")
	WebElement FirstAvailableDayCalendly_div;
	
	@FindBy(xpath="(//li[@class='spot available collapsed']/button[@class='button js-select time-button'])[1]")
	WebElement FirstAvailableTimeCalendly_button;
	
	@FindBy(xpath="(//button[text()='Confirm'])[1]")
	WebElement FirstConfirmCalendly_button;
	
	@FindBy(xpath="//input[@name='full_name']")
	WebElement FullNameCalendly_textfield;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement EmailCalendly_textfield;
	
	@FindBy(xpath="//input[@name='national_number']")
	WebElement NationalNumberCalendly_textfield;
	
	@FindBy(xpath="//input[@value='Schedule Event']")
	WebElement ScheduleEventCalendly_button;
	
	@FindBy(xpath="//h2[text()='Select a Day']")
	WebElement SelectADayCalendly_header;
	
	@FindBy(xpath="//span[@class='icon-angle-right']")
	WebElement NextCalendly_icon;
	
	
	public SEO20_OnboardingStepthree() {
		PageFactory.initElements(driver, this);
	}
	
	
	@Then("^Ill see the SEO20_LetsScheduleYourcall header with \"(Let's schedule your onboarding call)\"$")
	public void i_see_the_message_lets_schedule_call(String message) throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(DoneWithMyBooking_button));
		Assert.assertEquals(true, LetsScheduleCall_header.isDisplayed());
		Assert.assertEquals(message, LetsScheduleCall_header.getText().replace("’", "'"));
	}
	
	
	@Then("^Ill see the SEO20_DiscussOurFuturePartnership text with \"(We'll discuss our future partnership, how we will be working together)\"$")
	public void i_see_the_message_discuss_future_partnership(String message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, DiscussFuturePartnership_text.isDisplayed());
		Assert.assertEquals(true, DiscussFuturePartnership_text.getText().replace("’", "'").contains(message));
	}
	
	
	@Then("^Ill see the SEO20_Calendly iframe$")
	public void i_see_calendly_iframe() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Calendly_iframe.isDisplayed());
	}
	    
    @Then("^Ill see the SEO20_DoneWithBookingMyCall button$")
	public void i_see_done_with_booking_call_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, DoneWithMyBooking_button.isDisplayed());
	}	 

    @Then("^Ill see the SEO20_NahIllDoIt link$")
	public void i_see_ill_do_it_later_link() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, IllDotItLater_link.isDisplayed());
	}
 
    
    @When("^I select the SEO20_FirstAvailableDay in Calendly$")
   	public void i_select_first_available_day_calendly() throws Throwable, UnhandledAlertException {
    	driver.switchTo().frame(Calendly_iframe);
    	Thread.sleep(3000);
    	JS.executeScript("return document.getElementsByClassName('day js-show-picker')[1].click();");

   	}
	
    @When("^I select the SEO20_FirstAvailableTime in Calendly$")
   	public void i_select_first_available_time_calendly() throws Throwable, UnhandledAlertException {
    	JS.executeScript("return document.getElementsByClassName('button js-select time-button ')[1].click();");
    }
    
    @When("^I click the SEO20_FirstAvailableConfirm button in Calendly$")
   	public void i_click_first_available_confirm_calendly() throws Throwable, UnhandledAlertException {
    	JS.executeScript("return document.getElementsByClassName('base button confirm-button js-confirm')[1].click();");
   	}
    
    @When("^I populate the SEO20_FullNameCalendly textfield with ([^\"]*)$")
   	public void i_populate_fullname_calendly_textfield_with_value(String fullName) throws Throwable, UnhandledAlertException {
    	String currentSrc = JS.executeScript("return document.getElementsByClassName('calendly')[0].src;").toString();
    	String finalSrc = currentSrc+"&full_name="+fullName;
    	JS.executeScript ("return document.getElementsByClassName('calendly')[0].src = '"+finalSrc+"';");
   	}
    
    @When("^I populate the SEO20_EmailCalendly textfield with ([^\"]*)$")
   	public void i_populate_email_calendly_textfield_with_value(String email) throws Throwable, UnhandledAlertException {
    	Thread.sleep(3000);
    	String currentSrc = JS.executeScript("return document.getElementsByClassName('calendly')[0].src;").toString();
    	String finalSrc = currentSrc+"&email="+email;
    	JS.executeScript ("return document.getElementsByClassName('calendly')[0].src = '"+finalSrc+"';");
   	}

    
    @When("^I click the SEO20_ScheduleEvent button$")
   	public void i_click_schedule_event_button( ) throws Throwable, UnhandledAlertException {
    	Thread.sleep(3000);
    	JS.executeScript("return document.getElementsByClassName('button js-loading-hide')[0].click();");
    	driver.switchTo().defaultContent();
   	}
    
    
    @When("^I click the SEO20_DoneWithBookingMyCall button$")
   	public void i_click_done_with_booking_my_call_button( ) throws Throwable, UnhandledAlertException {
    	DoneWithMyBooking_button.click();
   	}
}
