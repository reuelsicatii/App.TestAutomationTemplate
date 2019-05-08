package test.Runner;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import com.jayway.jsonpath.JsonPath;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.api.services.sheets.v4.Sheets;
import cucumber.Framework.*;
import cucumber.api.junit.Cucumber;
import webApi.Sheets.GoogleSheet;
@RunWith(Cucumber.class)

public class R9_GSTestReport {
	
	@AfterClass
	public static void main() throws Exception 
	{
		File jsonfile = new File(System.getProperty("user.dir") + "\\Data\\webApi.Google\\GSTestReport.json");
		List<String> filenames = JsonPath.read(jsonfile, "$..filename");
		String [] filename = filenames.toArray(new String[filenames.size()]);
		List<String> ranges = JsonPath.read(jsonfile, "$..range");
		String [] range = ranges.toArray(new String[ranges.size()]);
		
	     for (int i = 0; i < range.length; i++) 
	     {
	    	 try {
	    		 createGSTestReport(filename[i],range[i]);	
				
			} catch (Exception e) {
				System.out.println("File not Found. Moving to the next file.");
			}
	    	 	
	     }
		
		
	}
	
	public static void createGSTestReport(String filename, String range) throws Exception 
	{		
		
		// Retrieve Data 
        //===================================================
		File jsonfile = new File(System.getProperty("user.dir") + "\\target\\JSON\\" + filename + ".json");
		List<Object> statuses = JsonPath.read(jsonfile, "$..after..status");
		List<Object> TestSuite = JsonPath.read(jsonfile, "$..name");
		System.out.println("TestSuite: " + TestSuite.get(0).toString());
		String [] status = statuses.toArray(new String[statuses.size()]);


        // Create Data
        //===================================================        
		List<Object> valuesX = new ArrayList<Object>();
		valuesX.add(0, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        for (String str : status) 
        {
        	valuesX.add(str.equalsIgnoreCase("passed") ? status[0].replace("passed", "1") : "0");
			
		}   
        
        List<List<Object>> valuesXY = Arrays.asList(valuesX);        
       
		
		//Retrieve SpreadSheetID
        //===================================================
        String spreadsheetId = null;
		if (WEBHelper.GetPropertValue("Data/TestProperties.xml","TestEnv").equalsIgnoreCase("PRD")) 
			{
			spreadsheetId = "1kRZ2UiQ79MIekcBavePjfrNkVFvm2jUKKTZ2VLEkEjg";
			} 
		
		else if (WEBHelper.GetPropertValue("Data/TestProperties.xml","TestEnv").equalsIgnoreCase("STG")) 
			{
			spreadsheetId = "1Gn5aVUoSIGBwbsXfNanwGVikqu8iwbGnopFcJePjFwI";
			}	
		else if (WEBHelper.GetPropertValue("Data/TestProperties.xml","TestEnv").equalsIgnoreCase("DEV")) 
		{
			spreadsheetId = "1b14DTN3iFvnzTCdVvceoPyUq0cASgsD4VViQNqG0544";
		}
		else 
		{
				System.out.println("No Equivalent GoogleSheet - Range");
		}

        // Pushed Data to GoogleSheet
        //===================================================
        //final String spreadsheetId = "1kRZ2UiQ79MIekcBavePjfrNkVFvm2jUKKTZ2VLEkEjg";	
        Sheets sheets = GoogleSheet.connectSheet();
        try {
        	GoogleSheet.appendSheet(sheets, spreadsheetId, range, valuesXY);	
		} catch (Exception e) {
			System.out.println("Either <filename>.json or Googheetsheet tab is not found");
			e.printStackTrace();
			System.out.println(e);
		}    		
		  
	}	
}


