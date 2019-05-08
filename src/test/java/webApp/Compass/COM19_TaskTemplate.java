package webApp.Compass;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.When;
import test.Utilities.JsonDataGettersSetters;
import test.Utilities.JsonUtil;

public class COM19_TaskTemplate extends WEBHelper{

	@FindBy(xpath="//div[@class='tlos-content']//button[@id='tasklist-create-button']")
	WebElement TaskListCreateButton_button;

	@FindBy(xpath="//div[@class='modal-body']//input[@name='short_description']")
	WebElement TaskListShortDescription_textfield;
	
	@FindBy(xpath="//select[@name='department_id']")
	WebElement TaskListDepartment_dropdown;
	
	@FindBy(xpath="//div[@class='modal-body']//textarea[@name='instructions']")
	WebElement TaskListInstructions_textfield;
	
	@FindBy(xpath="//div[@class='modal-body']//textarea[@name='description']")
	WebElement TaskListDescription_textfield;
	
	@FindBy(xpath="//form[@id='tasklist-form']//button[text()='Save']")
	WebElement TaskListSave_button;
	
	@FindBy(xpath="//div[@id='tasklist-toolbar']//i[@class='fa fa-refresh']")
	WebElement TaskListRefresh_icon;
	
	@FindBy(xpath="//div[@id='subtask-toolbar']//button[@id='subtask-create-button']")
	WebElement SubTaskCreateButton_button;
	
	@FindBy(xpath="//div[@id='main']//input[@name='short_description']")
	WebElement MainSubtaskName_textfield;
	
	@FindBy(xpath="//div[@id='main']//select[@name='department_id']")
	WebElement MainSubtaskDepartment_dropdown;
	
	@FindBy(xpath="//div[@id='main']//input[@name='start_in']")
	WebElement MainSubtaskStartIn_textfield;
	
	@FindBy(xpath="//div[@id='main']//input[@name='duration']")
	WebElement MainSubtaskDuration_textfield;
	
	@FindBy(xpath="//div[@id='main']//input[@name='required_time']")
	WebElement MainSubtaskRequiredTime_textfield;
	
	@FindBy(xpath="//div[@id='main']//input[@name='price']")
	WebElement MainSubtaskPrice_textfield;
	
	@FindBy(xpath="//div[@id='main']//input[@name='skill']")
	WebElement MainSubtaskSkill_textfield;
	
	@FindBy(xpath="//div[@id='main']//select[@name='skill_type']")
	WebElement MainSubtaskSkillTypes_textfield;
	
	@FindBy(xpath="//div[@id='main']//select[@name='priority']")
	WebElement MainSubtaskPriority_textfield;
	
	@FindBy(xpath="//div[@id='main']//select[@name='status']")
	WebElement MainSubtaskStatus_dropwdown;
	
	@FindBy(xpath="//div[@id='main']//textarea[@name='instructions']")
	WebElement MainSubtaskInstructions_textfield;
	
	@FindBy(xpath="//input[@name='client_approval']")
	WebElement MainSubtaskClientApproval_checkbox;
	
	@FindBy(xpath="//div[@id='main']//select[@name='output_requirements[]']")
	WebElement MainSubtaskOutputReqs_select;
	
	@FindBy(xpath="//div[@id='main']//select[@name='predecessors[]']")
	WebElement MainSubtasTaskDependencies_select;

	@FindBy(xpath="//a[text()='Tabs']")
	WebElement TabSubtasTaskTabs_link;
	
	@FindBy(xpath="//a[text()='Reporting']")
	WebElement TabSubtasTaskReporting_link;
	
	@FindBy(xpath="//div[@id='reporting']//input[@name='task_name_display']")
	WebElement ReportingSubtaskTaskTaskNameDisplay_textfield;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[text()='Close']")
	WebElement CreateTaskListModalClose_button;
	
	
	public static final WebElement SelectTabSetupByIndex(int index){
		WebElement selectTabByIndex_checkbox = driver.findElement(By.xpath("(//div[@id='tabs']//li/input)["+index+"]"));
		return selectTabByIndex_checkbox;
	} 
	
	public static final WebElement SelectTabSetupByKeyword(String keyword){
		WebElement selectTabByKeyword = driver.findElement(By.xpath("//div[@id='tabs']//*[contains(text(), '"+keyword+"')]/input"));
		return selectTabByKeyword;
	}
	
	public static final WebElement SelectFromTaskList(String task){
		WebElement selectFromTaskList = driver.findElement(By.xpath("//div[@id='tasklists']//a[contains(.,'"+task+"')]"));
		return selectFromTaskList;
	}
	
	@FindBy(xpath="//div[@class='modal-footer']//button[@onclick='product_template.submit(); return false;']")
	WebElement MainSubtaskSave_button;
	
	@FindBy(xpath="//select[@name='category']")
	WebElement TaskListCategory_dropdown;
	
	public COM19_TaskTemplate() {
		PageFactory.initElements(driver, this);
		
	}
	
	@When("I create ([^\"]*) under Create Tasklist section for ([^\"]*)$")
   	public void i_create_number_task(int taskCount, String product) throws Throwable, UnhandledAlertException {
		String jsonFilePath = System.getProperty("user.dir") + "\\Data\\webApp.Compass\\"+product+"_Tasks.json";
		String jsonContent = "";
		jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		JsonDataGettersSetters jsonFile = JsonUtil.fromJson(jsonContent, JsonDataGettersSetters.class);
		
		 for (int i=0; i < taskCount; i++){
			 Thread.sleep(3000);
			 TaskListCreateButton_button.click();
			 Thread.sleep(3000);
			 TaskListShortDescription_textfield.sendKeys(jsonFile.getTaskName().get(i)+"_"+dateNoSpace);
			 Thread.sleep(2000);
			 SelectByVisibleText(TaskListDepartment_dropdown, jsonFile.getDepartment().get(i));
			 Thread.sleep(2000);
			 TaskListSave_button.click();
			 Thread.sleep(2000);
			 CreateTaskListModalClose_button.click();
		 }
   	}
	
	
	@When("I create ([^\"]*) under \"([^\"]*)\" for ([^\"]*)$")
   	public void i_create_subtask_number_for_task_value(int subTaskCount, String task, String product) throws Throwable, UnhandledAlertException {
		String jsonFilePath = System.getProperty("user.dir") + "\\Data\\webApp.Compass\\"+task+"_Subtasks.json";
		String jsonContent = "";
		jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		JsonDataGettersSetters jsonFile = JsonUtil.fromJson(jsonContent, JsonDataGettersSetters.class);
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		SelectFromTaskList(task+"_"+dateNoSpace).click();
		Thread.sleep(3000);
		
		 for (int i=0; i < subTaskCount; i++){
			 Thread.sleep(3000);
			 SubTaskCreateButton_button.click();
			 Thread.sleep(3000);
			 MainSubtaskName_textfield.clear();
			 Thread.sleep(3000);
			 MainSubtaskName_textfield.sendKeys(jsonFile.getSubtaskDescription().get(i));
			 Thread.sleep(3000);
			 SelectByVisibleText(TaskListCategory_dropdown, jsonFile.getCategory().get(i));
			 Thread.sleep(2000);
			 SelectByVisibleText(MainSubtaskDepartment_dropdown, jsonFile.getDepartment().get(i));
			 Thread.sleep(2000);
			 
			 MainSubtaskStartIn_textfield.sendKeys(jsonFile.getStartTask().get(i));
			 MainSubtaskDuration_textfield.sendKeys(jsonFile.getTaskDuration().get(i));
			 
			 Thread.sleep(3000);
			 SelectByVisibleText(MainSubtaskStatus_dropwdown, jsonFile.getSubtaskStatus().get(i));

			 
			 String clientApproval = jsonFile.getClientApproval().get(i);
			 Thread.sleep(2000);
			 if (clientApproval.equals("Yes")){
				 MainSubtaskClientApproval_checkbox.click();
			 }
			 
			 String outputRequirements = jsonFile.getOutputRequirements().get(i);
			 Thread.sleep(2000);
			 if(outputRequirements.equals("None")){
				 
			 }else{
				 SelectByVisibleText(MainSubtaskOutputReqs_select, outputRequirements);
			 }

			 String taskDependencies = jsonFile.getTaskDependencies().get(i);
			 Thread.sleep(2000);
			 if(taskDependencies.equals("None")){
				 
			 }else{
				 SelectByVisibleText(MainSubtasTaskDependencies_select, taskDependencies);
			 }
			 
			 String tabsSetup = jsonFile.getTabsSetup().get(i);
			 if(tabsSetup.equals("None")){
				 
			 }else{
				 Thread.sleep(1000);
				 TabSubtasTaskTabs_link.click();
				 Thread.sleep(2000);
				 SelectTabSetupByKeyword(tabsSetup).click();
				 Thread.sleep(2000);

			 }
			 
			 TabSubtasTaskReporting_link.click();
			 Thread.sleep(2000);
			 ReportingSubtaskTaskTaskNameDisplay_textfield.sendKeys(jsonFile.getSubtaskDescription().get(i));
			 Thread.sleep(3000);
			 MainSubtaskSave_button.click();
			 
		 }
   	}
	
	
	@When("I select \"([^\"]*)\" under COM19_TaskDependencies Section$")
   	public void i_select_task_dependency_value(String taskDependency) throws Throwable, UnhandledAlertException {
		 Thread.sleep(3000);
		 SelectByVisibleText(MainSubtasTaskDependencies_select, taskDependency);
   	}
	
	@When("I click COM19_SubtaskSave button$")
   	public void i_click_subTask_save_button() throws Throwable, UnhandledAlertException {
		 MainSubtaskSave_button.click();
		 driver.navigate().refresh();
   	}
}
