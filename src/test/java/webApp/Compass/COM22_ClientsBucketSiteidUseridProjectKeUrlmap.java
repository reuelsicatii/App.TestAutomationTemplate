package webApp.Compass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM22_ClientsBucketSiteidUseridProjectKeUrlmap extends WEBHelper{
	
	@FindBy(xpath="//button[@id='save-target-keywords-btn']")
	WebElement SaveTargetKeywowords_button;
	
	@FindBy(xpath="//div[@id='target_keywords_wrap']//div[@class='content ui-droppable']")
	WebElement TargetKeywordsDroppable_div;
	
	@FindBy(xpath="//div[@id='available_keywords_wrap']//div[@class='content ui-droppable']")
	WebElement AvailableKeywordsDroppable_div;
	
	public static final WebElement AvailableKeywordsItem_text(String keyword){
		WebElement availableKeywordsItem_text = driver.findElement(By.xpath("//div[@id='available_keywords_wrap']//div[@data-keyword-text='"+keyword.toLowerCase()+"']"));
		return availableKeywordsItem_text;
	}
	
	public static final WebElement AvailableTargetKeywords_text(String keyword){
		WebElement availableTargetKeywords_text = driver.findElement(By.xpath("//div[@class='target-item-keyword'][contains(text(),'"+keyword+"')]"));
		return availableTargetKeywords_text;
	}
	
	public COM22_ClientsBucketSiteidUseridProjectKeUrlmap() {
		PageFactory.initElements(driver, this);
	}

	@When("^I DragDrop \"([^\"]*)\" from COM22_AvailableKeywords section to COM22_TargetKeywords section")
	public void i_drag_drop_value_from_available_keywords_to_target_keywords(String keywords) throws Throwable, UnhandledAlertException {
		
		driver.manage().window().maximize();
		Thread.sleep(5000);

		Action dragAndDrop = action
				.clickAndHold(AvailableKeywordsItem_text(keywords))
				.moveToElement(TargetKeywordsDroppable_div)
				.release(TargetKeywordsDroppable_div)
		        .build();		
				dragAndDrop.perform(); 		
	}
	
	
	@When("^I click COM22_SaveTargetKeywords button")
	public void i_click_save_target_keywords_button() throws Throwable, UnhandledAlertException {
		SaveTargetKeywowords_button.click();	
	}
	
	
	@Then("^Ill see that the \"([^\"]*)\" is displayed under COM22_TargetKeywords section")
	public void ill_see_keyword_displayed_under_target_keywords_section(String keyword) throws Throwable, UnhandledAlertException {
		driver.navigate().refresh();
		Assert.assertEquals(true, AvailableTargetKeywords_text(keyword.toLowerCase()).isDisplayed());
		Thread.sleep(3000);
	}
}