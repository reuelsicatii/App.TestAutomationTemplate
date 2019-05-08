package webApp.Compass;

import org.junit.Assert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM18_TasksTemplateProducttemplateform extends WEBHelper{

	@FindBy(xpath="//select[@name='category']")
	WebElement ProductCategory_dropdown;
	
	@FindBy(xpath="//select[@name='entity_id']")
	WebElement ChooseAProduct_dropdown;
	
	@FindBy(xpath="//input[@name='template_name']")
	WebElement ProductTemplateName_textfield;
	
	@FindBy(xpath="(//ins)[1]")
	WebElement Setup_checkbox;	
	
	@FindBy(xpath="(//ins)[2]")
	WebElement Monthly_checkbox;	
	
	@FindBy(xpath="(//ins)[3]")
	WebElement MonthOne_checkbox;	
	
	@FindBy(xpath="(//ins)[4]")
	WebElement MonthTwo_checkbox;	
	
	@FindBy(xpath="(//ins)[5]")
	WebElement MonthThree_checkbox;	
	
	@FindBy(xpath="(//ins)[6]")
	WebElement MonthFour_checkbox;	
	
	@FindBy(xpath="(//ins)[7]")
	WebElement MonthFive_checkbox;	
	
	@FindBy(xpath="(//ins)[8]")
	WebElement MonthSix_checkbox;	
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement ProductSave_button;
	
	@FindBy(xpath="//p[text()='Product template saved successfully!']")
	WebElement ProductSuccessfullySaved_text;
	
	@FindBy(xpath="//div[@class='modal-footer']//button[@class='btn btn-primary']")
	WebElement ModalOKay_button;
	
	public COM18_TasksTemplateProducttemplateform() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
    @Then("^Ill see the Create Product Template$")
	public void i_see_create_product_template_page() throws Throwable, UnhandledAlertException {
    	Assert.assertEquals(true, ProductTemplateName_textfield.isDisplayed());
	}
    
    
    @When("^I select ([^\"]*) under the COM18_Product Category dropdown$")
   	public void i_select_product_category_value(String productCategory) throws Throwable, UnhandledAlertException {
    	Thread.sleep(3000);
       	SelectByVisibleText(ProductCategory_dropdown, productCategory+"_"+ dateNoSpace);
       	
   	}
    
    @When("^I select ([^\"]*) under the COM18_Product dropdown$")
   	public void i_select_product_value(String product) throws Throwable, UnhandledAlertException {
       	SelectByVisibleText(ProductCategory_dropdown, product+"_"+ dateNoSpace);
       	
   	}
    
    @When("^I populate COM18_Template textfield with ([^\"]*)$")
   	public void i_populate_template_name_value(String product) throws Throwable, UnhandledAlertException {
    	ProductTemplateName_textfield.clear();
       	ProductTemplateName_textfield.sendKeys(product+"_"+ dateNoSpace+" Template");
       	Thread.sleep(3000);
       	
   	}
    
    
    @When("^I click COM18_Monthly checkbox$")
   	public void i_click_monthly_checkbox() throws Throwable, UnhandledAlertException {
       	Monthly_checkbox.click();
       	
   	}
    
    
    @When("^I click COM18_MonthOne checkbox$")
   	public void i_click_monthone_checkbox() throws Throwable, UnhandledAlertException {
       	MonthOne_checkbox.click();
       	
   	}

    @When("^I click COM18_MonthTwo checkbox$")
   	public void i_click_monthtwo_checkbox() throws Throwable, UnhandledAlertException {
       	MonthTwo_checkbox.click();
       	
   	}
    
    @When("I click COM8_Save button$")
   	public void i_click_save_template_button() throws Throwable, UnhandledAlertException {
    	ProductSave_button.click();
       	
   	}
    
    
    @When("I click COM8_OK button$")
   	public void i_click_modal_ok_button() throws Throwable, UnhandledAlertException {
    	Thread.sleep(3000);
    	ModalOKay_button.click();
    	Thread.sleep(3000);
       	
   	}
		
}
