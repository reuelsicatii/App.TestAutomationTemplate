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

public class SEO23_SettingsUsersUserId extends WEBHelper{
	@FindBy(xpath="//h3[text()='Profile Information']")
	WebElement ProfileInformation_header;
	
	@FindBy(xpath="//h3[text()='Profile Information']/ancestor::div[@class='widget']//button[text()='Save']")
	WebElement Save_button;
	
	@FindBy(xpath="//h6[text()='Invoices']/ancestor::tr//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper')]")
	WebElement InvoiceSwitchToggle_icon;
	
	@FindBy(xpath="//button[text()='Save Permissions']")
	WebElement SavePermissions_button;
	
	public SEO23_SettingsUsersUserId() {
		PageFactory.initElements(driver, this);
	}
	
	
	@Then("Ill see the SEO23_ProfileInformation header")
	public void ill_see_profile_information_header() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Save_button));
 		Assert.assertEquals(true, ProfileInformation_header.isDisplayed());
	}

	@When("I toggle SEO23_InvoicesSwitch icon")
	public void i_toggle_invoices_switch() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Save_button));
		JS.executeScript("window.scrollTo(0,200)", InvoiceSwitchToggle_icon);
		MouseHover(InvoiceSwitchToggle_icon);
		InvoiceSwitchToggle_icon.click();
	}
	
	
	@When("I click the SEO23_SavePermissions button")
	public void i_click_save_permissions_button() throws Throwable, UnhandledAlertException {
		JS.executeScript("arguments[0].scrollIntoView();", SavePermissions_button);
		SavePermissions_button.click();
	}


}
