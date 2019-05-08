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
Feature: [TAA-19] Lumen Smoke Test Suite v0.1

  @LUMENSMOKETEST @Sitepagetreenodes @Sitepagetreenodes_TS01
  Scenario Outline: Sitepagetreenodes_TS01
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "site_id" and Value as "8"
    And I add parameter Key as "pagination_clause[pagination_limit]" and Value as "none"
    And I add parameter Key as "language_type_code" and Value as "en"
    And I build RequestSpecification
    And I execute a GET method
    Then I receive a response with StatusCode <StatusCode> over Sitepagetreenodes
    And I see that response JSON is equal to <ExpectedJSON> over Sitepagetreenodes

    Examples: 
      | BasePath              | StatusCode | ExpectedJSON                |
      | /site-page-tree-nodes |        200 | Sitepagetreenodes_TS01_TC01 |
      
      
  @LUMENSMOKETEST @Sitepagetreenodes @Sitepagetreenodes_TS02
  Scenario Outline: Sitepagetreenodes_TS02
    Given Im an Account Manager
    When I draft RequestSpecBuilder
    And I set baseURI for LumenDEVURL
    And I set basePath to <BasePath>
    And I add parameter Key as "site_id" and Value as "8"
    And I add parameter Key as "pagination_clause[pagination_limit]" and Value as "none"
    And I build RequestSpecification
    And I execute a GET method
    Then I receive a response with StatusCode <StatusCode> over Sitepagetreenodes
    And I see that response JSON is equal to <ExpectedJSON> over Sitepagetreenodes

    Examples: 
      | BasePath              | StatusCode | ExpectedJSON                |
      | /site-page-tree-nodes |        422 | Sitepagetreenodes_TS02_TC01 |
      
