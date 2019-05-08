package webApp.Compass;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM21_ClientsBucketSiteidUseridProjectKeywords extends WEBHelper{
	
	@FindBy(xpath="//input[@id='keyword_search']")
	WebElement Search_textfield;
	
	@FindBy(xpath="//span[text()='Search']")
	WebElement Search_button;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement Add_button;
	
	@FindBy(xpath="//button[text()='Remove']")
	WebElement Remove_button;
	
	@FindBy(xpath="//textarea[@id='keywords']")
	WebElement Keywords_textarea;
	
	@FindBy(xpath="//select[@name='search_engine_id[]']")
	WebElement SearchEngines_selection;
	
	@FindBy(xpath="//select[@id='cmbKeywordDefaultTagging']")
	WebElement DefaultTagging_dropdown;
	
	@FindBy(xpath="//select[@id='cmbKeywordDefaultTagging']")
	WebElement GeoTarget_dropdown;
	
	@FindBy(xpath="//form[@id='form-add-keywords']//button[@type='submit']")
	WebElement AddKeywordsSave_button;
	
	@FindBy(xpath="//form[@id='form-add-keywords']//button[text()='Cancel']")
	WebElement AddKeywordsCancel_button;
	
	@FindBy(xpath="//div[@class='text-center']/i")
	WebElement Bookmark_icon;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement ModalOK_button;
	
	@FindBy(xpath="//p[text()='Keywords were added to the campaign.']")
	WebElement ModalMessage_text;
	
	
	public COM21_ClientsBucketSiteidUseridProjectKeywords() {
		PageFactory.initElements(driver, this);
	}
	
	
	@When("I click the COM21_AddKeyword button")
	public void i_click_add_keyword_button(){
		Add_button.click();
		
	}
	
	@When("I enter \"([^\"]*)\" in the COM21_Keywords textarea")
	public void i_enter_value_in_keywords_text_area(String keyword){
		Keywords_textarea.sendKeys(keyword);
	}
	
	@When("I select \"([^\"]*)\" in the COM21_DefaultTagging dropdown")
	public void i_select_value_in_the_default_tagging_dropwdown(String tagging){
		SelectByVisibleText(DefaultTagging_dropdown, tagging);
	}
	
	@When("I click the COM21_Save button")
	public void i_click_save_button(){
		AddKeywordsSave_button.click();
	}
	
	@Then("Ill see the COM21_SuccessKeywordModal")
	public void ill_see_success_keyword_modal(){
		WD.until(ExpectedConditions.elementToBeClickable(ModalOK_button));
		Assert.assertEquals(true, ModalMessage_text.isDisplayed());
	}
	
	@When("I click COM21_KeywordOkModal")
	public void i_click_ok_of_success_keyword_modal(){
		ModalOK_button.click();
	}

}