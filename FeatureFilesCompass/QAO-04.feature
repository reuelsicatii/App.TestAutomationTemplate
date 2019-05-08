#Author: your.email@your.domain.com
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
Feature: [QAO-04] [Compass]: Workforce Smoke/Regression TestSuite

  #Scenario Description:
  #Given I'm an Account Manager
  #When I create a Campaign in COMPASS
  #And I select <Category> and add a <Product> to the campaign in COMPASS
  #And I pay the <Product> in COMPASS
  #And I create a project and associate the <Product> in COMPASS
  #And I activate the <Product>
  #And I deploy the  <Product>  through Deploy
  #Then I'll be able to see that the tasks of the <Product> are correctly deployed
  @CPSSMOKETEST @TaskDeployment @TaskDeployment_TS01 @TAA-9
  Scenario Outline: COMSMOKETEST_TS01
    Given Im an Account Manager
    When I navigate to "COMDEV_Login"
    And I populate COM01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate COM01_Password with "qwerty"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click COM03_CreateCampaign button
    And I populate COM04_CampaignName with "www.seleniumhq.org/projects/"
    And I populate COM04_BrandName with "www.seleniumhq.org/projects/"
    And I populate COM04_CampaignURL with "http://www.seleniumhq.org/projects/"
    And I populate COM04_Description textfield with "Test Automation Description"
    And I select "IT & Tech (deleted)" over COM04_Category dropdown
    And I populate COM04_ProductandServiceOverview textfield with "Test Automation ProductandServiceOverview"
    And I click COM04_Submit button
    Then Ill see campaign successfully created
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click "www.seleniumhq.org/projects/" link
    And I click COM06_Products tab
    And I click COM07_OrderAProduct button
    And I select <Category> over COM07_SelectACategory list
    And I click <Product> name
    And I click COM07_AddthisProduct button
    Then Ill see <Product> successfully added
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click "www.seleniumhq.org/projects/" link
    And I click COM06_Products tab
    And I click the COM07_<Product> link
    And I click COM07_Invoice link
    And I click COM05_Payments tab
    And I click COM05_AddNewPayment button
    And I populate COM05_AmountPaid with "399.00"
    And I select "Cash" over COM05_Type dropdown
    And I populate COM05_ReferenceNumber with "12345"
    And I click COM05_No_DoYouWantToSendOpsANotification button
    And I click COM05_No_UseCredit button
    And I click COM05_No_DoyouWantToSendTheClientANotification button
    And I click COM05_Submit button
    Then Ill see <Product> successfully paid
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click "www.seleniumhq.org/projects/" link
    And I hover COM06_ProjectManagement tab
    And I click COM06_Project dropdown
    And I click COM08_AddAProject button
    And I populate COM08_NameTheProject textfield with "TestAutomation - BasicWebDesign"
    And I select <Product> over COM08_SelectAProduct dropdown
    And I click COM08_SaveProject button
    Then I see the product associated with the project
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click "www.seleniumhq.org/projects/" link
    And I click COM06_Products tab
    And I click the COM07_<Product> link
    And I click the COM07_Edit button
    And I select "Active" over COM07_ProductStatus dropdown
    And I click COM07_Save button
    Then Ill see <Product> activated
    When I navigate to "COMDEV_Deployment"
    And I populate COM09_Campaign textfield with "www.seleniumhq.org/projects/"
    And I click COM09_Deployment button
    And I populate COM10_MonthNo with "1"
    And I click COM10_Deploy button
    And I click COM10_Yes button
    Then Ill see <Product> is deployed over COMDEV_Deployment
    And Ill see <Product> task correctly deployed
    When I navigate to "COMDEV_Logout"
    Then Ill see that Ive logout successfully

    Examples: 
      | Category            | Product                        |
      | Website Development | Basic Web Design               |
      | SEO Services        | Advanced SEO Site Consultation |

  #Scenario Description:
  #Given I'm an Account Manager
  #When I create a Campaign in COMPASS
  #And I select <Category> and add a <Product> to the campaign in COMPASS
  #And I pay the <Product> in COMPASS
  #And I create a project and associate the <Product> in COMPASS
  #And I activate the <Product>
  #And I deploy the  <Product>  through Deploy from Queue
  #Then I'll be able to see that the tasks of the <Product> are correctly deployed
  @CPSSMOKETEST @TaskDeployment @TaskDeployment_TS02 @TAA-9
  Scenario Outline: COMSMOKETEST_TS02
    Given Im an Account Manager
    When I navigate to "COMDEV_Login"
    And I populate COM01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate COM01_Password with "qwerty"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click COM03_CreateCampaign button
    And I populate COM04_CampaignName with "www.seleniumhq.org/projects/"
    And I populate COM04_BrandName with "www.seleniumhq.org/projects/"
    And I populate COM04_CampaignURL with "http://www.seleniumhq.org/projects/"
    And I populate COM04_Description textfield with "Test Automation Description"
    And I select "IT & Tech (deleted)" over COM04_Category dropdown
    And I populate COM04_ProductandServiceOverview textfield with "Test Automation ProductandServiceOverview"
    And I click COM04_Submit button
    Then Ill see campaign successfully created
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click "www.seleniumhq.org/projects/" link
    And I click COM06_Products tab
    And I click COM07_OrderAProduct button
    And I select <Category> over COM07_SelectACategory list
    And I click <Product> name
    And I click COM07_AddthisProduct button
    Then Ill see <Product> successfully added
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click "www.seleniumhq.org/projects/" link
    And I click COM06_Products tab
    And I click the <Product> link
    And I click COM07_Invoice link
    And I click COM05_Payments tab
    And I click COM05_AddNewPayment button
    And I populate COM05_AmountPaid with "399.00"
    And I select "Cash" over COM05_Type dropdown
    And I populate COM05_ReferenceNumber with "12345"
    And I click COM05_No_DoYouWantToSendOpsANotification button
    And I click COM05_No_UseCredit button
    And I click COM05_No_DoyouWantToSendTheClientANotification button
    And I click COM05_Submit button
    Then Ill see <Product> successfully paid
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click "www.seleniumhq.org/projects/" link
    And I hover COM06_ProjectManagement tab
    And I click COM06_Project dropdown
    And I click COM08_AddAProject button
    And I populate COM08_NameTheProject textfield with "TestAutomation"
    And I select <Product> over COM08_SelectAProduct dropdown
    And I click COM08_SaveProject button
    Then I see the product associated with the project
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click "www.seleniumhq.org/projects/" link
    And I click COM06_Products tab
    And I click the <Product> link
    And I click the COM07_Edit button
    And I select "Active" over COM07_ProductStatus dropdown
    And I click COM07_Save button
    Then Ill see <Product> activated
    When I navigate to "COMDEV_Queue"
    And I populate COM11_Campaign textfield with "www.seleniumhq.org/projects/"
    And I click COM11_Deploy button
    #And I populate COM12_MonthNo with "1"
    And I select "1" over COM12_Template dropdown
    And I populate COM12_From with "Today"
    And I populate COM12_To with "Next Day"
    And I click COM12_DeployNow button
    Then Ill see <Product> is deployed over COMDEV_Queue
    And Ill see <Product> task correctly deployed
    When I navigate to "COMDEV_Logout"
    Then Ill see that Ive logout successfully

    Examples: 
      | Category            | Product                        |
      | Website Development | Basic Web Design               |
      | SEO Services        | Advanced SEO Site Consultation |

  #Scenario Description:
  #Given I'm an Account Manager
  #When I create a Campaign in COMPASS
  #And I select <Category> and add a <Product> to the campaign in COMPASS
  #And I pay the <Product> in COMPASS
  #And I create a project and associate the <Product> in COMPASS
  #And I activate the <Product>
  #And I deploy the  <Product>  through Deploy from Queue
  #Then I'll be able to see that the tasks of the <Product> are correctly deployed
  @CPSSMOKETEST @TaskDeployment @TaskDeployment_TS03 @TAA-9
  Scenario Outline: COMSMOKETEST_TS03
    Given Im an Account Manager
    When I navigate to "COMDEV_Login"
    And I populate COM01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate COM01_Password with "qwerty"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to "COMDEV_Client"
    And I click COM02_LogInAsClient button
    And I switch to child window tab
    And I click SEO01_AddCampaign button
    And I populate the SEO01_DomainUrl textfield with "www.seleniumhq.org/projects/"
    And I click SEO02_CheckDomain button
    And I click SEO02_CreateCampaign button
    And I click SEO02_ClickToGetStarted button
    Then Ill see campaign successfully created in SEO
    When I navigate to "SEODEV_Store"
    And I click <Category> link in SEO Store
    And I click <Product> button in SEO Store
    And I select Selenium over SEO03_SelectCampaign dropdown for <Product>
    And I click SEO03_Continue button for <Product>
    And I click SEO03_ProceedToCheckout button
    And I click SEO04_OthersPaymentMethod radiobutton
    And I populate SEO04_Street textfield with "Street"
    And I populate SEO04_City textfield with "City"
    And I select "United States" over SEO04_Country dropdown
    And I click SEO04_MakePayment button
    And I capture and store Invoice Number from InvoiceNumber link
    Then Ill see <Product> successfully added in SEO
    When I navigate to "COMDEV_Invoices"
    And I click COM05_Invoice link
    And I click COM05_Payments tab
    And I click COM05_AddNewPayment button
    And I populate COM05_AmountPaid with "399.00"
    And I select "Cash" over COM05_Type dropdown
    And I populate COM05_ReferenceNumber with "12345"
    And I click COM05_No_DoYouWantToSendOpsANotification button
    And I click COM05_No_UseCredit button
    And I click COM05_No_DoyouWantToSendTheClientANotification button
    And I click COM05_Submit button
    Then Ill see <Product> successfully paid
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click "Selenium" link
    And I hover COM06_ProjectManagement tab
    And I click COM06_Project dropdown
    And I click COM08_AddAProject button
    And I populate COM08_NameTheProject textfield with "TestAutomation - BasicWebDesign"
    And I select <Product> over COM08_SelectAProduct dropdown
    And I click COM08_SaveProject button
    Then I see the product associated with the project
    When I navigate to "COMDEV_Client"
    And I click COM02_Campaigns tab
    And I click "Selenium" link
    And I click COM06_Products tab
    And I click the <Product> link
    And I click the COM07_Edit button
    And I select "Active" over COM07_ProductStatus dropdown
    And I click COM07_Save button
    Then Ill see <Product> activated
    When I navigate to "COMDEV_Deployment"
    And I populate COM09_Campaign textfield with "www.seleniumhq.org/projects/"
    And I click COM09_Deployment button
    And I populate COM10_MonthNo with "1"
    And I click COM10_Deploy button
    Then Ill see <Product> is deployed over COMDEV_Deployment
    And Ill see <Product> task correctly deployed
    When I navigate to "COMDEV_Logout"
    Then Ill see that Ive logout successfully

    Examples: 
      | Category            | Product                        |
      | Website Development | Basic Web Design               |
      | SEO Services        | Advanced SEO Site Consultation |

  #Scenario Description:
  #When I look into <Period> task
  #Then I'll see all assigned <Period> task
  #When I'll filter for <Task Status> for a given <Period>
  #Then I'll see all assigned  <Task Status> for a given <Period>
  #When I filter for <Milestone Status> for a given <Period> &  <Task Status>
  #Then I'll see all assigned  <Milestone Status> for a given  <Period> &  <Task Status>
  #When I'll search for <Keyword> for a given <Period>, <Task Status> & <Milestone Status>
  #Then I'll see all assigned <Keyword> for a given <Period>, <Task Status> & <Milestone Status>
  @CPSSMOKETEST @TaskDeployment @TaskDeployment_TS04 @TAA-9
  Scenario Outline: COMSMOKETEST_TS04
    Given Im an Account Manager
    When I navigate to "COMDEV_Login"
    And I populate COM01_Username with <User>
    And I populate COM01_Password with "qwerty123"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to "COMDEV_Task"
    And I click COM13_<Period> button
    Then Ill see all assigned <Period> task during 1Fil of <User>
    When I select <Task Status> over COM13_FilterStatus dropdown
    Then Ill see all assigned <Task Status> for a given <Period> during 2Fil of <User>
    When I select <Milestone Status> over COM13_FilterAddtlStatus dropdown
    Then Ill see all assigned <Milestone Status> for a given <Period> and <Task Status> during 3Fil of <User>
    When I populate COM13_MytaskSearch with <Keyword>
    And I click COM13_Search button over COM13_MyTask
    Then Ill see all assigned <Keyword> for a given <Period>, <Task Status> and <Milestone Status> during 4Fil of <User>
    When I navigate to "COMDEV_Logout"
    Then Ill see that Ive logout successfully

    Examples: 
      | User                             | Period     | Task Status | Milestone Status | Keyword     |
      | ContentCOMDEV@mailinator.com     | Today      | Completed   | All              | Citation    |
      | PPCCOMDEV@mailinator.com         | This Week  | Open        | All              | Account     |
      | SocialMediaCOMDEV@mailinator.com | This Month | In-Progress | All              | Crossposts  |
      | WebDevCOMDEV@mailinator.com      | All Time   | On-hold     | All              | Development |
      | ContentCOMDEV@mailinator.com     | All Time   | Blocked     | Overdue          | Publication |
      | WebDevCOMDEV@mailinator.com      | All Time   | Blocked     | Overdue          | Hour        |
      | ContentCOMDEV@mailinator.com     | All Time   | Blocked     | Late             | Editing     |
      | WebDevCOMDEV@mailinator.com      | All Time   | Blocked     | Late             | Hour        |

  #Scenario Description:
  #Given I'm an <User>
  #And I am tagged for Task For Review
  #And  I am tagged for Exam for Review
  #When I look into Task Pool
  #And I grab a task
  #Then I'll see that task is assigned to me
  #When I look into Task For Review
  #And I <Action 1> the task
  #Then I'll see a pop-up that I've <Action 1> the Task
  #When I look into Exam For Review
  #And I <Action 2> the Exam
  #Then I'll see a pop-up that I've <Action 2> the Exam
  @CPSSMOKETEST @TaskDeployment @TaskDeployment_TS05 @TAA-9
  Scenario Outline: COMSMOKETEST_TS05
    Given Im an Account Manager
    When I navigate to "COMDEV_Login"
    And I populate COM01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate COM01_Password with "qwerty"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to "COMDEV_Task"
    And I click COM13_ExamForReview button over COM13_MyTask
    And I click COM13_<Action 2> button over COM13_ExamForReview
    Then Ill see a popup that Ive <Action 2> the Task

    Examples: 
      | User                         | Action 1 | Action 2 |
      | ContentCOMDEV@mailinator.com | Approve  | Approve  |

  #| PPCCOMDEV@mailinator.com         | Reject   | Reject   |
  #| SocialMediaCOMDEV@mailinator.com | View     | View     |
  #| WebDevCOMDEV@mailinator.com      | Approve  | Approve  |
  #| ContentCOMDEV@mailinator.com     | Reject   | Reject   |
  #Scenario Description:
  #Given I'm a <User>
  #And i login through to "COMDEV_Login"
  #And I am tagged as delegator
  #When I look into For Delegation
  #And I delegate a "TaskName" to "Truelogic"
  #Then I'll see that "TaskName"  is delegated to my Team's Task Pool over Compass
  @CPSSMOKETEST @TaskDeployment @TaskDeployment_TS06 @TAA-9
  Scenario Outline: COMSMOKETEST_TS06
    Given Im an Account Manager
    When I navigate to "COMDEV_Login"
    And I populate COM01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate COM01_Password with "qwerty"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to "COMDEV_Task"
    And I click COM13_ForDelegation button over COM13_MyTask
    And I select "Truelogic" over COM13_OrganizationSelect dropdown
    And I populate COM13_MytaskSearch with "test"
    And I click COM13_Search button over COM13_MyTask
    And I DragDrop task from MyTask to Organization
    Then Ill see the successful popup message over Compass
    When I click COM13_TaskPool button over Compass
    Then Ill see that the task is delegated to my team TaskPool over Compass
    When I navigate to "COMDEV_Logout"
    Then Ill see that Ive logout successfully

    Examples: 
      | Delegator                    |
      | ContentCOMDEV@mailinator.com |

  #| PPCCOMDEV@mailinator.com         |
  #| SocialMediaCOMDEV@mailinator.com |
  #| WebDevCOMDEV@mailinator.com      |
  #Scenario Description:
  #Given I'm a <User>
  #And i login through to "COMDEV_Login"
  #And I am tagged as delegator
  #When I look into For Delegation
  #And I delegate a "TaskName" to "PayPerContent"
  #Then Ill see the successful popup message over Compass
  #When I navigate to "PPCDEV_Login"
  #Then I'll see that "TaskName"is delegate to my Team's Task Pool over Paypercontent
  #And Ill see that only <Task Level> are listed on Team's Task Pool Paypercontent
  @CPSSMOKETEST @TaskDeployment @TaskDeployment_TS07 @TAA-9
  Scenario Outline: COMSMOKETEST_TS07
    Given Im an Account Manager
    When I navigate to "COMDEV_Login"
    And I populate COM01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate COM01_Password with "qwerty"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to "COMDEV_Task"
    And I click COM13_ForDelegation button over COM13_MyTask
    And I select "PayPerContent" over COM13_OrganizationSelect dropdown
    And I populate COM13_MytaskSearch with "test"
    And I click COM13_Search button over COM13_MyTask
    And I DragDrop task from MyTask to Organization
    Then Ill see the successful popup message over Compass
    When I navigate to "COMDEV_Logout"
    Then Ill see that Ive logout successfully
    When I navigate to "PPCDEV_Login"
    And I populate PPC01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate PPC01_Password with "qwerty"
    And I click PPC01_LogIn button
    Then Ill see that Ive login successfully over Paypercontent
    When I navigate to "PPCDEV_Home"
    Then Ill see that the task is delegated to my team TaskPool over Paypercontent
    And Ill see that only <Task Level> are listed to my team TaskPool over Paypercontent

    Examples: 
      | WebApp1User                  | WebApp2User                  | Task Level |
      | ContentCOMDEV@mailinator.com | ContentPPCDEV@mailinator.com |          1 |

  #| PPCCOMDEV@mailinator.com         | PPCPPCDEV@mailinator.com         |2 |
  #| SocialMediaCOMDEV@mailinator.com | SocialMediaPPCDEV@mailinator.com | 3|
  #| WebDevCOMDEV@mailinator.com      | WebDevPPCDEV@mailinator.com      | 3|
  #Scenario Description:
  #Given I'm a <User>
  #When I login through to "COMDEV_Login"
  #And I am tagged as delegator
  #When I look into For Delegation
  #And I delegate a "TaskName" to "Truelogic"
  #And I assign a "TaskName" to <Contributor>
  #Then Ill see the successful popup message over Compass
  #When I navigate to "COMDEV_Task" as <Contributor>
  #Then I'll see that "TaskName" is delegated to <Contributor> MyTask over Paypercontent
  @CPSSMOKETEST @TaskDeployment @TaskDeployment_TS08 @TAA-9
  Scenario Outline: COMSMOKETEST_TS08
    Given Im an Account Manager
    When I navigate to "COMDEV_Login"
    And I populate COM01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate COM01_Password with "qwerty"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to "COMDEV_Task"
    And I click COM13_ForDelegation button over COM13_MyTask
    And I select "Truelogic" over COM13_OrganizationSelect dropdown
    And I populate COM13_MytaskSearch with "test"
    And I click COM13_Search button over COM13_MyTask
    And I DragDrop task from COM13_MyTask to COM13_<Contributor>
    Then Ill see the successful popup message over Compass
    When I navigate to "COMDEV_Logout"
    Then Ill see that Ive logout successfully
    When I navigate to "COMDEV_Login"
    And I populate COM01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate COM01_Password with "qwerty"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to "COMDEV_Task"
    And I click COM13_"All Time" button
    And I populate COM13_MytaskSearch with "test"
    And I click COM13_Search button over COM13_MyTask
    Then Ill see that the task is delegated to <Contributor> MyTask over Compass

    Examples: 
      | WebApp1User                  | Contributor         |
      | ContentCOMDEV@mailinator.com | Jonathan Ortigueras |

  #| ContentCOMDEV@mailinator.com | ConContentCOMDEV@mailinator.com |
  #| PPCCOMDEV@mailinator.com         | ConPPCCOMDEV@mailinator.com         |
  #| SocialMediaCOMDEV@mailinator.com | ConSocialMediaCOMDEV@mailinator.com |
  #| WebDevCOMDEV@mailinator.com      | ConWebDevCOMDEV@mailinator.com  |
  #Scenario Description:
  #Given I'm a <User>
  #And i login through to "COMDEV_Login"
  #And I am tagged as delegator
  #When I look into For Delegation
  #And I delegate a "TaskName" to "Truelogic"
  #And I assign a "TaskName" to <Contributor>
  #Then Ill see the successful popup message over Compass
  #When I navigate to "PPCDEV_Login" as <Contributor>
  #Then I'll see that "TaskName" is delegated to <Contributor> MyTask over PayPerContent
  @CPSSMOKETEST @TaskDeployment @TaskDeployment_TS10 @TAA-9
  Scenario Outline: COMSMOKETEST_TS09
    Given Im an Account Manager
    When I navigate to "COMDEV_Login"
    And I populate COM01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate COM01_Password with "qwerty"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to "COMDEV_Task"
    And I click COM13_ForDelegation button over COM13_MyTask
    And I select "Truelogic" over COM13_OrganizationSelect dropdown
    And I populate COM13_MytaskSearch with "test"
    And I click COM13_Search button over COM13_MyTask
    And I DragDrop task from COM13_MyTask to COM13_<Contributor>
    Then Ill see the successful popup message over Compass
    When I navigate to "COMDEV_Logout"
    Then Ill see that Ive logout successfully
    When I navigate to "PPCDEV_Login"
    And I populate PPC01_Username with "rv.villanueva@truelogic.com.ph"
    And I populate PPC01_Password with "qwerty"
    And I click PPC01_LogIn button
    Then Ill see that Ive login successfully over Paypercontent
    And Ill see that the task is delegated to <Contributor> MyTask over Paypercontent

    Examples: 
      | WebApp1User                  | Contributor   |   |
      | ContentCOMDEV@mailinator.com | Ariel Dacanay | 1 |
      #| ContentCOMDEV@mailinator.com | ConContentWRIDEV@mailinator.com | 
  #| PPCCOMDEV@mailinator.com         | ConPPCWRIDEV@mailinator.com         |
  #| SocialMediaCOMDEV@mailinator.com | ConSocialMediaWRIDEV@mailinator.com |
  #| WebDevCOMDEV@mailinator.com      | ConWebDevWRIDEV@mailinator.com  |
