package webApp.Compass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM26_TaskProjectViewTabroadmap extends WEBHelper{

	@FindBy(xpath="//a[@class='cke_button cke_button__save_article  cke_button_off']")
	WebElement SaveArticle_button;
	
	@FindBy(xpath="//a[text()='Roadmap']")
	WebElement Roadmap_link;
	
	@FindBy(xpath="//a[text()='Campaign Roadmap']")
	WebElement CampaignRoadmap_link;
	
	public static final WebElement Gear_icon(String submissionTask){
		WebElement gear_icon = driver.findElement(By.xpath("//h3[text()='"+submissionTask+"']/ancestor::div[@class='tlos-title clearfix']//i[@class='fa fa-cog']"));
		return gear_icon;
	}
	
	public static final WebElement Close_button(String submissionTask){
		WebElement close_button = driver.findElement(By.xpath("//h3[text()='"+submissionTask+"']/ancestor::div[@id='dropzone-container']//button[text()='Close']"));
		return close_button;
	}
	
	@FindBy(xpath="(//div[contains(@class,'select2-drop-active')]//input[@class='select2-input'])[2]")
	WebElement AnchorType_textfield;
	
	public static final WebElement AnchorType_dropdown(String submissionTask){
		String finalString = submissionTask.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		WebElement anchorType_dropdown = driver.findElement(By.xpath("//div[contains(@id,'"+finalString+"')]//span[text()='Select Anchor Type']//ancestor::div[@class='form-group']//select"));
		return anchorType_dropdown;
	}
	
	@FindBy(xpath="//li/div[@class='select2-result-label']")
	WebElement AnchorTypeResult_list;
	
	
	public static final WebElement Keyword_dropdown(String submissionTask){
		String finalString = submissionTask.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		WebElement keyword_dropdown = driver.findElement(By.xpath("//div[contains(@id,'"+finalString+"')]//span[text()='Select Keyword']//ancestor::div[@class='form-group']//select"));
		return keyword_dropdown;
	}
	
	@FindBy(xpath="(//div[contains(@class,'select2-drop-active')]//input[@class='select2-input'])[2]")
	WebElement Keyword_textfield;
	
	@FindBy(xpath="(//div[contains(@class,'select2-drop-active')]//input[@class='select2-input'])[2]")
	WebElement KeywordArrowDown_dropdown;
	
	public static final WebElement KeywordArrowDown_dropdown(String submissionTask){
		String finalString = submissionTask.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
		WebElement keywordArrowDown_dropdown = driver.findElement(By.xpath("//div[contains(@id,'"+finalString+"')]//span[text()='Select Keyword']/../span[@class='select2-arrow']"));
		return keywordArrowDown_dropdown;
	}
	
	
	
	
	public static final WebElement KeywordResult_list(String keyword){
		WebElement keywordResult_list = driver.findElement(By.xpath("//li/div[@class='select2-result-label'][contains(text(),'"+keyword.toLowerCase()+"')]"));
		return keywordResult_list;
	}
	

	@FindBy(xpath="//button[text()='Save Roadmap']")
	WebElement SaveRoadmap_button;
	
	@FindBy(xpath="//textarea[@placeholder='Enter a note...']")
	WebElement Notes_textarea;
	
	@FindBy(xpath="//input[@value='SUBMIT']")
	WebElement Submit_button;
	
	public COM26_TaskProjectViewTabroadmap() {
		PageFactory.initElements(driver, this);
		
	}
	
	@Then("I will be able to see the COM26_Roadmap Tab")
	public void ill_see_roadmap_tab(){
		Assert.assertEquals(true, Roadmap_link.isDisplayed());
	}
	
	@Then("I will be able to see the COM26_Campaign Roadmap Tab")
	public void ill_see_campaign_roadmap_tab(){
		Assert.assertEquals(true, CampaignRoadmap_link.isDisplayed());
	}
	
	@When("I click the COM26_Campaign Roadmap Tab")
	public void i_click_campaign_roadmap_tab(){
		CampaignRoadmap_link.click();
	}
	
	@When("I click on the COM26_Gear icon of \"([^\"]*)\"$")
	public void i_click_gear_icon_of_submission_value(String submissionTask) throws InterruptedException{
		Thread.sleep(3000);
		Gear_icon(submissionTask).click();
	}
	
	
	@When("I click the COM26_AnchorType dropdown of \"([^\"]*)\"$")
	public void i_click_the_anchor_dropdown_of_submission_value(String submissionTask) throws InterruptedException{
		Thread.sleep(2000);
		AnchorType_dropdown(submissionTask).click();
	}
	
	
	@When("I search \"([^\"]*)\" under the COM26_AnchorType dropwdown$")
	public void i_search_anchor_type_of_submission_value(String anchorType){
		AnchorType_textfield.sendKeys(anchorType);
	}
	
	
	@When("I select \"([^\"]*)\" under the COM26_AnchorType dropwdown of \"([^\"]*)\"")
	public void i_select_returned_anchor(String anchor, String submissionTask) throws InterruptedException{
		Thread.sleep(2000);
		SelectByVisibleText(AnchorType_dropdown(submissionTask), anchor);

	}
	
	@When("I click the COM26_Keyword dropdown of \"([^\"]*)\"$")
	public void i_click_the_keyword_dropdown_of_submission_value(String submissionTask) throws InterruptedException{
		Thread.sleep(2000);
		KeywordArrowDown_dropdown(submissionTask).click();
	}
	
	
	@When("I search \"([^\"]*)\" under the COM26_Keyword dropwdown$")
	public void i_search_keyword_of_submission_value(String keyword){
		Keyword_textfield.sendKeys(keyword);
	}
	
	@When("I select \"([^\"]*)\" under the COM26_Keyword dropwdown")
	public void i_select_returned_keyword(String keyword) throws InterruptedException{
		Thread.sleep(2000);
		KeywordResult_list(keyword).click();
	}
	
	
	@When("I click on the COM26_close button of \"([^\"]*)\"$")
	public void i_click_close_button_of_submission_value(String submissionTask){
		Close_button(submissionTask).click();
	}
	
	@When("I click on the COM26_SaveRoadmap button")
	public void i_click_save_roadmap_button(){
		JS.executeScript("window.scrollTo(0, 0);", SaveRoadmap_button);
		SaveRoadmap_button.click();
	}
	
	@When("I enter \"([^\"]*)\" under the COM26_Note textfield")
	public void i_enter_value_in_notes_textfield(String notes){
		Notes_textarea.sendKeys(notes);
	}
	
	@When("I click COM26_Submit button")
	public void i_click_submit_button(){
		Submit_button.click();
	}
}
