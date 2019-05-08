package restassured.Framework;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;




public class CommonSteps extends APIHelper{
	
	
	//RequestSpecBuilder reqB;

	@Given("^Im an Account Manager$")
	public void im_an_Account_Manager() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	}
	
	@Given("^Im a new Partner$")
	public void im_a_new_Partner() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

	}
	
	@When("^I draft RequestSpecBuilder$")
	public void i_draft_RequestSpecBuilder() throws Throwable {
	
		reqB = getRequestSpecBuilder();
		
	}

	
	@When("^I set baseURI for LumenDEVURL$")
	public void I_set_baseURI_for_LumenDEVURL() throws Throwable{	
		
		reqB.setBaseUri(GetPropertValue("Data/TestProperties.xml","LumenSTGURL"));		
		
	}
	
	@When("^I set baseURI for KratosDEVURL$")
	public void I_set_baseURI_for_KratosDEVURL() throws Throwable{	
		
		reqB.setBaseUri(GetPropertValue("Data/TestProperties.xml","KratosSTGURL"));		
		
	}
	
	@When("^I set baseURI to ([^\"]*)$")
	public void I_set_baseURI_to_VARIABLE(String arg0) {		

		reqB.setBaseUri(arg0);
		
	}
	
	@When("^I set basePath to ([^\"]*)$")
	public void I_set_basePath_to_VARIABLE(String arg0) {		

		reqB.setBasePath(arg0);				
		
	}
	
	@When("^I set basePath to \"([^\"]*)\"$")
	public void I_set_basePath_to_VALUE(String arg0) {		

		reqB.setBasePath(arg0);				
		
	}
	
	@When("^I add parameter Key as \"([^\"]*)\" and Value as ([^\"]*)$")
	public void i_add_parameter_Key_as_VALUE_and_Value_as_VARIABLE(String arg0, String arg1) throws Throwable {	
		
		reqB.removeParam(arg0);
		reqB.addParam(arg0, arg1);
		
	}
	
	@When("^I add parameter Key as \"([^\"]*)\" and Value as \"([^\"]*)\"$")
	public void i_add_parameter_Key_as_VALUE_and_Value_as_VALUE(String arg0, String arg1) throws Throwable {	
		
		reqB.removeParam(arg0);
		reqB.addParam(arg0, arg1);
		
	}
	
	@When("^I add token to parameter$")
	public void I_add_token_to_parameter() throws Throwable {	

		reqB.removeParam("token");
		reqB.addParam("token", Token);
		
	}
	
	@When("^I add header Key as \"([^\"]*)\" and Value as ([^\"]*)$")
	public void i_add_header_Key_as_VALUE_and_Value_as_VARIABLE(String arg0, String arg1) throws Throwable {	

		reqB.addHeader(arg0, arg1);
		
	}
	
	@When("^I add header Key as \"([^\"]*)\" and Value as \"([^\"]*)\"$")
	public void i_add_header_Key_as_VALUE_and_Value_as_VALUE(String arg0, String arg1) throws Throwable {	

		reqB.addHeader(arg0, arg1);
		
	}
	
	
	
	@When("^I build RequestSpecification$")
	public void i_build_RequestSpecification() throws Throwable {
	
		requestSpecification = reqB.build();
		System.out.println(requestSpecification.log().all());
		
	}
	
	@When("^I reset RequestSpecification$")
	public void i_reset_RequestSpecification() throws Throwable {
		
		reset();
		
	}
	
	
	@When("^I remove \"([^\"]*)\" parameter$")
	public void i_remove_VALUE_parameter(String arg0) throws Throwable {
		
		reqB.removeParam(arg0);
		
	}
	
	@When("^I attached response to JsonPath$")
	public void I_attached_response_to_JsonPath() {
		
		jp = new JsonPath(Resp.asString());
		//System.out.println(Resp.asString());

	}
	
	@When("^I retrieve token$")
	public void I_retrieve_token() {
		
		Token = jp.getString("response.data.token");
		//System.out.println("TOKEN: " + Token);
	}
	
	
	@When("^I execute a GET method$")
	public void I_execute_a_GET_method() {
		
		Resp = get();
		//System.out.println(Resp.asString());

	}
	
	
	@When("^I execute a POST method$")
	public void i_execute_a_POST_method() throws Throwable {
		
		Resp = post();
		//System.out.println(Resp.asString());

	}
	
	
	
	
	
	
	
	
	

}
