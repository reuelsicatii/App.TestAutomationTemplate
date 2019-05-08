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

public class SEO03_Store extends WEBHelper{
	
	@FindBy(xpath=".//select[@class='form-control select2-me select2-offscreen']")
	WebElement SelectCampaign_dropbox;
	
	@FindBy(xpath=".//button[text()='Proceed to Checkout']")
	WebElement ProceedToCheckout_button;
	

	


		
	public SEO03_Store() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@When("^I click ([^\"]*) link in SEO Store$")
	public void i_click_Category_link(String arg1) throws Throwable, UnhandledAlertException {
		
		WebElement Category = driver.findElement(By.xpath(".//div[@class='store-category-wrapper boxfix']//a[text()='" + arg1 + "']"));
		WD.until(ExpectedConditions.elementToBeClickable(Category));
		Category.click();		
		
	}
	
	
	@When("^I click ([^\"]*) button in SEO Store$")
	public void i_click_Product_button(String arg1) throws Throwable, UnhandledAlertException {
		
		//Thread.sleep(3000);
		//System.out.println(arg1);
		switch (arg1)
		{
		
			case "Basic Web Design": 
				//System.out.println("i_click_Product_button" + arg1);
				//WD.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='website_development']/div[2]/div[2]/div[1]/div/div[3]/div/div[1]/button[1]")));
				driver.findElement(By.xpath(".//*[@id='website_development']/div[2]/div[2]/div[1]/div/div[3]/div/div[1]/button[1]")).click();	 
	        break;
			
			case "Advanced SEO Site Consultation": 
				//System.out.println("i_click_Product_button" + arg1);
				//WD.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='seo_services']/div[2]/div/div/div/div[3]/div/div[1]/button[1]")));
				driver.findElement(By.xpath(".//*[@id='seo_services']/div[2]/div/div/div/div[3]/div/div[1]/button[1]")).click();
			break;			
		
		}		
		
	}
	
	@When("^I select Selenium over SEO03_SelectCampaign dropdown for ([^\"]*)$")
	public void i_select_over_SEO03_SelectCampaign_dropdown(String arg1) throws Throwable, UnhandledAlertException {
		
		
		//Thread.sleep(3000);
		switch (arg1)
		{
		
			case "Basic Web Design": 
				//System.out.println("i_select_over_SEO03_SelectCampaign_dropdown" + arg1);
				Select BWD=new Select(
				driver.findElement(By.xpath(".//*[@id='website_development']/div[2]/div[2]/div[1]/div/div[3]/div/div[2]/div[1]/div/select")));
				BWD.selectByVisibleText("Selenium");
	        break;
			
			case "Advanced SEO Site Consultation": 
				//System.out.println("i_select_over_SEO03_SelectCampaign_dropdown" + arg1);
				Select ASSC=new Select(
				driver.findElement(By.xpath(".//*[@id='seo_services']/div[2]/div/div/div/div[3]/div/div[2]/div[1]/div/select")));
				ASSC.selectByVisibleText("Selenium");
			break;			
		
		}	
	
		    
	}
	
	@When("^I click SEO03_Continue button for ([^\"]*)$")
	public void i_click_SEO03_Continue_button(String arg1) throws Throwable, UnhandledAlertException {
		
		//Thread.sleep(3000);
		switch (arg1)
		{
		
			case "Basic Web Design": 
				driver.findElement(By.xpath(".//*[@id='website_development']/div[2]/div[2]/div[1]/div/div[3]/div/div[2]/div[3]/button")).click();
	        break;
			
			case "Advanced SEO Site Consultation": 
				driver.findElement(By.xpath(".//*[@id='seo_services']/div[2]/div/div/div/div[3]/div/div[2]/div[3]/button")).click();
			break;			
		
		}
			
		
	}
	
	
	@When("^I click SEO03_ProceedToCheckout button$")
	public void i_click_SEO03_ProceedToCheckout_button() throws Throwable, UnhandledAlertException {
		
		WD.until(ExpectedConditions.elementToBeClickable(ProceedToCheckout_button));
		ProceedToCheckout_button.click();	
		
	}
	
	
	

	
	


}
