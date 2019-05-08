package webApp.Compass;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class COM25_TaskProjectViewTabarticle extends WEBHelper{

	@FindBy(xpath="//input[@placeholder='Title...']")
	WebElement ArticleTitle_textfield;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr']")
	WebElement ArticleBody_textarea;
	
	@FindBy(xpath="//a[@class='cke_button cke_button__save_article  cke_button_off']")
	WebElement ArticleSave_button;
	
	@FindBy(xpath="//input[@name='meta[title]']")
	WebElement SEOtitle_textfield;
	
	@FindBy(xpath="//textarea[@name='meta[description]']")
	WebElement MetaDescription_textarea;
	
	@FindBy(xpath="//input[@name='article[tags]']")
	WebElement Tags_textfield;
	
	@FindBy(xpath="//a[text()='Compose Article']")
	WebElement ComposeArticle_link;
	
	@FindBy(xpath="//p[text()='The article was saved successfully!']")
	WebElement ArticleSuccessfullySaveMessage_text;
	
	@FindBy(xpath="//p[text()='The article was saved successfully!']/ancestor::div[@class='modal-content']//button[text()='OK']")
	WebElement ArticleSuccessfullyOk_button;
	
	@FindBy(xpath="//a[text()='Review Article']")
	WebElement ReviewArticle_link;
	
	@FindBy(xpath="//button[@class='btn btn-sm btn-default editor-approve']")
	WebElement EditorApproveArticle_buton;
	
	@FindBy(xpath="//button[@class='btn btn-sm btn-danger editor-approve']")
	WebElement EditorRejectArticle_buton;
	
	@FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
	WebElement ArticleTextArea_iframe;
	
	@FindBy(xpath="//a[text()='Post Article']")
	WebElement PostArticle_link;

	public COM25_TaskProjectViewTabarticle() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@Then("I will be able to see the COM25_ComposeArticle Tab")
	public void i_will_see_compose_article_tab() throws InterruptedException{
		Assert.assertEquals(true, ComposeArticle_link.isDisplayed());
	}
	
	@When("I click the COM25_ComposeArticle Tab")
	public void i_click_compose_article_tab() throws InterruptedException{
		ComposeArticle_link.click();
	}
	
	
	@When("I populate COM25_ArticleTitle textfield with \"([^\"]*)\"")
	public void i_populate_article_title_with_value(String articleTitle) throws InterruptedException{
		ArticleTitle_textfield.clear();
		ArticleTitle_textfield.sendKeys(articleTitle);
	}
	
	@When("I populate COM25_ArticleBody textarea with \"([^\"]*)\"")
	public void i_populate_article_body_with_value(String articleBody) throws InterruptedException{
    	driver.switchTo().frame(ArticleTextArea_iframe);
		ArticleBody_textarea.clear();
		ArticleBody_textarea.sendKeys(articleBody);
    	driver.switchTo().defaultContent();
	}
	
	
	@When("I click the COM25_ArticleSave button")
	public void i_click_article_save_button() throws InterruptedException{
		ArticleSave_button.click();
	}
	
	@Then("Ill see the COM25_SuccessfulSaveModal Message")
	public void i_see_successful_save_message_modal() throws InterruptedException{
		Thread.sleep(3000);
		Assert.assertEquals(true, ArticleSuccessfullySaveMessage_text.isDisplayed());

	}
	
	@When("I click COM25_SuccessfulSaveModalOk button")
	public void i_click_article_modal_ok_button() throws InterruptedException{
		ArticleSuccessfullyOk_button.click();
	}
	
	
	@Then("I will be able to see the COM25_ReviewArticle Tab")
	public void ill_see_the_review_article_tab() throws InterruptedException{
		Assert.assertEquals(true, ReviewArticle_link.isDisplayed());

	}
	
	
	@When("I click the COM25_ReviewArticle Tab")
	public void i_click_the_review_article_tab() throws InterruptedException{
		ReviewArticle_link.click();

	}
	
	@Then("Ill see the COM25_ApproveArticle button")
	public void ill_see_approve_article_button() throws InterruptedException{
		Assert.assertEquals(true, EditorApproveArticle_buton.isDisplayed());


	}
	
	@Then("Ill see the COM25_RejectArticle button")
	public void ill_see_reject_article_button() throws InterruptedException{
		Assert.assertEquals(true, EditorRejectArticle_buton.isDisplayed());
	}
	
	
	@When("I click the COM25_ApproveArticle Tab")
	public void i_click_approve_article_button() throws InterruptedException{
		EditorApproveArticle_buton.click();

	}
	

	@When("I click the COM25_PostArticle Tab")
	public void i_click_the_post_article_tab() throws InterruptedException{
		PostArticle_link.click();

	}
	
	@Then("I will be able to see the COM25_PostArticle Tab")
	public void ill_see_the_post_article_tab() throws InterruptedException{
		PostArticle_link.click();
		Assert.assertEquals(true, PostArticle_link.isDisplayed());

	}
	
	
}
