package webApp.Seoreseller;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;
import cucumber.api.java.en.Then;

public class SEO13_WebAuditsAuditidPreview extends WEBHelper{
	
	@FindBy(xpath="//h2[text()='Technical Audit']")
	WebElement TechnicalAudit_header;
	
	@FindBy(xpath="//div[@class='main-title'][contains(.,'Website Audit')]")
	WebElement WebsiteAudit_header;
	
	public static final WebElement CompetitorBar_text(String url){
		WebElement competitorBar_text = driver.findElement(By.xpath("//div[@id='executive-summary-page']//div[@class='competitors-body']//div[text()='"+url+"']"));
		return competitorBar_text;
	}

	public SEO13_WebAuditsAuditidPreview() {
		PageFactory.initElements(driver, this);
	}
	
	@Then("^Ill be redirected to Web Audit Report Preview$")
	public void i_redirect_to_web_audit_report() throws Throwable, UnhandledAlertException {
		ReUsablesKeyword.switchToLatestTab();
		Thread.sleep(3000);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(true, currentUrl.contains("webaudits"));
		Assert.assertEquals(true, currentUrl.contains("preview"));
		
	}
	
	
	@Then("^Ill be redirected to SEO13_OldWebAuditReport Preview$")
	public void i_redirect_to_old_web_audit_report() throws Throwable, UnhandledAlertException {
		ReUsablesKeyword.switchToLatestTab();
		Thread.sleep(3000);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(true, currentUrl.contains("webaudits"));
		Assert.assertEquals(true, currentUrl.contains("preview"));
		
	}
	
	@Then("^Ill see the SEO13_Audit report$")
	public void ill_see_audit_report(){
			Assert.assertEquals(true, TechnicalAudit_header.isDisplayed());
	}
	@Then("^Ill see the Old SEO13_Audit report$")
	public void ill_see_old_audit_report(){
			Assert.assertEquals(true, WebsiteAudit_header.isDisplayed());
	}
	
	@Then("^Ill see Competitor ([^\"]*)$")
	public void ill_see_audit_report(String url){
			if(url.equals("blank")){
				
			}else{
				Assert.assertEquals(true, CompetitorBar_text(url).isDisplayed());
			}
	}
}
