package webApp.Compass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM06_ClientsBucketSiteidUseridProject extends WEBHelper{
	
	@FindBy(xpath=".//a[@id='products_button']")
	WebElement Product_tab;
	
	@FindBy(xpath=".//a[text()='Project Management ']")
	WebElement ProjectManagement_tab;
	
	@FindBy(xpath=".//div[@id='pcont']//a[@id='subprojects_button']")
	WebElement Project_dropdown;	
	
	@FindBy(xpath="//a[text()='Business Info']")
	WebElement BusinessInfo_link;	
	
	@FindBy(xpath="//a[text()='Edit Business Info']")
	WebElement EditBusinessInfo_button;	
		
	@FindBy(xpath="//a[@id='products_button']")
	WebElement ProductsTab_button;
	
	@FindBy(xpath="//table[@id='campaign-products-table']//i[@class='fa fa-gear']")
	WebElement ProductsGear_icon;
	
	@FindBy(xpath="//table[@id='campaign-products-table']//select")
	WebElement ProductsStatus_dropdown;
	
	@FindBy(xpath="//i[@title='save']")
	WebElement ProductStatusSave_icon;
	
	public static final WebElement OverviewInvoice_link(int index){
		WebElement overviewInvoice_link = driver.findElement(By.xpath("(//a[contains(.,'INV')])["+index+"]"));
		return overviewInvoice_link;
	}
	
	
	public static final WebElement ProductStatus_text(String productStatus){
		WebElement productStatus_text = driver.findElement(By.xpath("//span[text()='"+productStatus+"']"));
		return productStatus_text;
	}
	
	@FindBy(xpath="//button[text()='Proceed']")
	WebElement Proceed_button;
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement Clsoe_button;
	
	@FindBy(xpath="//a[text()='SEO ']")
	WebElement SEO_tab;
	
	@FindBy(xpath="//a[text()='Keywords']")
	WebElement Keywords_link;
	
	@FindBy(xpath="//a[text()='URL Map']")
	WebElement UrlMaps_link;
	
	@FindBy(xpath="(//a[text()='Projects'])[2]")
	WebElement Projects_link;
	
	public COM06_ClientsBucketSiteidUseridProject() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@When("^I click COM06_Products tab$")
	public void i_click_Products_tab() throws Throwable, UnhandledAlertException {
		Product_tab.click();
	}
	
	@When("^I hover COM06_ProjectManagement tab$")
	public void i_hover_ProjectManagement_tab() throws Throwable, UnhandledAlertException {
		
		WD.until(ExpectedConditions.elementToBeClickable(ProjectManagement_tab));
        action.moveToElement(ProjectManagement_tab) 
        .build()
        .perform();         
        Thread.sleep(2000);
        
        
	}

	@When("^I click COM06_Project dropdown$")
	public void i_click_Project_dropdown() throws Throwable, UnhandledAlertException {
        
		action.moveToElement(Project_dropdown) 
        .click()
        .build()
        .perform(); 
		
		
	}

	
	@When("^I click COM06_BusinessInfo link$")
	public void i_click_BusinessInfo_link() throws Throwable, UnhandledAlertException {
		BusinessInfo_link.click();
	}
	
	@When("^I click COM06_EditBusinessInfo button$")
	public void i_click_EditBusinessInfo_button() throws Throwable, UnhandledAlertException {
		EditBusinessInfo_button.click();
	}
	
	@When("^I click COM06_Products button$")
	public void i_click_ProductsTab_button() throws Throwable, UnhandledAlertException {
		ProductsTab_button.click();
	}
	
	@When("^I click Invoice number ([^\"]*)$")
	public void i_click_Invoice_index(int number) throws Throwable, UnhandledAlertException {
		OverviewInvoice_link(number).click();
	}
	
	@When("^I click the COM06_ProductsGear icon under the Products Section$")
	public void i_click_products_gear_icon() throws Throwable, UnhandledAlertException {
		WindowScrollAndClick(ProductsGear_icon);

	}
	
	@When("^I select ([^\"]*) in the COM06_ProductsDropwdown under the Products Section$")
	public void i_select_product_status_value(String productStatus) throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		WindowScrollAndClick(ProductsStatus_dropdown);
		Select select = new Select(ProductsStatus_dropdown);
		select.selectByVisibleText(productStatus);
	}
	
	
	@When("^I click the COM06_SaveIcon under the Products Section$")
	public void i_click_products_save_icon() throws Throwable, UnhandledAlertException {
		WindowScrollAndClick(ProductStatusSave_icon);
	}
	
	
	@Then("^Ill see that the COM06_Product Status is ([^\"]*)$")
	public void ill_see_products_status_value(String productStatus) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, ProductStatus_text(productStatus).isDisplayed());
		Thread.sleep(3000);
	}
	
	
	@When("^I click the COM06_Proceed button in the modal$")
	public void i_click_proceed_button() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Proceed_button.click();
	}
	
	@When("^I click the COM06_Close button in the modal$")
	public void i_click_close_button() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Clsoe_button.click();
	}
	
	
	@When("^I hover to COM06_SEO tab$")
	public void i_hover_to_SEO_tab() throws Throwable {
		MouseHover(SEO_tab);
		Thread.sleep(5000);
	}
	
	@When("^I select COM06_Keywords link$")
	public void i_select_keywords_link() throws Throwable {
		Thread.sleep(3000);
		Keywords_link.click();
	}
	
	@When("^I select COM06_URLmap link$")
	public void i_select_urlMap_link() throws Throwable {
		Thread.sleep(3000);
		UrlMaps_link.click();
	}
	
	@When("^I hover to COM06_ProjectManagement tab$")
	public void i_hover_to_project_management_tab() throws Throwable {
		MouseHover(ProjectManagement_tab);
		Thread.sleep(5000);
	}
	
	@When("^I select COM06_Projects link$")
	public void i_select_projects_link() throws Throwable {
		Thread.sleep(3000);
		Projects_link.click();
	}
	
}