package webApi.Lumen;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import restassured.Framework.APIHelper;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.google.gson.*;
import static org.junit.Assert.assertEquals;








public class SignUp extends APIHelper{
	
	
	@When("^I add parameter Key as \"([^\"]*)\" and Value from randomgenerator over SignUp$")
	public void i_add_parameter_Key_as_and_Value_as(String arg0) throws Throwable {	
		
		reqB.addParam(arg0, randomgenerator() + "@testautomation.com");
		
	}
	
	@Then("^I receive a response with StatusCode ([^\"]*) over SignUp$")
	public void I_receive_a_response_with_StatusCode_STATUSCODE_over_SignUp(int arg0) {
		assertEquals(arg0, Resp.getStatusCode());		
		
	}
	
	
	@Then("^I see that response JSON is equal to ([^\"]*) over SignUp$")
	public void I_see_that_response_JSON_is_equal_to_EXPECTEDJSON_over_SignUp(String arg0) throws IOException {
		
		//System.out.println(Resp.asString());
		File expectedjsonfile;
		expectedjsonfile = new File(System.getProperty("user.dir") + "\\Data\\LumenAPI\\" + arg0+ ".json");		
		
		JsonElement Expected = parser.parse(FileUtils.readFileToString(expectedjsonfile));
		JsonElement Actual = parser.parse(Resp.asString());
		
		assertEquals(Expected, Actual);
		
		
	}
	

	
	
	
	
	
	
	
	
	

}
