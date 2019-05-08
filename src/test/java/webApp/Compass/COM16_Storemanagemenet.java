package webApp.Compass;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.SetUp;
import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.Utilities.JsonDataGettersSetters;
import test.Utilities.JsonUtil;

public class COM16_Storemanagemenet extends WEBHelper{
	

	@FindBy(xpath="//button[@id='add_category_button']")
	WebElement AddCategory_button;
	
	@FindBy(xpath="//input[@name='cat_name']")
	WebElement BasicDetailsCategoryName_textfield;
	
	@FindBy(xpath="//textarea[@name='cat_desc']")
	WebElement BasicDetailsDescription_textarea;
	
	@FindBy(xpath="//div[@id='basic_details']//button[text()='Next']")
	WebElement BasicDetailsNext_button;
	
	@FindBy(xpath="(//div[@id='category_types']//div[contains(@class, 'icheckbox')])[1]")
	WebElement CategoryTypeIsActive_checkbox;	
	
	@FindBy(xpath="//div[@id='category_types']//button[text()='Next']")
	WebElement CategoryTypeNext_button;	
	
	@FindBy(xpath="//button[text()='Save and Submit']")
	WebElement ClientBriefSaveSubmit_button;
	
	public static final WebElement CategoryItem_span (String categoryName){
		WebElement categoryItem_span = driver.findElement(By.xpath("//table[@id='category-table']//span[contains(.,'"+categoryName+"')]"));
		return categoryItem_span;
	}
	
	public static final WebElement ProductSerialItem_span (String productSerial){
		WebElement productSerialItem_span = driver.findElement(By.xpath("//table[@id='products-table']//td[contains(.,'"+productSerial+"')][1]"));
		return productSerialItem_span;
	}
	
	@FindBy(xpath="//button[text()='Add New Product']")
	WebElement AddNewProduct_button;
	
	@FindBy(xpath="//input[@name='prod_code']")
	WebElement ProductCode_textfield;
	
	@FindBy(xpath="//input[@name='prod_name']")
	WebElement ProductName_textfield;
	
	@FindBy(xpath="//textarea[@name='prod_desc']")
	WebElement ProductDescription_textarea;
	
	@FindBy(xpath="(//div[@id='basic_details']//ins)[1]")
	WebElement AddNewProductFeaturedProd_checkbox;	
	
	@FindBy(xpath="(//div[@id='basic_details']//ins)[2]")
	WebElement AddNewProductIsActive_checkbox;
	
	@FindBy(xpath="(//div[@id='basic_details']//ins)[3]")
	WebElement AddNewProductIsProposable_checkbox;	
	
	@FindBy(xpath="(//div[@id='basic_details']//ins)[4]")
	WebElement AddNewProductViewable_checkbox;	
	
	@FindBy(xpath="(//div[@id='basic_details']//ins)[5]")
	WebElement AddNewProductDisableCart_checkbox;	
	
	@FindBy(xpath="//div[@id='basic_details']//button[text()='Next']")
	WebElement AddNewProdBasicDetailsNext_button;
	
	@FindBy(xpath="//div[@id='product_setup']//ins")
	WebElement AddNewProductIsOneOff_checkbox;	
	
	@FindBy(xpath="//select[@name='prod_currency']")
	WebElement AddNewProductCurrency_dropdown;
	
	@FindBy(xpath="//input[@name='prod_monthly_fee']")
	WebElement AddNewProductMonthlyFee_textfield;
	
	@FindBy(xpath="//input[@name='prod_setup_fee']")
	WebElement AddNewProductSetupFee_textfield;
	
	@FindBy(xpath="//div[@id='product_setup']//button[text()='Next']")
	WebElement AddNewProdPriceSettingsNext_button;
	
	@FindBy(xpath="//li/a[text()='Key Features']")
	WebElement KeyFeaturesTab_link;
	
	@FindBy(xpath="//div[@id='product_attr']//li/a)")
	List<WebElement> ProductAttributesTab_link;
	
	@FindBy(xpath="//li[@id='btnNewTab']")
	WebElement ProductAttributesNewTab_link;
	
	@FindBy(xpath="//div[@class='tab-content']//input[@class='form-control tab_name']")
	List<WebElement> TabName_textfield;
	
	@FindBy(xpath="//div[@class='tab-content']//button[@title='Code View']")
	List<WebElement> CodeView_button;
	
	@FindBy(xpath="//div[@class='tab-content']//textarea[@class='note-codable']")
	List<WebElement> TabContent_textarea;
	
	@FindBy(xpath="//div[@class='note-editable']")
	List<WebElement> TabCodeEditor_textarea;
	
	@FindBy(xpath="//a[text()='Thumbnail']")
	WebElement AddNewProdThumbnailTab_link;
	
	@FindBy(xpath="//div[@id='product_thumbnail']//button[text()='Save and Submit']")
	WebElement ThumbnailSaveAndSubmit_button;
	
	@FindBy(xpath="//h3[text()='Category Browser']")
	WebElement CategoryBrowser_header;
	
	@FindBy(xpath="//a[text()='Client Brief']")
	WebElement ClientBriefTab_link;
	
	public COM16_Storemanagemenet() {
		PageFactory.initElements(driver, this);
	}
	
	@Then("^Ill see the COM16_CategoryBrowser header$")
	public void ill_see_the_category_browser_header() throws Throwable, UnhandledAlertException {

		Assert.assertEquals(true, CategoryBrowser_header.isDisplayed());

	}
	 
	@When("^I click COM16_AddCategory button$")
	public void i_click_add_category_button() throws Throwable, UnhandledAlertException {
		AddCategory_button.click();
	}
	
	@When("I populate COM16_CategoryName textfield with ([^\"]*)$")
	public void i_populate_category_name_with_value(String categoryName) throws Throwable, UnhandledAlertException {
		BasicDetailsCategoryName_textfield.sendKeys(categoryName+"_"+ dateNoSpace);
	}
	
    @When("I populate COM16_Description with ([^\"]*)$")
	public void i_populate_description_with_value(String categoryName) throws Throwable, UnhandledAlertException {
    	String content = ReadContentFromTextFile("webApp.Compass\\"+categoryName+"_Description.txt");
    	
    	Thread.sleep(2000);
    	BasicDetailsDescription_textarea.sendKeys(content);

	}
    
    @When("I click COM16_Next button of Basic Details tab under Add New Category$")
	public void i_click_next_button_of_basic_details() throws Throwable, UnhandledAlertException {
    	BasicDetailsNext_button.click();
	}
    
    @When("I validate if COM16_IsActive selected$")
	public void i_validate_is_active_selected() throws Throwable, UnhandledAlertException {
    	if(CategoryTypeIsActive_checkbox.getAttribute("class").contains("checked")){
    	}else{
    		CategoryTypeIsActive_checkbox.click();
    	}

	}
    
    @When("I click COM16_Next button of Category Types tab under Add New Category$")
	public void i_click_next_button_of_category_type() throws Throwable, UnhandledAlertException {
    	CategoryTypeNext_button.click();
	}
    
    @When("I click the COM16_SaveAndSubmit button under Add New Category$")
   	public void i_click_save_submit_under_add_new_category() throws Throwable, UnhandledAlertException {
       	ClientBriefSaveSubmit_button.click();
   	}
    
    @When("I click  COM16_([^\"]*) under the Category Name list$")
   	public void i_click_category_under_category_list(String categoryName) throws Throwable, UnhandledAlertException {
    	Thread.sleep(5000);
       	WindowScrollAndClick(CategoryItem_span(categoryName+"_"+ dateNoSpace));
    	String scenario = SetUp.getScenarioName();
		
		if(scenario.contains("LocalSEO")){
	       	clearWriteTextfile("webApp.Compass\\LocalSEO_Date.txt", dateNoSpace);

		}else if(scenario.contains("OrganicSEO")){
	       	clearWriteTextfile("webApp.Compass\\OrganicSEO_Date.txt", dateNoSpace);

		}else if(scenario.contains("WebDesign")){
	       	clearWriteTextfile("webApp.Compass\\WebDesign_Date.txt", dateNoSpace);
		}
   	}
   
    @When("I click COM16_AddNewProduct button$")
   	public void i_click_add_new_product_button() throws Throwable, UnhandledAlertException {
       	AddNewProduct_button.click();
   	}
    
    @When("I populate COM16_ProductCode textfield with ([^\"]*)$")
   	public void i_populate_product_code_textfield_with_value(String product) throws Throwable, UnhandledAlertException {
       	ProductCode_textfield.sendKeys(product+"_"+ dateNoSpace);
   	}
    
    @When("I populate COM16_ProductName textfield with ([^\"]*)$")
   	public void i_populate_product_name_textfield_with_value(String product) throws Throwable, UnhandledAlertException {
       	ProductName_textfield.sendKeys(product+"_"+ dateNoSpace);
       	String scenario = SetUp.getScenarioName();
		
		if(scenario.contains("LocalSEO")){
	       	clearWriteTextfile("webApp.Compass\\LocalSEO_Date.txt", dateNoSpace);

		}else if(scenario.contains("OrganicSEO")){
	       	clearWriteTextfile("webApp.Compass\\OrganicSEO_Date.txt", dateNoSpace);

		}else if(scenario.contains("WebDesign")){
	       	clearWriteTextfile("webApp.Compass\\WebDesign_Date.txt", dateNoSpace);
		}
       	
       	
   	}
    
    @When("I populate COM16_Description of Add New Product Modal with ([^\"]*)$")
   	public void i_populate_description_of_add_new_product_value(String categoryName) throws Throwable, UnhandledAlertException {
        String content = ReadContentFromTextFile("webApp.Compass\\"+categoryName+"_Description.txt");
        ProductDescription_textarea.sendKeys(content);
   	}
    
    @When("I click COM16_Next button of Basic Details under Add New Product Modal$")
   	public void i_click_basic_details_next_under_add_new_product() throws Throwable, UnhandledAlertException {
    	WindowScrollAndClick(AddNewProdBasicDetailsNext_button);
   	}
    
	@When("I click COM16_IsActive button of Add New Product Modal$")
   	public void i_click_is_active_under_add_new_product() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
    	AddNewProductIsActive_checkbox.click();
   	}
	
	@When("I click COM16_IsProposable button of Add New Product Modal$")
   	public void i_click_is_proposable_under_add_new_product() throws Throwable, UnhandledAlertException {
    	AddNewProductIsProposable_checkbox.click();
   	}
	
	@When("I click COM16_Viewable button of Add New Product Modal$")
   	public void i_click_viewable_under_add_new_product() throws Throwable, UnhandledAlertException {
    	AddNewProductViewable_checkbox.click();
   	}

	@When("I select ([^\"]*) in the COM16_Currency dropdown of Add New Product Modal$")
   	public void i_select_value_under_currenncy_dropdown_add_product_modal(String currency) throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		SelectByVisibleText(AddNewProductCurrency_dropdown, currency);

   	}

	@When("I populate COM16_MonthlyFee textfield with ([^\"]*) of Add New Product Modal$")
   	public void i_populate_monthly_fee_of_add_product_modal_with_value(String monthlyFee) throws Throwable, UnhandledAlertException {
		AddNewProductMonthlyFee_textfield.sendKeys(monthlyFee);
    	
   	}
	
	@When("I click COM16_Next button of Price Settings under Add New Product Modal$")
   	public void i_click_price_settings_next_under_add_new_product() throws Throwable, UnhandledAlertException {
		AddNewProdPriceSettingsNext_button.click();
    	
   	}
	
	@When("I populate COM16_KeyFeature textarea with ([^\"]*)$")
   	public void i_populate_key_features_with_value(String product) throws Throwable, UnhandledAlertException {
        String content = ReadContentFromTextFile("webApp.Compass\\"+product+"_Key Features.txt");
        JS.executeScript("arguments[0].innerHTML = " + content, TabCodeEditor_textarea.get(0));;

   	}
	
	@When("I add an additional ([^\"]*) for ([^\"]*)$")
   	public void i_add_addtional_tab_value_for_value(int count, String product) throws Throwable, UnhandledAlertException {
		String jsonFilePath = System.getProperty("user.dir") + "\\Data\\webApp.Compass\\"+product+"_Product Attributes.json";
		String jsonContent = "";
		jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		JsonDataGettersSetters jsonFile = JsonUtil.fromJson(jsonContent, JsonDataGettersSetters.class);
		
		
		for(int i=0; i < count; i++){
			int a = i + 1;
			ProductAttributesNewTab_link.click();
			Thread.sleep(3000);
			TabName_textfield.get(a).clear();
			TabName_textfield.get(a).sendKeys(jsonFile.getTabName().get(i));
			
			String textFilePath = "webApp.Compass\\"+product+jsonFile.getFileName().get(i);
	        String textFileContent = ReadContentFromTextFile(textFilePath);	        
	        JS.executeScript("arguments[0].innerHTML = " + textFileContent, TabCodeEditor_textarea.get(a));;
		}
   	}
	 
	@When("I click COM16_ThumbnailTab link of Add New Product Modal$$")
   	public void i_click_thumbailtab_under_add_new_product() throws Throwable, UnhandledAlertException {
		AddNewProdThumbnailTab_link.click();
   	}
	
	@When("I click COM16_SaveAndSubmit button of Add New Product Modal$")
   	public void i_click_save_submit_under_add_new_product() throws Throwable, UnhandledAlertException {
		ThumbnailSaveAndSubmit_button.click();
   	}
	
	@Then("Ill see COM16_([^\"]*) was created$")
   	public void ill_see_product_value_created(String product) throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		Assert.assertEquals(true, ProductSerialItem_span(product+"_"+ dateNoSpace).isDisplayed());
   	}
}
