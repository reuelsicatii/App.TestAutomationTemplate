package webApp.Seoreseller;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SEO04_StoreCheckout extends WEBHelper{
	
	@FindBy(xpath=".//input[@name='street']")
	WebElement Street_tetxtfield;
	
	@FindBy(xpath=".//input[@name='city']")
	WebElement City_tetxtfield;

	@FindBy(xpath=".//select[@name='country']")
	WebElement Country_dropbox;
	


		
	public SEO04_StoreCheckout() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@When("^I click SEO04_OthersPaymentMethod radiobutton$")
	public void i_click_SEO04_OthersPaymentMethod_radiobutton() throws Throwable, UnhandledAlertException {
		
		driver.findElement(By.xpath(".//table[@class='table table-hover']/tbody/tr[3]/td[1]/div/ins")).click();	
		
	}
	
	
	@When("^I populate SEO04_Street textfield with \"([^\"]*)\"$")
	public void i_populate_SEO04_Street_tetxtfield_with(String arg1) throws Throwable, UnhandledAlertException {
		
		Street_tetxtfield.sendKeys(arg1);	
		
	}
	
	@When("^I populate SEO04_City textfield with \"([^\"]*)\"$")
	public void i_populate_SEO04_City_tetxtfield_with(String arg1) throws Throwable, UnhandledAlertException {
		
		City_tetxtfield.sendKeys(arg1);	
		
	}
	
	@When("^I select \"([^\"]*)\" over SEO04_Country dropdown$")
	public void i_select_over_Category_dropdown(String arg1) throws Throwable, UnhandledAlertException {
	
		Select S=new Select(Country_dropbox);
		S.selectByVisibleText(arg1);
	    
	}
	
	@When("^I click SEO04_MakePayment button$")
	public void i_click_SEO04_MakePayment_button() throws Throwable, UnhandledAlertException {
		
		WD.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[@id='checkout-button']")));
		driver.findElement(By.xpath(".//button[@id='checkout-button']")).click();	
		
	}
	
	
	

	
	


}
