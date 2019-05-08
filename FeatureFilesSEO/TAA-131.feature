#Author: lorraine@truelogic.com.ph
#Version 1.0 06.27 2018 - Initial creation of file
Feature: [TAA-131] [SEOReseller]: SafeEmail_IMAP Smoke/Regression TestSuite

  #Covered Ticket : SRS-3468
  #Scenario Description:
  #Given I am an existing Partner
  #And I have not yet setup my Email Settings Wizard
  #And I have a Yahoo/Microsoft Account
  #When I set the Email Wizard Settings
  #Then I'll see the 'Oops. We currently don't support Yahoo and Microsot emails. 'Message
  @SRSSMOKETEST @SafeEmail_IMAP @SafeEmail_TS01 @TAA-159
  Scenario Outline: TAA-159
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then Ill see the SEO06_LogIn page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_EmailSettings
    Then Ill see the Email Settings Page
    When I click SEO12_Update button
    Then Ill see the Email Setup Wizard Modal
    And Ill see the "SEOReseller will send its emails using your email account. Please confirm the email address you will be using."
    And Ill see the SEO12_EmailAddress textfield
    And Ill see the SEO12_Next button
    When I enter <SafeEmail> in the SEO12_EmailAddress textfield
    And I click SEO12_Next button
    Then Ill see the "We currently dont support Yahoo and Microsoft emails." Message
    And Ill see the SEO12_Retry button

    Examples: 
      | Email                | Password  | SafeEmail          |
      | TAA159imap@gmail.com | happy123$ | TAA159@yahoo.com   |
      | TAA159imap@gmail.com | happy123$ | TAA159@hotmail.com |
      | TAA159imap@gmail.com | happy123$ | TAA159@live.com    |
      | TAA159imap@gmail.com | happy123$ | TAA159@msn.com     |
      | TAA159imap@gmail.com | happy123$ | TAA159@outlook.com |

  #Covered Ticket : SRS-3468
  #Scenario Description:
  #Given I am an existing Partner
  #And I have not yet setup my Email Settings Wizard
  #And I have a Yahoo/Microsoft Account
  #When I click an email trigger in the Dashboard
  #Then I'll see the 'Oops. We currently don't support Yahoo and Microsot emails. 'Message
  @SRSSMOKETEST @SafeEmail_IMAP @SafeEmail_TS02 @TAA-163
  Scenario Outline: TAA-163
  Given Im an existing Partner
	When I navigate to "SEOSTG_Login"
	And I populate the SEOE6_EmailAddress textfield with <email>
	And I populate the SEOE6_Password textfield with <password>
	And I click the SEO06_LoginToYourDashBoard button
	Then Ill see the SEO06_LogIn page
		
	When I redirect to SEO1_<DashBoardPage>
	And I click the  Email Trigger of <SendEmailTrigger>
	Then Ill see the Email Setup Wizard Modal
		
	When I enter <SafeEmail> in the SEO12_EmailAddress textfield
	And I click SEO12_Next button
	Then Ill see the "We currently dont support Yahoo and Microsoft emails." Message
	And Ill see the SEO12_Retry button	

    Examples: 
      | Email                | Password  | SafeEmail        | DashBoardPage       | SendEmailTrigger  |
      | TAA163imap@gmail.com | happy123$ | TAA163@yahoo.com | Web Audit Page      | Web Audit         |
      | TAA163imap@gmail.com | happy123$ | TAA163@yahoo.com | Proposal Page       | Proposal          |
      | TAA163imap@gmail.com | happy123$ | TAA163@yahoo.com | Lead Generator Page | Lead Gen          |
      | TAA163imap@gmail.com | happy123$ | TAA163@yahoo.com | Lead Generator Page | Lead Gen Sequence |
      | TAA163imap@gmail.com | happy123$ | TAA163@yahoo.com | CRM Page            | CRM               |
      | TAA163imap@gmail.com | happy123$ | TAA163@yahoo.com | CRM Page            | CRM Sequence      |
      | TAA163imap@gmail.com | happy123$ | TAA163@msn.com   | Web Audit Page      | Web Audit         |
      | TAA163imap@gmail.com | happy123$ | TAA163@msn.com   | Proposal Page       | Proposal          |
      | TAA163imap@gmail.com | happy123$ | TAA163@msn.com   | Lead Generator Page | Lead Gen          |
      | TAA163imap@gmail.com | happy123$ | TAA163@msn.com   | Lead Generator Page | Lead Gen Sequence |
      | TAA163imap@gmail.com | happy123$ | TAA163@msn.com   | CRM Page            | CRM               |
      | TAA163imap@gmail.com | happy123$ | TAA163@msn.com   | CRM Page            | CRM Sequence      |

  #Covered Ticket : SRS-3000, SRS-3202, SRS-3490, SRS-3260, SRS-4099, SRS-2721
  #Given I am a Partner
  #And I have not yet setup my Email Settings Wizard
  #When I set up my Email Settings Wizard
  #And I click an Email Trigger
  #Then Ill see that the email is sent by indicated email address in the email wizard settings
  #And Ill see the status of the Email Signature in my email
  @SRSSMOKETEST @SafeEmail_IMAP @SafeEmail_TS02 @TAA-174
  Scenario Outline: TAA-174
    Given Im an existing Partner
    When I navigate to "Login"
		And I populate the SEOE6_EmailAddress textfield with <email>
		And I populate the SEOE6_Password textfield with <password>
		And I click the SEO06_LoginToYourDashBoard button
		Then I see the SEO01_Home Page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_Email Settings List
    Then Ill see the Email Settings Page
    And Ill see the "This is an auto-generated signature for your convenience." text
    And Ill see the "Please make sure to include your company address." text
    And I <SetUpCondition> my Email Signature
    When I click the SEO12_Add button
    And I populate <Email> in the SEO12_EmailAddress textfield
    And I click the SEO12_Next button
    And I populate SEO12_Username textfield with <Email>
    And I populate SEO12_Password textfield with <Password>
    And I populate SEO12_IMAP textfield with <IMAP>
    And I populate SEO12_IMAPport textfield with <IMAPport>
    And I populate SEO12_SMTP textfield with <SMTP>
    And I populate SEO12_SMTPport textfield with <SMTPport>
    And I click the SEO12_SignIn button
    Then Ill see the Let's Roll Modal

    Examples: 
      | Email            | Password | DashBoardPage  | SendEmailTrigger | SubjectB       | Body           | Domain | EmailSignatureStatus | SetUpCondition | Subject            | IMAP          | IMAPport | SMTP          | SMTPport |
      | TAA_174@zoho.com | happy123 | Web Audit Page | Web Audit        | This is a test | This is a test | google | not displayed        | did not set up | Email Setup Wizard | imap.zoho.com |      993 | smtp.zoho.com |      465 |
     #| TAA_174@zoho.com  | happy123$ | Web Audit Page      | Web Audit              | This is a test | This is a test | google | not displayed        | did not set up | Email Setup Wizard |
     #| TAA_174@zoho.com  | happy123$ | Proposal Page       | Proposal               | This is a test | This is a test | google | not displayed        | did not set up | Email Setup Wizard |
     #| TAA_174@zoho.com  | happy123$ | Proposal Page       | Newly Created Proposal | This is a test | This is a test | google | not displayed        | did not set up | Email Setup Wizard |
     #| TAA_174@zoho.com  | happy123$ | Lead Generator Page | Lead Gen               | This is a test | This is a test | google | not displayed        | did not set up | Email Setup Wizard |
     #| TAA_174@zoho.com  | happy123$ | Lead Generator Page | Lead Gen Sequencer     | This is a test | This is a test | google | not displayed        | did not set up | Email Setup Wizard |
     #| TAA_174@zoho.com  | happy123$ | CRM Page            | CRM                    | This is a test | This is a test | google | not displayed        | did not set up | Email Setup Wizard |
     #| TAA_174@zoho.com  | happy123$ | CRM Details Page    | CRM                    | This is a test | This is a test | google | not displayed        | did not set up | Email Setup Wizard |
     #| TAA_1748@zoho.com | happy123$ | CRM Page            | CRM Email Sequencer    | This is a test | This is a test | google | not displayed        | did not set up | Email Setup Wizard |
