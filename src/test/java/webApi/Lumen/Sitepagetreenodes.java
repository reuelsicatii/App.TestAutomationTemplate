package webApi.Lumen;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import restassured.Framework.APIHelper;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.google.gson.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;;








public class Sitepagetreenodes extends APIHelper{	
	

	@Then("^I receive a response with StatusCode ([^\"]*) over Sitepagetreenodes$")
	public void I_receive_a_response_with_StatusCode_STATUSCODE_over_AuditWebauditdata(int arg0) {
		//System.out.println(Resp.getStatusCode());
		assertEquals(arg0, Resp.getStatusCode());		
		
	}
	
	@Then("^I see that response JSON is equal to ([^\"]*) over Sitepagetreenodes$")
	public void I_see_that_response_JSON_is_equal_to_EXPECTEDJSON_over_AuditWebauditdata(String arg0) throws IOException {
		
		//System.out.println(Resp.asString());
		File expectedjsonfile;
		expectedjsonfile = new File(System.getProperty("user.dir") + "\\Data\\LumenAPI\\" + arg0+ ".json");		
		
		JsonElement Expected = parser.parse(FileUtils.readFileToString(expectedjsonfile));
		JsonElement Actual = parser.parse(Resp.asString());
		
		assertEquals(Expected, Actual);
		
		
	}
	

}
