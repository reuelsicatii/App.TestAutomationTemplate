package webApp.PayPerContent;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.jayway.jsonpath.JsonPath;

import cucumber.Framework.WEBHelper;
import cucumber.Framework.SetUp;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PPC03_Task extends WEBHelper{
	
	@FindBy(xpath=".//*[@id='identity']")
	 WebElement Username_txtfield;
	
	@FindBy(xpath=".//*[@id='password']")
	WebElement Password_txtfield;
	
	@FindBy(xpath=".//input[contains(@value, 'Log In')]")
	WebElement Login_button;
	

		
	public PPC03_Task() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@Then("^Ill see that the task is delegated to ([^\"]*) MyTask over Paypercontent$")
	public void ill_see_that_the_task_is_delegated_to_my_team_over_Taskpool_WebApp(String arg0) throws Throwable {		
		
/*		List<WebElement> Tasklist = driver
		.findElements(By.xpath(".//table[@id='tbl_clients_dta']/tbody/tr/td[2]/div[1]"));
		
		for (WebElement TL : Tasklist) {
			
			System.out.println(TL.getText());
			System.out.println("Replaced: " + TL.getText().replace("Short Description: ", ""));
			
		}
		
		String x= SetUp.getScenarioName();
		String Filename = System.getProperty("user.dir") + "\\Data\\" +
				x.replaceAll("\\W+","") + 
				".json";
		
		File jsonfile= new File(Filename);	
		
		
		int i = 0;
		for (WebElement TL : Tasklist) 
		{				
				assertEquals(TL.getText(), JsonPath.read(jsonfile, "$.Tasklist[" + i + "]").toString());			
				i++;
		}*/
		
	}
	
	
	@Then("^Ill see that only ([^\"]*) are listed on MyTask over Paypercontent$")
	public void Ill_see_that_only_Task_Level_are_listed_on_MyTask_over_Paypercontent(String arg0) throws Throwable {		
		
		//To be CODED
		
	}
	
	


}
