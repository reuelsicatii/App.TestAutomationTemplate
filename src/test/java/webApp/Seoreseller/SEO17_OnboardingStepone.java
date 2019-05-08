package webApp.Seoreseller;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SEO17_OnboardingStepone extends WEBHelper{
	@FindBy(xpath="//span[text()='SKIP']")
	WebElement Skip_link;
	
	@FindBy(xpath="//button[text()='Proceed']")
	WebElement Proceed_button;
	
	@FindBy(xpath="//input[@id='radio-list-01']")
	WebElement test;
	
	
	public static final WebElement SeoHandlingRadioButton(String seo){
		WebElement seohandlingRadioButton = driver.findElement(By.xpath("//label[contains(.,'"+seo+"')]/../input[@type='radio']"));
		return seohandlingRadioButton;
	}
	
	public SEO17_OnboardingStepone() {
		PageFactory.initElements(driver, this);
	}
	
	@When("^I click the SEO17_Skip link")
	public void i_click_skip_link() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Skip_link.click();
	}
	
	@When("^I click the SEO17_Myself Radio button")
	public void i_click_myself_radio_button() throws Throwable, UnhandledAlertException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('radio-list-0').click();");
	}
	
	@When("^I click the SEO17_InHouse Radio button")
	public void i_click_inhouse_radio_button() throws Throwable, UnhandledAlertException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('radio-list-1').click();");
	}
	
	@When("^I click the SEO17_WithFreelancer Radio button")
	public void i_click_with_freelancer_radio_button() throws Throwable, UnhandledAlertException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('radio-list-2').click();");
	}
	
	@When("^I click the SEO17_WithAnAgency Radio button")
	public void i_click_with_agency_radio_button() throws Throwable, UnhandledAlertException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('radio-list-3').click();");
	}
	
	@When("^I click the SEO17_WithAnOutsource Radio button")
	public void i_click_with_outsource_radio_button() throws Throwable, UnhandledAlertException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('radio-list-4').click();");
	}
	
	@When("^I click the SEO17_DontDoSEO Radio button")
	public void i_click_with_dont_do_seo_radio_button() throws Throwable, UnhandledAlertException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('radio-list-5').click();");
	}
	
	@Then("^Ill see that the SEO17_Proceed button will be enabled")
	public void ill_see_proceed_button_enabled() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Proceed_button.isEnabled());

	}
	
	@When("^I click the SEO17_Proceed button")
	public void i_click_proceed_button() throws Throwable, UnhandledAlertException {
		Proceed_button.click();

	}
	
	@When("^I click the radio button of SEO17_([^\"]*)")
	public void i_click_the_value_radio_button(String radioOption) throws Throwable, UnhandledAlertException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		if(radioOption.contains("myself")){
			js.executeScript("document.getElementById('radio-list-0').click();");
			
		}else if(radioOption.contains("in-house")){
			js.executeScript("document.getElementById('radio-list-1').click();");
			
		}else if(radioOption.contains("with a freelancer")){
			js.executeScript("document.getElementById('radio-list-2').click();");
			
		}else if(radioOption.contains("with an agency")){
			js.executeScript("document.getElementById('radio-list-3').click();");
			
		}else if(radioOption.contains("with an outsource provider")){
			js.executeScript("document.getElementById('radio-list-4').click();");
			
		}else if(radioOption.contains("no seo")){
			js.executeScript("document.getElementById('radio-list-5').click();");
			
		}
		
	}
	
}
