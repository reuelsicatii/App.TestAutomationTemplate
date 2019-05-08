#Author: lorraine@truelogic.com.ph
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
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
Feature: [TAA-191] [SEOReseller]: WebAudit Smoke/Regression TestSuite

  #Scenario Description:
  #Given I'm a User
	#When I enter a website
	#And I click "Run New Audit(Beta)" Button
	#Then my report will generated using the web audit tool 
	#And I can view the report
  @SRSSMOKETEST @WebAudit @SRS-3568_TS01 @TAA-277 
  Scenario Outline: TAA-277
    Given Im an existing Partner
		When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
		
		When I populate SEO01_website textfield with <website>
		And I click SEO01_RunNewAuditBeta button
		Then I will be notified <websiteText> is now ready!
		And Ill see the SEO01_click here link of <websiteText>
		
		When I click SEO01_ClickHere link of <websiteText>
		Then Ill be redirected to Web Audit Report Preview
		And Ill see the SEO13_Audit report

    Examples: 
      | email                | password  |           website             |      websiteText       |
      | tlosrnd321@gmail.com | happy123  | https://www.jollibee.com.ph/  |       jollibee         |
      
  #Scenario Description:
	#	Given I'm a User
	#And I click add competitors link
	#When I Run Audit a valid website
	#Then a report will generated using the web audit tool 
	#And I will be notified "<website> is now ready!"
	#And see the results
  @SRSSMOKETEST @WebAudit @SRS-3568_TS02 @TAA-278 
  Scenario Outline: TAA-278
    Given Im an existing Partner
		When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
		
		When I populate SEO01_website textfield with <website>
		And I click SEO01_AddCompetitors link
		Then Ill see SEO01_CompetitorOne textfield
    And Ill see SEO01_CompetitorTwo textfield
    And Ill see SEO01_CompetitorThree textfield
    
		When I populate SEO01_CompetitorOne textfield with <compWebOne>
		And I populate SEO01_CompetitorTwo textfield with <compWebTwo>
		And I populate SEO01_CompetitorThree textfield with <compWebThree>
		And I click SEO01_RunNewAuditBeta button
		Then I will be notified <websiteText> is now ready!
		And Ill see the SEO01_click here link of <websiteText>
		
		When I click SEO01_ClickHere link of <websiteText>
		Then Ill be redirected to Web Audit Report Preview
		And Ill see the SEO13_Audit report
		And Ill see Competitor <compWebOneText>
		And Ill see Competitor <compWebTwoText>
		And Ill see Competitor <compWebThreeText>

    Examples: 
      | email                | password  |           website             |      websiteText      |  compWebOne             |  compWebOneText    | compWebTwo              | compWebTwoText  |  compWebThree              |  compWebThreeText |
      | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  https://www.yondu.com/ |   www.yondu.com    | https://www.google.com/ | www.google.com  |  https://www.yugatech.com/ |  www.yugatech.com |
      | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  https://www.yondu.com/ |   www.yondu.com    | https://www.google.com/ | www.google.com  |  blank                     |  blank            |
			| tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  https://www.yondu.com/ |   www.yondu.com    | blank                   | blank           |  https://www.yugatech.com/ |  www.yugatech.com |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  blank                  |   blank            | https://www.google.com/ | www.google.com  |  https://www.yugatech.com/ |  www.yugatech.com |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  https://www.yondu.com/ |   www.yondu.com    | blank                   | blank           |  blank                     |  blank            |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  blank                  |   blank            | https://www.google.com/ | www.google.com  |  blank                     |  blank            |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  blank                  |   blank            | blank                   | blank           |  https://www.yugatech.com/ |  www.yugatech.com |
		  
		  
	#Scenario Description:
	#Given I'm a User
	#And I click "Add Competitors New Audit (Beta) Only" link 
	#When I click "Remove Competitors New Audit (Beta) Only" link
	#Then I will not see Competitor1 text field, Competitor2 text field, Competitor3 text field
  @SRSSMOKETEST @WebAudit @SRS-3568_TS03 @TAA-279
  Scenario Outline: TAA-279
    Given Im an existing Partner
		When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page        
		
		When I click SEO01_AddCompetitors link
		Then Ill see SEO01_CompetitorOne textfield
    And Ill see SEO01_CompetitorTwo textfield
    And Ill see SEO01_CompetitorThree textfield
    
    When I click SEO01_RemoveCompetitors link
		Then Ill not see SEO01_CompetitorOne textfield
    And Ill not see SEO01_CompetitorTwo textfield
    And Ill not see SEO01_CompetitorThree textfield
    
    Examples: 
      | email                | password  |
      | tlosrnd321@gmail.com | happy123  |
 
 
	#Scenario Description:
	#Given I'm a User
	#And I click add competitors link
	#When I enter a valid website on  <Website text field>
	#And I  enter Competitors website on <Comp_Website1> text field
	#And I enter Competitors website on <Comp_Website2> text field
	#Then a report will generated using the web audit tool 
	#And I will be notified "<website> is now ready!"
	#And I will see the results
  @SRSSMOKETEST @WebAudit @SRS-3568_TS04 @TAA-280
  Scenario Outline: TAA-280
    Given Im an existing Partner
		When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
		
		When I populate SEO01_website textfield with <website>
		And I click SEO01_AddCompetitors link
		Then Ill see SEO01_CompetitorOne textfield
    And Ill see SEO01_CompetitorTwo textfield
    And Ill see SEO01_CompetitorThree textfield
    
		When I populate SEO01_CompetitorOne textfield with <compWebOne>
		And I populate SEO01_CompetitorTwo textfield with <compWebTwo>
		And I click SEO01_RunNewAuditBeta button
		Then I will be notified <websiteText> is now ready!
		And Ill see the SEO01_click here link of <websiteText>
		
		When I click SEO01_ClickHere link of <websiteText>
		Then Ill be redirected to Web Audit Report Preview
		And Ill see the SEO13_Audit report
		And Ill see Competitor <compWebOneText>
		And Ill see Competitor <compWebTwoText>
    
    Examples: 
      | email                | password  |           website             |      websiteText      |  compWebOne             |  compWebOneText    | compWebTwo              | compWebTwoText  |
      | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  https://www.yondu.com/ |   www.yondu.com    | https://www.google.com/ | www.google.com  |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  https://www.yondu.com/ |   www.yondu.com    | blank                   | blank           |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  blank                  |   blank            | https://www.google.com/ | www.google.com  |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  blank                  |   blank            | blank                   | blank           |
		  
	#Scenario Description:
	#Given I'm a User   
	#When I enter invalid website URL
	#Then I'll see a notification "Please enter a valid website URL (ending in .com, .net, .us, .biz, .food, etc.)"
  @SRSSMOKETEST @WebAudit @SRS-3568_TS05 @TAA-281
  Scenario Outline: TAA-281
    Given Im an existing Partner
		When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
		
		When I populate SEO01_website textfield with <website>
		And I click SEO01_AddCompetitors link
		Then Ill see SEO01_CompetitorOne textfield
    And Ill see SEO01_CompetitorTwo textfield
    And Ill see SEO01_CompetitorThree textfield
    
		When I populate SEO01_CompetitorOne textfield with <compWebOne>
		And I populate SEO01_CompetitorTwo textfield with <compWebTwo>
		And I populate SEO01_CompetitorThree textfield with <compWebThree>
		And I click SEO01_RunNewAuditBeta button	
    Then Ill see a SEO01_WebAuditInvalid notification
    
    Examples: 
      | email                | password  |        website             |      compWebOne                |     compWebTwo            |       compWebThree      |
      | tlosrnd321@gmail.com | happy123  |     htt://www.posh.com/    |      blank                     |       blank               |          blank          |
      | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/   |      htt://www.posh.com/       |       blank               |          blank          |
	    | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/   |      blank                     |    htt://www.posh.com/    |          blank          |
	    | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/   |      blank                     |       blank               |   htt://www.posh.com/   |	 
	    
  #Scenario Description:
	#Given I'm a User
	#When I populate Website text field with invalid website url
	#Then I'll see an error message "The website you are trying to audit cannot be reached right now. Please try again later.."
  @SRSSMOKETEST @WebAudit @SRS-3568_TS06 @TAA-319
  Scenario Outline: TAA-319
    Given Im an existing Partner
		When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
		
		When I populate SEO01_website textfield with <website>
		And I click SEO01_RunNewAuditBeta button	
    Then Ill see a SEO01_WebAuditCannotBeReached notification
    
    Examples: 
      | email                | password  |             website                  |
      | tlosrnd321@gmail.com | happy123  |     http://www.brittleririri.com/    |
      
       
  #Scenario Description:
	#Given I'm an AppUser
	#When I enter a website
	#And I click "RUN AUDIT" button
	#Then I'll see the generated report in a new tab
  @SRSSMOKETEST @WebAudit @SRS-3569_TS01 @TAA-320
  Scenario Outline: TAA-320
    Given Im an existing Partner
		When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
		
		When I click the SEO01_AuditQuickAccess icon
		And I populate SEO14_website textfield with <website>
		And I click SEO14_RunAuditbutton
		Then I will be notified <websiteText> is now ready!
		And Ill see the SEO01_click here link of <websiteText>
		
		When I click SEO01_ClickHere link of <websiteText>
		Then Ill be redirected to SEO13_OldWebAuditReport Preview
		And Ill see the Old SEO13_Audit report

    Examples: 
      | email                | password  |         website                  |  websiteText     |
      | tlosrnd321@gmail.com | happy123  | http://www.singaporeflyer.com/   |  singaporeflyer  |
      
  #Scenario Description:
	#Given I'm an AppUser
	#When I enter a website and three competitor websites
	#And I click "RUN NEW AUDIT (BETA)" button
	#Then I'll see the generated report
  @SRSSMOKETEST @WebAudit @SRS-3569_TS02 @TAA-321
  Scenario Outline: TAA-321
    Given Im an existing Partner
		When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
		
		When I click the SEO01_AuditQuickAccess icon
		And I click SEO14_AddCompetitors link
		Then Ill see SEO14_CompetitorOne textfield
    And Ill see SEO14_CompetitorTwo textfield
    And Ill see SEO14_CompetitorThree textfield
    
    When I populate SEO14_website textfield with <website>
		And I populate SEO14_CompetitorOne textfield with <compWebOne>
		And I populate SEO14_CompetitorTwo textfield with <compWebTwo>
		And I populate SEO14_CompetitorThree textfield with <compWebThree>
		And I click SEO14_RunNewAuditBeta button
		Then I will be notified <websiteText> is now ready!
		And Ill see the SEO01_click here link of <websiteText>
		
		When I click SEO01_ClickHere link of <websiteText>
		Then Ill be redirected to Web Audit Report Preview
		And Ill see the SEO13_Audit report
		And Ill see Competitor <compWebOneText>
		And Ill see Competitor <compWebTwoText>
		And Ill see Competitor <compWebThreeText>

    Examples: 
      | email                | password  |           website             |      websiteText      |  compWebOne             |  compWebOneText    | compWebTwo              | compWebTwoText  |  compWebThree              |  compWebThreeText |
      | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  https://www.yondu.com/ |   www.yondu.com    | https://www.google.com/ | www.google.com  |  https://www.yugatech.com/ |  www.yugatech.com |
      | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  https://www.yondu.com/ |   www.yondu.com    | https://www.google.com/ | www.google.com  |  blank                     |  blank            |
			| tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  https://www.yondu.com/ |   www.yondu.com    | blank                   | blank           |  https://www.yugatech.com/ |  www.yugatech.com |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  blank                  |   blank            | https://www.google.com/ | www.google.com  |  https://www.yugatech.com/ |  www.yugatech.com |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  https://www.yondu.com/ |   www.yondu.com    | blank                   | blank           |  blank                     |  blank            |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  blank                  |   blank            | https://www.google.com/ | www.google.com  |  blank                     |  blank            |
		  | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |      www.posh.com     |  blank                  |   blank            | blank                   | blank           |  https://www.yugatech.com/ |  www.yugatech.com |
	
	#Scenario Description:
	#Given I'm an AppUser
	#And I click "Remove Competitor's New Audit (Beta) only" link
	#Then the three competitor text fields will be gone 
  @SRSSMOKETEST @WebAudit @SRS-3569_TS03 @TAA-322
  Scenario Outline: TAA-322
    Given Im an existing Partner
		When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
		
		When I click the SEO01_AuditQuickAccess icon
		And I click SEO14_AddCompetitors link
		Then Ill see SEO14_CompetitorOne textfield
    And Ill see SEO14_CompetitorTwo textfield
    And Ill see SEO14_CompetitorThree textfield	
	
	  When I populate SEO14_website textfield with <website>
		And I populate SEO14_CompetitorOne textfield with <compWebOne>
		And I populate SEO14_CompetitorTwo textfield with <compWebTwo>
		And I populate SEO14_CompetitorThree textfield with <compWebThree>
		And I click SEO01_RemoveCompetitors link
		Then Ill not see SEO14_CompetitorOne textfield
    And Ill not see SEO14_CompetitorTwo textfield
    And Ill not see SEO14_CompetitorThree textfield	
	
    Examples: 
      | email                | password  |           website             |    compWebOne             |       compWebTwo         |      compWebThree           | 
      | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/      |    https://www.yondu.com/ |  https://www.google.com/ |   https://www.yugatech.com/ |
      
	#Given I'm an AppUser
	#When I enter a website and three competitor websites with invalid URL(WebAudit Page)
	#Then I'll see an error pop-up message that says "ERROR Please enter a valid website URL ending in .com, .net, .us, .biz, .food, etc.) 
  @SRSSMOKETEST @WebAudit @SRS-3569_TS04 @TAA-323
  Scenario Outline: TAA-323
    Given Im an existing Partner
		When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
		
		When I click the SEO01_AuditQuickAccess icon
		And I populate SEO14_website textfield with <website>
		And I click SEO14_AddCompetitors link
		Then Ill see SEO14_CompetitorOne textfield
    And Ill see SEO14_CompetitorTwo textfield
    And Ill see SEO14_CompetitorThree textfield
    
		When I populate SEO14_CompetitorOne textfield with <compWebOne>
		And I populate SEO14_CompetitorTwo textfield with <compWebTwo>
		And I populate SEO14_CompetitorThree textfield with <compWebThree>
		And I click SEO14_RunNewAuditBeta button
    Then Ill see a SEO01_WebAuditInvalid notification
    
    Examples: 
      | email                | password  |        website             |      compWebOne                |     compWebTwo            |       compWebThree      |
      | tlosrnd321@gmail.com | happy123  |     htt://www.posh.com/    |      blank                     |       blank               |          blank          |
      | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/   |      htt://www.posh.com/       |       blank               |          blank          |
	    | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/   |      blank                     |    htt://www.posh.com/    |          blank          |
	    | tlosrnd321@gmail.com | happy123  |     http://www.posh.com/   |      blank                     |       blank               |   htt://www.posh.com/   |	 