package webApp.Compass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cucumber.Framework.SetUp;
import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM08_ClientsBucketSiteidUseridProjectSubproject extends WEBHelper{
	
	@FindBy(xpath=".//button[@id='subproject-add-button']")
	WebElement AddAProject_Button;
	
	@FindBy(xpath=".//*[@id='subproject_name']")
	WebElement NameTheProject_textfield;
	
	@FindBy(xpath=".//select[@name='product_id']")
	WebElement SelectAProduct_dropdown;
	
	@FindBy(xpath="//button[text()='Save Project']")
	WebElement SaveProject_button;
	
	public static final WebElement Project_link(String keyword){
		WebElement project_link = driver.findElement(By.xpath("//table[@id='subprojects-table']//td[@class=' sorting_1']/a[contains(.,'"+keyword+"')]"));
		return project_link;
	}
	
	@FindBy(xpath="(//span[@class='input-group-addon btn btn-primary'])[2]")
	WebElement StartDateGlyphicon_button;

	@FindBy(xpath="//input[@name='start_date']")
	WebElement StartDate_textfield;
	
	@FindBy(xpath="(//span[@class='input-group-addon btn btn-primary'])[3]")
	WebElement EndDateGlyphicon_button;
	
	@FindBy(xpath="//input[@name='end_date']")
	WebElement EndDate_textfield;
	
	@FindBy(xpath="//a[contains(.,'Project Management')]")
	WebElement ProjectManagement_link;
	
	
	public static final WebElement TaskName_link(String task){
		WebElement taskName_link = driver.findElement(By.xpath("//table[@id='sp-tasks-table']//a[contains(.,'"+task+"')]"));
		return taskName_link;
	}
	
	
	public static final WebElement TaskEdit_icon(String task){
		WebElement taskEdit_icon = driver.findElement(By.xpath("//a[contains(.,'"+task+"')]/ancestor::div[contains(@class,'task-item-name')]//span[@class='fa fa-pencil clickable']"));
		return taskEdit_icon;
	}
	
	@FindBy(xpath="//label[text()='Assignee']/ancestor::div[@class='form-group date-filter']//span[@class='select2-arrow']")
	WebElement Assignee_dropdown;
	
	
	@FindBy(xpath="//div[contains(@class,'select2-drop-active')]//input[@class='select2-input']")
	WebElement Assignee_textfield;
	
	public static final WebElement Assignee_list(String assignee){
		WebElement assignee_list = driver.findElement(By.xpath("//li/div[@class='select2-result-label'][contains(text(),'"+assignee+"')]"));
		return assignee_list;
	}
	
	@FindBy(xpath="//h5[contains(.,'Edit Task')]//button[@type='submit']")
	WebElement TaskSave_button;
	
	
	@FindBy(xpath="//input[@id='tasks_search']")
	WebElement TaskSearch_textfield;
	
	@FindBy(xpath="//button[@id='tasks-search-button']")
	WebElement TaskSearch_button;
	
	
	public static final WebElement TaskStatus_text(String taskName, String taskStatus){
		WebElement taskStatus_text = driver.findElement(By.xpath("//a[contains(.,'"+taskName+"')]/ancestor::div[contains(@class,'task-item-name')]//span[contains(text(),'"+taskStatus+"')]"));
		return taskStatus_text;
	}
	
	public COM08_ClientsBucketSiteidUseridProjectSubproject() {
		
		PageFactory.initElements(driver, this);
		
	}
	


	@When("^I click COM08_AddAProject button$")
	public void i_click_AddAProject_button() throws Throwable {
		AddAProject_Button.click();
	}

	@When("^I populate COM08_NameTheProject textfield with \"([^\"]*)\"$")
	public void i_populate_NameTheProject_textfield_with(String arg1) throws Throwable {
		Thread.sleep(2000);
		NameTheProject_textfield.sendKeys(arg1);
	}
	
	
	@When("^I select ([^\"]*) with ([^\"]*) over COM08_SelectAProduct dropdown$")
	public void i_select_Product_over_COM08_SelectAProduct_dropdown(String category, String product) throws Throwable {
			String finalCategory,finalProduct;
			String dateIdentifier = null;
			
			if(SetUp.getScenarioName().contains("LocalSEO")){
				dateIdentifier = readTextfile("webApp.Compass\\LocalSEO_Date.txt");	 

			}else if(SetUp.getScenarioName().contains("OrganicSEO")){
				dateIdentifier = readTextfile("webApp.Compass\\OrganicSEO_Date.txt");	 

			}else if(SetUp.getScenarioName().contains("WebDesign")){
				dateIdentifier = readTextfile("webApp.Compass\\WebDesign_Date.txt");
			}
			
			if (SetUp.getScenarioName().contentEquals("LocalSEO_TS02")) {
				finalCategory = category + "_" + dateIdentifier;
				finalProduct = product + "_" + dateIdentifier;
				Thread.sleep(2000);
			} else {
				finalCategory = category;
				finalProduct = product;
				Thread.sleep(2000);
			}
			
			Select S=new Select(SelectAProduct_dropdown);
			S.selectByVisibleText(finalCategory+" - "+finalProduct);
	}
	
	
	@When("^I click COM08_SaveProject button$")
	public void i_click_SaveProject_button() throws Throwable {
		SaveProject_button.click();
		Thread.sleep(5000);		

	}
	
	
	@Then("^I see the product associated with the project$")
	public void i_see_the_product_associated_with_the_project() throws Throwable {
		//Temporary code block until COM-178 & COM-179 is delivered
		Thread.sleep(5000);		
		
	}
	
	@Then("^Ill see the Subprojects Page$")
	public void ill_see_subprojects_page() throws Throwable {
		Thread.sleep(5000);		
		Assert.assertEquals(true, AddAProject_Button.isDisplayed());
	}
	
	@When("^I populate COM08_NameTheProject textfield with value ([^\"]*)$")
	public void i_populate_NameTheProject_textfield_with_value(String projectName) throws Throwable {
		String currentDate = GetCurrentDateWithTime();
		NameTheProject_textfield.sendKeys(projectName+" "+currentDate);
	}
	
	@When("^I select today as Start Date$")
	public void i_select_current_as_start_date() throws Throwable {
		String currentDate = GetCurrentDateWithoutTime();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('start_date')[0].setAttribute('value', '"+currentDate+"')");
	}
	
	
	@When("^I select \"([^\"]*)\" days after today as an Estimated End Date$")
	public void i_select_5_days_after_as_end_date(String number) throws Throwable {
		String targetDate = DateAddition(Integer.parseInt(number));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('end_date')[1].setAttribute('value', '"+targetDate+"')");
		Thread.sleep(10000);		

	}
	
	@Then("^Ill see the COM08_([^\"]*) in the subprojects page$")
	public void ill_see_task_value(String taskName) throws Throwable {
		Thread.sleep(5000);		
		Assert.assertEquals(true, TaskName_link(taskName).isDisplayed());
	}
	
	@Then("^Ill see the COM08_ProjectManagement tab$")
	public void ill_see_project_management_tab() throws Throwable {
		Thread.sleep(5000);		
		Assert.assertEquals(true, ProjectManagement_link.isDisplayed());
	}
	
	@When("^I select \"([^\"]*)\" Project under the COM08_Project table")
	public void i_select_project_under_the_project_table(String project) throws Throwable {
		 Project_link(project).click();
	} 
	
	@When("^I click on the COM08_TaskEdit icon of \"([^\"]*)\"")
	public void i_click_edit_icon_of_task_value(String taskName) throws Throwable {
		Thread.sleep(3000);
		MouseHover(TaskName_link(taskName));
		TaskEdit_icon(taskName).click();
	} 
	 
	@When("^I click the COM08_Assignee dropdown")
	public void i_click_assignee_dropdown() throws Throwable {
		Thread.sleep(3000);
		JS.executeScript("window.scrollBy(0,200);", Assignee_dropdown);
		Assignee_dropdown.click();
	} 
	
	@When("^I search \"([^\"]*)\" in the COM08_Assignee textfield")
	public void i_search_assignee_in_assignee_textfield(String assignee) throws Throwable {
		Thread.sleep(3000);
		Assignee_textfield.sendKeys(assignee);
	} 
	
	@When("^I select \"([^\"]*)\" under the COM08_Assignee dropdown list")
	public void i_select_assignee_under_assignee_dropdown_list(String assignee) throws Throwable {
		Thread.sleep(3000);
		Assignee_list(assignee).click();
	} 
	
	@When("^I click the COM08_Save button of Edit Task Window")
	public void i_click_save_button_of_edit_task_window() throws Throwable {
		TaskSave_button.click();
	} 
	
	@When("^I click on the COM08_\"([^\"]*)\" Task$")
	public void i_click_task(String taskName) throws Throwable {
		Thread.sleep(3000);
		TaskName_link(taskName).click();
	}
	
	
	
	@When("^I populate COM08_TaskSearch textfield with \"([^\"]*)\"$")
	public void i_populate_task_search_with_value(String taskName) throws Throwable {
		TaskSearch_textfield.sendKeys(taskName);
	}
	
	
	@When("^I click the COM08_TaskSearch button")
	public void i_click_task_search_button() throws Throwable {
		TaskSearch_button.click();
	}
	
	@Then("^Ill see that the COM08_TaskStatus of \"([^\"]*)\" is \"([^\"]*)\"")
	public void ill_see_task_value_with_status_value(String taskName, String taskStatus) throws Throwable {
		Thread.sleep(3000);
		Assert.assertEquals(true, TaskStatus_text(taskName, taskStatus).isDisplayed());
		
	}
	
}
