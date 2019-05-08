#Author: reuel@truelogic.com.ph, lorraine@truelogic.com.ph
#Version 1.0 01.28 2019 - Initial creation of file
Feature: [TAA-519] [SEOReseller] Support Menu Smoke/Regression TestSuite

  #Scenario Description:
	#Given I am a Partner
	#When I hover to the support menu
	#And I click the Getting Started Link
	#Then see the Getting Started Blog
  @SRSSMOKETEST @SupportMenu @SupportMenu_TS01 @TAA-520
  Scenario Outline: TAA-520
		Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    
    When I hover to SEO00_SupportMenu link
    Then Ill see the SEO00_GettingStarted link
    And Ill see the SEO00_LearnTheBasic "Learn the basics to get productive with our marketing suite in minutes." text
    
    When I click the SEO00_GettingStarted link
    Then Ill be redirected to the SEO00_Helpcenter
    And Ill see the SEO00_GettingStarted header
    
    Examples: 
			| FirstName | LastName   | email                     | password  |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 |
      
  #Scenario Description:
	#Given I am a Partner
	#When I hover to the support menu
	#And I click the Knowledge Base Link
	#Then Ill see the Advice and answers from the SEOReseller Team
  @SRSSMOKETEST @SupportMenu @SupportMenu_TS02 @TAA-521
  Scenario Outline: TAA-521
		Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    
    When I hover to SEO00_SupportMenu link
    Then Ill see the SEO00_KnowledgeBase link
    And Ill see the SEO00_DetailedUserGuides "Detailed user guides for every feature of our suite." text
    
    When I click the SEO00_KnowledgeBase link
    Then Ill be redirected to the SEO00_Helpcenter
    And Ill see the SEO00_AdviceAndAnswers header
    
    Examples: 
			| FirstName | LastName   | email                     | password  |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 |
      
  #Scenario Description:
	#Given I am a Partner
	#When I hover to the support menu
	#And I click the Email Us Link
	#Then Ill see that Ill be redirected to the mailbox
  @SRSSMOKETEST @SupportMenu @SupportMenu_TS03 @TAA-522
  Scenario Outline: TAA-522
		Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    
    When I hover to SEO00_SupportMenu link
    Then Ill see the SEO00_EmailUs link
    And Ill see that the SEO00_EmailUs is a mail redirection
    And Ill see the SEO00_OfficeOpenDays "Our offices are open 24/5" text
    And Ill see the SEO00_OfficeOpenHours "From Monday 7 AM To Saturday 7 AM, your timezone" text

    
    Examples: 
			| FirstName | LastName   | email                     | password  |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 |
      
      
	#Scenario Description:
	#Given I am a Partner
	#When I hover to the support menu
	#And I click the Knowledge Base Link
	#Then Ill see the Advice and answers from the SEOReseller Team
  @SRSSMOKETEST @SupportMenu @SupportMenu_TS04 @TAA-523
  Scenario Outline: TAA-523
		Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    
    When I hover to SEO00_SupportMenu link
    Then Ill see the SEO00_ProjectManager image
    And Ill be able to see the SEO00_YourProjectManager "your Project Manager is here to guide you." text
    And Ill be able to see the SEO00_ProjectManagaerEmail text
    
    Examples: 
			| FirstName | LastName   | email                     | password  |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 |   
      
       #Scenario Description:
	#Given I am a Partner
	#When I hover to the support menu
	#And I click the Contact Us button
	#Then Ill see the Contact us page of seoreseller.com
  @SRSSMOKETEST @SupportMenu @SupportMenu_TS05 @TAA-524
  Scenario Outline: TAA-524
		Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    
    When I hover to SEO00_SupportMenu link
    Then Ill see the SEO00_ContactUs button
    
    When I click the SEO00_ContactUs button
    Then Ill be redirected to the SEO00_SeoResellerContactUs Page
    And Ill see the SEO00_ContactUsToday header
    
    Examples: 
			| FirstName | LastName   | email                     | password  |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 |
           
      