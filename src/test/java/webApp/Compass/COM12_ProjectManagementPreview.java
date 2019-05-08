package webApp.Compass;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM12_ProjectManagementPreview extends WEBHelper{
	

	@FindBy(xpath=".//input[@name='month_num']")
	WebElement MonthNo_textfield;
	
	@FindBy(xpath=".//button[text()='DEPLOY NOW!']")
	WebElement DeployNow_button;
	
	@FindBy(xpath=".//select[@name='scope']")
	WebElement Template_dropdown;
	

		
	public COM12_ProjectManagementPreview() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
		
	@When("^I populate COM12_MonthNo with \"([^\"]*)\"$")
	public void i_populate_MonthNo_with(String arg1) throws Throwable {
		MonthNo_textfield.sendKeys(arg1);
	}
	
	@When("^I click COM12_DeployNow button$")
	public void i_click_Deploy_button() throws Throwable, UnhandledAlertException {
		
		JS.executeScript("arguments[0].scrollIntoView();", DeployNow_button);
		WD.until(ExpectedConditions.elementToBeClickable(DeployNow_button));
		DeployNow_button.click();
		
	}
	
	
	@Then("^Ill see ([^\"]*) is deployed over COMDEV_Queue$")
	public void ill_see_Product_is_deployed_over_COMDEV_Queue(String arg1) throws Throwable, UnhandledAlertException {
	
		Thread.sleep(20000);
		assertEquals("Tasks were deployed successfully! Do you want to manage the milestone?",
				driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();	
			
	}
	
	@When("^I select \"([^\"]*)\" over COM12_Template dropdown$")
	public void i_select_template_over_COM12_Template_dropdown(String arg1) throws Throwable {
	    	
		Thread.sleep(1000);
			
		Select S=new Select(Template_dropdown);
		S.selectByIndex(0);

	}
	
	@When("^I populate COM12_From with \"([^\"]*)\"$")
	public void i_populate_COM12_From_with(String arg1) throws Throwable {
		
		log.info("I populate COM12_From with Today");

		driver.findElement(By.xpath("//input[@name='cycle_from']")).click();
		Thread.sleep(1000);
		List<WebElement> ToDates=driver.findElements(By.xpath(".//div[@class='datetimepicker-days']/table/tbody/tr/td"));
		for(WebElement EleDate:ToDates)
		{		
			if(EleDate.getAttribute("class").equalsIgnoreCase("day active"))
			{				
				EleDate.click();
				break;
			}
			
		}
		
	}
	
	@When("^I populate COM12_To with \"([^\"]*)\"$")
	public void i_populate_COM12_To_with(String arg1) throws Throwable {
		
		driver.findElement(By.xpath("//input[@name='cycle_to']")).click();
		Thread.sleep(1000);
		

		String TableTo_tdclass = "";
		String TableFrom_tdclass = "";
		List<WebElement> FromDates=driver.findElements(By.xpath(".//div[@class='datetimepicker-days']/table/tbody/tr/td"));		
		for(WebElement EleDate:FromDates)
		{		
			//System.out.println(ele.getText() + "-OUTSIDE-" + ele.getAttribute("class"));
			if(EleDate.getAttribute("class").equalsIgnoreCase("day active") ||
					TableTo_tdclass.equalsIgnoreCase("day active"))
			{	

				if (!TableTo_tdclass.equalsIgnoreCase("day active") &&
						EleDate.getAttribute("class").equalsIgnoreCase("day active"))
				{
					//System.out.println(ele.getText() + "-INSIDE ATTR-" + ele.getAttribute("class"));
					TableTo_tdclass = EleDate.getAttribute("class");
				}
				
				else if (TableTo_tdclass.equalsIgnoreCase("day active") && 
						EleDate.getAttribute("class").equalsIgnoreCase("day active"))
				{
					//System.out.println(ele.getText() + "-INSIDE TABLE-" + ele.getAttribute("class"));
					TableFrom_tdclass = EleDate.getAttribute("class");
				}
				
				else if (TableTo_tdclass.equalsIgnoreCase("day active") && 
						TableFrom_tdclass.equalsIgnoreCase("day active") &&
						EleDate.getAttribute("class").equalsIgnoreCase("day")) 
				{
					EleDate.click();
					//System.out.println(arg1);
					break;
					
				}

			}			
	  	}
		
	}
	

	
	
}
