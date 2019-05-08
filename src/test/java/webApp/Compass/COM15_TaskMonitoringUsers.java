package webApp.Compass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import cucumber.Framework.WEBHelper;

public class COM15_TaskMonitoringUsers extends WEBHelper{
	
	
	public static final WebElement UserInfoCircle_link(String keyword){
		WebElement userInfoCircle_link = driver.findElement(By.xpath("//td[contains(.,'"+keyword+"')]/..//a[@class='fa fa-info-circle']"));
		return userInfoCircle_link;
	}
	
		
	public COM15_TaskMonitoringUsers() {
		PageFactory.initElements(driver, this);
	}
	
	
	

	
	


}
