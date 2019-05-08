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
Feature: [TAA-18] Lumen Smoke Test Suite v0.1

  @LUMENSMOKETEST @AuditWebauditdata @AuditWebauditdata_TS01
  Scenario Outline: AuditWebauditdata_TS01
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "auditToken" and Value as <auditToken>
    And I build RequestSpecification
    And I execute a GET method
    Then I receive a response with StatusCode <StatusCode> over AuditWebauditdata
    And I see that response JSON is equal to <ExpectedJSON> over AuditWebauditdata

    Examples: 
      | BasePath              | auditToken  | StatusCode | ExpectedJSON                |
      | audits/web-audit-data | QJwrsm9zMo7 |        200 | AuditWebauditdata_TS01_TC01 |
      | audits/web-audit-data | jWg4gzmH9Ga |        200 | AuditWebauditdata_TS01_TC02 |

  @LUMENSMOKETEST @AuditWebauditdata @AuditWebauditdata_TS02
  Scenario Outline: AuditWebauditdata_TS02
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I remove "auditToken" parameter
    And I build RequestSpecification
    And I execute a GET method
    Then I receive a response with StatusCode <StatusCode> over AuditWebauditdata
    And I see that response JSON is equal to <ExpectedJSON> over AuditWebauditdata

    Examples: 
      | BasePath              | StatusCode | ExpectedJSON                |
      | audits/web-audit-data |        422 | AuditWebauditdata_TS02_TC01 |
