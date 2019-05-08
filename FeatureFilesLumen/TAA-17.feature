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
Feature: [TAA-17] Lumen Smoke Test Suite v0.1

  @LUMENSMOKETEST @Generateaudit @Generateaudit_TS01
  Scenario Outline: Generateaudit_TS01
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to "/login/authenticate"
    And I add parameter Key as "email" and Value as "bordy@truelogic.com.ph"
    And I add parameter Key as "password" and Value as "Abcd1234"
    And I add parameter Key as "site_id" and Value as "8"
    And I build RequestSpecification
    And I execute a POST method
    And I attached response to JsonPath
    And I retrieve token
    And I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "url" and Value as <URL>
    And I add parameter Key as "user_id" and Value as "18805"
    And I add parameter Key as "logo" and Value as ""
    And I add auditToken to parameter over Generateaudit
    And I add parameter Key as "reanalyze" and Value as <Reanalyze>
    And I add token to parameter
    And I add parameter Key as "site_id" and Value as "8"
    And I build RequestSpecification
    And I execute a POST method
    Then I receive a response with StatusCode <StatusCode> over Generateaudit


    Examples: 
      | BasePath              | URL                           | Reanalyze | StatusCode |
      | audits/generate-audit | http://www.felipeandsons.com/ |         0 |        200 |
      | audits/generate-audit | http://www.felipeandsons.com/ |         1 |        200 |

  @LUMENSMOKETEST @Generateaudit @Generateaudit_TS02
  Scenario Outline: Generateaudit_TS02
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to "/login/authenticate"
    And I add parameter Key as "email" and Value as "bordy@truelogic.com.ph"
    And I add parameter Key as "password" and Value as "Abcd1234"
    And I add parameter Key as "site_id" and Value as "8"
    And I build RequestSpecification
    And I execute a POST method
    And I attached response to JsonPath
    And I retrieve token
    And I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "url" and Value as <URL>
    And I add parameter Key as "user_id" and Value as "18805"
    And I add parameter Key as "logo" and Value as ""
    #And I remove "auditToken" parameter
    And I add parameter Key as "reanalyze" and Value as <Reanalyze>
    And I add token to parameter
    And I add parameter Key as "site_id" and Value as "8"
    And I build RequestSpecification
    And I execute a POST method
    Then I receive a response with StatusCode <StatusCode> over Generateaudit
    And I see that response JSON is equal to <ExpectedJSON> over Generateaudit

    Examples: 
      | BasePath              | URL                           | Reanalyze | StatusCode | ExpectedJSON            |
      | audits/generate-audit | http://www.felipeandsons.com/ |         0 |        422 | Generateaudit_TS02_TC01 |
   
   
   @LUMENSMOKETEST @Generateaudit_TS03
  Scenario Outline: Generateaudit_TS03
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to "/login/authenticate"
    And I add parameter Key as "email" and Value as "bordy@truelogic.com.ph"
    And I add parameter Key as "password" and Value as "Abcd1234"
    And I add parameter Key as "site_id" and Value as "8"
    And I build RequestSpecification
    And I execute a POST method
    And I attached response to JsonPath
    And I retrieve token
    And I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "url" and Value as <URL>
    And I add parameter Key as "user_id" and Value as "18805"
    And I add parameter Key as "logo" and Value as ""
    And I add auditToken to parameter over Generateaudit
    And I add parameter Key as "reanalyze" and Value as <Reanalyze>
    #And I remove "token" parameter
    And I add parameter Key as "site_id" and Value as "8"
    And I build RequestSpecification
    And I execute a POST method
    Then I receive a response with StatusCode <StatusCode> over Generateaudit
    And I see that response JSON is equal to <ExpectedJSON> over Generateaudit

    Examples: 
      | BasePath              | URL                           | Reanalyze | StatusCode | ExpectedJSON            |
      | audits/generate-audit | http://www.felipeandsons.com/ |         1 |        401 | Generateaudit_TS03_TC01 |
   
