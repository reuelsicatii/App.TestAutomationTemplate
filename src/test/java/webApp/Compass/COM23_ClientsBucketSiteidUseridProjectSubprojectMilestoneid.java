package webApp.Compass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;

public class COM23_ClientsBucketSiteidUseridProjectSubprojectMilestoneid extends WEBHelper{
	
	@FindBy(xpath="//input[@data-type='search']")
	WebElement Search_textfield;
	
	@FindBy(xpath="//button[@id='tasks-search-button']")
	WebElement Search_button;
	
	public static final WebElement Task_link(String taskName){
		WebElement task_link = driver.findElement(By.xpath("//a[contains(.,'"+taskName+"')]"));
		return task_link;
	}
	
	public static final WebElement TaskStatus_text(String taskName){
		WebElement taskStatus_text = driver.findElement(By.xpath("//a[contains(.,'"+taskName+"')]/ancestor::div[contains(@class,'task-item-name')]//span[contains(@class,'tag-status')]"));
		return taskStatus_text;
	}
	
	public static final WebElement EditTask_Icon(String taskName){
		WebElement editTask_Icon = driver.findElement(By.xpath("//a[contains(.,'"+taskName+"')]/ancestor::div[contains(@class,'task-item-name')]//span[@title='Edit']"));
		return editTask_Icon;
	}
	
	public static final WebElement DeleteTask_Icon(String taskName){
		WebElement deleteTask_Icon = driver.findElement(By.xpath("//a[contains(.,'"+taskName+"')]/ancestor::div[contains(@class,'task-item-name')]//span[@title='Delete']"));
		return deleteTask_Icon;
	}
	 
	@FindBy(xpath="//div[@class='editor-container']//h5")
	WebElement EditTaskTitle_header;
	
	@FindBy(xpath="//div[@class='editor-container']//button[@type='submit']")
	WebElement EditTaskSave_button;
	
	@FindBy(xpath="//div[@class='editor-container']//button[@id='sptasks-close_form-button']")
	WebElement EditTaskClose_button;
	
	@FindBy(xpath="//small[text()='SETTINGS']")
	WebElement EditTaskSettingsTab_link;
	
	@FindBy(xpath="//small[text()='LOGS']")
	WebElement EditTaskLogsTab_link;
	
	@FindBy(xpath="//small[text()='CHANGE LOG']")
	WebElement EditTaskChangeLogTab_link;
	
	@FindBy(xpath="//select[@name='status']")
	WebElement EditTaskStatus_dropdown;
	
	@FindBy(xpath="//select[@name='dept_id']")
	WebElement EditTaskDepartment_dropdown;
	
	@FindBy(xpath="//select[@name='priority']")
	WebElement EditTaskPriority_dropdown;
	
	@FindBy(xpath="//div[@id='s2id_autogen48']")
	WebElement EditTaskAssignee_dropdown;
	
	public COM23_ClientsBucketSiteidUseridProjectSubprojectMilestoneid() {
		
		PageFactory.initElements(driver, this);
		
	}
	

}
