package webApp.Seoreseller;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SEO22_SettingsUsers extends WEBHelper{
	@FindBy(xpath="//h3[text()='Manage Users']")
	WebElement ManageUsers_header;
	
	@FindBy(xpath="//button[text()='Add New User']")
	WebElement AddNewUser_button;
	
	@FindBy(xpath="//h4[text()='Add New User']")
	WebElement AddNewUserModal_header;
	
	@FindBy(xpath="//input[@id='user_email']")
	WebElement Email_textfield;
	
	@FindBy(xpath="//input[@id='user_username']")
	WebElement Username_textfield;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password_textfield;
	
	@FindBy(xpath="//select[@id='user_role']")
	WebElement Role_dropdown;
	
	@FindBy(xpath="//input[@id='password']/preceding-sibling::i")
	WebElement PasswordToggle_icon;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement Save_button;
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement Close_button;
	
	@FindBy(xpath="//div[@class='modal-header']/button")
	WebElement AddNewUserModalX_button;

	@FindBy(xpath="//div[text()='This Email is already in use.']")
	WebElement EmailAlreadyUsed_text;
	
	@FindBy(xpath="//div[text()='The Username field must contain a unique value.']")
	WebElement UsernameFieldMustBeUnique_text;
	
	@FindBy(xpath="//div[text()='The Password field must be at least 8 characters in length.']")
	WebElement PasswordMustBeAtleast8chars_text;
	
	@FindBy(xpath="//h4[text()='Delete User']")
	WebElement DeleteUser_header;
	
	@FindBy(xpath="//button[text()='Yes']")
	WebElement Yes_button;
	
	@FindBy(xpath="//button[text()='No']")
	WebElement No_button;
	
	@FindBy(xpath="//div[text()='Are you sure you want to delete this user?']")
	WebElement AreYouSureYouWantToDeleteUser_text;
	
	@FindBy(xpath="(//a[@title='Delete User'])[1]")
	WebElement FirstDeleteUser_button;
	
	public static final WebElement EditIconOfSpecificUser(String email){
		WebElement editIconOfSpecificUser = driver.findElement(By.xpath("//a[text()='"+email+"']/ancestor::tr//a[@alt='Edit User']"));
		return editIconOfSpecificUser;
	}
	
	
	public SEO22_SettingsUsers() {
		PageFactory.initElements(driver, this);
	}
	
	
	@Then("^Ill be able to see the SEO22_ManageUsers Page")
	public void ill_see_manage_users_page() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(AddNewUser_button));
 		Assert.assertEquals(true, ManageUsers_header.isDisplayed());
	}
	
	
	@When("^I click the SEO22_AddNewUser button")
	public void i_click_add_new_user_button() throws Throwable, UnhandledAlertException {
		AddNewUser_button.click();
	}
	
	@Then("^Ill see the SEO22_AddNewUser Modal")
	public void i_see_add_new_user_modal() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Save_button));
		Assert.assertEquals(true, AddNewUserModal_header.isDisplayed());

	}
	
	@Then("^Ill see the SEO22_EmailAddress textfield")
	public void i_see_email_address_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Email_textfield.isDisplayed());
		
	}
	
	@Then("^Ill see the SEO22_Username textfield")
	public void i_see_username_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Username_textfield.isDisplayed());
	}
	
	
	@Then("^Ill see the SEO22_Role dropdown")
	public void i_see_role_dropdown() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Role_dropdown.isDisplayed());
		
	}
	
	@Then("^Ill see the SEO22_Password textfield")
	public void i_see_password_textfield() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Password_textfield.isDisplayed());

	}
	
	@Then("^Ill see that the Password textfield contains a SEO22_Toggle icon")
	public void ill_see_password_textfield_with_toggle_icon() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, PasswordToggle_icon.isDisplayed());
	}
	
	@Then("^Ill see the SEO22_Save button")
	public void ill_see_save_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Save_button.isDisplayed());

	}
	
	@Then("^Ill see the SEO22_Close button")
	public void ill_see_close_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Close_button.isDisplayed());

	}
	
	@Then("^Ill see the SEO22_Xclose button of Add New User Modal")
	public void ill_see_x_button_of_add_new_user_modal() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		if(driver.findElements(By.xpath("//div[@class='modal-header']/button")).size()!= 0){
			Assert.assertTrue(true);
		}else{
			Assert.fail();
		}

	}
	
	@When("^I populate SEO22_EmailAddress textfield with ([^\"]*)")
	public void i_populate_email_address_textfield_with_value(String email) throws Throwable, UnhandledAlertException {
		String[] emailParts = email.split("@");
		String finalString = emailParts[0]+"+"+dateNoMin+"@"+emailParts[1];
		Email_textfield.sendKeys(finalString);	
	}
	
	@When("^I enter SEO22_EmailAddress textfield with an existing email ([^\"]*)")
	public void i_enter_email_address_textfield_with_existing_email_value(String email) throws Throwable, UnhandledAlertException {
		Email_textfield.sendKeys(email);	
	}
	
	
	@When("^I populate SEO22_Username textfield with ([^\"]*)")
	public void i_populate_username_textfield_with_value(String username) throws Throwable, UnhandledAlertException {
		Username_textfield.sendKeys(username+dateNoSpace);
		
	}
	
	@When("^I enter SEO22_Username textfield with an existing user ([^\"]*)")
	public void i_enter_username_textfield_with_existing_user(String username) throws Throwable, UnhandledAlertException {
		Username_textfield.sendKeys(username);
	}
	
	@When("^I select ([^\"]*) in SEO22_Role dropdown")
	public void i_select_role_value_under_role_dropwdown(String role) throws Throwable, UnhandledAlertException {
		SelectByVisibleText(Role_dropdown, role);
		
	}
	
	@When("^I populate SEO22_Password textfield with ([^\"]*)")
	public void i_populate_password_textfield_with_value(String password) throws Throwable, UnhandledAlertException {
		Password_textfield.sendKeys(password);
		
	}
	
	@When("^I click the SEO22_Save button")
	public void i_click_save_button() throws Throwable, UnhandledAlertException {
		Save_button.click();
		
	}
	
	@Then("^Ill see the SEO22_EmailAlreadyUsed 'This Email is already in use.' text")
	public void ill_see_email_already_used_text() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Save_button));
		Assert.assertEquals(true, EmailAlreadyUsed_text.isDisplayed());
	}
	
	@Then("^Ill see the SEO22_UsernamMustBeUnique 'The Username field must contain a unique value.' text")
	public void ill_see_username_must_contain_unique_text() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Save_button));
		Assert.assertEquals(true, UsernameFieldMustBeUnique_text.isDisplayed());
	}
	
	
	@Then("^Ill see the SEO22_UsernamMustBeUnique 'The Password field must be at least 8 characters in length.' text")
	public void ill_see_atleast_8_character_in_length_text() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Save_button));
		Assert.assertEquals(true, PasswordMustBeAtleast8chars_text.isDisplayed());
	}
	
	
	@Then("^Ill see the SEO22_DeleteUser Modal")
	public void i_see_delete_user_modal() throws Throwable, UnhandledAlertException {
		WD.until(ExpectedConditions.elementToBeClickable(Yes_button));
		Assert.assertEquals(true, DeleteUser_header.isDisplayed());

	}
	
	@Then("^Ill see the SEO22_Yes button")
	public void ill_see_yes_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, Yes_button.isDisplayed());

	}
	
	@Then("^Ill see the SEO22_No button")
	public void ill_see_no_button() throws Throwable, UnhandledAlertException {
		Assert.assertEquals(true, No_button.isDisplayed());

	}
	
	
	@Then("^Ill see the SEO22_Xclose button of Delete User Modal")
	public void ill_see_x_button_of_delete_user_modal() throws Throwable, UnhandledAlertException {
		Thread.sleep(3000);
		if(driver.findElements(By.xpath("//div[@class='modal-header']/button")).size()!= 0){
			Assert.assertTrue(true);
		}else{
			Assert.fail();
		}

	}
	
	
	@Then("^Ill see the SEO22_Confirmation 'Are you sure you want to delete this user' text")
	public void i_see_are_you_sure_you_want_to_delete_text(){
		Assert.assertEquals(true, AreYouSureYouWantToDeleteUser_text.isDisplayed());

	}
	
	@When("^I click the first SEO22_DeleteUser button")
	public void i_click_theA_first_delete_user_button() throws Throwable, UnhandledAlertException {
		FirstDeleteUser_button.click();
		
	}
	

	@When("^I click the SEO22_Edit button of ([^\"]*)")
	public void i_click_edit_icon_of_user_value(String email) throws Throwable, UnhandledAlertException {
		EditIconOfSpecificUser(email).click();		
	}
	
}
