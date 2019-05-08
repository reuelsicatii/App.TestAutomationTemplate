package webApp.Compass;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jayway.jsonpath.JsonPath;

import cucumber.Framework.WEBHelper;
import cucumber.Framework.SetUp;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM13_Tasks extends WEBHelper{
	

	@FindBy(xpath=".//select[@id='filter-status']")
	WebElement FilterStatus_DropDown;
	
	@FindBy(xpath=".//select[@id='filter-addtl-status']")
	WebElement FilterAddtlStatus_DropDown;
	
	@FindBy(xpath=".//div[@id='tasks-table_length']//select[@class='form-control']")
	WebElement TaskList_DropDown;
	
	@FindBy(xpath=".//input[@id='mytasks_search']")
	WebElement Search_textfield;
	
	@FindBy(xpath=".//button[text()='Search']")
	WebElement Search_button;
	
	@FindBy(xpath=".//button[@id='unassigned-button']")
	WebElement ForDelegation_button;
	
	@FindBy(xpath=".//button[@id='test-review']")
	WebElement ExamForReview_button;
	
	@FindBy(xpath=".//button[@id='task-review']")
	WebElement TaskForReview_button;
	
	@FindBy(xpath=".//select[@id='organization_select']")
	WebElement OrganizationSelect_DropDown;
	
	@FindBy(xpath=".//button[@id='task-pool']")
	WebElement TaskPool_button;
	
	public static final WebElement DraggableTask_tr(String keyword){
		WebElement draggableTask_tr = driver.findElement(By.xpath("//a[contains(.,'"+keyword+"')]/ancestor::tr"));
		return draggableTask_tr;
	}
	
	@FindBy(xpath="//div[@class='org-tasks ui-droppable']")
	WebElement DroppablePool_div;
	
	public static final WebElement ExamForReviewApprove_button(String keyword){
		WebElement examForReviewApprove_button = driver.findElement(By.xpath("//strong[contains(.,'"+keyword+"')]/ancestor::tr//a[@title='Approve']"));
		return examForReviewApprove_button;
	}
	
	public static final WebElement ExamForReviewReject_button(String keyword){
		WebElement examForReviewReject_button = driver.findElement(By.xpath("//strong[contains(.,'"+keyword+"')]/ancestor::tr//a[@title='Reject']"));
		return examForReviewReject_button;
	}
	
	public static final WebElement ExamForReviewView_button(String keyword){
		WebElement examForReviewView_button = driver.findElement(By.xpath("//strong[contains(.,'"+keyword+"')]/ancestor::tr//a[@title='View']"));
		return examForReviewView_button;
	}
		
	public COM13_Tasks() {
		
		PageFactory.initElements(driver, this);
		
	}
	
		

	@When("^I click COM13_([^\"]*) button$")
	public void i_click_COM13_PeriodVariable_button(String arg1) throws Throwable, UnhandledAlertException {
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//div[@id='date_filter-btngrp']/button[text()='"+ arg1 + "']")).click();
		
		Thread.sleep(2000);
		Select S=new Select(TaskList_DropDown);
		S.selectByVisibleText("100");		
	
	}
	
	@When("^I click COM13_\"([^\"]*)\" button$")
	public void i_click_COM13_PeriodValue_button(String arg1) throws Throwable, UnhandledAlertException {
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//div[@id='date_filter-btngrp']/button[text()='"+ arg1 + "']")).click();
		
		Thread.sleep(2000);
		Select S=new Select(TaskList_DropDown);
		S.selectByVisibleText("100");		
	
	}
	
	
	@Then("^Ill see all assigned ([^\"]*) task during 1Fil of ([^\"]*)$")
	public void ill_see_all_assigned_period_task(String Period, String User) throws Throwable, UnhandledAlertException {
		
		Thread.sleep(10000);
		
		String x= SetUp.getScenarioName();
		String Filename = System.getProperty("user.dir") + "\\Data\\" +
				x.replaceAll("\\W+","") + 
				".json";
		
		String y=User.substring(0, User.length() - 15);

		
		List<WebElement> Tasklist = driver
				.findElements(By.xpath(".//table[@id='tasks-table']//a"));
		
		File jsonfile= new File(Filename);
		
	
		int i = 0;
		for (WebElement TL : Tasklist) 		{		
				
				//System.out.println("$." + y + ".Period." + Period.replace(" ","") + "[" + i + "]");
				//System.out.println(TL.getText());
				//System.out.println(JsonPath.read(jsonfile, "$." + y + ".Period." + Period.replace(" ","") + "[" + i + "]").toString());
				assertEquals(JsonPath.read(jsonfile, "$." + y + ".Period." + Period.replace(" ","") + "[" + i + "]").toString(), TL.getText());			
				i++;
		}
				
			
	}
	
	
	@When("^I select ([^\"]*) over COM13_FilterStatus dropdown$")
	public void i_select_Open_over_FilterStatus_dropdown(String arg1) throws Throwable {
		Select S=new Select(FilterStatus_DropDown);
		S.selectByVisibleText(arg1);		

	}

	@Then("^Ill see all assigned ([^\"]*) for a given ([^\"]*) during 2Fil of ([^\"]*)$")
	public void ill_see_all_assigned_Open_for_a_given_Today(String Status, String Period, String User) throws Throwable {
		
		Thread.sleep(10000);
		
		String x= SetUp.getScenarioName();
		String Filename = System.getProperty("user.dir") + "\\Data\\" +
				x.replaceAll("\\W+","") + 
				".json";
		
		String y=User.substring(0, User.length() - 15);
		
		
		List<WebElement> Tasklist = driver
				.findElements(By.xpath(".//table[@id='tasks-table']//a"));
		
		File jsonfile= new File(Filename);	
		
		int i = 0;
		for (WebElement TL : Tasklist) 
		{		
				//System.out.println("$." + y + ".Status." + Status + "[" + i + "]");
				//System.out.println(TL.getText());
				//System.out.println(JsonPath.read(jsonfile, "$." + y + ".Status." + Status + "[" + i + "]").toString());
				assertEquals(JsonPath.read(jsonfile, "$." + y + ".Status." + Status + "[" + i + "]").toString(), TL.getText());			
				i++;
		}
		
	}

	@When("^I select ([^\"]*) over COM13_FilterAddtlStatus dropdown$")
	public void i_select_Late_over_FilterAddtlStatus_dropdown(String arg1) throws Throwable {
		Select S=new Select(FilterAddtlStatus_DropDown);
		S.selectByVisibleText(arg1);
		
	}

	@Then("^Ill see all assigned ([^\"]*) for a given ([^\"]*) and ([^\"]*) during 3Fil of ([^\"]*)$")
	public void ill_see_all_assigned_Late_for_a_given_Today_Open(String Milestone, String Status, String Period, String User) throws Throwable {
		
		Thread.sleep(10000);
		
		String x= SetUp.getScenarioName();
		String Filename = System.getProperty("user.dir") + "\\Data\\" +
				x.replaceAll("\\W+","") + 
				".json";
		
		String y=User.substring(0, User.length() - 15);
		
		
		List<WebElement> Tasklist = driver
				.findElements(By.xpath(".//table[@id='tasks-table']//a"));
		
		File jsonfile= new File(Filename);	
		
		int i = 0;
		for (WebElement TL : Tasklist) 
		{				
				//System.out.println("$." + y + ".Milestone." + Milestone + "[" + i + "]");
				//System.out.println(TL.getText());
				//System.out.println(JsonPath.read(jsonfile, "$." + y + ".Milestone." + Milestone + "[" + i + "]").toString());
				assertEquals(
						JsonPath.read(jsonfile, "$." + y + ".Milestone." + Milestone + "[" + i + "]").toString()
						, TL.getText());			
				i++;
		}
		
	}

	@When("^I populate COM13_MytaskSearch with ([^\"]*)$")
	public void i_populate_COM13_MytaskSearch_with_variable(String arg1) throws Throwable {
		Search_textfield.sendKeys(arg1);
	}
	
	@When("^I populate COM13_MytaskSearch with \"([^\"]*)\"$")
	public void i_populate_COM13_MytaskSearch_with_value(String arg1) throws Throwable {
		Search_textfield.sendKeys(arg1);
		Thread.sleep(5000);
	}

	@When("^I click COM13_Search button over COM13_MyTask$")
	public void i_click_COM13_Search_button() throws Throwable {
		
		JS.executeScript("window.scrollTo(0, 0)");
		Search_button.click();
	}

	@Then("^Ill see all assigned ([^\"]*) for a given ([^\"]*), ([^\"]*) and ([^\"]*) during 4Fil of ([^\"]*)$")
	public void ill_see_all_assigned_NA_for_a_given_Today_Open_Late(String Search, String Milestone, String Status, String Period, String User) throws Throwable {
		
		Thread.sleep(10000);
		
		String x= SetUp.getScenarioName();
		String Filename = System.getProperty("user.dir") + "\\Data\\" +
				x.replaceAll("\\W+","") + 
				".json";
		
		String y=User.substring(0, User.length() - 15);
		
		
		List<WebElement> Tasklist = driver
				.findElements(By.xpath(".//table[@id='tasks-table']//a"));
		
		File jsonfile= new File(Filename);	
		
		int i = 0;
		for (WebElement TL : Tasklist) 
		{		
				//System.out.println("$." + y + ".Search." + Search + "[" + i + "]");
				//System.out.println(TL.getText());
				//System.out.println(JsonPath.read(jsonfile, "$." + y + ".Search." + Search + "[" + i + "]").toString());
				assertEquals(JsonPath.read(jsonfile, "$." + y + ".Search." + Search + "[" + i + "]").toString(), TL.getText());			
				i++;
		}
	}
	
	@When("^I click COM13_ForDelegation button over COM13_MyTask$")
	public void i_click_COM13_ForDelegation_button_over_COM13_MyTask() throws Throwable, UnhandledAlertException {
		
		Thread.sleep(5000);		
		ForDelegation_button.click();

		Thread.sleep(2000);
		Select S=new Select(TaskList_DropDown);
		S.selectByVisibleText("100");	
	}
	
	
	@When("^I click COM13_ExamForReview button over COM13_MyTask$")
	public void i_click_COM13_ExamForReview_button_over_COM13_MyTask() throws Throwable, UnhandledAlertException {
		
		Thread.sleep(5000);		
		ExamForReview_button.click();

		Thread.sleep(2000);
		Select S=new Select(TaskList_DropDown);
		S.selectByVisibleText("100");	
	}
	
	@When("^I click COM13_TaskForReview button over COM13_MyTask$")
	public void i_click_COM13_TaskForReview_button_over_COM13_MyTask() throws Throwable, UnhandledAlertException {
		
		Thread.sleep(5000);		
		TaskForReview_button.click();

		Thread.sleep(2000);
		Select S=new Select(TaskList_DropDown);
		S.selectByVisibleText("100");	
	}
	
	
	@When("^I click COM13_([^\"]*) button over COM13_ExamForReview$")
	public void i_click_COM13_Action2_button_over_COM13_MyTask(String arg0) throws Throwable, UnhandledAlertException {
		
		Thread.sleep(5000);	
		
		switch (arg0)
		{
		
			case "Approve": 
				driver.findElement(By.xpath(".//table[@id='tasks-table']/tbody/tr/td[1]/a[1]")).click();
	        break;
			
			case "Reject": 
				driver.findElement(By.xpath(".//table[@id='tasks-table']/tbody/tr/td[1]/a[2]")).click();
			break;
			
			case "View": 
				driver.findElement(By.xpath(".//table[@id='tasks-table']/tbody/tr/td[1]/a[3]")).click();
			break;
			
		}


		
	}
	
	
	@When("^I select \"([^\"]*)\" over COM13_OrganizationSelect dropdown$")
	public void i_select_Organization_over_OrganizationSelect_dropdown(String arg1) throws Throwable {
		Select S=new Select(OrganizationSelect_DropDown);
		S.selectByVisibleText(arg1);
		
	}
	
	@When("^I DragDrop task from MyTask to Organization$")
	public void i_dragdrop_taskname_from_COM13_MyTask_to_COM13_Organization() throws Throwable, UnhandledAlertException {
		
		
		Thread.sleep(5000);
		
		WebElement From = driver.findElement(By.xpath(".//table[@id='tasks-table']/tbody/tr[1]//a"));		 
		WebElement To = driver.findElement(By.xpath(".//table[@class='table']/tbody/tr[1]"));		
		
		Action dragAndDrop = action
		.clickAndHold(From)
		.moveToElement(To)
		.release(To)
        .build();		
		dragAndDrop.perform(); 		

		
	}
	
	@When("^I DragDrop task from COM13_MyTask to COM13_([^\"]*)$")
	public void i_dragdrop_taskname_from_COM13_MyTask_to_COM13_Contributor(String arg0) throws Throwable, UnhandledAlertException {
		
		
		Thread.sleep(5000);		
		
		WebElement From = driver.findElement(By.xpath(".//table[@id='tasks-table']/tbody/tr[1]//a"));		 
		WebElement To = driver.findElement(By.xpath(".//div[@id='acc-contrib']//a[contains(.,'" + arg0 + "')]"));
		
		Action dragAndDrop = action
		.clickAndHold(From)
		.moveToElement(To)
		.release(To)
        .build();		
		dragAndDrop.perform(); 		
		

		
	}
	
	@Then("^Ill see the successful popup message over Compass$")
	public void ill_see_the_successful_popup_message_over_Compass() throws Throwable {

		Thread.sleep(5000);
		
		//assertEquals(driver.findElement(By.xpath(".//div[@id='modal_div']//p")).getText(), 
				//"Successfully added to Truelogic task pool.");
		
		driver.findElement(By.xpath(".//div[@id='modal_div']//button[text()='Close']")).click();
		
	}
	
	@Then("^Ill see a popup that Ive ([^\"]*) the Task$")
	public void iIll_see_a_popup_that_Ive_Action_2_the_Task(String arg0) throws Throwable {

		Thread.sleep(5000);
		
		//TODO
		
		System.out.println("Message: " + driver.findElement(By.xpath(".//div[@id='notification_modal']//div[@class='modal-body']")));
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		
	}
	
	
	@When("^I click COM13_TaskPool button over Compass$")
	public void i_click_COM13_TaskPool_button_over_Compass() throws Throwable {	

		
		Thread.sleep(5000);	
		TaskPool_button.click();
		
	}
	
		
	
	@Then("^Ill see that the task is delegated to my team TaskPool over Compass$")
	public void ill_see_that_the_task_is_delegated_to_my_team_over_WebApp() throws Throwable {		
		
		//To be CODED
		
	}
	
	
	@Then("^Ill see that the task is delegated to ([^\"]*) MyTask over Compass$")
	public void ill_see_that_task_is_delegated_to_Contributor_MyTask_over_Compass(String arg0) throws Throwable {		
		
		//To be CODED
		
	}

	@When("^I populate COM13_MytaskSearch textfield with latest ([^\"]*)$")
	public void i_populate_COM13_MytaskSearch_with_latest_value(String campaignName) throws Throwable {
		Search_textfield.sendKeys(campaignName+" "+ dateNoSpace);
	}
	
	@When("^I DragDrop latest ([^\"]*) from COM13_MyTask to COM13_([^\"]*)$")
	public void i_dragdrop_latest_taskValue_from_COM13_MyTask_to_COM13_ContributorValue(String taskName, String contributorName) throws Throwable, UnhandledAlertException {
		
		
		Thread.sleep(5000);		
		
		WebElement From = driver.findElement(By.xpath(".//table[@id='tasks-table']/tbody/tr[2]//a"));		 
		WebElement To = driver.findElement(By.xpath(".//div[@id='acc-contrib']//a[contains(.,'" + contributorName + "')]"));
		
		Action dragAndDrop = action
		.clickAndHold(From)
		.moveToElement(To)
		.release(To)
        .build();		
		dragAndDrop.perform(); 		

		
	}
}
