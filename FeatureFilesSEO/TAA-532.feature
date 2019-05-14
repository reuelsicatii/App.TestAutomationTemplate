#Author: reuel@truelogic.com.ph, lorraine@truelogic.com.ph
#Version 1.0 01.28 2019 - Initial creation of file
Feature: [TAA-519] [SEOReseller] Manage Users Menu Smoke/Regression TestSuite

  #Scenario Description:
  #Given I am a Partner
  #When I navigate to the Manage Users Page
  #And I click the Add New User button
  #Then Ill see the Add New User Modal
  #And Ill see that the UI of Add New User Modal is aligned with the requirements
  @SRSSMOKETEST @ManageUsers @ManageUsers_TS01 @TAA-535
  Scenario Outline: ManageUsers_TS01
    Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I click the SEO22_AddNewUser button
    Then Ill see the SEO22_AddNewUser Modal
    And Ill see the SEO22_EmailAddress textfield
    And Ill see the SEO22_Username textfield
    And Ill see the SEO22_Role dropdown
    And Ill see the SEO22_Password textfield
    And Ill see that the Password textfield contains a SEO22_Toggle icon
    And Ill see the SEO22_Save button
    And Ill see the SEO22_Close button
    And Ill see the SEO22_Xclose button of Add New User Modal

    Examples: 
      | FirstName | LastName   | email                     | password  |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 |

  #Scenario Description:
  #When I navigate to the Manage Users Page
  #And I click the Add New User button
  #Then Ill be able to add New Users
  @SRSSMOKETEST @ManageUsers @ManageUsers_TS02 @TAA-539
  Scenario Outline: ManageUsers_TS02
    Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I click the SEO22_AddNewUser button
    And I populate SEO22_EmailAddress textfield with <userEmailAdd>
    And I populate SEO22_Username textfield with <username>
    And I select <roleClassification> in SEO22_Role dropdown
    And I populate SEO22_Password textfield with <userPassword>
    And I click the SEO22_Save button
    Then Ill see the SEO23_ProfileInformation header

    Examples: 
      | FirstName | LastName   | email                     | password  | userEmailAdd           | username     | roleClassification | userPassword |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | EmployeeTS02@gmail.com | EmployeeTS02 | Employee           | emp12345     |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | ClientTS02@gmail.com   | ClientTS02   | Client             | cli12345     |

  #Scenario Description:
  #When I navigate to the Manage Users Page
  #And I click the Add New User button
  #And the email is already used in same/other partner account
  #Then Ill see the "This Email is already in use." text
  @SRSSMOKETEST @ManageUsers @ManageUsers_TS03 @TAA-541
  Scenario Outline: ManageUsers_TS03
    Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I click the SEO22_AddNewUser button
    And I enter SEO22_EmailAddress textfield with an existing email <userEmailAdd>
    And I click the SEO22_Save button
    Then Ill see the SEO22_EmailAlreadyUsed 'This Email is already in use.' text

    Examples: 
      | FirstName | LastName   | email                     | password  | userEmailAdd                    | username     | roleClassification | userPassword |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | EmployeeTS03Duplicate@gmail.com | EmployeeTS02 | Employee           | emp12345     |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | ClientTS03Duplicate@gmail.com   | ClientTS02   | Client             | cli12345     |

  #Scenario Description:
  #When I navigate to the Manage Users Page
  #And I click the Add New User button
  #And the suername is already used in same/other partner account
  #Then Ill see the "The Username field must contain a unique value." text
  @SRSSMOKETEST @ManageUsers @ManageUsers_TS04 @TAA-543
  Scenario Outline: ManageUsers_TS04
    Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I click the SEO22_AddNewUser button
    And I enter SEO22_Username textfield with an existing user <username>
    And I click the SEO22_Save button
    Then Ill see the SEO22_UsernamMustBeUnique 'The Username field must contain a unique value.' text

    Examples: 
      | FirstName | LastName   | email                     | password  | username           |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | EmployeeTS04Unique |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | ClientTS04Unique   |

  #Scenario Description:
  #When I navigate to the Manage Users Page
  #And I click the Add New User button
  #And the password is less than 8 characters
  #Then Ill see the "The Password field must be at least 8 characters in length." text
  @SRSSMOKETEST @ManageUsers @ManageUsers_TS05 @TAA-545
  Scenario Outline: ManageUsers_TS05
    Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I click the SEO22_AddNewUser button
    And I populate SEO22_Password textfield with <userPassword>
    And I click the SEO22_Save button
    Then Ill see the SEO22_UsernamMustBeUnique 'The Password field must be at least 8 characters in length.' text

    Examples: 
      | FirstName | LastName   | email                     | password  | userPassword |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 |        12345 |

  #Scenario Description:
  #Given I am a Partner
  #When I navigate to the Manage Users Page
  #And I click a delecte user button
  #Then Ill see the Delete User Modal
  #And Ill see that the UI of Delete User Modal is aligned with the requirements
  @SRSSMOKETEST @ManageUsers @ManageUsers_TS06 @TAA-547
  Scenario Outline: ManageUsers_TS06
    Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I populate SEO22_Search textfield with <username>
    And I click the SEO22_Search button
    And I click the SEO22_DeleteUser button of <username>
    Then Ill see the SEO22_DeleteUser Modal
    And Ill see the SEO22_Confirmation 'Are you sure you want to delete this user' text
    And Ill see the SEO22_Yes button
    And Ill see the SEO22_No button
    And Ill see the SEO22_Xclose button of Delete User Modal

    Examples: 
      | FirstName | LastName   | email                     | password  | userEmailAdd           | username     | roleClassification | userPassword |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | EmployeeTS06@gmail.com | EmployeeTS06 | Employee           | emp12345     |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | ClientTS06@gmail.com   | ClientTS06   | Client             | cli12345     |

  #Scenario Description:
  #Given I am a Partner
  #When I navigate to the Manage Users Page
  #And I delecte a user button
  #Then Ill see the SEO**_SuccessDeletion "User successfully deleted" notification
  @SRSSMOKETEST @ManageUsers @ManageUsers_TS07 @TAA-611
  Scenario Outline: ManageUsers_TS07
    Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I click the SEO22_AddNewUser button
    And I populate SEO22_EmailAddress textfield with <userEmailAdd>
    And I populate SEO22_Username textfield with <username>
    And I select <roleClassification> in SEO22_Role dropdown
    And I populate SEO22_Password textfield with <userPassword>
    And I click the SEO22_Save button
    Then Ill see the SEO23_ProfileInformation header
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I populate SEO22_Search textfield with <username>
    And I click the SEO22_Search button
    And I click the SEO22_DeleteUser button of <username>
    Then Ill see the SEO22_DeleteUser Modal
    And Ill see the SEO22_Confirmation 'Are you sure you want to delete this user' text
    When I click the SEO22_YesDelete button
    Then Ill see the SEO22_Confirmation 'User successfully deleted' text

    Examples: 
      | FirstName | LastName   | email                     | password  | userEmailAdd           | username     | roleClassification | userPassword |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | EmployeeTS07@gmail.com | EmployeeTS07 | Employee           | emp12345     |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | ClientTS07@gmail.com   | ClientTS07   | Client             | cli12345     |

  #Scenario Description:
  #Given I am a Partner
  #When I navigate to the Manage Users Page
  #And I enable permission for Invoices
  #And I access Branded Dashboard
  #Then Ill see that the invoices icon is available
  @SRSSMOKETEST @ManageUsers @ManageUsers_TS13 @TAA-556
  Scenario Outline: ManageUsers_TS13
    Given Im a new Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    And I wait for page to load
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    Then Ill be able to see the SEO22_ManageUsers Page
    When I populate SEO22_Search textfield with <userEmailAdd>
    And I click the SEO22_Search button
    And I click the SEO22_Edit button of <userEmailAdd>
    And I toggle SEO23_InvoicesSwitch icon
    And I click the SEO23_SavePermissions button
    And I click the SEO00_Home link
    And I click the SEO00_BrandedDashboardRedirect link
    Then Ill see the ACH00_BrandedDashboardLogin page
    When I populate ACH00_Username textfield with <username>
    And I populate ACH00_Password textfield with <userPassword>
    And I click the ACH00_Login button
    And I wait for page to load
    Then Ill see the ACH00_Invoices icon
    When I navigate to "Login"
    And I click the SEO01_UserAvatar button
    And I click the SEO01_ManageUsers list
    And I populate SEO22_Search textfield with <userEmailAdd>
    And I click the SEO22_Search button
    And I click the SEO22_Edit button of <userEmailAdd>
    And I toggle SEO23_InvoicesSwitch icon
    And I click the SEO23_SavePermissions button
    And I click the SEO00_Home link
    And I click the SEO00_BrandedDashboardRedirect link
    And I wait for page to load
    Then Ill not see the ACH00_Invoices icon

    Examples: 
      | FirstName | LastName   | email                     | password  | userEmailAdd               | username         | userPassword |
      | RND       | Automation | lorraine@truelogic.com.ph | 123456789 | EmployeeTS13Edit@gmail.com | EmployeeTS13Edit | emp12345     |
