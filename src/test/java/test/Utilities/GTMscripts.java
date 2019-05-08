package test.Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.Framework.*;

public class GTMscripts extends WEBHelper{
	String pageUrl;
	String logger;
	public ExtentReports extent;
	public ExtentTest test ;
	
	Date date = new Date();
	SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
	String timeStamp = sdf.format(date);
	
	String HS="(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':\n"
					+"new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],\n"
					+"j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=\n"
					+"'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);\n"
					+"})(window,document,'script','dataLayer','GTM-TGSC38');";
	
	String headScript=HS.replaceAll("\\s","");
	String BS="<iframe src=\"//www.googletagmanager.com/ns.html?id=GTM-TGSC38\" height=\"0\" width=\"0\" style=\"display:none;visibility:hidden\"></iframe>";
	
	String Bodyscript=BS.replaceAll("\\s","");
	
		public GTMscripts()
		{
			 extent = new ExtentReports("target/GTM_Valid_"+timeStamp.replaceAll("[^\\w]", "_")+".html", true);
		}
	
	
	
	@Test
	public void GTMURLSValidations() throws Exception
	 {
		log.info("GTM header script :"+headScript);
		
		
		  String FILENAME="Data/GTM.txt";
			FileReader fr = new FileReader(FILENAME);
			BufferedReader br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));
			while ((sCurrentLine = br.readLine()) != null) {
				log.info("GTM Validation started for ::"+sCurrentLine.trim());
				GTMvalidation(sCurrentLine.trim(),extent);
				log.info("GTM Validation Completed for ::"+sCurrentLine.trim());
		}
		
			br=null;
			fr=null;
			
			extent.flush(); 
	 }
	
	
	
	public void GTMvalidation(String URL,ExtentReports extent) throws Exception
	{
		pageUrl=URL;
		int temp = 0;
		//System.out.println(Title);
		 log.info("GTM Validation started for URl ::"+URL);
		 test = extent.startTest("GTM_Validation("+URL+")", URL);
		 test.log(LogStatus.INFO, "GTM Validation started for URl ::"+URL);
		 WebDriver driver = new FirefoxDriver(); 
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			WebDriverWait W=new WebDriverWait(driver, 120);
		 driver.get(URL);	
		 try{
		 W.until(ExpectedConditions.attributeContains(driver.findElement(By.tagName("html")), "innerHTML", "GTM-TGSC38"));
		 
		 }
		 catch(Exception e){
			 test.log(LogStatus.FAIL, "GTM-TGSC38 TAG is not avilable in URl :" + URL);
				log.fatal("GTM-TGSC38 TAG is not avilable in URl" + URL);
		 }
				 
		  
		  
		  //Header script Validation
		  
		  if(driver.findElements(By.xpath("/html/head/script[contains(.,'GTM-TGSC38')]")).size()==1)
			{
				String Script=driver.findElement(By.xpath("/html/head/script[contains(., 'GTM-TGSC38')]")).getAttribute("innerHTML");
				
				
				if(Script.replaceAll("\\s","").equalsIgnoreCase(headScript))
				{
					test.log(LogStatus.PASS, "Header script is avilable under header tag");
    				log.info("Header script is avilable under header tag");
				}
				
				else 
    			{
					test.log(LogStatus.FAIL, "Header script is not avilable  under header tag");
					log.error("Header script is not avilable  under header tag");
    				
    			}
			}
		  
		  else
		  {
			  test.log(LogStatus.FAIL, "Header script is not avilable in Header tag :" + URL);
				log.fatal("Header script is not avilable in Header tag :" + URL);
		  }
				  
		  
	   				        		
//Body Script Validation
		  
		  
		  if(driver.findElements(By.xpath("/html/body/noscript[contains(.,'www.googletagmanager.com/ns.html?id=GTM-TGSC38')]")).size()==1)
			{
				String Script=driver.findElement(By.xpath("/html/body/noscript[contains(.,'www.googletagmanager.com/ns.html?id=GTM-TGSC38')]")).getAttribute("innerHTML");
				
				
				if(Script.replaceAll("\\s","").equalsIgnoreCase(Bodyscript))
				{
					test.log(LogStatus.PASS, "Body script is avilable under body tag");
    				log.info("Body script is avilable under body tag");
				}
				
				else 
    			{
					test.log(LogStatus.FAIL, "Body script is not avilable  under body tag");
					log.error("Body script is not avilable  under body tag");
    				
    			}
			}
		 
		  else
		  {
			  test.log(LogStatus.FAIL, "Body script is not avilable under Body tag :" + URL);
				log.fatal("Body script is not avilable under Body tag :" + URL);
		  }
			
		 
		 
		
		  extent.endTest(test);
		  driver.quit(); 
		  test.log(LogStatus.INFO, "GTM Validation Ended for URl ::"+URL);
	}
	
	
	 
}
