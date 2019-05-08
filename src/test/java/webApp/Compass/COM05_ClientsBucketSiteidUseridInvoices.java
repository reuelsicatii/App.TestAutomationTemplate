package webApp.Compass;

//import static org.testng.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import cucumber.Framework.WEBHelper;
import webApp.Seoreseller.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM05_ClientsBucketSiteidUseridInvoices extends WEBHelper{
	
	@FindBy(xpath=".//a[@href='#inv-payments']")
	WebElement Payments_tab;
	
	@FindBy(xpath=".//button[text()='Add New Payment']")
	WebElement AddNewPayment_button;

	@FindBy(xpath=".//input[contains(@name, 'amt_paid')]")
	WebElement AmountPaid_textfield;
	
	@FindBy(xpath=".//select[contains(@name, 'payment_type')]")
	WebElement Type_dropbox;
	
	@FindBy(xpath=".//input[contains(@name, 'payment_ref')]")
	WebElement ReferenceNumber_tetxfield;
	
	@FindBy(xpath=".//button[text()='Submit']")
	WebElement Submit_button;
	
	@FindBy(xpath="//button[text()='Mark As Paid']")
	WebElement MarkAsPaid_button;
	
	@FindBy(xpath="//button[text()='Mark As Paid']")
	WebElement Invoice;
	
	public static final WebElement InvoiceStatus (String status){
		WebElement invoiceStatus_text = driver.findElement(By.xpath("//td/strong[text()='"+status+"']"));
		return invoiceStatus_text;
	}
	
	public COM05_ClientsBucketSiteidUseridInvoices() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@When("^I click COM05_Payments tab$")
	public void i_click_Payments_tab() throws Throwable, UnhandledAlertException {
		
		WD.until(ExpectedConditions.elementToBeClickable(Payments_tab));
		Payments_tab.click();
	}

	@When("^I click COM05_AddNewPayment button$")
	public void i_click_AddNewPayment_button() throws Throwable, UnhandledAlertException {
		AddNewPayment_button.click();
	}

	@When("^I populate COM05_AmountPaid with \"([^\"]*)\"$")
	public void i_populate_AmountPaid_with(String arg1) throws Throwable, UnhandledAlertException {
		AmountPaid_textfield.sendKeys(arg1);
	}

	@When("^I select \"([^\"]*)\" over COM05_Type dropdown$")
	public void i_select_over_Type_dropdown(String arg1) throws Throwable, UnhandledAlertException {
		Select S = new Select(Type_dropbox);
		S.selectByVisibleText(arg1);  
	}

	@When("^I populate COM05_ReferenceNumber with \"([^\"]*)\"$")
	public void i_populate_ReferenceNumber_with(String arg1) throws Throwable, UnhandledAlertException {
		ReferenceNumber_tetxfield.sendKeys(arg1);
	}

	@When("^I click COM05_No_DoYouWantToSendOpsANotification button$")
	public void i_click_No_DoYouWantToSendOpsANotification_button() throws Throwable, UnhandledAlertException {
		

		WebElement No_DoYouWantToSendOpsANotification_button = driver
		.findElement(By.xpath(".//*[@id='invoice_add']/div[4]/div[1]/label[2]/div/ins"));
		
		action
		.moveToElement(No_DoYouWantToSendOpsANotification_button)		
		.click()
		.build()
	    .perform(); 
	}

	@When("^I click COM05_No_UseCredit button$")
	public void i_click_No_UseCredit_button() throws Throwable, UnhandledAlertException {
		
		WebElement No_UseCredit_button = driver
		.findElement(By.xpath(".//*[@id='invoice_add']/div[3]/div[2]/label[2]/div/ins"));
		
		action
		.moveToElement(No_UseCredit_button)		
		.click()
		.build()
	    .perform();
	}

	@When("^I click COM05_No_DoyouWantToSendTheClientANotification button$")
	public void i_click_No_DoyouWantToSendTheClientANotification_button() throws Throwable, UnhandledAlertException {
		
		WebElement No_DoyouWantToSendTheClientANotification_button = driver
		.findElement(By.xpath(".//*[@id='invoice_add']/div[4]/div[2]/label[2]/div/ins"));
		
		action
		.moveToElement(No_DoyouWantToSendTheClientANotification_button)		
		.click()
		.build()
	    .perform();
	}

	@When("^I click COM05_Submit button$")
	public void i_click_Submit_button() throws Throwable, UnhandledAlertException {
		
		action
		.moveToElement(Submit_button)		
		.click()
		.build()
	    .perform();
	}

	@Then("^Ill see ([^\"]*) successfully paid$")
	public void ill_see_Product_successfully_paid(String arg1) throws Throwable, UnhandledAlertException {
			
        
		Thread.sleep(5000);	
		try {
			
			assertEquals("Payment has been added.",
					driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        
	}
		
	@When("^I click COM05_Invoice link$")
	public void i_click_COM05_Invoice_link() throws Throwable, UnhandledAlertException {		

		//System.out.println(SEO05_Invoices.InvoiceNumber);
		driver.findElement(By.xpath(".//table[@id='tbl_invoices']//a[text()='"+ SEO05_Invoices.InvoiceNumber +"']")).click();
		//driver.findElement(By.xpath(".//table[@id='tbl_invoices']//a"));
		//driver.get(driver.getCurrentUrl() + "//" + SEO05_Invoices.InvoiceNumber);

	}

	@When("^I click COM05_MarkAsPaid button$")
	public void i_click_COM05_MarkAsPaid_button() throws Throwable, UnhandledAlertException {		
		MarkAsPaid_button.click();
	}
	
	
	@When("^Ill see that the invoice status is ([^\"]*)$")
	public void ill_see_invoice_status(String status) throws Throwable, UnhandledAlertException {		
		Assert.assertEquals(true, InvoiceStatus(status).isDisplayed());

	}
	
}
