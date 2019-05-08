package cucumber.Framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;




public class TearDown extends WEBHelper {
	
	
	//public static Scenario scenario;

	@After
	public void teardown(Scenario scenario) throws IOException 
	{
		
		if (scenario.isFailed()) 
		{	
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmssa");
			String timeStamp = sdf.format(date);
			String filename = System.getProperty("user.dir") + "\\target\\screenshots\\" + scenario.getName() + "_" + timeStamp + ".png";
			
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(filename));
		    //scenario.embed(screenshot, System.getProperty("user.dir") + "image/png");		      
		    log.warn("Execution got failed for " + scenario.getName() +" and screenshot got save to " + filename);  

		 }	
		
		log.info("Execution is ended from First Runner Test - After Annotation");
		driver.quit();
		
		CloseDriverObject();
		
		log.info("Execution Completed and Browser was quit");	
	    driver=null;
	}

	
	
}
