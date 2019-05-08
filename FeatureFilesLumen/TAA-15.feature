#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Givecondition step
#When: Sen: Some prome key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: [TAA-15] Lumen Smoke Test Suite v0.1

  @LUMENSMOKETEST @LoginAuthenticate @LoginAuthenticate_TS01
  Scenario Outline: LoginAuthenticate_TS01
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "email" and Value as <Email>
    And I add parameter Key as "password" and Value as <Password>
    And I add parameter Key as "site_id" and Value as <SiteID>
    And I build RequestSpecification
    And I execute a POST method
    And I attached response to JsonPath
    And I retrieve token
    Then I receive a response with StatusCode <StatusCode> over LoginAuthenticate
    And I see that response JSON contains all the expected fields and values over LoginAuthenticate

    Examples: 
      | BasePath            | Email                  | Password | SiteID | StatusCode |
      | /login/authenticate | bordy@truelogic.com.ph | Abcd1234 |      8 |        200 |

  @LUMENSMOKETEST @LoginAuthenticate @LoginAuthenticate_TS02
  Scenario Outline: LoginAuthenticate_TS02
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "email" and Value as <Email>
    And I add parameter Key as "password" and Value as <Password>
    And I add parameter Key as "site_id" and Value as <SiteID>
    And I build RequestSpecification
    And I execute a POST method
    Then I receive a response with StatusCode <StatusCode> over LoginAuthenticate
    And I see that response JSON is equal to <ExpectedJSON> over SignUp

    Examples: 
      | BasePath            | Email                  | Password | SiteID | StatusCode | ExpectedJSON                |
      | /login/authenticate | brdy@truelogic.com.ph  | Abcd1234 |      8 |        400 | LoginAuthenticate_TS02_TC01 |
      | /login/authenticate | bordy@truelogic.com.ph | Abcd123  |      8 |        400 | LoginAuthenticate_TS02_TC02 |
      | /login/authenticate | bordy@truelogic.com.ph | Abcd123  |        |        422 | LoginAuthenticate_TS02_TC03 |

  @LUMENSMOKETEST @SignUp_TS01
  Scenario Outline: SignUp_TS01
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "password" and Value as <Password>
    And I add parameter Key as "confirmPassword" and Value as <ConfirmPassword>
    And I add parameter Key as "site_id" and Value as <SiteID>
    And I add parameter Key as "email" and Value from randomgenerator over SignUp
    And I build RequestSpecification
    And I execute a POST method
    Then I receive a response with StatusCode <StatusCode> over SignUp
    And I see that response JSON is equal to <ExpectedJSON> over SignUp

    Examples: 
      | BasePath | Email                            | Password  | ConfirmPassword | SiteID | StatusCode | ExpectedJSON     |
      | /signup  | randomgenerator@truelogic.com.ph | Abcd1234  | Abcd1234        |      1 |        200 | SignUp_TS01_TC01 |
      | /signup  | randomgenerator@truelogic.com.ph | Abcd12346 | Abcd12345       |      1 |        422 | SignUp_TS01_TC02 |
      | /signup  | randomgenerator@truelogic.com.ph | Abcd123   | Abcd12345       |      1 |        422 | SignUp_TS01_TC03 |
      | /signup  | randomgenerator@truelogic.com.ph | Abcd1234  | Abcd1234        |        |        422 | SignUp_TS01_TC04 |

  @LUMENSMOKETEST @Campaign_TS01
  Scenario Outline: Campaign_TS01
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to "/login/authenticate"
    And I add parameter Key as "email" and Value as "bordy@truelogic.com.ph"
    And I add parameter Key as "password" and Value as "Abcd1234"
    And I add parameter Key as "site_id" and Value as "1"
    And I build RequestSpecification
    And I execute a POST method
    And I attached response to JsonPath
    And I retrieve token

    #Then I receive a response with StatusCode <StatusCode> over SignUp
    #And I see that response JSON is equal to <ExpectedJSON> over SignUp
    Examples: 
      | BasePath | Email                            | Password | ConfirmPassword | SiteID | StatusCode | ExpectedJSON     |
      | /signup  | randomgenerator@truelogic.com.ph | Abcd1234 | Abcd1234        |      1 |        200 | SignUp_TS01_TC01 |
      
      
      
