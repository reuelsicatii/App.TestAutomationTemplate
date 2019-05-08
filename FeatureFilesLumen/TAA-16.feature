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
Feature: [TAA-16] Lumen Smoke Test Suite v0.1
 
  @LUMENSMOKETEST @AuditWebaudit @AuditWebaudit_TS01
  Scenario Outline: AuditWebaudit_TS01
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
    And I add parameter Key as "owner_id" and Value as "18805"
    And I add token to parameter
    And I add parameter Key as "site_id" and Value as "8"
    And I add parameter Key as "type" and Value as "audit"
    And I add parameter Key as "status_code" and Value as <ParamStatusCode>
    And I add parameter Key as "pagination_clause[pagination_limit]" and Value as <PaginationClause>
    And I add parameter Key as "sql_clause[order_by][date_posted]" and Value as <SQLClause>
    And I build RequestSpecification
    And I execute a GET method
    Then I receive a response with StatusCode <StatusCode> over AuditWebaudit
    And I see that response JSON matches to <ExpectedJSON> Schema over AuditWebaudit

    Examples: 
      | BasePath          | ParamStatusCode | PaginationClause | SQLClause | StatusCode | ExpectedJSON            |
      | /audits/web-audit | done            |               10 | desc      |        200 | AuditWebaudit_TS01_TC01 |
      | /audits/web-audit | done            |                5 | desc      |        200 | AuditWebaudit_TS01_TC02 |
      | /audits/web-audit | error           |                2 | desc      |        200 | AuditWebaudit_TS01_TC03 |
      
      
      
	@LUMENSMOKETEST @AuditWebaudit @AuditWebaudit_TS02
  Scenario Outline: AuditWebaudit_TS02
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "owner_id" and Value as "18805"
    And I add parameter Key as "token" and Value as "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOm51bGwsImlhdCI6MTUwMjQyNTg4NCwiZXhwIjoxNTAyNDI5NDg0LCJuYmYiOjE1MDI0MjU4ODQsImp0aSI6Ik1oN0VWNUF4SThiZ014MlciLCJzdWIiOjE4ODA1fQ.cAfLng0GhiREj3jaMjOkduG9SjevEEPoVHeF5aQcuTI"
    And I add parameter Key as "site_id" and Value as "8"
    And I add parameter Key as "type" and Value as "audit"
    And I add parameter Key as "status_code" and Value as <ParamStatusCode>
    And I add parameter Key as "pagination_clause[pagination_limit]" and Value as <PaginationClause>
    And I add parameter Key as "sql_clause[order_by][date_posted]" and Value as <SQLClause>
    And I build RequestSpecification
    And I execute a GET method
    Then I receive a response with StatusCode <StatusCode> over AuditWebaudit
    And I see that response JSON is equal to <ExpectedJSON> over AuditWebaudit

    Examples: 
      | BasePath          | ParamStatusCode | PaginationClause | SQLClause | StatusCode | ExpectedJSON            |
      | /audits/web-audit | done            |               10 | desc      |        401 | AuditWebaudit_TS02_TC01 |
      
      
      	@LUMENSMOKETEST @AuditWebaudit_TS03
  Scenario Outline: AuditWebaudit_TS03
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "owner_id" and Value as "18805"
    And I add parameter Key as "token" and Value as "cAfLng0GhiREj3jaMjOkduG9SjevEEPoVHeF5aQcuTI"
    And I add parameter Key as "site_id" and Value as "8"
    And I add parameter Key as "type" and Value as "audit"
    And I add parameter Key as "status_code" and Value as <ParamStatusCode>
    And I add parameter Key as "pagination_clause[pagination_limit]" and Value as <PaginationClause>
    And I add parameter Key as "sql_clause[order_by][date_posted]" and Value as <SQLClause>
    And I build RequestSpecification
    And I execute a GET method
    Then I receive a response with StatusCode <StatusCode> over AuditWebaudit
    And I see that response JSON is equal to <ExpectedJSON> over AuditWebaudit

    Examples: 
      | BasePath          | ParamStatusCode | PaginationClause | SQLClause | StatusCode | ExpectedJSON            |
      | /audits/web-audit | done            |               10 | desc      |        401 | AuditWebaudit_TS03_TC01 |
      
      
      
      
      
      
