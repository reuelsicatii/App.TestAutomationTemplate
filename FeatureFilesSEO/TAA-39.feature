#Author: reuel@truelogic.com.ph, lorraine@truelogic.com.ph
#Version 1.0 06.27 2018 - Initial creation of file
Feature: [TAA-39] [SEOReseller] Login/Logout Smoke/Regression TestSuite

  #Scenario Description:
  #Covered Ticket : SRS-4968
  #Given I'm a  Partner
  #When I Manual log in Successfully
  #And Click Log Out
  #Then I'll see the Log in Page
  @SRSSMOKETEST @LoginLogout @LoginLogout_TS01 @TAA-40
  Scenario Outline: TAA-40
    Given Im an existing Partner
    When I navigate to "Login"
    Then Ill see the SEO06_EmailAddress textfield
    And Ill see the SEO06_Password textfield
    And Ill see the SEO06_LogIntoyouDashboard button
    And Ill see the SEO06_SigninwithGoogle button
    And Ill see the SEO06_TermsofUseandPrivacyPolicy div with message "By logging in, you agree to SEOReseller's Terms of Use and Privacy Policy"
    When I populate the SEOE6_EmailAddress textfield with <Email>
    And I populate the SEOE6_Password textfield with <Password>
    And I click the SEO06_LoginToYourDashBoard button
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_Logout list
    Then Ill see the SEO06_LogIn page
    And Ill see the SEO06_Password textfield
    And Ill see the SEO06_LogIntoyouDashboard button
    And Ill see the SEO06_SigninwithGoogle button
    And Ill see the SEO06_TermsofUseandPrivacyPolicy div with message "By logging in, you agree to SEOReseller's Terms of Use and Privacy Policy"
		And Ill see that the SEO06_TermsofUse link will direct to /terms-use upon click
		And Ill see that the SEO06_PrivacyPolicy link will direct to /privacy-policy upon click
    Examples: 
      | Email                        | Password  |
      | rndautomationtest5@gmail.com | happy123$ |

  #Scenario Description:
  #Covered Ticket : SRS-4968
  #Given I'm a  Partner
  #When I Manual log in unsuccessfully
  #Then I'll not be redirected to the Dashboard
  @SRSSMOKETEST @LoginLogout @LoginLogout_TS02 @TAA-41
  Scenario Outline: TAA-41
    Given Im an existing Partner
    When I navigate to "Login"
    Then Ill see the SEO06_EmailAddress textfield
    And Ill see the SEO06_Password textfield
    And Ill see the SEO06_LogIntoyouDashboard button
    And Ill see the SEO06_SigninwithGoogle button
    And Ill see the SEO06_TermsofUseandPrivacyPolicy div with message "By logging in, you agree to SEOReseller's Terms of Use and Privacy Policy"
    When I populate the SEOE6_EmailAddress textfield with <Email>
    And I populate the SEOE6_Password textfield with <Password>
    And I click the SEO06_LoginToYourDashBoard button
    Then Ill see the SEO06_Error div with <Message>
    And Ill not see the SEO00_Dashboard page

    Examples: 
      | Email                        | Password  | Message   |
      | rndautomationtest6@gmail.com |           | Incorrect |
      |                              | happy123$ | Blank     |
      |                              |           | Blank     |

  #Scenario Description:
  #Covered Ticket : SRS-4968
  #Given I'm a  Partner
  #When I Google log in Successfully
  #And Click Log Out
  #Then I'll see the Log in Page
  @SRSSMOKETEST @LoginLogout @LoginLogout_TS03 @TAA-42
  Scenario Outline: TAA-42
    Given Im an existing Partner
    When I navigate to "Login"
    Then Ill see the SEO06_EmailAddress textfield
    And Ill see the SEO06_Password textfield
    And Ill see the SEO06_LogIntoyouDashboard button
    And Ill see the SEO06_SigninwithGoogle button
    And Ill see the SEO06_TermsofUseandPrivacyPolicy div with message "By logging in, you agree to SEOReseller's Terms of Use and Privacy Policy"
    When I click the SEO06_SigninwithGoogle button
    And I navigate to ChildWindow
    Then Ill see the GMAIL01_GooglePopUp window
    When I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    Then Ill not see the GMAIL01_GooglePopUp window
    When I navigate to ParentWindow
    Then Ill see the SEO00_Dashboard page
		When I click the SEO01_UserAvatar button
    And I click the SEO01_Logout list
    Then Ill see the SEO06_LogIn page

    Examples: 
      | Email                        | Password  |
      | RNDAutomationTest7@gmail.com | happy123$ |
