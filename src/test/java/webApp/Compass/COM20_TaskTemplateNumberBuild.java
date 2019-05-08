package webApp.Compass;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.When;

public class COM20_TaskTemplateNumberBuild extends WEBHelper{

	public static final WebElement SelectTaskTemplate(String taskTemplate){
		WebElement selectTaskTemplate_link = driver.findElement(By.xpath("//div[@id='tasklists']//a[contains(.,'"+taskTemplate+"')]"));
		return selectTaskTemplate_link;
	}
	
	@FindBy(xpath="//div[@id='task-droppable']")
	WebElement DroppableArea_div;
	
	@FindBy(xpath="//div[@class='spacer']//select[@class='form-control input-sm']")
	WebElement Monthly_dropdown;
	
	@FindBy(xpath="//div[@class='spacer']//button[@id='pt-edit-button']")
	WebElement Edit_button;
	
	public static final WebElement Task_link(String task){
		WebElement task_link = driver.findElement(By.xpath("//div[@id='tasks-tree']//*[contains(text(), '"+task+"')]"));
		return task_link;
	}
	
	
	public static final WebElement TaskCollapse_icon(String task){
		WebElement taskCollapse_icon = driver.findElement(By.xpath("//strong[contains(.,'"+task+"')]/ancestor::li//i[@class='jstree-icon jstree-ocl']"));
		return taskCollapse_icon;
	}
	
	public static final WebElement SubTask_icon(String subTask){
		WebElement subTask_icon = driver.findElement(By.xpath("//*[contains(text(), '"+subTask+"')]"));
		return subTask_icon;
	}
	
	
	public COM20_TaskTemplateNumberBuild() {
		PageFactory.initElements(driver, this);
		
	}
	
	public static final WebElement SelectFromTaskList(String task){
		WebElement selectFromTaskList = driver.findElement(By.xpath("//div[@id='tasklists']//a[contains(.,'"+task+"')]"));
		return selectFromTaskList;
	}
	
	 @When("^I DragDrop \"([^\"]*)\" from COM20_TaskTemplates section to COM20_Droppable section$")
		public void i_dragdrop_task_from_TaskTemplates_to_TemplateBuilder(String taskTemplate) throws Throwable, UnhandledAlertException {
			
		 	driver.manage().window().maximize();
			Thread.sleep(5000);
			WebElement from = driver.findElement(By.xpath("//div[@id='tasklists']//a[contains(.,'"+taskTemplate+"_"+dateNoSpace+"')]"));		 
			WebElement to = driver.findElement(By.xpath("//div[@id='task-droppable']"));
			System.out.println("CURRENT TASK   " + taskTemplate+"_"+dateNoSpace +" DISPLAY STATUS:"+ from.isDisplayed());

			Thread.sleep(3000);
			Action dragAndDrop = action
					.clickAndHold(from)
					.moveToElement(to)
					.release(to)
			        .build();		
					dragAndDrop.perform(); 		
		}
	 
	 
	 @When("^I click the COM20_Collapse icon of \"([^\"]*)\"$")
		public void i_click_collapse_icon_of_task_value(String taskName) throws Throwable, UnhandledAlertException {
			Thread.sleep(3000);
			TaskCollapse_icon(taskName.toUpperCase()).click();
	 }
	 
	 @When("^I select \"([^\"]*)\"$")
		public void i_select_subtask_value(String subTask) throws Throwable, UnhandledAlertException {
			Thread.sleep(5000);		
			SubTask_icon(subTask).click();
	 }
	 
	 
	 @When("^I click COM20_Edit button$")
		public void i_click_edit_button () throws Throwable, UnhandledAlertException {
			Edit_button.click();
			Thread.sleep(2000);		
	 }
		
}
