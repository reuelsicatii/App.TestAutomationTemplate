package webApp.Compass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.jayway.jsonpath.JsonPath;

import cucumber.Framework.WEBHelper;
import cucumber.Framework.SetUp;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM10_TaskDeploymentDeploy extends WEBHelper{
	
	@FindBy(xpath=".//input[@value='Campaign']")
	 WebElement Campaign_txtfield;
	
	@FindBy(xpath=".//table[@id='deployments-table']/tbody/tr[1]//span")
	WebElement Deployment_button;
	
	@FindBy(xpath=".//input[@name='month_num']")
	WebElement MonthNo_textfield;
	
	@FindBy(xpath=".//button[text()='Deploy!']")
	WebElement Deploy_button;
	
	@FindBy(xpath=".//button[contains(.,'Yes')]")
	WebElement Yes_button;
	
	@FindBy(xpath="//legend[text()='Deployment Information']")
	WebElement DeployInformationPage_text;
	
	@FindBy(xpath="//input[@name='cycle']")
	WebElement Cycle_textfield;
	
	@FindBy(xpath="//input[@name='launch_date']")
	WebElement LaunchDate_textfield;
	
	@FindBy(xpath="//input[@name='launch_date']")
	WebElement SuccessfullyDeployed_text;
	
	@FindBy(xpath="//div[@class='modal-footer']//button[text()='OK']")
	WebElement ModalOk_buton;
	

		
	public COM10_TaskDeploymentDeploy() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
		
	@When("^I populate COM10_MonthNo with \"([^\"]*)\"$")
	public void i_populate_MonthNo_with(String arg1) throws Throwable, UnhandledAlertException {
		MonthNo_textfield.sendKeys(arg1);
	}
	
	@When("^I click COM10_Deploy button$")
	public void i_click_Deploy_button() throws Throwable, UnhandledAlertException {
		Deploy_button.click();
	}
	
	@When("^I click COM10_Yes button$")
	public void i_click_Yes_button() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Yes_button));
		Yes_button.click();
	}
	
		
	@Then("^Ill see ([^\"]*) is deployed over COMDEV_Deployment$")
	public void ill_see_Product_is_deployed_over_COMDEV_Deployment(String arg1) throws Throwable, UnhandledAlertException {
	
		Thread.sleep(10000);
		assertEquals("Awesome!!!", driver.findElement(By.xpath("//h4[@class='text-success']")).getText());
		assertEquals("Tasks we're deployed successfully!", driver.findElement(
				By.xpath("//h4[@class='text-success']/following-sibling::p")).getText());
		
		driver.findElement(By.xpath("//button[@class='btn primary']")).click();
			
	}

	
	@Then("^Ill see ([^\"]*) task correctly deployed$")
	public void ill_see_Product_task_correctly_deployed(String arg1) throws Throwable, UnhandledAlertException {
		
		
		Thread.sleep(10000);
		
		List<WebElement> Tasklist = driver
		.findElements(By.xpath(".//table[@id='sp-tasks-table']//span[@class='task-name']"));
		
		List<WebElement> Status = driver
		.findElements(By.xpath(".//table[@id='sp-tasks-table']//span[contains(@class, 'tag-status')]"));
		
		List<WebElement> Priority = driver
		.findElements(By.xpath(".//table[@id='sp-tasks-table']//span[contains(@class, 'tag-priority')]"));
		
		File jsonfile;
		jsonfile = new File(System.getProperty("user.dir") + "\\Data\\" + arg1.replaceAll("\\s+","") + ".json");		
		
		//Tasklist validation
		if (!Tasklist.isEmpty()) 
		{
			for (WebElement TL : Tasklist) 
			{		
					for (int i = 0; i < 10; i++) 
					{
						if (JsonPath.read(jsonfile, "$.Tasklist[" + i + "]").toString().contentEquals(TL.getText())) 
						{
							break;
						}
					}
			}
			
		}
		
		else 
		{
			fail("Expected set of Tasklist is not correctly deployed");
		}
		

		//Status validation
		int s = 0;
		for (WebElement S : Status) 
		{				
				assertEquals(JsonPath.read(jsonfile, "$.Status[" + s + "]").toString(), S.getText());			
				s++;
		}
		
		//Priority validation
		int p = 0;
		for (WebElement P : Priority) 
		{				
				assertEquals(JsonPath.read(jsonfile, "$.Priority[" + p + "]").toString(), P.getText());			
				p++;
		}
			
	     
	    
	}
	
	@Then("^Ill see the COM10_DeploymentInformation Section$")
	public void ill_see_deployment_information_section() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, DeployInformationPage_text.isDisplayed());
	}
	
	
	@When("^Ill see that a date is visible in the Cycle Month Calendar$")
	public void ill_see_date_visible_Cycle_Year() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Cycle_textfield.getAttribute("value").contains(GetCurrentDateMonthYear()));
	}
	
	@When("^I see that a launch date is already seleted by default$")
	public void i_see_launch_date_with_default_value() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, LaunchDate_textfield.getAttribute("value").contains(GetCurrentDateWithoutTime()));
	}
	
	@When("^Ill see the 'tasks were deployed successfully' modal$")
	public void ill_see_tasks_deployed_successfully() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(ModalOk_buton));
		Assert.assertEquals(true, SuccessfullyDeployed_text.isDisplayed());
		
	}
	
	@When("^I click COM10_ModalOk button$")
	public void i_click_ok_modal_button() throws Throwable, UnhandledAlertException {
		ModalOk_buton.click();
	}
}
