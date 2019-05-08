package webApp.YellowPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;

public class YP01_SearchResult extends WEBHelper {

	public static final WebElement BusinessName_text(String businessName) {
		WebElement businessName_text = driver.findElement(
				By.xpath("//div[@class='search-results organic']//span[contains(text(),'" + businessName + "')]"));
		return businessName_text;
	}

	public static final WebElement BusinessStreetAddress_text(String businessName) {
		WebElement businessStreetAddress_text = driver.findElement(By.xpath("//span[contains(text(),'" + businessName
				+ "')]//ancestor::div[@class='info']//span[@class='street-address']"));
		return businessStreetAddress_text;
	}

	public static final WebElement BusinessLocality_text(String businessName) {
		WebElement businessLocality_text = driver.findElement(By.xpath(
				"//span[contains(text(),'" + businessName + "')]//ancestor::div[@class='info']//span[@class='locality']"));
		return businessLocality_text;
	}

	public static final WebElement BusinessWebsite_link(String businessName) {
		WebElement businessWebsite_link = driver.findElement(By.xpath("//span[contains(text(),'" + businessName
				+ "')]//ancestor::div[@class='info']//a[@class='track-visit-website']"));
		return businessWebsite_link;
	}

	public static final WebElement BusinessPrimaryPhone_text(String businessName) {
		WebElement businessWebsite_link = driver.findElement(By.xpath("//span[contains(text(),'" + businessName
				+ "')]//ancestor::div[@class='info']//div[@class='phones phone primary']"));
		return businessWebsite_link;
	}

	public YP01_SearchResult() {
		PageFactory.initElements(driver, this);

	}

}
