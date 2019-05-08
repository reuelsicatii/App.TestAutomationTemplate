package webApp.Seoreseller;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.When;

public class SEO18_OnboardingEnd extends WEBHelper{
	@FindBy(xpath="//button[contains(.,'go to the dashboard')]")
	WebElement LetsGoToTheDashBoard_button;
	
	
	public SEO18_OnboardingEnd() {
		PageFactory.initElements(driver, this);
	}
	
	@When("^I click the SEO18_LetsGoToTheDashboard button")
	public void i_click_lets_go_to_the_dashboard_button() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		LetsGoToTheDashBoard_button.click();
	}
}
