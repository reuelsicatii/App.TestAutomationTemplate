package test.Utilities;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import cucumber.Framework.WEBHelper;
import cucumber.Framework.SetUp;

public class QueryDatabase extends WEBHelper{
	
	static Connection connection = null;
	static PreparedStatement prepStatement = null;
	static Statement statement = null;

	
	public static void ConnectionBuildUp() throws Throwable {
		System.out.println("-------- DB Connection Build Up will now start ------------");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No MySQL JDBC Driver was availabe");
			e.printStackTrace();
			return;
		}
		
		try {
			
			switch (GetTestEnv())
			{		
				case "DEV": 
					connection = DriverManager
					.getConnection("jdbc:mysql://10.10.3.32:3306/development_central","dev", "Qaz123123!"); 
		        break;
				
				case "STG":  
				connection = DriverManager
				.getConnection("jdbc:mysql://10.10.3.196:3306/staging_central","weng", "weng12345");
				break;
				
				case "PRD": 
					//Credentials below is not allowed to DELETE
					connection = DriverManager
					.getConnection("jdbc:mysql://10.10.2.219:3306/prod_central","reuel", "reuel123");
		        break;
				
				default: 
					System.out.println("TestEnv not recognize:" + GetTestEnv());
					log.info("TestEnv not recognize:" + GetTestEnv());
				break;
			
			}
			

		} catch (SQLException e) {
			System.out.println("Failed to make connection!");
			e.printStackTrace();
			return;
		}
		
	}
	
	public static String ReturnSpecificData (String Query, String identifier) throws Throwable{
		ConnectionBuildUp();
		String finalResult = null;
		if (connection != null) {
			prepStatement = connection.prepareStatement(Query);
			ResultSet result = prepStatement.executeQuery();
			  while(result.next()) {
				  finalResult = result.getString(identifier);
			
			  	}
			  prepStatement.close();
			  connection.close();

			
		} else {
			System.out.println("Failed to make connection!");
		}
		
		return finalResult;
	}
	
	public static void DeleteSpecificData (String Query) throws Throwable{
		ConnectionBuildUp();
		
		statement = connection.createStatement();
		statement.executeUpdate(Query);
		statement.close();
		connection.close();
		
	}
}
