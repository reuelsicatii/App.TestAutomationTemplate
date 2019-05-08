#Author: lorraine@truelogic.com.ph
#Version 1.0 06.27 2018 - Initial creation of file

Feature: [TAA-128] [SEOReseller]: SafeEmail_OAuth (Default)
  #Covered Ticket : SRS-3469, SRS-3940, SRS-4713
  # Given I am a Partner
  # And I have not yet setup my Email Settings Wizard
  # And the date today is > May 15 2018
  # When I click an email trigger of Web Audit/Proposal in the Dashboard
  # Then Ill see the Email Settings Wizard Modal
  # And Ill not see the 'By May 15, 2018' verbiage
  # And Ill see the Do It Later button
  # When I click the Do It Later button
  # Then I can send an email
  @SRSSMOKETEST @SafeEmail_OAuth @SafeEmailOauth_TS01 @TAA-133
  Scenario Outline: TAA-133
    Given Im an existing Partner
		When I navigate to "SEOSTG_Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
		
	  When I redirect to SEO1_<DashBoardPage>
		And I click the  Email Trigger of <SendEmailTrigger>
#		Then Ill see the Email Setup Wizard Modal
#		And Ill not see the SEO00_ByMayFifteen text
#		And Ill see the SEO12_EmailAddress textfield
#		And Ill see the SEO12_Next button
#		And Ill see the SEO12_Next button
#		And Ill see the SEO00_DoItLater button
#		And Ill not see the SEO00_ByMayFifteen text
		
#		When I click the SEO00_DoItLater button
    Then Ill see that an SEO00_Email Modal will be displayed
    
		When I populate the SEO00_To textfield with <Email>
		And I populate the SEO00_Subject textfield with <Subject>
		And I click SEO00_Send button
		Then Ill see the SEO00_MessageSentNotification
		
#		 When I open my <Domain> mailbox using my <Email> and <Password>
#		 And Ill see the email with Subject <Subject> for my <Domain> Mailbox
    
    Examples: 
      | Email  								  | Password    | DashBoardPage          | Domain  | Subject          | SendEmailTrigger  |
      | TAA133oauth@gmail.com   | happy123$   | Web Audit Page         | google  | your Web Audit   | Web Audit         |
      | TAA133oauth@gmail.com   | happy123$   | Proposal Page          | google  | This is a test   | Proposal          |
      | TAA133oauth@gmail.com   | happy123$   | Lead Generator Page    | google  | This is a test   | Lead Gen          |
      
  #Covered Ticket : SRS-3469, SRS-3940, SRS-4713
  # Given I am a Partner
  # And I have not yet setup my Email Settings Wizard
  # And the date today is > May 15 2018
  # When I click an email trigger except for WebAudit/Proposal in the Dashboard
  # Then Ill see the Email Settings Wizard Modal
  # And Ill not see the 'By May 15, 2018' verbiage
  # And Ill not see the Do It Later button
  #@SRSSMOKETEST @SafeEmail @SafeEmailOauth_TS02 @TAA-141
  #Scenario Outline: TAA-141
    #Given Im an existing Partner
#		When I navigate to "SEOSTG_Login"
#		And I enter <Email> in the Email Address Field
#		And I enter <Password> in the Password Field
#		And I click the Log in to your Dashboard button
#		Then Ill see the Dashboard Page
#		
#	  When I redirect to SEO1_<DashBoardPage>
#		And I click the  Email Trigger of <SendEmailTrigger>
#		Then Ill see the Email Setup Wizard Modal
#		And Ill not see the SEO00_ByMayFifteen text
#		And Ill see the SEO12_EmailAddress textfield
#		And Ill see the SEO12_Next button
#		And Ill see the SEO12_Next button
#		And Ill not see the SEO00_DoItLater button
    #
    #Examples: 
      #| Email  								 | Password    | SafeEmail          | DashBoardPage       |  SendEmailTrigger   |
      #| TAA141oauth@gmail.com  | happy123$   | TAA159@yahoo.com   | Lead Generator Page |  Lead Gen           |
      #| TAA141oauth@gmail.com  | happy123$   | TAA159@hotmail.com | Lead Generator Page |  Lead Gen Sequence  | 
      #| TAA141oauth@gmail.com  | happy123$   | TAA159@live.com    |  CRM Page           |  CRM                |
      #| TAA141oauth@gmail.com  | happy123$   | TAA159@msn.com     |  CRM Page           |  CRM Details Send   |
      #| TAA141oauth@gmail.com  | happy123$   | TAA159@outlook.com |  CRM Page           |  CRM Sequence       |