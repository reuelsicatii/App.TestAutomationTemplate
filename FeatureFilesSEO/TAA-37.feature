#Author: reuel@truelogic.com.ph, lorraine@truelogic.com.ph
#Version 1.0 06.27 2018 - Initial creation of file
Feature: [TAA-37] [SEOReseller]: Forgot Password Smoke/Regression TestSuite

  #Scenario Description:
  #Covered Tickets : SRS-2493, SRS-3106
  #Given I'm a existing Partner
  #When I Click Forgot Password
  #And Successfully Changed the Password
  #Then I'll see the Dashboard Page
  @SRSSMOKETEST @ForgotPassword @ForgotPassword_TS01 @TAA-43
  Scenario Outline: TAA-43
    Given Im an existing Partner
    When I navigate to "Login"
    And I click the SEO06_ForgotPassword link
    Then Ill see the SEO08_ForgotPassword page
    And Ill see the SEO08_SRS banner
    When I enter <Email> in the SEO08_EnterEmail textfield
    And I click the SEO08_Submit button
    Then Ill see the SEO08_Message div with "You are almost in your account! Please check your email to reset your password"
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    And I click the GMAIL01_EmailSubject div with "Reset Account Password Request"
    Then Ill see the GMAIL01_Message div with "To reset your password please click on the button below. Link will only be valid for 24 hours:"
    And Ill see the GMAIL01_ResetYourPassword <ElementName>
    When I click the GMAIL01_ResetYourPassword <ElementName>
    And I navigate to ChildWindow
    Then Ill see the SEO09_ResetPassword page
    And Ill see the SEO09_Message input with "Should be at least 8 characters"
    And Ill see the SEO09_Toggle button
    And Ill see the SEO09_BacktoLoginpage link
    When I populate SEO09_Password textfield with <NewPassword>
    And I click the SEO09_Submit button
    Then Ill see the SEO00_Dashboard page
    When I navigate to ParentWindow
    And I click the GMAIL01_EmailSubject div with "Account Password successfully updated"
    Then Ill see the GMAIL01_Message div with "This message is to confirm that you changed your password. Please see details:"

    Examples: 
      | Email                        | Password  | NewPassword | ElementName |
      | RNDAutomationTest8@gmail.com | happy123$ | happy123    | link        |
      | RNDAutomationTest8@gmail.com | happy123$ | happy123    | button      |
      | RNDAutomationTest8@gmail.com | happy123$ | 12345678    | link        |
      | RNDAutomationTest8@gmail.com | happy123$ | 12345678    | button      |
      | RNDAutomationTest8@gmail.com | happy123$ | happyabc    | link        |
      | RNDAutomationTest8@gmail.com | happy123$ | happyabc    | button      |

  #Scenario Description:
  #Covered Tickets : SRS-2493, SRS-3106
  #Given I'm a existing Partner
  #When I Click Forgot Password
  #And Unsuccessfully Changed the Password
  #Then I'll not see the Dashboard Page
  @SRSSMOKETEST @ForgotPassword @ForgotPassword_TS02 @TAA-44
  Scenario Outline: TAA-44
    Given Im an existing Partner
    When I navigate to "Login"
    And I click the SEO06_ForgotPassword link
    Then Ill see the SEO08_ForgotPassword page
    And Ill see the SEO08_SRS banner
    When I enter <Email> in the SEO08_EnterEmail textfield
    And I click the SEO08_Submit button
    Then Ill see the SEO08_Message div with "You are almost in your account! Please check your email to reset your password"
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    And I click the GMAIL01_EmailSubject div with "Reset Account Password Request"
    Then Ill see the GMAIL01_Message div with "To reset your password please click on the button below. Link will only be valid for 24 hours:"
    And Ill see the GMAIL01_ResetYourPassword <ElementName>
    When I click the GMAIL01_ResetYourPassword <ElementName>
    And I navigate to ChildWindow
    Then Ill see the SEO09_ResetPassword page
    And Ill see the SEO09_Message input with "Should be at least 8 characters"
    And Ill see the SEO09_Toggle button
    And Ill see the SEO09_BacktoLoginpage link
    When I populate SEO09_Password textfield with <NewPassword>
    And I click the SEO09_Submit button
    Then Ill see the SEO09_Message div with "The Password field must be at least 8 characters in length."
    And Ill see the SEO09_ResetPassword page

    Examples: 
      | Email                        | Password  | NewPassword | ElementName |
      | RNDAutomationTest9@gmail.com | happy123$ |         123 | link        |
      | RNDAutomationTest9@gmail.com | happy123$ |         123 | button      |

  #Scenario Description:
  #Covered Tickets : SRS-2493, SRS-3106z
  #Given I'm a existing Partner
  #When I Click Forgot Password
  #And did not change the Password
  #Then I'll see the Dashboard Page
  @SRSSMOKETEST @ForgotPassword @ForgotPassword_TS03 @TAA-45
  Scenario Outline: TAA-45
    Given Im an existing Partner
    When I navigate to "Login"
    And I click the SEO06_ForgotPassword link
    Then Ill see the SEO08_ForgotPassword page
    And Ill see the SEO08_SRS banner
    When I enter <Email> in the SEO08_EnterEmail textfield
    And I click the SEO08_Submit button
    Then Ill see the SEO08_Message div with "You are almost in your account! Please check your email to reset your password"
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    And I click the GMAIL01_EmailSubject div with "Reset Account Password Request"
    Then Ill see the GMAIL01_Message div with "To reset your password please click on the button below. Link will only be valid for 24 hours:"
    And Ill see the GMAIL01_ResetYourPassword <ElementName>
    When I click the GMAIL01_ResetYourPassword <ElementName>
    And I navigate to ChildWindow
    Then Ill see the SEO09_ResetPassword page
    And Ill see the SEO09_Message input with "Should be at least 8 characters"
    And Ill see the SEO09_Toggle button
    And Ill see the SEO09_BacktoLoginpage link
    When I click the SEO09_BacktoLoginpage link
    Then Ill see the SEO00_LogIn page
    When I populate the SEOE6_EmailAddress textfield with <Email>
    And I populate the SEOE6_Password textfield with <Password>
    And I click the SEO06_LoginToYourDashBoard button
    Then Ill see the SEO00_Dashboard page

    Examples: 
      | Email                         | Password  | ElementName |
      | RNDAutomationTest10@gmail.com | happy123$ | button      |
      | RNDAutomationTest10@gmail.com | happy123$ | link        |
