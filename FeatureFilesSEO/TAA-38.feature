#Author: reuel@truelogic.com.ph, lorraine@truelogic.com.ph
#Version 1.0 06.27 2018 - Initial creation of file
Feature: [TAA-38] [SEOReseller]: Registration Smoke/Regression TestSuite

  #Covered Ticket : SRS-2544, SRS-2690, SRS-3160, SRS-2545, SRS-2546, SRS-4157
  #Scenario Description:
  #Given I'm a new Partner
  #When I Manual Sign-Up successfully through GMAIL
  #Then I'll be directed to Welcome Page
  #When I verify the email
  #And Finish the Company Profile Set up
  #Then I'll see the Home Page of the Dashboard
  @SRSSMOKETEST @Registration @Registration_TS01 @TAA-88
  Scenario Outline: TAA-88
    Given Im a new Partner
    And I ensure that <Email> does not exist
    When I navigate to "Login"
    Then Ill see the SEO06_SeoReseller Banner
    
    When I click SEO06_SignUp link
    And I wait for page to load
    Then Ill see the SEO010_SignUp Page
    And Ill see the SEO010_TwoMinutesSetupToGetStarted_div with "2 minute setup to get started with SEOReseller right away. Grow your agency by outsourcing your SEO, Web Design, Social Media, Link Building and more!"
    And Ill see the SEO010_SignInWithGoogle button
    And Ill see the SEO010_FirstName textfield
    And Ill see the SEO010_LastName textfield
    And Ill see the SEO010_EmailAddress textfield
    And Ill see the SEO010_Password textfield
    And Ill see the SEO010_TermsOfUseAndPrivacyPolicyVerbiage_div with "By signing up, you agree to SEOReseller's Terms of Use and Privacy Policy"
    And Ill see the SEO010_AlreadyhaveAnAccount_div with "Already have an account"
    And Ill see the SEO010_CreateAccount button
   
    When I populate the SEO010_FirstName textfield with <FirstName>
    And I populate the SEO010_LastName textfield with <LastName>
    And I populate the SEO010_Email textfield with <Email>
    And I populate the SEO010_Password textfield with <Password>
    And I click SEO010_CreateAccount button
    And I wait for page to load
    Then Ill be redirected to SEO11_Welcome page
    And I see the SEO11_Congratulations div with "Congratulations! You are just one step away to access all features of your free account."
    
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    Then I see the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
   
		When I click the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    Then Ill see the GMAIL01_ThankYouForRegistering div with "Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below."
    And Ill see the GMAIL01_GotoMyDashboard <ElementName>
    
    When I click the GMAIL01_GotoMyDashboard <ElementName>
    And I navigate to ChildWindow
    And I wait for page to load
    And I click the SEO16_LetsGetStarted button
    And I click the SEO17_Skip link
    And I click the SEO18_LetsGoToTheDashboard button
    Then Ill see the SEO01_SuccessAccountVerifyMessage div with "Congratulations! You have successfully verified your email address."
    
    When I click the SEO01_UserAvatar button
    And I click the SEO01_Logout list
    And I wait for page to load
    Then Ill see the SEO06_LogIn page
    
    When I populate the SEOE6_EmailAddress textfield with <Email>
    And I populate the SEOE6_Password textfield with <Password>
    And I click the SEO06_LoginToYourDashBoard button
    Then Ill not see the SEO01_CompanySetup popup

    Examples: 
      | FirstName | LastName   | Email                         | Password  | ElementName | Country     | CompanyName    | CompanyProfile                 | ExistingClients     | CompanyWebsite | BusinessPhone | Address |
      | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      | Philippines | This is a test | I have 10 to 30 employees.     | 10 to 20 clients.   | www.test.com   |    9171111111 | Makati  |
      | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | link        | Philippines | This is a test | I have more than 30 employees. | Exceeds 20 clients. | www.test.com   |    9171111111 | Makati  |

  #Covered Ticket : SRS-2544, SRS-2690, SRS-3160, SRS-2545, SRS-2546, SRS-4157
  #Scenario Description:
  #Given I'm a new Partner
  #When I Manual Sign-Up successfully through ZOHO
  #Then I'll be directed to Welcome Page
  #When I verify the email
  #And Finish the Company Profile Set up
  #Then I'll see the Home Page of the Dashboard
  @SRSSMOKETEST @Registration @Registration_TS01 @TAA-241
  Scenario Outline: TAA-241
    Given Im a new Partner
    And I ensure that <Email> does not exist
    When I navigate to "Login"
    Then Ill see the SEO06_SeoReseller Banner
    When I click SEO06_SignUp link
    And I wait for page to load
    Then Ill see the SEO010_SignUp Page
    And Ill see the SEO010_TwoMinutesSetupToGetStarted_div with "2 minute setup to get started with SEOReseller right away. Grow your agency by outsourcing your SEO, Web Design, Social Media, Link Building and more!"
    And Ill see the SEO010_SignInWithGoogle button
    And Ill see the SEO010_FirstName textfield
    And Ill see the SEO010_LastName textfield
    And Ill see the SEO010_EmailAddress textfield
    And Ill see the SEO010_Password textfield
    And Ill see the SEO010_TermsOfUseAndPrivacyPolicyVerbiage_div with "By signing up, you agree to SEOReseller's Terms of Use and Privacy Policy"
    And Ill see the SEO010_AlreadyhaveAnAccount_div with "Already have an account"
    And Ill see the SEO010_CreateAccount button
    When I populate the SEO010_FirstName textfield with <FirstName>
    And I populate the SEO010_LastName textfield with <LastName>
    And I populate the SEO010_Email textfield with <Email>
    And I populate the SEO010_Password textfield with <Password>
    And I click SEO010_CreateAccount button
    And I wait for page to load
    Then Ill be redirected to SEO11_Welcome page
    And I see the SEO11_Congratulations div with "Congratulations! You are just one step away to access all features of your free account."
    When I navigate to ZOHO
    And I click the ZOHO01_Login link
    And I populate the ZOHO01_Email textField with <Email>
    And I populate the ZOHO01_Password textField with <Password>
    And I click the ZOHO01_SignIn button
    And I wait for page to load
    And I click the ZOHO01_SEOReseller button
    Then I see the ZOHO01_EmailSubject div with "Please Confirm Your Email Address"
    When I click the ZOHO01_EmailSubject div with "Please Confirm Your Email Address"
    And I wait for page to load
    Then Ill see the ZOHO01_ThankYouForRegistering div with "Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below."
    And Ill see the ZOHO01_GotoMyDashboard <ElementName>
    When I click the ZOHO01_GotoMyDashboard <ElementName>
    And I navigate to ChildWindow
    And I click the SEO16_LetsGetStarted button
    And I click the SEO17_Skip link
    And I click the SEO18_LetsGoToTheDashboard button
    Then Ill see the SEO01_SuccessAccountVerifyMessage div with "Congratulations! You have successfully verified your email address."
    When I click the SEO01_UserAvatar button
    And I click the SEO01_Logout list
    And I wait for page to load
    Then Ill see the SEO06_LogIn page
    When I populate the SEOE6_EmailAddress textfield with <Email>
    And I populate the SEOE6_Password textfield with <Password>
    And I click the SEO06_LoginToYourDashBoard button
    Then Ill not see the SEO01_CompanySetup popup

    Examples: 
      | FirstName | LastName   | Email                        | Password  | ElementName | Country     | CompanyName    | CompanyProfile                 | ExistingClients     | CompanyWebsite | BusinessPhone | Address |
      | RND       | Automation | RNDAutomationTest12@zoho.com | happy123$ | button      | Philippines | This is a test | I have 10 to 30 employees.     | 10 to 20 clients.   | www.test.com   |    9171111111 | Makati  |
      | RND       | Automation | RNDAutomationTest12@zoho.com | happy123$ | link        | Philippines | This is a test | I have more than 30 employees. | Exceeds 20 clients. | www.test.com   |    9171111111 | Makati  |

  #Covered Ticket : SRS-2544, SRS-2690, SRS-3160, SRS-2545, SRS-2546, SRS-4157
  #Scenario Description:
  #Given I'm a new Partner,
  #When I Auto Google Sign-Up successfully
  #Then I'll see the Dashboard
  @SRSSMOKETEST @Registration @Registration_TS02 @TAA-96
  Scenario Outline: TAA-96
    Given Im a new Partner
    And I ensure that <Email> does not exist
    When I navigate to "Login"
    Then Ill see the SEO06_SeoReseller Banner
    When I click SEO06_SignUp link
    And I wait for page to load
    Then Ill see the SEO010_SignUp Page
    And Ill see the SEO010_TwoMinutesSetupToGetStarted_div with "2 minute setup to get started with SEOReseller right away. Grow your agency by outsourcing your SEO, Web Design, Social Media, Link Building and more!"
    And Ill see the SEO010_SignInWithGoogle button
    And Ill see the SEO010_FirstName textfield
    And Ill see the SEO010_LastName textfield
    And Ill see the SEO010_EmailAddress textfield
    And Ill see the SEO010_Password textfield
    And Ill see the SEO010_TermsOfUseAndPrivacyPolicyVerbiage_div with "By signing up, you agree to SEOReseller's Terms of Use and Privacy Policy"
    And Ill see the SEO010_AlreadyhaveAnAccount_div with "Already have an account"
    And Ill see the SEO010_CreateAccount button
    When I click the SEO010_SignInWithGoogle button
    And I navigate to ChildWindow
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    And I wait for 3000 millisecond
    And I navigate to ParentWindow
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_Logout list
    And I wait for page to load
    Then Ill see the SEO06_LogIn page
    When I populate the SEOE6_EmailAddress textfield with <Email>
    And I populate the SEOE6_Password textfield with <Password>
    And I click the SEO06_LoginToYourDashBoard button
    Then Ill not see the SEO01_CompanySetup popup

    Examples: 
      | FirstName | LastName   | Email                         | Password  | Country     | CompanyName    | CompanyProfile                | ExistingClients    | CompanyWebsite | BusinessPhone | Address |
      | RND       | Automation | RNDAutomationTest14@gmail.com | happy123$ | Philippines | This is a test | I have more than 30 employees | Exceeds 20 clients | www.test.com   |    9171111111 | Makati  |

  #Covered Ticket : SRS-2544,SRS-2690,SRS-3160,SRS-2545,SRS-2546,SRS-4157
  #Scenario Description:
  #Given I'm a new Partner,
  #When I Manual Sign-Up successfully
  #And I resend the verification link
  #Then I see the Dashboard
  @SRSSMOKETEST @Registration @Registration_TS03 @TAA-104
  Scenario Outline: TAA-104
    Given Im a new Partner
    And I ensure that <Email> does not exist
    When I navigate to "Login"
    Then Ill see the SEO06_SeoReseller Banner
    When I click SEO06_SignUp link
    And I wait for page to load
    Then Ill see the SEO010_SignUp Page
    And Ill see the SEO010_TwoMinutesSetupToGetStarted_div with "2 minute setup to get started with SEOReseller right away. Grow your agency by outsourcing your SEO, Web Design, Social Media, Link Building and more!"
    When I populate the SEO010_FirstName textfield with <FirstName>
    And I populate the SEO010_LastName textfield with <LastName>
    And I populate the SEO010_Email textfield with <Email>
    And I populate the SEO010_Password textfield with <Password>
    And Ill see the SEO010_TermsOfUseAndPrivacyPolicyVerbiage_div with "By signing up, you agree to SEOReseller's Terms of Use and Privacy Policy"
    And Ill see the SEO010_AlreadyhaveAnAccount_div with "Already have an account"
    And I click SEO010_CreateAccount button
    And I wait for page to load
    Then Ill be redirected to SEO11_Welcome page
    And I see the SEO11_Congratulations div with "Congratulations! You are just one step away to access all features of your free account."
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    Then I see the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    When I click the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    Then Ill see the GMAIL01_ThankYouForRegistering div with "Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below."
    And Ill see the GMAIL01_GotoMyDashboard <ElementName>
    When I navigate back to "Welcome"
    And I wait for page to load
    Then Ill be redirected to SEO11_Welcome page
    And I click the SEO11_resend link
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    Then I see the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    When I click the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    Then Ill see the GMAIL01_ThankYouForRegistering div with "Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below."
    And Ill see the GMAIL01_GotoMyDashboard <ElementName>
    When I click the GMAIL01_GotoMyDashboard <ElementName>
    And I click the SEO16_LetsGetStarted button
    And I click the SEO17_Skip link
    And I click the SEO18_LetsGoToTheDashboard button
    Then Ill see the SEO01_SuccessAccountVerifyMessage div with "Congratulations! You have successfully verified your email address."
    When I click the SEO01_UserAvatar button
    And I click the SEO01_Logout list
    And I wait for page to load
    Then Ill see the SEO06_LogIn page
    When I populate the SEOE6_EmailAddress textfield with <Email>
    And I populate the SEOE6_Password textfield with <Password>
    And I click the SEO06_LoginToYourDashBoard button
    Then Ill not see the SEO01_CompanySetup popup

    Examples: 
      | FirstName | LastName   | Email                         | Password  | Country     | CompanyName    | CompanyProfile                | ExistingCLients    | CompanyWebsites | BusinessPhone | Address |
      | RND       | Automation | RNDAutomationTest15@gmail.com | happy123$ | Philippines | This is a Test | I have more than 30 employees | Exceeds 20 Clients | www.test.com    |    9171111111 | Makati  |
