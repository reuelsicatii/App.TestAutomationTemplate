package webApp.Seoreseller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.utils.URIBuilder;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.Utilities.JsonDataGettersSetters;
import test.Utilities.JsonUtil;
import webApp.YellowPages.YP01_SearchResult;

public class SEO15_Leadgenerator extends WEBHelper {

	@FindBy(xpath = "//input[@id='location']")
	WebElement Location_textfield;

	@FindBy(xpath = "//input[@id='keyword']")
	WebElement Keyword_textfield;

	@FindBy(xpath = "//button[@id='generate-lead']")
	WebElement GenerateLeads_button;

	@FindBy(xpath = "//button[text()=' Processing...']")
	WebElement Processing_button;

	@FindBy(xpath = "//span[@id='totalLeads']")
	WebElement TotalLeads_text;

	@FindBy(xpath = "//h6[text()='Leads table is currently busy.']")
	WebElement LeadsTableCurrentlyBusy_text;

	@FindBy(xpath = "//select[@name='lead-generator-table_length']")
	WebElement LeadGenRecordsPerPage_dropdown;

	@FindBy(xpath = "//table[@id='lead-generator-table']//tbody//tr")
	WebElement LeadGenResult_table;

	@FindBy(xpath = "//div[@data-id='leadGenGenerated'][contains(.,'We have finished the lead generation. Click ')]")
	WebElement SuccessfulLeadGen_text;

	public static final WebElement SpecificViewLeads_button(String keyword) {
		return driver.findElement(
				By.xpath("(//h5[contains(.,'" + keyword + "')]/ancestor::tr//button[@data-content='View Leads'])[1]"));
	}

	public static final WebElement CompanyNameByIndex_text(int index) {
		WebElement CompanyNameByIndex_text = null;
		try {
			CompanyNameByIndex_text = driver.findElement(By.xpath("(//div[@class='company'])[" + index + "]"));
		} catch (WebDriverException e) {
			log.info("Unable to locate element");
		}
		return CompanyNameByIndex_text;
	}

	public static final WebElement CompanyAddressByIndex_text(int index) {
		WebElement CompanyAddressByIndex_text = null;
		try {
			CompanyAddressByIndex_text = driver.findElement(By.xpath("(//div[@class='address'])[" + index + "]"));
		} catch (WebDriverException e) {
			log.info("Unable to locate element");
		}
		return CompanyAddressByIndex_text;
	}

	public static final WebElement WebsiteByIndex_text(int index) {
		WebElement WebsiteByIndex_text = null;
		try {
			WebsiteByIndex_text = driver.findElement(By.xpath("(//div[@class='website'])[" + index + "]"));
		} catch (WebDriverException e) {
			log.info("Unable to locate element");
		}
		return WebsiteByIndex_text;
	}

	public static final WebElement PhoneNumberByIndex_text(int index) {
		WebElement PhoneNumberByIndex_text = null;
		try {
			PhoneNumberByIndex_text = driver.findElement(By.xpath("(//div[@class='phone'])[" + index + "]"));
		} catch (WebDriverException e) {
			log.info("Unable to locate element");
		}
		return PhoneNumberByIndex_text;
	}

	public static final WebElement KeywordAutoComplete_text(String keyword) {
		WebElement keywordAutoComplete_text = driver.findElement(By.xpath("//div[@data-keyword='" + keyword + "']"));
		return keywordAutoComplete_text;
	}

	public static final WebElement LocationAutoComplete_text(String location) {
		WebElement locationAutoComplete_text = driver.findElement(By.xpath("//div[@data-location='" + location + "']"));
		return locationAutoComplete_text;
	}

	@FindBy(xpath = "//div[@id='lead-generator-table_processing']")
	WebElement LeadGenLoader_icon;

	@FindBy(xpath = "//div[@class='keyword-suggestions-item']")
	List<WebElement> SRSkeywordSuggestionList_div;

	@FindBy(xpath = "//li[@class='no-geo']")
	List<WebElement> YPkeywordSuggestionList_list;

	@FindBy(xpath = "//input[@id='leadGenerationFilter']")
	WebElement Filter_textfield;

	@FindBy(xpath = "//p[@class='error-msg'][text()='No locations found.']")
	WebElement NoLocationsFound_text;

	@FindBy(xpath = "//h3[text()='Lead Generator Results']")
	WebElement LeadGeneratorResults_header;

	@FindBy(xpath = "//p[@class='error-msg'][text()='No search results for this niche.']")
	WebElement NoSearchResultsForThisNiche_text;

	@FindBy(xpath = "//p[@class='error-msg'][text()='Search term must be 3 characters and above.']")
	WebElement SearchTermMustBeThreeChars_text;

	@FindBy(xpath = "//input[@name='search_terms']")
	WebElement SearchTerm_textfield;

	@FindBy(xpath = "//input[@name='geo_location_terms']")
	WebElement GeoLocation_textfield;

	@FindBy(xpath = "//form[@id='search-form']//button")
	WebElement Search_button;

	public SEO15_Leadgenerator() {
		PageFactory.initElements(driver, this);
	}

	@When("I enter a US Location data in SEO15_Location textfield coming from LeadGeneratorData Json$")
	public void i_populate_SEO15_Location_data_from_json() throws Throwable, UnhandledAlertException {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		Date currentDate = new Date();
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
		String currentDay = simpleDateformat.format(currentDate);
		Calendar cal = Calendar.getInstance();
		String pmOrAm;
		cal.setTime(currentDate);
		if (cal.get(Calendar.AM_PM) == 1) {
			pmOrAm = "PM";
		} else {
			pmOrAm = "AM";
		}

		String jsonFilePath = System.getProperty("user.dir") + "\\Data\\webApp.Seoreseller\\LeadGeneratorData.json";
		String jsonContent = "";
		jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
		JsonDataGettersSetters jsonFile = JsonUtil.fromJson(jsonContent, JsonDataGettersSetters.class);
		String location = "";

		if (currentDay.equals("Monday")) {
			location = jsonFile.getMonday().get(pmOrAm);

		} else if (currentDay.equals("Tuesday")) {
			location = jsonFile.getTuesday().get(pmOrAm);

		} else if (currentDay.equals("Wednesday")) {
			location = jsonFile.getWednesday().get(pmOrAm);

		} else if (currentDay.equals("Thursday")) {
			location = jsonFile.getThursday().get(pmOrAm);

		} else if (currentDay.equals("Friday")) {
			location = jsonFile.getFriday().get(pmOrAm);

		} else if (currentDay.equals("Saturday")) {
			location = jsonFile.getSaturday().get(pmOrAm);

		} else if (currentDay.equals("Sunday")) {
			location = jsonFile.getSunday().get(pmOrAm);

		}

		Thread.sleep(3000);
		Location_textfield.sendKeys(location);
		Thread.sleep(3000);
		Location_textfield.click();
	}

	@When("^I populate SEO15_Keyword textfield with ([^\"]*)$")
	public void i_populate_SEO15_Keyword_textfield_with_value(String keyword)
			throws Throwable, UnhandledAlertException {
		Keyword_textfield.click();
		Thread.sleep(3000);
		Keyword_textfield.sendKeys(keyword);
		Thread.sleep(5000);
		KeywordAutoComplete_text(keyword).click();
		Thread.sleep(3000);
	}

	@When("^I populate SEO15_Keyword textfield with \"([^\"]*)\"$")
	public void i_populate_SEO15_Keyword_textfield_with_variable(String keyword)
			throws Throwable, UnhandledAlertException {
		Keyword_textfield.click();
		Thread.sleep(3000);
		Keyword_textfield.sendKeys(keyword);
		Thread.sleep(5000);
		KeywordAutoComplete_text(keyword).click();
		Thread.sleep(3000);
	}

	@When("^I click the the SEO15_GenerateLeads button$")
	public void i_click_SEO15_GenerateLeads_button() throws Throwable, UnhandledAlertException {
		GenerateLeads_button.click();
	}

	@Then("^Ill see the SE015_Processing button$")
	public void ill_see_SE015_Processing_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Processing_button.isDisplayed());
		Thread.sleep(3000);
	}

	@When("^I click the SE015_ViewLeads button of ([^\"]*) in location from the test data file$")
	public void i_click_SE015_ViewLeads_button(String keyword) throws Throwable, UnhandledAlertException {
		int sleep = 10000;
		for (int i = 0; i <= 30; i++) {
			if (SuccessfulLeadGen_text.isDisplayed()) {
				System.out.println("Generation of Lead Gen is Completed");
				Thread.sleep(5000);
				String output = keyword.substring(0, 1).toUpperCase() + keyword.substring(1);
				SpecificViewLeads_button(output).click();
				break;

			} else {
				System.out.println("Lead Gen is In Progress");
				Thread.sleep(sleep);
			}
			sleep = sleep + 10000;
		}
	}

	@Then("^Ill see the SE015_LeadGen table$")
	public void ill_see_SE015_LeadGen_table() throws Throwable, UnhandledAlertException {
		for (int i = 0; i < 10; i++) {
			if (LeadGenLoader_icon.getAttribute("style").contains("visibility: hidden;")) {
				System.out.println("Lead Gen Loader is Completed");
				Assert.assertEquals(true, LeadGenResult_table.isDisplayed());
				break;
			} else {
				System.out.println("Lead Gen Loader is Ongoing");
				Thread.sleep(10000);
			}
		}
	}

	@Then("^Ill see that SEO15_TotalLeadsFound is equal to the row count returned$")
	public void ill_see_SEO15_TotalLeadsFound_is_correct() throws Throwable, UnhandledAlertException {
		Select s = new Select(LeadGenRecordsPerPage_dropdown);
		s.selectByVisibleText("100");
		Thread.sleep(5000);
		int tableTotalCount = driver.findElements(By.xpath("//table[@id='lead-generator-table']//tbody//tr")).size();
		String tableTotalCountString = String.valueOf(tableTotalCount);
		Assert.assertEquals(tableTotalCountString, TotalLeads_text.getText());
	}

	@Then("^Ill see that the Company Name is available per row$")
	public void ill_see_CompanyName_value_per_row() throws Throwable, UnhandledAlertException {
		int tableTotalCount = driver.findElements(By.xpath("//table[@id='lead-generator-table']//tbody//tr")).size();

		for (int i = 1; i <= tableTotalCount; i++) {
			System.out.println("Companny Name[" + i + "]" + CompanyNameByIndex_text(i).getAttribute("title"));
			Assert.assertEquals(false, CompanyNameByIndex_text(i).getText().isEmpty());

		}
	}

	@Then("^Ill see the SEO15_ErrorMessage 'No locations found.' in red under the field$")
	public void ill_see_SEO15_ErrorMessage_No_location_found() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, NoLocationsFound_text.isDisplayed());
	}

	@Then("^Ill be redirected to Lead Generator page$")
	public void ill_be_redirected_to_lead_generator_page() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, LeadGeneratorResults_header.isDisplayed());
	}

	@When("^I populate SEO15_Location textfield with ([^\"]*)$")
	public void i_populate_SEO15_Location_textfield_with_variable(String location)
			throws Throwable, UnhandledAlertException {
		Location_textfield.click();
		Thread.sleep(3000);
		Location_textfield.sendKeys(location);
		Thread.sleep(5000);
		LocationAutoComplete_text(location).click();
		Thread.sleep(3000);
	}

	@When("^I populate SEO15_Location textfield with \"([^\"]*)\"$")
	public void i_populate_SEO15_Location_textfield_with_value(String location)
			throws Throwable, UnhandledAlertException {
		Location_textfield.click();
		Thread.sleep(3000);
		Location_textfield.sendKeys(location);
		Thread.sleep(5000);
		LocationAutoComplete_text(location).click();
		Thread.sleep(3000);
	}

	@When("^I populate SEO15_Location textfield without auto selection with ([^\"]*)$")
	public void i_populate_SEO15_Location_textfieldwithout_auto_selection_with_variable_(String location)
			throws Throwable, UnhandledAlertException {
		Location_textfield.click();
		Thread.sleep(3000);
		Location_textfield.sendKeys(location);
		Thread.sleep(3000);
		Location_textfield.click();
		Thread.sleep(3000);
	}

	@When("^I populate SEO15_Location textfield without auto selection with \"([^\"]*)\"$")
	public void i_populate_SEO15_Location_textfield_without_auto_selection_with_value(String location)
			throws Throwable, UnhandledAlertException {
		Location_textfield.click();
		Thread.sleep(3000);
		Location_textfield.sendKeys(location);
		Thread.sleep(3000);
		Location_textfield.click();
		Thread.sleep(3000);
	}

	@Then("^Ill see the SEO15_ErrorMessage \"No search results for this niche.\" in red under the field$")
	public void ill_see_SEO15_ErrorMessage_No_results_for_niche() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, NoSearchResultsForThisNiche_text.isDisplayed());
	}

	@When("^I enter the keyword ([^\"]*) in the SEO15_Keyword textfield without auto selection$")
	public void i_populate_SEO15_Keyword_textfield_with_variable_no_list(String keyword)
			throws Throwable, UnhandledAlertException {
		Keyword_textfield.click();
		Thread.sleep(3000);
		Keyword_textfield.sendKeys(keyword);
		Thread.sleep(3000);
	}

	@When("^I enter the keyword \"([^\"]*)\" in the SEO15_Keyword textfield without auto selection$")
	public void i_populate_SEO15_Keyword_textfield_with_value_no_list(String keyword)
			throws Throwable, UnhandledAlertException {
		Keyword_textfield.click();
		Thread.sleep(3000);
		Keyword_textfield.sendKeys(keyword);
		Thread.sleep(3000);
	}

	@Then("^Ill see SEO15_Location textfield$")
	public void ill_see_SEO15_Location() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, Location_textfield.isDisplayed());
	}

	@Then("^Ill see SEO15_Keyword textfield$")
	public void ill_see_SEO15_Keyword() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, Keyword_textfield.isDisplayed());
	}

	@Then("^Ill see SEO15_GenerateLeads button is Disabled$")
	public void SEO15_GenerateLeads_disabled_by_default() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(false, GenerateLeads_button.isEnabled());
	}

	@Then("^Ill see SEO15_GenerateLeads button is Enabled$")
	public void SEO15_GenerateLeads_enabled() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, GenerateLeads_button.isEnabled());
	}

	@Then("^Ill see the SEO15_ErrorMessage \"Search term must be 3 characters and above.\" in red under the field$")
	public void ill_see_SEO15_ErrorMessage_search_must_be_three_chars_and_above()
			throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, SearchTermMustBeThreeChars_text.isDisplayed());

	}

	@Then("^Ill see the auto suggestion list for ([^\"]*) matches result from yellowpages$")
	public void ill_see_auto_sugesstion_matches_yellowpages(String keyword) throws Throwable, UnhandledAlertException {
		int keywordDashboardSize = SRSkeywordSuggestionList_div.size();
		List<String> myList = new ArrayList<String>();

		for (int i = 0; i < keywordDashboardSize; i++) {
			myList.add(SRSkeywordSuggestionList_div.get(i).getAttribute("data-keyword"));
		}

		driver.get("https://www.yellowpages.com/autosuggest/headings.html?text=" + keyword);
		Thread.sleep(3000);

//		int keywordYPsize = YPkeywordSuggestionList_list.size();
//		for (int i = 0; i < keywordYPsize; i++) {
//			Assert.assertEquals(myList.get(i), YPkeywordSuggestionList_list.get(i).getAttribute("data-value"));
//		}

		int sleep = 10000;
		for (int x = 0; x <= 10; x++) {
			try {
				driver.get("https://www.yellowpages.com/autosuggest/headings.html?text=" + keyword);
				Thread.sleep(sleep);
				int keywordYPsize = YPkeywordSuggestionList_list.size();
				for (int i = 0; i < keywordYPsize; i++) {
					Assert.assertEquals(myList.get(i), YPkeywordSuggestionList_list.get(i).getAttribute("data-value"));
				}
				break;
			} catch (NullPointerException | WebDriverException e) {
				log.info(x + " times navigating to: https://www.yellowpages.com/autosuggest/headings.html?text="
						+ keyword);
				e.printStackTrace();
			}
			sleep = sleep + 10000;
		}
	}

	@Then("^Ill see that the selected ([^\"]*) is displayed in the SEO15_Keyword textfield$")
	public void ill_see_selected_keyword_displayed_in_SEO15_Keyword_textfield(String selectedKeyword)
			throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String compareString = js.executeScript("return document.getElementById('keyword').value;").toString();
		Thread.sleep(3000);
		Assert.assertEquals(selectedKeyword, compareString);
	}

	@When("^I select the ([^\"]*) in the SEO15_NicheSuggestion List$")
	public void i_select_niche_in_SEO15_NicheSuggestion_list(String selectedKeyword)
			throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		KeywordAutoComplete_text(selectedKeyword).click();
		Thread.sleep(3000);
	}

	@When("^I click outside of the SEO15_Keyword textfield$")
	public void i_click_outside_of_SEO15_Keyword_textfield() throws Throwable, UnhandledAlertException {
		Filter_textfield.click();
	}

	@Then("^Ill see that the first item ([^\"]*) from the autocomplete list is displayed in the SEO15_Keyword textfield$")
	public void ill_see_first_item_displayed_in_SEO15_Keyword_textfield(String firstItem)
			throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String compareString = js.executeScript("return document.getElementById('keyword').value;").toString();
		Thread.sleep(3000);
		Assert.assertEquals(firstItem, compareString);
	}

	@Then("^Ill not see the SEO15_NicheSuggestion list for ([^\"]*)$")
	public void ill_not_see_SEO15_NicheSuggestion_list(String keyword) throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		try {
			if (KeywordAutoComplete_text(keyword).isDisplayed()) {
				Assert.fail("SEO15_NicheSuggestion was displayed");
			}

		} catch (WebDriverException ex) {
			Assert.assertTrue(true);
		}
	}

	@When("^I clear SEO15_Keyword textfield$")
	public void i_clear_SEO15_Keyword_textfield() throws Throwable, UnhandledAlertException {
		Keyword_textfield.sendKeys(Keys.BACK_SPACE);
		Keyword_textfield.clear();
		Thread.sleep(5000);
	}

	@Then("^Ill NOT see the SEO15_ErrorMessage \"No search results for this niche.\" in red under the field$")
	public void ill_not_see_SEO15_ErrorMessage_No_results_for_niche() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		try {
			if (NoSearchResultsForThisNiche_text.isDisplayed()) {
				Assert.fail("'No search results for this niche.' was displayed");
			}

		} catch (WebDriverException ex) {
			Assert.assertTrue(true);
		}
		Thread.sleep(5000);
	}

	@Then("^Ill see that the SEO15_Location is enabled$")
	public void SSEO15_Locations_enabled_by_default() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, Location_textfield.isEnabled());
	}

	@Then("^Ill see that the SEO15_Keyword is disabled$")
	public void SEO15_Keyword_disabled_by_default() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(false, Keyword_textfield.isEnabled());
	}

	@Then("^Ill see that the Details for Search Result of ([^\"]*) in ([^\"]*) matches the details from yellowpages$")
	public void ill_see_dshboard_company_details_matches_yp_company_details(String keyword, String location)
			throws Throwable, UnhandledAlertException {
		int dbTableTotalCount = driver.findElements(By.xpath("//table[@id='lead-generator-table']//tbody//tr")).size();
		log.info("Capturing in count:" + dbTableTotalCount);
		String dbCompanyName = "";
		String dbLocation = "";
		String dbWesbite = "";
		String dbPhone = "";

		for (int i = 1; i <= dbTableTotalCount; i++) {

			try {
				dbCompanyName = CompanyNameByIndex_text(i).getText();
			} catch (NullPointerException | WebDriverException e) {
				dbCompanyName = "";
			} finally {
				log.info("Capturing CompanyNameByIndex: " + dbCompanyName);
			}

			try {
				dbLocation = CompanyAddressByIndex_text(i).getText();
			} catch (NullPointerException | WebDriverException e) {
				dbLocation = "";
			} finally {
				log.info("Capturing CompanyAddressByIndex: " + dbLocation);
			}

			try {
				dbWesbite = WebsiteByIndex_text(i).getText();
			} catch (NullPointerException | WebDriverException e) {
				dbWesbite = "";
			} finally {
				log.info("Capturing WebsiteByIndex: " + dbWesbite);
			}

			try {
				dbPhone = PhoneNumberByIndex_text(i).getText();
			} catch (NullPointerException | WebDriverException e) {
				dbPhone = "";
			} finally {
				log.info("Capturing PhoneNumberByIndex: " + dbPhone);
			}

			String[] splitLoc = dbLocation.split(",");
			dbLocation = splitLoc[0];

			URIBuilder ub = new URIBuilder("https://www.yellowpages.com/search");
			ub.addParameter("search_terms", keyword);
			ub.addParameter("geo_location_terms", location);
			log.info(ub.toString() + "&refinements=bbb_grade_display%3A1");

			int sleep = 10000;
			for (int x = 0; x <= 10; x++) {
				try {
					driver.get(ub.toString() + "&refinements=bbb_grade_display%3A1");
					Thread.sleep(sleep);
					driver.switchTo().window(driver.getWindowHandle());
					YP01_SearchResult.BusinessLocality_text(dbCompanyName).isDisplayed();
					break;
				} catch (NullPointerException | WebDriverException e) {
					log.info(x + " times navigating to: " + ub.toString() + "&refinements=bbb_grade_display%3A1");
					e.printStackTrace();
				}
				sleep = sleep + 50000;
			}

			if (dbLocation.isEmpty()) {
				log.info("Seoreseller Location:" + dbLocation + " -- Yellowpages Location:"
						+ YP01_SearchResult.BusinessLocality_text(dbCompanyName).getText());
				Assert.assertTrue(true);
			} else if (YP01_SearchResult.BusinessLocality_text(dbCompanyName).getText().contains(dbLocation)) {
				log.info("Seoreseller Location:" + dbLocation + " -- Yellowpages Location:"
						+ YP01_SearchResult.BusinessLocality_text(dbCompanyName).getText());
				Assert.assertTrue(true);
			} else {
				Assert.fail("Business location from Dashboard doesnt match the location details from YP");
				log.info("Seoreseller Location:" + dbLocation + " -- Yellowpages Location:"
						+ YP01_SearchResult.BusinessLocality_text(dbCompanyName).getText());
			}

			if (dbPhone.isEmpty()) {
				log.info("Seoreseller Phone:" + dbPhone + " -- Yellowpages Phone:"
						+ YP01_SearchResult.BusinessPrimaryPhone_text(dbCompanyName).getText());
				Assert.assertTrue(true);
			} else if (YP01_SearchResult.BusinessPrimaryPhone_text(dbCompanyName).getText()
					.replaceAll("[^a-zA-Z0-9]", "").contains(dbPhone.replaceAll("[^a-zA-Z0-9]", ""))) {
				log.info("Seoreseller Phone:" + dbPhone + " -- Yellowpages Phone:"
						+ YP01_SearchResult.BusinessPrimaryPhone_text(dbCompanyName).getText());
				Assert.assertTrue(true);
			} else {
				Assert.fail("Business' Phone from Dashboard doesnt match the phone details from YP");
				log.info("Seoreseller Phone:" + dbPhone + " -- Yellowpages Phone:"
						+ YP01_SearchResult.BusinessPrimaryPhone_text(dbCompanyName).getText());
			}

			if (dbWesbite.isEmpty()) {
				log.info("Seoreseller Website:" + dbWesbite + " -- Yellowpages Website:"
						+ YP01_SearchResult.BusinessWebsite_link(dbCompanyName).getText());
				Assert.assertTrue(true);
			} else if (YP01_SearchResult.BusinessWebsite_link(dbCompanyName).getAttribute("href").contains(dbWesbite)) {
				log.info("Seoreseller Website:" + dbWesbite + " -- Yellowpages Website:"
						+ YP01_SearchResult.BusinessWebsite_link(dbCompanyName).getAttribute("href"));
				Assert.assertTrue(true);
			} else {
				Assert.fail("Business' Website from Dashboard doesnt match the Website details from YP");
				log.info(" Seoreseller Website:" + dbWesbite + " -- Yellowpages Website:"
						+ YP01_SearchResult.BusinessWebsite_link(dbCompanyName).getAttribute("href"));
			}

			driver.navigate().back();
		}
	}
}
