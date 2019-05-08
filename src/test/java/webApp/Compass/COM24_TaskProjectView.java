package webApp.Compass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import cucumber.Framework.WEBHelper;

public class COM24_TaskProjectView extends WEBHelper{

	@FindBy(xpath="//button[text()='Click to Start']")
	WebElement ClickToStart_button;

	@FindBy(xpath="//button[text()='Put On-Hold']")
	WebElement PutOnHold_button;
	
	@FindBy(xpath="//button[text()='Click to Resume']")
	WebElement ClickToResume_button;
	
	@FindBy(xpath="//button[text()='Click to Complete']")
	WebElement ClickToComplete_button;
	
	@FindBy(xpath="//button[text()='Submit for Review']")
	WebElement SubmitForReview_button;
	
	public static final WebElement TaskTab_link(String taskTab){
		WebElement taskTab_link = driver.findElement(By.xpath("//div[@id='tasktabs']//a[text()='"+taskTab+"']"));
		return taskTab_link;
	}
	
	@FindBy(xpath="//span[contains(@class,'legend-status')]")
	WebElement TaskStatus_text;
	
	
	@FindBy(xpath="(//tbody[@class='no-border-y']//a)[2]")
	WebElement Milestone_link;
	
	
	
	public COM24_TaskProjectView() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	@When("I click on the COM24_ClickToStart button")
	public void i_click_click_to_start_button(){
		ClickToStart_button.click();
	}

	@When("I click on the COM24_ClickToComplete button")
	public void i_click_click_to_complete_button() throws InterruptedException{
		Thread.sleep(3000);
		JS.executeScript("window.scrollTo(0, 0);", ClickToComplete_button);
		ClickToComplete_button.click();
	}
	
	@Then("I will be able to see that the COM24_TaskStatus text is \"([^\"]*)\"")
	public void i_will_see_status_is_value(String status) throws InterruptedException{
		Thread.sleep(3000);
		Assert.assertEquals(true, TaskStatus_text.getText().equals(status));
	}
	
	@When("I click on the COM24_SubmitForReview button")
	public void i_click_submit_for_review_button() throws InterruptedException{
		Thread.sleep(3000);
		JS.executeScript("window.scrollTo(0, 0);", SubmitForReview_button);
		SubmitForReview_button.click();
	}
	
	
	@When("I click the COM24_MileStone link")
	public void i_click_the_milestone_link(){
		Milestone_link.click();
	}
	
	@When("I click on the COM24_PutOnHold button")
	public void i_click_put_on_hold_button() throws InterruptedException{
		Thread.sleep(3000);
		JS.executeScript("window.scrollTo(0, 0);", PutOnHold_button);
		PutOnHold_button.click();
	}
 	
}

