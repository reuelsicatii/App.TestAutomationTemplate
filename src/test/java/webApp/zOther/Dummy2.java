package webApp.zOther;



import cucumber.Framework.WEBHelper;
import cucumber.Framework.SetUp;
import cucumber.api.Scenario;
import cucumber.api.java.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import com.google.gson.JsonArray;
import com.jayway.jsonpath.JsonPath;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;;



public class Dummy2 extends WEBHelper{

	
	@Test
	public void test() throws Exception 
	{
		
		if(SetUp.getScenarioName().toString().contains("COMSMOKETEST_TS04"))
		{

			CallAPI("http://dev.app.compass/tests/delete_test_automation_data");
			
		}

	}

}
