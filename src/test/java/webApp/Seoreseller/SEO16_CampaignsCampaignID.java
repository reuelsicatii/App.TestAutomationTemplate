package webApp.Seoreseller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By; 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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

public class SEO16_CampaignsCampaignID extends WEBHelper{
	
	@FindBy(xpath="//input[@id='location']")
	WebElement Campaign_link;
	
	public static final WebElement Campaign_link(String campaign){
		WebElement SelectedtCountry = driver.findElement(By.xpath("//div[@class='breadcrumb-ui']//a[text()= '"+campaign+"']"));
		return SelectedtCountry;
	}
	
	
	@Then("^Ill be redirected to SEO16_([^\\\"]*) page$")
	public void ill_be_redirected_to_value_page(String campaign) throws Throwable {
		Assert.assertEquals(true, Campaign_link(campaign).isDisplayed());
	}
	
	
	
}
