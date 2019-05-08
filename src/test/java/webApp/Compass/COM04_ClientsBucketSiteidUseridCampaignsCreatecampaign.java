package webApp.Compass;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.SetUp;
import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM04_ClientsBucketSiteidUseridCampaignsCreatecampaign extends WEBHelper {

	@FindBy(xpath = ".//*[@id='projects_button']")
	WebElement Campaigns_tab;

	@FindBy(xpath = ".//*[@id='create_project_btn']")
	WebElement COM_CreateCampaign_button;

	@FindBy(xpath = ".//input[contains(@name, 'project_name')]")
	WebElement CampaignName_textfield;

	@FindBy(xpath = ".//input[@id='brand_name']")
	WebElement BrandName_textfield;

	@FindBy(xpath = ".//input[contains(@name, 'project_url')]")
	WebElement CampaignURL_textfield;

	@FindBy(xpath = ".//textarea[contains(@name, 'project_description')]")
	WebElement CampaignDesccription_textfield;

	@FindBy(xpath = ".//select[contains(@name, 'category')]")
	WebElement Category_dropbox;

	@FindBy(xpath = ".//textarea[@id='service_overview']")
	WebElement ProductandServiceOverview_textfield;

	@FindBy(xpath = ".//button[text()='Submit']")
	WebElement Submit_button;

	@FindBy(xpath = "//input[@name='business_name']")
	WebElement BusinessName_textfield;

	@FindBy(xpath = "//input[@id='business_email']")
	WebElement BusinessEmail_textfield;

	@FindBy(xpath = "//span[text()='Please select category']")
	WebElement MainCategory_dropdown;

	public static final WebElement MainCategoryList(String maincategory) {
		WebElement mainCategoryList = driver
				.findElement(By.xpath("//ul[@class='select2-results']//div[text()='" + maincategory + "']"));
		return mainCategoryList;
	}

	public COM04_ClientsBucketSiteidUseridCampaignsCreatecampaign() {

		PageFactory.initElements(driver, this);

	}

	@When("^I populate COM04_CampaignName textfield with ([^\"]*)$")
	public void i_populate_CampaignName_textfield_with(String CampaignName) throws Throwable, UnhandledAlertException {
		String dateIdentifier = null;

		if (SetUp.getScenarioName().contains("LocalSEO")) {
			dateIdentifier = readTextfile("webApp.Compass\\LocalSEO_Date.txt");

		} else if (SetUp.getScenarioName().contains("OrganicSEO")) {
			dateIdentifier = readTextfile("webApp.Compass\\OrganicSEO_Date.txt");

		} else if (SetUp.getScenarioName().contains("WebDesign")) {
			dateIdentifier = readTextfile("webApp.Compass\\WebDesign_Date.txt");
		}
		
		if (SetUp.getScenarioName().contentEquals("LocalSEO_TS02")) {
			CampaignName_textfield.sendKeys(CampaignName + "_" + dateIdentifier);
			Thread.sleep(2000);
		} else {
			CampaignName_textfield.sendKeys(CampaignName);
			Thread.sleep(2000);
		}

	}

	@When("^I populate COM04_BrandName textfield with ([^\"]*)$")
	public void i_populate_BrandName_textfield_with(String arg1) throws Throwable, UnhandledAlertException {
		BrandName_textfield.sendKeys(arg1);
	}

	@When("^I populate COM04_CampaignURL textfield with ([^\"]*)$")
	public void i_populate_CampaignURL_textfield_with(String arg1) throws Throwable, UnhandledAlertException {
		CampaignURL_textfield.sendKeys(arg1);
	}

	@When("^I populate COM04_Description textfield with \"([^\"]*)\"$")
	public void i_populate_Description_textfield_with(String arg1) throws Throwable, UnhandledAlertException {
		CampaignDesccription_textfield.sendKeys(arg1);
		Thread.sleep(3000);
	}

	@When("^I select \"([^\"]*)\" over COM04_Category dropdown$")
	public void i_select_over_Category_dropdown(String maincategory) throws Throwable, UnhandledAlertException {
		MainCategory_dropdown.click();
		Thread.sleep(3000);
		MainCategoryList(maincategory).click();
		Thread.sleep(3000);
	}

	@When("^I populate COM04_BusinessEmail textfield with ([^\"]*)$")
	public void i_popualate_business_email_textfield_with_value(String businessEmail)
			throws Throwable, UnhandledAlertException {
		BusinessEmail_textfield.sendKeys(businessEmail);

	}

	@When("^I populate COM04_ProductandServiceOverview textfield with \"([^\"]*)\"$")
	public void i_populate_ProductandServiceOverview_textfield_with(String arg1)
			throws Throwable, UnhandledAlertException {
		ProductandServiceOverview_textfield.sendKeys(arg1);
	}

	@When("^I click COM04_Submit button$")
	public void i_click_Submit_button() throws Throwable, UnhandledAlertException {
		WindowScrollAndClick(Submit_button);
	}

	@Then("^Ill see campaign successfully created$")
	public void ill_see_campaign_successfully_created() throws Throwable {

		Thread.sleep(5000);
		try {

			assertEquals("Project successfully created.", driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@When("^I populate COM04_BusinessName with \"([^\"]*)\"$")
	public void i_populate_businessName_with(String businessName) throws Throwable, UnhandledAlertException {
		BusinessName_textfield.sendKeys(businessName);
	}

}
