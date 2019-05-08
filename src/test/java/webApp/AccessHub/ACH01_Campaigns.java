package webApp.AccessHub;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;


public class ACH01_Campaigns extends WEBHelper{
	
	@FindBy(xpath="//button[@data-content='Invoices']/i")
	 WebElement Invoices_icon;
	
	
	public ACH01_Campaigns () {
		PageFactory.initElements(driver, this);
	}
	
	
	@Then("^Ill see the ACH00_Invoices icon")
	public void ill_see_invoices_icon() throws Throwable {
		Assert.assertEquals(true, Invoices_icon.isDisplayed());
	}
	
	@Then("^Ill not see the ACH00_Invoices icon")
	public void ill_not_see_invoices_icon() throws Throwable {
		try{
			if(Invoices_icon.isDisplayed()){
				Assert.fail();
			}

		}catch(NoSuchElementException ex){
			Assert.assertTrue(true);
		}
	}

}
