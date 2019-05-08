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
#@ (Tags/Labels):To group Scenariosgi
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: [TAA-466] [Compass]: Compass WIGS Test Suite v0.1

	# Scenario Description:
	#	Given Im an App User from QA department
	#	And I received requirements from Sales Team
	#	And a campaign was already existing
	#	And a project was not yet created
	#	And Product was not existing
	#	And Templates were not yet created
	#	And Invoice notification was not created
	#	When Workforce Team Launch a deployment
	#	And I access app.compass/login
	#	Then Ill see the 'tasks were deployed successfully' modal
  @CPSSMOKETEST @OrganicSEO @OrganicSEO_TS01 @TAA-481
  Scenario Outline: OrganicSEO_TS01
    Given Im an Account Manager
    When I navigate to "Login"
    And I populate COM01_Username with "lorraine@truelogic.com.ph"
    And I populate COM01_Password with "123456789"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    
    When I hover to COM14_Tools link
		And I click COM14_StoreManagement link
		Then Ill see the COM16_CategoryBrowser header
    
    When I click COM16_AddCategory button 
    And I populate COM16_CategoryName textfield with <category>
    And I populate COM16_Description with <category>
    And I click COM16_Next button of Basic Details tab under Add New Category
    And I validate if COM16_IsActive selected
    And I click COM16_Next button of Category Types tab under Add New Category
    And I click the COM16_SaveAndSubmit button under Add New Category
    
    When I click  COM16_<category> under the Category Name list
    And I click COM16_AddNewProduct button
 		And I populate COM16_ProductCode textfield with <product>
		And I populate COM16_ProductName textfield with <product>
		And I populate COM16_Description of Add New Product Modal with <category>
		And I click COM16_IsActive button of Add New Product Modal
		And I click COM16_IsProposable button of Add New Product Modal
		And I click COM16_Viewable button of Add New Product Modal
		And I click COM16_Next button of Basic Details under Add New Product Modal
		And I select <currency> in the COM16_Currency dropdown of Add New Product Modal
		And I populate COM16_MonthlyFee textfield with <monthlyFee> of Add New Product Modal
		And I click COM16_Next button of Price Settings under Add New Product Modal
		And I populate COM16_KeyFeature textarea with <product>
		And I add an additional <tabNumber> for <product>
		And I click COM16_ThumbnailTab link of Add New Product Modal
		And I click COM16_SaveAndSubmit button of Add New Product Modal
		And I click  COM16_<category> under the Category Name list
		Then Ill see COM16_<product> was created
		
	  When I hover to COM14_TasksMenu link
    And I hover to COM14_Templates link
    And I select COM14_TaskTemplates link
    And I create <taskCount> under Create Tasklist section for <product>
    And I create <subtaskCountA> under "Update Campaign Roadmap" for <product>
    And I create <subtaskCountB> under "Citation Creation" for <product>
    And I create <subtaskCountC> under "Guest Blog Outreach #1" for <product>
    And I create <subtaskCountD> under "Editorial #1" for <product>
    And I hover to COM14_TasksMenu link
    And I hover to COM14_Templates link
    And I select COM14_ProductTemplates link
    And I click COM17_Create button
    Then Ill see the Create Product Template
    
    When I select <category> under the COM18_Product Category dropdown
    And I populate COM18_Template textfield with <product>
    And I click COM18_Monthly checkbox
    And I click COM18_MonthOne checkbox
    And I click COM18_MonthTwo checkbox
    And I click COM8_Save button
    And I click COM8_OK button
    And I DragDrop "Citation Creation" from COM20_TaskTemplates section to COM20_Droppable section
    And I DragDrop "Update Campaign Roadmap" from COM20_TaskTemplates section to COM20_Droppable section
    And I DragDrop "Guest Blog Outreach #1" from COM20_TaskTemplates section to COM20_Droppable section
    And I DragDrop "Editorial #1" from COM20_TaskTemplates section to COM20_Droppable section
    And I click the COM20_Collapse icon of "Guest Blog Outreach #1"
    And I select "Guest Blog Outreach #1 Creation"
    And I click COM20_Edit button
    And I select "Update Campaign Roadmap" under COM19_TaskDependencies Section
    And I click COM19_SubtaskSave button
    And I click the COM20_Collapse icon of "Editorial #1"
    And I select "Editorial #1 Creation"
    And I click COM20_Edit button
    And I select "Update Campaign Roadmap" under COM19_TaskDependencies Section
    And I click COM19_SubtaskSave button
    And I hover to COM14_TasksMenu link
    And I hover to COM14_Templates link
    And I select COM14_ProductTemplates link
    And I search <product> in the COM17_SearchProduct Filter
    And I click the COM17_dropdown button of <product>
    And I click COM17_Activate button of <product>
    Then Ill see that the status of the template is Active
		    
    
    Examples: 
      | client                   | category       |  product         |            categProduct           |    currency    |  monthlyFee  |   tabNumber  | taskCount  |  subtaskCountA   | subtaskCountB | subtaskCountC |  subtaskCountD |
      | lorraine@truelogic.com.ph| Organic SEO    |  Organic Silver  |   Organic SEO - Organic Silver    | US Dollars USD |      399     |        3     |     4      |         1        |        1      |       3       |        3       |


	# Scenario Description:
  # Given Im a Project Manager
	# When I access app.compass/login
	# And I create a Campaign
	# And I order a product
	# Then Ill see that a product will be successfully assigned to a campaign
  @CPSSMOKETEST @OrganicSEO @OrganicSEO_TS02 @TAA-484
  Scenario Outline: OrganicSEO_TS02
    Given Im an Account Manager
    When I navigate to "Login"
    And I populate COM01_Username with "lorraine@truelogic.com.ph"
    And I populate COM01_Password with "123456789"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    
    When I hover to COM14_Tools link
		And I click COM14_StoreManagement link
		Then Ill see the COM16_CategoryBrowser header
		
		When I search <client> in the COM14_GlobalSearch textfield
		And I select <client> in the Clients section
		Then Ill see the Client Overview
		
		When I click COM02_Campaigns tab
		Then Ill see the Campaign Page
		
		When I click COM03_CreateCampaign button
		And I populate COM04_CampaignName with "Uniqlo"
		And I populate COM04_BrandName with "www.uniqlo.com"
		And I populate COM04_CampaignURL with "http://www.uniqlo.com/ph/"
		And I populate COM04_Description textfield with "Test Uniqlo Automation Description"
		And I populate COM04_ProductandServiceOverview textfield with "Test Automation ProductandServiceOverview"
		And I populate COM04_BusinessEmail textfield with <client>
		And I select "Fashion & Lifestyle" over COM04_Category dropdown
		And I click COM04_Submit button
		Then Ill see campaign successfully created
		
		When I click COM06_Products button
		Then Ill see the Products Page
		
		When I click COM07_OrderAProduct button
		And I select <category> over COM07_SelectACategory list
		And I click <product> name
		And I click COM07_AddthisProduct button
		Then Ill see <product> successfully added
		
		When I hover to COM14_ProjectManagement link
		And I click COM14_Projects link
		Then Ill see the Subprojects Page
		
		When I click COM08_AddAProject button
		And I populate COM08_NameTheProject textfield with value <product>
		And I select <category> with <product> over COM08_SelectAProduct dropdown
		And I select today as Start Date 
		And I select "5" days after today as an Estimated End Date
		And I click COM08_SaveProject button
		And I click COM14_OverviewTab
		And I click the COM06_ProductsGear icon under the Products Section 
		And I select <productStatus> in the COM06_ProductsDropwdown under the Products Section
		And I click the COM06_SaveIcon under the Products Section
		And I click the COM06_Proceed button in the modal
		And I click the COM06_Close button in the modal
		Then Ill see that the COM06_Product Status is <productStatus>
		
    Examples: 
      | client                     |   category     |     product      |           categProduct            |  productStatus    |
      | lorraine@truelogic.com.ph  | Organic SEO    |  Organic Silver  |   Organic SEO - Organic Silver    |      Active       |
      
  # Scenario Description:
  # Given Im a Workforce Specialist
	# And Product Template Status was tagged as Active
	# And Product Status was tagged as Active
	#	And Project was already created
	#	And the intake form was already signed
	#	And Product was not customized
	#	When I access app.compass/login
	#	And I Deploy the Task
	#	Then Ill see the 'tasks were deployed successfully' modal
  @CPSSMOKETEST @OrganicSEO @OrganicSEO_TS03 @TAA-487
  Scenario Outline: OrganicSEO_TS03
	  Given Im a Workforce Specialist
	  When I navigate to "Login"
	  And I populate COM01_Username with "lorraine@truelogic.com.ph"
	  And I populate COM01_Password with "123456789"
	  And I click COM01_LogIn button
	  Then Ill see that Ive login successfully
	  
	  When I hover to COM14_TasksMenu link
		And I click COM14_DeployMenu link
		Then I will see the COM09_TaskDeployments Header
		
		When I search the "Uniqlo" in the COM09_CampaignSearch textfield
		And I search the "-" in the COM09_LastDeployment textfield
		And I click the COM09_Deploy button of latest campaign without Deploy Info
		Then Ill see the COM10_DeploymentInformation Section
		
		When I populate COM10_MonthNo with "1"
		And Ill see that a date is visible in the Cycle Month Calendar
		And I see that a launch date is already seleted by default
		And I click COM10_Deploy button
    And I click COM10_Yes button
		Then Ill see the 'tasks were deployed successfully' modal
		
		When I click COM10_ModalOk button
		Then Ill see the COM08_<taskName> in the subprojects page
		
		Examples: 
      | client                   | category     |  product      |        categProduct          |  productStatus    |       taskName           |
      | lorraine@truelogic.com.ph| Local SEO    |  Local Basic  |   Local SEO - Local Basic    |      Active       | Update Campaign Roadmap  |
      
  # Scenario Description:
	#Given Im an SEO Delegator
	#And the tasks were already available in the For Delegation Section
	#When I assign the tasks to a particular assignee
	#Then Ill see that the tasks will be assigned successfully
	#When Im now an SEO Contributor
	#And I click the 'Click to Complete' button
	#Then Ill see that the Task Status is set to Completed
  @CPSSMOKETEST @OrganicSEO @OrganicSEO_TS04 @TAA-490
  Scenario Outline: OrganicSEO_TS04
  Given I am an SEO Specialist
  When I navigate to "Login"
  And I populate COM01_Username with "wigsseospecialist@gmail.com"
  And I populate COM01_Password with "123456789"
  And I click COM01_LogIn button
  Then Ill see that Ive login successfully
  
  When I enter the campaign "Uniqlo" in the COM14_GlobalSearch textfield
	And I select "Uniqlo" in the Campaign Result Section
	Then Ill see the COM08_ProjectManagement tab
	
	When I hover to COM06_SEO tab
	And I select COM06_Keywords link
	And I click the COM21_AddKeyword button
	And I enter "Search Engine Optimzation" in the COM21_Keywords textarea
	And I select "Targeted" in the COM21_DefaultTagging dropdown
	And I click the COM21_Save button
  Then Ill see the COM21_SuccessKeywordModal
  
  When I click COM21_KeywordOkModal
  And I hover to COM06_SEO tab
  And I select COM06_URLmap link
  And I DragDrop "Search Engine Optimzation" from COM22_AvailableKeywords section to COM22_TargetKeywords section	
  And I click COM22_SaveTargetKeywords button
  Then Ill see that the "Search Engine Optimzation" is displayed under COM22_TargetKeywords section	
  
  When I hover to COM06_ProjectManagement tab
	And I select COM06_Projects link
	And I select "Organic Silver" Project under the COM08_Project table 
	Then Ill see the COM08_<taskName> in the subprojects page 
	  
	When I click on the COM08_TaskEdit icon of "Update Campaign Roadmap"
	And I click the COM08_Assignee dropdown
	And I select "SEO Specialist" under the COM08_Assignee dropdown list
	And I click the COM08_Save button of Edit Task Window
	And I click on the COM08_"Update Campaign Roadmap" Task 
	And I click on the COM24_ClickToStart button 
	Then I will be able to see the COM26_Roadmap Tab 
	And I will be able to see the COM26_Campaign Roadmap Tab 
	
	When I click the COM26_Campaign Roadmap Tab 
	And I click on the COM26_Gear icon of "Guest Blog Outreach #1 Submission"
	And I select "Anchor Type 1" under the COM26_AnchorType dropwdown of "Guest Blog Outreach #1 Submission"
	And I click the COM26_Keyword dropdown of "Guest Blog Outreach #1 Submission"
	And I select "Search Engine Optimzation" under the COM26_Keyword dropwdown
  And I click on the COM26_close button of "Guest Blog Outreach #1 Submission"


	And I click on the COM26_Gear icon of "Editorial #1 Submission"
	And I select "Anchor Type 1" under the COM26_AnchorType dropwdown of "Editorial #1 Submission"
	And I click the COM26_Keyword dropdown of "Editorial #1 Submission"
	And I select "Search Engine Optimzation" under the COM26_Keyword dropwdown
	And I click on the COM26_close button of "Editorial #1 Submission"
	
	And I click on the COM26_SaveRoadmap button 
 	And I enter "This is a test" under the COM26_Note textfield
 	And I click COM26_Submit button
  And I click on the COM24_ClickToComplete button 
	Then I will be able to see that the COM24_TaskStatus text is "COMPLETED"
	
	Examples:  
    | client                   |   category     |     product      |           categProduct            |  productStatus    |       taskName           |
    | lorraine@truelogic.com.ph| Organic SEO    |  Organic Silver  |   Organic SEO - Organic Silver    |      Active       | Update Campaign Roadmap  |
    
  #Scenario Description:
	#Given Im a Content Assignee
	#And the tasks were already available in the For Delegation Section
	#When I assign the tasks to a particular assignee
	#Then Ill see that the tasks will be assigned successfully
	#When I progressed the tasks
	#And I click the 'Click to Complete' button
	#Then Ill see that the Task Status is set to Completed
  @CPSSMOKETEST @OrganicSEO @OrganicSEO_TS05 @TAA-493
  Scenario Outline: OrganicSEO_TS05
	Given I am a Content Specialist
	When I navigate to "Login"
	And I populate COM01_Username with "wigscontentcontributor@gmail.com"
	And I populate COM01_Password with "123456789"
	And I click COM01_LogIn button
	Then Ill see that Ive login successfully
	
	When I enter the campaign "Uniqlo" in the COM14_GlobalSearch textfield
	And I select "Uniqlo" in the Campaign Result Section
	Then Ill see the COM08_ProjectManagement tab
	
	When I hover to COM06_ProjectManagement tab
	And I select COM06_Projects link
	And I select "Organic Silver" Project under the COM08_Project table 
	Then Ill see the COM08_<taskName> in the subprojects page 
	
	When I populate COM08_TaskSearch textfield with "Guest Blog Outreach #1 Creation"
	And I click the COM08_TaskSearch button
	And I click on the COM08_TaskEdit icon of "Guest Blog Outreach #1 Creation"
	And I click the COM08_Assignee dropdown
	And I select "Content Assignee" under the COM08_Assignee dropdown list
	And I click the COM08_Save button of Edit Task Window
	And I click on the COM08_"Guest Blog Outreach #1 Creation" Task 
	And I click on the COM24_ClickToStart button 
	Then I will be able to see the COM25_ComposeArticle Tab 
	
	When I click the COM25_ComposeArticle Tab 
	And I populate COM25_ArticleTitle textfield with "This is a test Article Title of Automation Script"
	And I populate COM25_ArticleBody textarea with "This is a test Article Body of Automation Script"
	And I click the COM25_ArticleSave button
	Then Ill see the COM25_SuccessfulSaveModal Message
	
	When I click COM25_SuccessfulSaveModalOk button
	And I click on the COM24_SubmitForReview button 
	Then I will be able to see that the COM24_TaskStatus text is "PENDING FOR REVIEW"
	
	When I click the COM24_MileStone link
	And I populate COM08_TaskSearch textfield with "Guest Blog Outreach #1 Editing"
	And I click the COM08_TaskSearch button
	And I click on the COM08_TaskEdit icon of "Guest Blog Outreach #1 Editing"
	And I click the COM08_Assignee dropdown
	And I select "Content Assignee" under the COM08_Assignee dropdown list
	And I click the COM08_Save button of Edit Task Window
	And I click on the COM08_"Guest Blog Outreach #1 Editing" Task 
	And I click on the COM24_ClickToStart button 
	Then I will be able to see the COM25_ReviewArticle Tab 
	
	When I click the COM25_ReviewArticle Tab
	Then Ill see the COM25_ApproveArticle button
	And Ill see the COM25_RejectArticle button
	
	When I click the COM25_ApproveArticle Tab
	And I click on the COM24_ClickToComplete button
	Then I will be able to see that the COM24_TaskStatus text is "COMPLETED"
	
	When I click the COM24_MileStone link
	And I populate COM08_TaskSearch textfield with "Guest Blog Outreach #1 Creation"
	And I click the COM08_TaskSearch button
	Then Ill see that the COM08_TaskStatus of "Guest Blog Outreach #1 Creation" is "Completed"

	Examples: 
    | client                   | category       |  product         |          categProduct             |  productStatus    |       taskName           |
    | lorraine@truelogic.com.ph| Organic SEO    |  Organic Silver  |   Organic SEO - Organic Silver    |      Active       | Update Campaign Roadmap  |   
    
	#Scenario Description:
	#Given Im a DMG Assignee
	#And the tasks were already available in the For Delegation Section
	#When I assign the tasks to a particular assignee
	#Then Ill see that the tasks will be assigned successfully
	#When I progressed the tasks
	#And I click the 'Click to Complete' button
	#Then Ill see that the Task Status is set to Completed
  @CPSSMOKETEST @OrganicSEO @OrganicSEO_TS06 @TAA-496
  Scenario Outline: OrganicSEO_TS06
	Given I am a DMG Specialist
	When I navigate to "Login"
	And I populate COM01_Username with "wigsdmgcontributor@gmail.com"
	And I populate COM01_Password with "123456789"
	And I click COM01_LogIn button
	Then Ill see that Ive login successfully
	
	When I enter the campaign "Uniqlo" in the COM14_GlobalSearch textfield
	And I select "Uniqlo" in the Campaign Result Section
	Then Ill see the COM08_ProjectManagement tab
	
	When I hover to COM06_ProjectManagement tab
	And I select COM06_Projects link
	And I select "Organic Silver" Project under the COM08_Project table 
	Then Ill see the COM08_<taskName> in the subprojects page 
	
	When I populate COM08_TaskSearch textfield with "Guest Blog Outreach #1 Submission"
	And I click the COM08_TaskSearch button
	And I click on the COM08_TaskEdit icon of "Guest Blog Outreach #1 Submission"
	And I click the COM08_Assignee dropdown
	And I select "DMG Assignee" under the COM08_Assignee dropdown list
	And I click the COM08_Save button of Edit Task Window
	And I click on the COM08_"Guest Blog Outreach #1 Submission" Task 
	And I click on the COM24_ClickToStart button 
	Then I will be able to see the COM25_PostArticle Tab 

	When I click on the COM24_PutOnHold button 
	Then I will be able to see that the COM24_TaskStatus text is "ON-HOLD"

	Examples: 
    | client                   |   category     |     product      |            categProduct           |  productStatus    |       taskName           |
    | lorraine@truelogic.com.ph| Organic SEO    |  Organic Silver  |   Organic SEO - Organic Silver    |      Active       | Update Campaign Roadmap  |
   
