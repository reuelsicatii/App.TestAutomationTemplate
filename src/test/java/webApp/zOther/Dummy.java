package webApp.zOther;


import static io.restassured.RestAssured.*;
import org.junit.Test;

import com.google.gson.JsonElement;

import restassured.Framework.APIHelper;;



public class Dummy extends APIHelper{
	
	
	@Test
	public void Main() throws Throwable {
		System.out.println("Starting...");
		reqB = getRequestSpecBuilder();
		reqB.setBaseUri("http://staging.api.lumen.io.aws/");
		reqB.setBasePath("admin/tools/email-updater");
		reqB.addParam("site_id", "1");
		reqB.addParam("from_email", "SPVdEycEsx@gmail.com");
		reqB.addParam("to_email", "test@gmail.com");
		
		requestSpecification = reqB.build();
		System.out.println("Building...");
		 
		Resp = post();
		System.out.println("Requesting...");
		
		System.out.println(Resp.getStatusCode());
		System.out.println(Resp.asString());
		JsonElement Actual = parser.parse(Resp.asString());
		System.out.println(Actual);
		
	}
	


		

		
		


	

}
