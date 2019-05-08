package webApp.Compass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import cucumber.Framework.SetUp;
import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM07_ClientsBucketSiteidUseridProjectProduct extends WEBHelper {

	@FindBy(xpath = ".//button[@id='order-product-button']")
	WebElement OrderAProduct_button;

	@FindBy(xpath = ".//*[@id='order-button']")
	WebElement AddthisProduct_button;

	@FindBy(xpath = ".//button[@id='edit-project-button']")
	WebElement Edit_button;

	@FindBy(xpath = ".//*[@id='save-project-button']")
	WebElement Save_button;

	@FindBy(xpath = ".//select[@name='campaign_status']")
	WebElement ProductStatus_dropdown;

	@FindBy(xpath = "//ol[@class='breadcrumb']//a[text()='Products']")
	WebElement ProductBreadcrumb_link;

	public COM07_ClientsBucketSiteidUseridProjectProduct() {

		PageFactory.initElements(driver, this);

	}

	@When("^I click COM07_OrderAProduct button$")
	public void i_click_OrderAProduct_button() throws Throwable {
		OrderAProduct_button.click();
	}

	@When("^I select ([^\"]*) over COM07_SelectACategory list$")
	public void i_select_Category_over_SelectACategory_list(String category) throws Throwable {
		String dateIdentifier = null;
		String finalCat;

		if (SetUp.getScenarioName().contains("LocalSEO")) {
			dateIdentifier = readTextfile("webApp.Compass\\LocalSEO_Date.txt");

		} else if (SetUp.getScenarioName().contains("OrganicSEO")) {
			dateIdentifier = readTextfile("webApp.Compass\\OrganicSEO_Date.txt");

		} else if (SetUp.getScenarioName().contains("WebDesign")) {
			dateIdentifier = readTextfile("webApp.Compass\\WebDesign_Date.txt");
		}

		if (SetUp.getScenarioName().contentEquals("LocalSEO_TS02")) {
			finalCat = category + "_" + dateIdentifier;
			Thread.sleep(2000);
		} else {
			finalCat = category;
			Thread.sleep(2000);
		}

		WebElement ScrollBar = driver.findElement(By.xpath(".//div[@class='slider']"));
		WebElement Category = driver
				.findElement(By.xpath(".//*[@id='categories_wrapper']//li[contains(.,'" + finalCat + "')]"));

		for (int i = 0; i < 100; i = i + 7) {

			try {
				action.moveToElement(ScrollBar)
				.clickAndHold(ScrollBar).moveByOffset(0, 13+i)
				.moveToElement(Category)						
				.click().build().perform();
				break;

			} catch (WebDriverException e) {
				e.printStackTrace();
				log.info("Failed Attempt: i_select_Category_over_SelectACategory_list again");
			}

		}

	}

	@When("^I select ([^\"]*) over COM07_SelectAProduct list$")
	public void i_click_Product_name(String product) throws Throwable {
		String dateIdentifier = null;
		String finalProduct;

		if (SetUp.getScenarioName().contains("LocalSEO")) {
			dateIdentifier = readTextfile("webApp.Compass\\LocalSEO_Date.txt");

		} else if (SetUp.getScenarioName().contains("OrganicSEO")) {
			dateIdentifier = readTextfile("webApp.Compass\\OrganicSEO_Date.txt");

		} else if (SetUp.getScenarioName().contains("WebDesign")) {
			dateIdentifier = readTextfile("webApp.Compass\\WebDesign_Date.txt");
		}

		if (SetUp.getScenarioName().contentEquals("LocalSEO_TS02")) {
			finalProduct = product + "_" + dateIdentifier;
			Thread.sleep(2000);
		} else {
			finalProduct = product;
			Thread.sleep(2000);
		}

		WebElement Product = driver
				.findElement(By.xpath(".//*[@id='products_wrapper']//li[@data-product-name='" + finalProduct + "']"));
		WD.until(ExpectedConditions.elementToBeClickable(Product));
		Product.click();

	}

	@When("^I click COM07_AddthisProduct button$")
	public void i_click_AddthisProduct_button() throws Throwable {
		AddthisProduct_button.click();
	}

	@Then("^Ill see ([^\"]*) successfully added$")
	public void ill_see_Product_successfully_added(String arg1) throws Throwable {
		Thread.sleep(5000);
		try {

			driver.switchTo().alert().accept();

		} catch (Exception e) {
			// TODO: Validation here
		}

	}

	@When("^I click the COM07_([^\"]*) link$")
	public void i_click_the_Product_link_variable(String arg1) throws Throwable {
		driver.findElement(By.xpath(".//a[text()='" + arg1 + "']")).click();
	}

	@When("^I click the \"([^\"]*)\" link$")
	public void i_click_the_Product_link_value(String arg1) throws Throwable {
		driver.findElement(By.xpath(".//a[text()='" + arg1 + "']")).click();
	}

	@When("^I click COM07_Invoice link$")
	public void i_click_Invoice_link() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='project-invoice-table']/tbody/tr[1]/td[1]/a")).click();
	}

	@When("^I click the COM07_Edit button$")
	public void i_click_the_Edit_button() throws Throwable {

		WD.until(ExpectedConditions.elementToBeClickable(Edit_button));
		Edit_button.click();
	}

	@When("^I select \"([^\"]*)\" over COM07_ProductStatus dropdown$")
	public void i_select_over_ProductStatus_dropdown(String arg1) throws Throwable {
		Select S = new Select(ProductStatus_dropdown);
		S.selectByVisibleText(arg1);
	}

	@When("^I click COM07_Save button$")
	public void i_click_Save_button() throws Throwable {
		Save_button.click();
	}

	@Then("^Ill see ([^\"]*) activated$")
	public void ill_see_Product_activated(String arg1) throws Throwable {

		// Temporary code block until COM-178 & COM-179 is delivered
		Thread.sleep(5000);
	}

	@Then("^Ill see the Products Page$")
	public void ill_see_Product_page() throws Throwable {
		Assert.assertEquals(true, ProductBreadcrumb_link.isDisplayed());
	}

}
