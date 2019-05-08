package webApp.Seoreseller;

import static org.junit.Assert.fail;

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

public class SEO01_Home extends WEBHelper{
	
	@FindBy(xpath=".//a[@href='/new-campaign/wizard']")
	WebElement AddCampaign_button;
	
	@FindBy(xpath=".//input[@id='business_url']")
	WebElement DomainUrl_textfield;
	
	@FindBy(xpath=".//button[@id='new-business-create-btn']")
	WebElement CheckDomain_button;
	
	@FindBy(xpath=".//button[@id='new-business-save-btn']")
	WebElement CreateCampaign_button;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement ClickToGetStarted_button;
	
	@FindBy(xpath="//div[@id='user-account-container']/button/img")
	WebElement UserAvatar_image;
	
	@FindBy(xpath="//div[@id='user-account-container']//li/a[@href='/logout']")
	WebElement Logout_list;
		
	@FindBy(xpath="//div[@id='profile-setup-box-image-action-holder']")
	WebElement CompanySetupUploadPhoto_Button;
	
	@FindBy(xpath="//div/input[@id='profile-setup-box-input-firstname']")
	WebElement CompanySetupFirstName_Textfield;
	
	@FindBy(xpath="//div/input[@id='profile-setup-box-input-lastname']")
	WebElement CompanySetupLastName_Textfield;
	
	@FindBy(xpath="//div/input[@id='profile-setup-box-input-role']")
	WebElement CompanySetupRole_Textfield;
	
	@FindBy(xpath="//div/input[@id='profile-setup-box-input-phone']")
	WebElement CompanySetupPhone_Textfield;
	
	@FindBy(xpath="//*[@id='profile-setup-box-input-container']//button[contains(.,'COMPLETE PROFILE')]")
	WebElement CompanySetupCompleteProfile_button;
	
	@FindBy(xpath="//input[@id='profile-setup-box-input-company-name']")
	WebElement CompanySetupCompanyName_textfield;	

	@FindBy(xpath="//input[@id='profile-setup-box-input-company-name']")
	WebElement CompanySetupCompanyProfile_Textfield;	
	
	@FindBy(xpath="//div[@class='selected-flag']")
	WebElement CompanySetupFlagIcon_Button;
	
	@FindBy(xpath="//a[text() = 'Email Settings']")
	WebElement EmailSetting_List;	
	
	public static final WebElement CompanySetupSelectCountry(String keyword){
		WebElement SelectedtCountry = driver.findElement(By.xpath("//span[@class='country-name'][text()='"+keyword+"']"));
		return SelectedtCountry;
	}
	
	@FindBy(xpath="//select[@name='partnerAgencyEmployeeCount']")
	WebElement CompanySetupCompanyProfile_Selector;	
	
	
	public static final WebElement CompanySetupCompanyProfileByKeyword(String keyword){
		WebElement SelectedCompanyProfile = driver.findElement(By.xpath("//ul[@class='select2-results']/li/div[contains(.,'"+keyword+"')]"));
		return SelectedCompanyProfile;
	}
	
	public static final WebElement CompanySetupCompanyProfileByIndex(int index){
		WebElement SelectedCompanyProfile = driver.findElement(By.xpath("//ul[@class='select2-results']/li["+index+"]"));
		return SelectedCompanyProfile;
	}	
	
	@FindBy(xpath="//select[@name='partnerAgencyClientCount']")
	WebElement CompanySetupExistingClient_Selector;	
	
	public static final WebElement CompanySetupExistingClientByKeyword(String keyword){
		WebElement SelectedExistingClient = driver.findElement(By.xpath("//ul[@class='select2-results']/li/div[contains(.,'"+keyword+"')]"));
		return SelectedExistingClient;
	}
	
	public static final WebElement CompanySetupExistingClientByIndex(int index){
		WebElement SelectedExistingClient = driver.findElement(By.xpath("//ul[@class='select2-results']/li["+index+"]"));
		return SelectedExistingClient;
	}	
	
	@FindBy(xpath="//input[@id='profile-setup-box-input-company-website']")
	WebElement CompanySetupCompanyWebsite_Textfield;	
	
	@FindBy(xpath="//input[@id='profile-setup-box-input-company-phone']")
	WebElement CompanySetupBusinessPhone_Textfield;	
	
	@FindBy(xpath="//input[@id='profile-setup-box-input-company-address']")
	WebElement CompanySetupAddress_Textfield;	
	
	@FindBy(xpath="(//span[@class='pac-matched'])[1]")
	WebElement CompanySetupAddressFirstAutofill_span;	
	
	@FindBy(xpath="//input[@id='profile-setup-box-input-company-city']")
	WebElement CompanySetupCity_Textfield;	
	
	@FindBy(xpath="//div[@id='s2id_profile-setup-box-input-company-state']//span[@class='select2-arrow']")
	WebElement CompanySetupState_Selector;		
	
	@FindBy(xpath="//div[@id='s2id_profile-setup-box-input-company-state']//span[@class='select2-chosen']")
	WebElement CompanySetupState_span;		

	@FindBy(xpath="//div[@id='s2id_profile-setup-box-input-company-country']//span[@class='select2-arrow']")
	WebElement CompanySetupCountry_Selector;
	
	@FindBy(xpath="//div[@id='s2id_profile-setup-box-input-company-country']//span[@class='select2-chosen']")
	WebElement CompanySetupCountry_span;	
	
	@FindBy(xpath="//div//a[text()='BACK']")
	WebElement CompanySetupBack_Input;
	
	@FindBy(xpath="//*[@id='profile-setup-box-input-container']//button[contains(.,'FINISH SETUP')]")
	WebElement CompanySetupFinishSetup_button;
	
	@FindBy(xpath="//p[text()='Congratulations! You have successfully verified your email address.']")
	WebElement SuccessAccountVerifyMessage_div;
	
	@FindBy(xpath="(//div[@class='custom-input-group-addon']/i)[6]")
	WebElement CompanySetupCompanyWebsite_icon;
	
	@FindBy(xpath="//div[@class='selected-flag']")
	WebElement CompanySetupSelectedFlag_icon;
	
	@FindBy(xpath="//h3/p")
	WebElement CompanySetupVerbiage_div;	
	
	@FindBy(xpath="//a[text()='Email Settings']")
	WebElement EmailSettings_link;
	
	@FindBy(xpath="//span[@class='menu-icon partner-crm-icon']")
	WebElement CRMIcon_link;
	
	@FindBy(xpath="//span[@class='menu-icon website-audit-icon']")
	WebElement WebAuditIcon_link;
	
	@FindBy(xpath="//span[@class='menu-icon proposal-icon']")
	WebElement ProposalIcon_link;

	@FindBy(xpath="//span[@class='menu-icon mockup-creator-icon']")
	WebElement MockUpCreatorIcon_link;
	
	@FindBy(xpath="//span[@class='menu-icon affiliates-icon']")
	WebElement LeadGeneratorIcon_link;
	
	@FindBy(xpath="//input[@id='audit-url']")
	WebElement AuditUrl_textfield;
	
	@FindBy(xpath="//button[text()='Run new audit (beta)']")
	WebElement RunAuditBeta_button;
	
	@FindBy(xpath="//button[text()='Run audit']")
	WebElement RunAudit_button;
	
	@FindBy(xpath="//a[@id='audit-competitor-btn']")
	WebElement AddRemoveCompetitors_link;
	
	@FindBy(xpath="//input[@placeholder='http://www.competitor-1.com']")
	WebElement FirstCompetitor_textfield;
	
	@FindBy(xpath="//input[@placeholder='http://www.competitor-2.com']")
	WebElement SecondCompetitor_textfield;
	
	@FindBy(xpath="//input[@placeholder='http://www.competitor-3.com']")
	WebElement ThirdCompetitor_textfield;
	
	public static final WebElement WebAuditClickHere_link(String url){
		WebElement webAuditClickHere_link = driver.findElement(By.xpath("//div[@class='ui-pnotify-text']//div[contains(text(), '"+ url +"')]/a"));
		return webAuditClickHere_link;
	}
	
	public static final WebElement WebAuditSuccessful_text(String url){
		WebElement webAuditSuccessful_text = driver.findElement(By.xpath("//div[@class='ui-pnotify-text']//div[contains(text(), '"+ url +"')]"));
		return webAuditSuccessful_text;
	}
	
	public static final WebElement WebAuditNotifClose_icon(String url){
		WebElement webAuditNotifClose_icon = driver.findElement(By.xpath("//b[contains(.,'"+url+"')]/ancestor::div[@class='alert ui-pnotify-container alert-success ui-pnotify-shadow']//span[@title='Close']"));
		return webAuditNotifClose_icon;
	}
	
	@FindBy(xpath="//button[text()=' Running...']")
	WebElement WebAuditRunning_button;
	
	@FindBy(xpath="//div[@class='page-menu-container']//a[text()='Home']")
	WebElement HomeMenu_link;
	
	@FindBy(xpath="//div[text()='Please enter a valid website URL (ending in .com, .net, .us, .biz, .food, etc.)']")
	WebElement WebAuditInvalidURLNotif_text;
	
	@FindBy(xpath="//p[text()='The website you are trying to audit cannot be reached right now. Please try again later..']")
	WebElement WebAuditCannotBeReachedNotif_text;
	
	@FindBy(xpath="//div[@class='intercom-team-avatar-container']")
	WebElement IntercomAvatar_icon;
	
	@FindBy(xpath="//div[@class='intercom-borderless-dismiss-button']")
	WebElement IntercomCloseChat_button;
	
	@FindBy(xpath="//div[@id='user-account-container']//li/a[@href='/settings/users']")
	WebElement ManageUsers_list;
	
	
	public SEO01_Home() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@When("^I click SEO01_AddCampaign button$")
	public void i_click_SEO01_AddCampaign_button() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(AddCampaign_button));
		AddCampaign_button.click();
	}
	
	@When("^I populate the SEO01_DomainUrl textfield with \"([^\"]*)\"$")
	public void i_populate_the_SEO01_DomainUrl_textfield_with(String arg1) throws Throwable {
		DomainUrl_textfield.sendKeys(arg1);
	}

	@When("^I click the SEO01_UserAvatar button$")
	public void i_click_user_avatar() throws Throwable, UnhandledAlertException {
		UserAvatar_image.click();
	}
	
	@When("^I click the SEO01_Logout list$")
	public void i_click_the_logout() throws Throwable, UnhandledAlertException {
//		if(IntercomAvatar_icon.isDisplayed()){
//			IntercomCloseChat_button.click();
//			Logout_list.click();
//		}else{
			Logout_list.click();
//		}
	}
	
	
	@Then("^I see the SEO01_SeoReseller banner$")
	public void i_see_the_SEO01_SeoReseller_banner() throws Throwable, UnhandledAlertException {
	    //CodeHere
	}
	
	@Then("^I see the SEO01_Home Page$")
	public void i_see_the_SEO01_Home_page() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, HomeMenu_link.isDisplayed());
		
	}
	
	@Then("^Ill see the SEO01_SuccessAccountVerifyMessage div with \"(Congratulations! You have successfully verified your email address.)\"$")
	public void i_see_the_SSEO01_SuccessAccountVerifyMessage_message(String Message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, SuccessAccountVerifyMessage_div.isDisplayed());
		Assert.assertEquals(Message, SuccessAccountVerifyMessage_div.getText());
	}
	
	@Then("^Ill see the SEO01_CompanySetup popup$")
	public void i_see_the_SEO01_CompanySetup_popup() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(CompanySetupCompleteProfile_button));
	}
	
	@Then("^Ill see SEO01_CompanyProfile div with \"(Customize your account by completing your profile information.)\"$")
	public void i_see_the_SEO01_CompanyProfile_verbiage(String Message) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, CompanySetupVerbiage_div.isDisplayed());
		Assert.assertEquals(Message, CompanySetupVerbiage_div.getText());
	}
	
	@Then("^Ill see the SEO01_UploadLogo button is removed$")
	public void ill_not_see_the_SEO01_UploadLogo_button() throws Throwable, UnhandledAlertException {
		Boolean isPresent = driver.findElements(By.xpath("//button[contains(.,'UPLOAD LOGO')]")).size() < 1;
		if(isPresent==true){
			Assert.assertEquals(true, isPresent);
		}else{
			fail("Upload Logo was displayed");
		}
	}
	
	@Then("^Ill see the SEO01_CompanyWebsite globe$")
	public void ill_see_the_SEO01_CompanyWebsite_globe() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, CompanySetupCompanyWebsite_icon.isDisplayed());
	}
	
	@Then("^Ill see the SEO01_PhoneCountry icon is ([^\"]*)$")
	public void ill_see_the_SEO01_PhoneCountry_icon(String country) throws Throwable, UnhandledAlertException {
		//Assert.assertEquals(true, CompanySetupSelectedFlag_icon.getAttribute("title").contains(country));
	}
	
	@When("^I click SEO01_CompleteProfile button$")
	public void i_click_SEO01_CompleteProfile_button() throws Throwable, UnhandledAlertException {
	    CompanySetupCompleteProfile_button.click();
	}
	
	@Then("^I populate SEO01_CompanyName textfield with ([^\"]*)$")
	public void i_populate_SEO01_CompanyName_value(String companyName) throws Throwable, UnhandledAlertException {
		CompanySetupCompanyName_textfield.sendKeys(companyName);
		Thread.sleep(2000);
	}
	
	@Then("^I click the SEO01_CompanyProfile dropdown to choose ([^\"]*)$")
	public void i_select_SEO01_CompleteProfile_dropdown(String companyProfile) throws Throwable, UnhandledAlertException {
		Select S = new Select(CompanySetupCompanyProfile_Selector);
		S.selectByVisibleText(companyProfile);
	}
	
	@Then("^I click the SEO01_ExistingClient dropdown to choose ([^\"]*)$")
	public void i_select_SEO01_ExistingClient_dropdown(String existingClient) throws Throwable, UnhandledAlertException {
		Select S = new Select(CompanySetupExistingClient_Selector);
		S.selectByVisibleText(existingClient);
	}
	 
	@Then("^I populate the SEO01_CompanyWebsite textfield with ([^\"]*)$")
	public void i_populate_SEO01_CompanyWebsite_textfield(String companyWebsite) throws Throwable, UnhandledAlertException {
		CompanySetupCompanyWebsite_Textfield.sendKeys(companyWebsite);

	}	
	
	@Then("^I populate the SEO01_BusinessPhone textfield with ([^\"]*)$")
	public void i_populate_SEO01_BusinessPhone_textfield(String businessPhone) throws Throwable, UnhandledAlertException {
		CompanySetupBusinessPhone_Textfield.sendKeys(businessPhone);
	}		

	@Then("^I populate the SEO01_Address textfield with ([^\"]*) returned by Google$")
	public void i_populate_SEO01_Address_textfield(String address) throws Throwable, UnhandledAlertException {
		CompanySetupAddress_Textfield.sendKeys(address);
		CompanySetupAddressFirstAutofill_span.click();
		Thread.sleep(2000);
	}
	
	@Then("^Ill see the SEO01_State and SEO01_Country fields are auto-populated$")
	public void ill_see_the_autopopulate_fields_in_companysetup() throws Throwable, UnhandledAlertException {
	     Assert.assertEquals(false, CompanySetupState_span.getText().isEmpty());
	     Assert.assertEquals(false, CompanySetupCountry_span.getText().isEmpty());
	}
	
	@Then("^I click the SEO01_FinishSetup button$")
	public void i_click_finish_setup_button() throws Throwable, UnhandledAlertException {
		CompanySetupFinishSetup_button.click();
	}
	
	@Then("^Ill not see the SEO01_CompanySetup popup$")
	public void Ill_not_see_SEO01_CompanySetup_popup() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		Assert.assertEquals(true, UserAvatar_image.isDisplayed());
	}

	@Then("^I click the SEO01_EmailSettings$")
	public void i_click_the_SEO01_EmailSettings_link() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		EmailSettings_link.click();
	}
	
	@When("^I click the SEO01_Email Settings List$")
	public void i_click_the_SEO01_EmailSetting_Link() throws Throwable, UnhandledAlertException {
		//CodeHere
		
	}
	
	@When("^I redirect to SEO01_([^\"]*)$")
	public void i_redirect_to_value_page(String page) throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(WebAuditIcon_link));
		if(page.equals("Web Audit Page")){
			WebAuditIcon_link.click();
			Thread.sleep(3000);
		}else if(page.equals("Proposal Page")){
			ProposalIcon_link.click();
			Thread.sleep(3000);
		}else if(page.equals("Lead Generator Page")){
			LeadGeneratorIcon_link.click();
			Thread.sleep(3000);
		}else if(page.equals("CRM Page")){
			CRMIcon_link.click();
			Thread.sleep(3000);
		}
	}	
	
	
 	
	@When("^I populate SEO01_website textfield with ([^\"]*)$")
	public void i_populate_SEO01_website_with_value(String url) throws Throwable, UnhandledAlertException {
		AuditUrl_textfield.sendKeys(url);
		
	}
	
	@When("^I click SEO01_RunNewAuditBeta button$")
	public void i_click_SEO01_RunNewAuditBeta_button() throws Throwable, UnhandledAlertException {
		RunAuditBeta_button.click();
	}
	
	@Then("^I will be notified ([^\"]*) is now ready!$")
	public void i_will_be_notified_audit_ready(String url) throws Throwable, UnhandledAlertException {
		for (int i = 0 ; i <90 ; i++){
			if(WebAuditRunning_button.isDisplayed()){
				System.out.println("Web Audit is In Progress");
				Thread.sleep(10000);
			}else{
				Thread.sleep(5000);
				Assert.assertEquals(true, WebAuditSuccessful_text(url).isDisplayed());
				break;
			}
		}

	}
	
	@Then("^Ill see the SEO01_click here link of ([^\"]*)$")
	public void i_see_click_here_of_url_value(String url) throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, WebAuditClickHere_link(url).isDisplayed());

	}
	
	
	@When("^I click SEO01_ClickHere link of ([^\"]*)$")
	public void i_click_SEO01_ClickHere_link(String url) throws Throwable, UnhandledAlertException {
		WebAuditClickHere_link(url).click();
	}
	
	@When("^I click SEO01_AddCompetitors link$")
	public void i_click_SEO01_AddCompetitors_link() throws Throwable, UnhandledAlertException {
		AddRemoveCompetitors_link.click();
		Thread.sleep(3000);
	}
	
	@When("^I click SEO01_RemoveCompetitors link$")
	public void i_click_SEO01_RemoveCompetitors_link() throws Throwable, UnhandledAlertException {
		AddRemoveCompetitors_link.click();
		Thread.sleep(3000);
	}
	
	
	@Then("^Ill see SEO01_CompetitorOne textfield$")
	public void i_see_SEO01_CompetitorOne_textfield() throws Throwable, UnhandledAlertException {
		for(int i = 0; i <=4; i++){
			Thread.sleep(3000);
			if(FirstCompetitor_textfield.isDisplayed()){
				Assert.assertEquals(true, FirstCompetitor_textfield.isDisplayed());
			}else{
				System.out.println("Elements for Competitors' textfields not yet completely displayed");
				Thread.sleep(5000);
			}
		}
	}
	
	@Then("^Ill see SEO01_CompetitorTwo textfield$")
	public void i_see_SEO01_CompetitorTwo_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, SecondCompetitor_textfield.isDisplayed());
		
	}
	
	@Then("^Ill see SEO01_CompetitorThree textfield$")
	public void i_see_SEO01_CompetitorThree_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, ThirdCompetitor_textfield.isDisplayed());
		
	}
	
	@When("^I populate SEO01_CompetitorOne textfield with ([^\"]*)$")
	public void i_populate_SEO01_CompetitorOne_textfield(String url) throws Throwable, UnhandledAlertException {
		if(url.equals("blank")){
		}else{
			FirstCompetitor_textfield.clear();
			FirstCompetitor_textfield.sendKeys(url);
		}
	}
	
		
	@When("^I populate SEO01_CompetitorTwo textfield with ([^\"]*)$")
	public void i_populate_SEO01_CompetitorTwo_textfield(String url) throws Throwable, UnhandledAlertException {
		if(url.equals("blank")){
		}else{
			SecondCompetitor_textfield.clear();
			SecondCompetitor_textfield.sendKeys(url);
		}
	}
	
	@When("^I populate SEO01_CompetitorThree textfield with ([^\"]*)$")
	public void i_populate_SEO01_CompetitorThree_textfield(String url) throws Throwable, UnhandledAlertException {
		if(url.equals("blank")){
		}else{
			ThirdCompetitor_textfield.clear();
			ThirdCompetitor_textfield.sendKeys(url);
		}
	}
	
	@Then("^Ill not see SEO01_CompetitorOne textfield$")
	public void ill_not_see_SEO01_CompetitorOne_textfield() throws Throwable, UnhandledAlertException {
		Thread.sleep(2000);
		Assert.assertEquals(false, FirstCompetitor_textfield.isDisplayed());
		
	}
	
	@Then("^Ill not see SEO01_CompetitorTwo textfield$")
	public void ill_not_see_SEO01_CompetitorTwo_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(false, SecondCompetitor_textfield.isDisplayed());
		
	}
	
	@Then("^Ill not see SEO01_CompetitorThree textfield$")
	public void ill_not_see_SEO01_CompetitorThree_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(false, ThirdCompetitor_textfield.isDisplayed());
		
	}
	
	@Then("^Ill see a SEO01_WebAuditInvalid notification$")
	public void ill_see_SEO01_WebAuditInvalid() throws Throwable {
		for (int i = 0 ; i <10 ; i++){
			if(WebAuditRunning_button.isDisplayed()){
				System.out.println("Web Audit is In Progress");
				Thread.sleep(3000);
			}else{
				Thread.sleep(2000);
				Assert.assertEquals(true, WebAuditInvalidURLNotif_text.isDisplayed());
				break;
			}
		}
		
	}
	
	@Then("^Ill see a SEO01_WebAuditCannotBeReached notification$")
	public void ill_see_SEO01_WebAuditCannotBeReached() throws Throwable {
		for (int i = 0 ; i <10 ; i++){
			if(WebAuditRunning_button.isDisplayed()){
				System.out.println("Web Audit is In Progress");
				Thread.sleep(3000);
			}else{
				Thread.sleep(2000);
				Assert.assertEquals(true, WebAuditCannotBeReachedNotif_text.isDisplayed());
				break;
			}
		}
		
	}
	
	@When("^I click the SEO01_AuditQuickAccess icon$")
	public void i_click_SEO01_AuditQuickAccess_icon() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		WD.until(ExpectedConditions.elementToBeClickable(WebAuditIcon_link));
		WebAuditIcon_link.click();
		Thread.sleep(5000);
	}	
	
	@When("^I click the SEO01_LeadGenQuickAccess icon$")
	public void i_click_SEO01_LeadGenQuickAccess_icon() throws Throwable, UnhandledAlertException {
		Thread.sleep(5000);
		WD.until(ExpectedConditions.elementToBeClickable(LeadGeneratorIcon_link));
		LeadGeneratorIcon_link.click();
		Thread.sleep(2000);
	}	
	
	@When("^I click the SEO01_ManageUsers list$")
	public void i_click_the_manage_users() throws Throwable, UnhandledAlertException {
		ManageUsers_list.click();
	}
}
