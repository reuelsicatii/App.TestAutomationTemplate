package webApi.Sheets;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class GoogleSheet {
	
	

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = System.getProperty("user.dir") + "\\Data\\webApi.Google\\Tokens";
    private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS,SheetsScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = System.getProperty("user.dir") + "\\Data\\webApi.Google\\Credentials.json";


    public static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
    	System.out.println("TOKENS_DIRECTORY_PATH: "+ TOKENS_DIRECTORY_PATH);
    	System.out.println("CREDENTIALS_FILE_PATH: "+ CREDENTIALS_FILE_PATH);
    	File jsonfile = new File(CREDENTIALS_FILE_PATH);
    	//InputStream in = GoogleSheet.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
    	InputStream in = new FileInputStream(jsonfile);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        //========================================================
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }
	
	
	
    public static Sheets connectSheet() throws GeneralSecurityException, IOException
    {
    	final String APPLICATION_NAME = "GoogleSheet";
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();      
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
    
    
    public static void appendSheet(Sheets sheets, String spreadsheetId, String range, List<List<Object>> values)
    {
        	try {
        	
            ValueRange body = new ValueRange()
                    .setValues(values);
            AppendValuesResponse result =
            		sheets.spreadsheets().values().append(spreadsheetId, range, body)
                            .setValueInputOption("USER_ENTERED")
                            .execute();
            
            System.out.printf("%d cells updated.", result.getUpdates().getUpdatedCells());
			
        	} catch (Exception e) {
			System.out.println(e);
        	}
    }
	

}
