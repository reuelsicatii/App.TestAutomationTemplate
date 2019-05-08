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
Feature: [TAA-499] [Compass]: Compass WIGS Test Suite v0.1

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
  @CPSSMOKETEST @WebDesign @WebDesign_TS01 @TAA-501
  Scenario Outline: WebDesign_TS01
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
    And I create <subtaskCountE> under "Client Intake" for <product>
    And I create <subtaskCountB> under "Development" for <product>
    And I create <subtaskCountA> under "Revision" for <product>
    And I create <subtaskCountC> under "Prelaunch QA" for <product>
    And I create <subtaskCountD> under "Site Migration" for <product>
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
    And I DragDrop "Client Intake" from COM20_TaskTemplates section to COM20_Droppable section
    And I DragDrop "Development" from COM20_TaskTemplates section to COM20_Droppable section
    And I DragDrop "Revision" from COM20_TaskTemplates section to COM20_Droppable section
    And I DragDrop "Prelaunch QA" from COM20_TaskTemplates section to COM20_Droppable section
    And I DragDrop "Site Migration" from COM20_TaskTemplates section to COM20_Droppable section
    
    And I click the COM20_Collapse icon of "Development"
    And I select "Design Phase ( Staging Site )"
    And I click COM20_Edit button
    And I select "Review Intake" under COM19_TaskDependencies Section
    And I click COM19_SubtaskSave button
    
    And I click the COM20_Collapse icon of "Revision"
    And I select "Client Revision 1 Window"
    And I click COM20_Edit button
    And I select "Content Integration" under COM19_TaskDependencies Section
    And I click COM19_SubtaskSave button
    
    And I click the COM20_Collapse icon of "Prelaunch QA"
    And I select "Prelaunch QA"
    And I click COM20_Edit button
    And I select "Survey / Hosting Creds" under COM19_TaskDependencies Section
    And I click COM19_SubtaskSave button
    
    And I click the COM20_Collapse icon of "Site Migration"
    And I select "Website Migration"
    And I click COM20_Edit button
    And I select "Prelaunch QA" under COM19_TaskDependencies Section
    And I click COM19_SubtaskSave button
    
    And I hover to COM14_TasksMenu link
    And I hover to COM14_Templates link
    And I select COM14_ProductTemplates link
    And I search <product> in the COM17_SearchProduct Filter
    And I click the COM17_dropdown button of <product>
    And I click COM17_Activate button of <product>
    Then Ill see that the status of the template is Active
		    
    
    Examples: 
      | client                   |      category        |  product          |            categProduct                     |    currency    |  monthlyFee  |   tabNumber  | taskCount  |  subtaskCountA   | subtaskCountB | subtaskCountC |  subtaskCountD | subtaskCountE |
      | lorraine@truelogic.com.ph| Website Development  |  Basic Web Design |   Website Development - Basic Web Design    | US Dollars USD |      499     |        2     |     5      |         4        |        2      |       3       |        4       |        2      |
	
	
  # Scenario Description:
  # Given Im a Project Manager
	# When I access app.compass/login
	# And I create a Campaign
	# And I order a product
	# Then Ill see that a product will be successfully assigned to a campaign
  @CPSSMOKETEST @WebDesign @WebDesign_TS02 @TAA-504
  Scenario Outline: WebDesign_TS02
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
		And I populate COM04_CampaignName with "Marina Bay"
		And I populate COM04_BrandName with "marinabaysands.com"
		And I populate COM04_CampaignURL with "https://www.marinabaysands.com/"
		And I populate COM04_Description textfield with "Test Marina Bay Automation Description"
		And I populate COM04_ProductandServiceOverview textfield with "Test Automation ProductandServiceOverview"
		And I populate COM04_BusinessEmail textfield with <client>
		And I select "Travel & Hospitality" over COM04_Category dropdown
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
      | client                     |        category      |     product        |               categProduct                  |  productStatus    |
      | lorraine@truelogic.com.ph  |  Website Development |  Basic Web Design  |   Website Development - Basic Web Design    |      Active       |
      
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
  @CPSSMOKETEST @WebDesign @WebDesign_TS03 @TAA-507
  Scenario Outline: WebDesign_TS03
	  Given Im a Workforce Specialist
	  When I navigate to "Login"
	  And I populate COM01_Username with "lorraine@truelogic.com.ph"
	  And I populate COM01_Password with "123456789"
	  And I click COM01_LogIn button
	  Then Ill see that Ive login successfully
	  
	  When I hover to COM14_TasksMenu link
		And I click COM14_DeployMenu link
		Then I will see the COM09_TaskDeployments Header
		
		When I search the "Marina Bay" in the COM09_CampaignSearch textfield
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
      | client                   |       category        |       product      |                categProduct             |  productStatus    |       taskName           |
      | lorraine@truelogic.com.ph| Website Development   |  Basic Web Design  |  Website Development - Basic Web Design |      Active       | Client Intake Assessment |
    
  #Scenario Description:
	#Given Im an Account Manager or a Web Dev Specialist
	#And the tasks were already available in the For Delegation Section
	#When I assign the tasks to a particular assignee
	#Then Ill see that the tasks will be assigned successfully
	#When I progress the subtasks under the Client Intake Task
	#Then Ill see that the Task Status is set to Completed
  @CPSSMOKETEST @WebDesign @WebDesign_TS04 @TAA-510
  Scenario Outline: WebDesign_TS04
		Given I am an Account Manager or a Web Dev Specialist
		When I navigate to "Login"
		And I populate COM01_Username with "wigssalescontributor@gmail.com"
		And I populate COM01_Password with "123456789"
		And I click COM01_LogIn button
		Then Ill see that Ive login successfully
		
		When I enter the campaign "Marina Bay" in the COM14_GlobalSearch textfield
		And I select "Marina Bay" in the Campaign Result Section
		Then Ill see the COM08_ProjectManagement tab
		
		When I hover to COM06_ProjectManagement tab
		And I select COM06_Projects link
		And I select "Basic Web Design" Project under the COM08_Project table 
		Then Ill see the COM08_<taskName> in the subprojects page 
		  
		When I click on the COM08_TaskEdit icon of "Client Intake Assessment"
		And I click the COM08_Assignee dropdown
		And I select "Sales Specialist" under the COM08_Assignee dropdown list
		And I click the COM08_Save button of Edit Task Window
		And I click on the COM08_"Client Intake Assessment" Task 
		And I click on the COM24_ClickToStart button 
		Then I will be able to see that the COM24_TaskStatus text is "IN-PROGRESS"
		
		When I click on the COM24_ClickToComplete button 
		Then I will be able to see that the COM24_TaskStatus text is "COMPLETED"
		
		When I hover to COM14_UserAvatar image
		And I select COM14_Logout link
		And I populate COM01_Username with "tlosrnd321@gmail.com"
		And I populate COM01_Password with "123456789"
		And I click COM01_LogIn button
		Then Ill see that Ive login successfully
		
		When I enter the campaign "Marina Bay" in the COM14_GlobalSearch textfield
		And I select "Marina Bay" in the Campaign Result Section
		Then Ill see the COM08_ProjectManagement tab
		
		When I hover to COM06_ProjectManagement tab
		And I select COM06_Projects link
		And I select "Basic Web Design" Project under the COM08_Project table 
		Then Ill see the COM08_<taskName> in the subprojects page 
		  
		When I populate COM08_TaskSearch textfield with "Review Intake"
	  And I click the COM08_TaskSearch button
		And I click on the COM08_TaskEdit icon of "Review Intake"
		And I click the COM08_Assignee dropdown
		And I select "WebDev Specialist" under the COM08_Assignee dropdown list
		And I click the COM08_Save button of Edit Task Window
		And I click on the COM08_"Review Intake" Task 
		And I click on the COM24_ClickToStart button 
		Then I will be able to see that the COM24_TaskStatus text is "IN-PROGRESS"
	
		When I click on the COM24_ClickToComplete button 
		Then I will be able to see that the COM24_TaskStatus text is "COMPLETED"

	
	Examples:  
    | client                   |   category     |     product      |           categProduct            |  productStatus    |       taskName              |
    | lorraine@truelogic.com.ph| Organic SEO    |  Organic Silver  |   Organic SEO - Organic Silver    |      Active       |   Client Intake Assessment  |
    
    
  #Scenario Description:
	#Given Im a Web Dev Specialist
	#And the tasks were already available in the For Delegation Section
	#When I assign the tasks to a particular assignee
	#Then Ill see that the tasks will be assigned successfully
	#When I progress the subtasks under the Development Task
	#Then Ill see that the Task Status is set to Completed
  @CPSSMOKETEST @WebDesign @WebDesign_TS05 @TAA-511
  Scenario Outline: WebDesign_TS05
		Given I am an Account Manager or a Web Dev Specialist
		When I navigate to "Login"
		And I populate COM01_Username with "tlosrnd321@gmail.com"
		And I populate COM01_Password with "123456789"
		And I click COM01_LogIn button
		Then Ill see that Ive login successfully
		
		When I enter the campaign "Marina Bay" in the COM14_GlobalSearch textfield
		And I select "Marina Bay" in the Campaign Result Section
		Then Ill see the COM08_ProjectManagement tab
		
		When I hover to COM06_ProjectManagement tab
		And I select COM06_Projects link
		And I select "Basic Web Design" Project under the COM08_Project table 
		Then Ill see the COM08_<taskName> in the subprojects page 
		  
		When I populate COM08_TaskSearch textfield with "Design Phase ( Staging Site )"
	  And I click the COM08_TaskSearch button 
		And I click on the COM08_TaskEdit icon of "Design Phase ( Staging Site )"
		And I click the COM08_Assignee dropdown
		And I select "WebDev Specialist" under the COM08_Assignee dropdown list
		And I click the COM08_Save button of Edit Task Window
		And I click on the COM08_"Design Phase ( Staging Site )" Task 
		And I click on the COM24_ClickToStart button 
		Then I will be able to see that the COM24_TaskStatus text is "IN-PROGRESS"
		
		When I click on the COM24_ClickToComplete button 
		Then I will be able to see that the COM24_TaskStatus text is "COMPLETED"
		
	  When I click the COM24_MileStone link
    And I populate COM08_TaskSearch textfield with "Content Integration"
	  And I click the COM08_TaskSearch button
		And I click on the COM08_TaskEdit icon of "Content Integration"
		And I click the COM08_Assignee dropdown
		And I select "WebDev Specialist" under the COM08_Assignee dropdown list
		And I click the COM08_Save button of Edit Task Window
		And I click on the COM08_"Content Integration" Task 
		And I click on the COM24_ClickToStart button 
		Then I will be able to see that the COM24_TaskStatus text is "IN-PROGRESS"
		
		When I click on the COM24_ClickToComplete button 
		Then I will be able to see that the COM24_TaskStatus text is "COMPLETED"
	
	Examples:  
    | client                   |   category     |     product      |           categProduct            |  productStatus    |       taskName              |
    | lorraine@truelogic.com.ph| Organic SEO    |  Organic Silver  |   Organic SEO - Organic Silver    |      Active       |   Client Intake Assessment  |
    
  #Scenario Description:
	#Given Im an Account Manager or a Web Dev Specialist
	#And the tasks were already available in the For Delegation Section
	#When I assign the tasks to a particular assignee
	#Then Ill see that the tasks will be assigned successfully
	#When I progress the subtasks under the Client Intake Task
	#Then Ill see that the Task Status is set to Completed
  @CPSSMOKETEST @WebDesign @WebDesign_TS06 @TAA-512
  Scenario Outline: WebDesign_TS06
		Given I am an Account Manager or a Web Dev Specialist
		When I navigate to "Login"
		And I populate COM01_Username with "wigssalescontributor@gmail.com"
		And I populate COM01_Password with "123456789"
		And I click COM01_LogIn button
		Then Ill see that Ive login successfully
		
		When I enter the campaign "Marina Bay" in the COM14_GlobalSearch textfield
		And I select "Marina Bay" in the Campaign Result Section
		Then Ill see the COM08_ProjectManagement tab
		
		When I hover to COM06_ProjectManagement tab
		And I select COM06_Projects link
		And I select "Basic Web Design" Project under the COM08_Project table 
		Then Ill see the COM08_<taskName> in the subprojects page 
		 
		When I populate COM08_TaskSearch textfield with "Client Revision 1 Window"
	  And I click the COM08_TaskSearch button  
		And I click on the COM08_TaskEdit icon of "Client Revision 1 Window"
		And I click the COM08_Assignee dropdown
		And I select "Sales Specialist" under the COM08_Assignee dropdown list
		And I click the COM08_Save button of Edit Task Window
		And I click on the COM08_"Client Revision 1 Window" Task 
		And I click on the COM24_ClickToStart button 
		Then I will be able to see that the COM24_TaskStatus text is "IN-PROGRESS"
		
		When I click on the COM24_ClickToComplete button 
		Then I will be able to see that the COM24_TaskStatus text is "COMPLETED"
		
		When I hover to COM14_UserAvatar image
		And I select COM14_Logout link
		And I populate COM01_Username with "tlosrnd321@gmail.com"
		And I populate COM01_Password with "123456789"
		And I click COM01_LogIn button
		Then Ill see that Ive login successfully
		
		When I enter the campaign "Marina Bay" in the COM14_GlobalSearch textfield
		And I select "Marina Bay" in the Campaign Result Section
		Then Ill see the COM08_ProjectManagement tab
		
		When I hover to COM06_ProjectManagement tab
		And I select COM06_Projects link
		And I select "Basic Web Design" Project under the COM08_Project table 
		Then Ill see the COM08_<taskName> in the subprojects page 
		 
		When I populate COM08_TaskSearch textfield with "Revision 1 Implementation"
	  And I click the COM08_TaskSearch button  
		And I click on the COM08_TaskEdit icon of "Revision 1 Implementation"
		And I click the COM08_Assignee dropdown
		And I select "WebDev Specialist" under the COM08_Assignee dropdown list
		And I click the COM08_Save button of Edit Task Window
		And I click on the COM08_"Revision 1 Implementation" Task 
		And I click on the COM24_ClickToStart button 
		Then I will be able to see that the COM24_TaskStatus text is "IN-PROGRESS"
		
		When I click on the COM24_ClickToComplete button 
		Then I will be able to see that the COM24_TaskStatus text is "COMPLETED"
		
		When I hover to COM14_UserAvatar image
		And I select COM14_Logout link
		And I populate COM01_Username with "wigssalescontributor@gmail.com"
		And I populate COM01_Password with "123456789"
		And I click COM01_LogIn button
		Then Ill see that Ive login successfully
		
		When I enter the campaign "Marina Bay" in the COM14_GlobalSearch textfield
		And I select "Marina Bay" in the Campaign Result Section
		Then Ill see the COM08_ProjectManagement tab
		
		When I hover to COM06_ProjectManagement tab
		And I select COM06_Projects link
		And I select "Basic Web Design" Project under the COM08_Project table 
		Then Ill see the COM08_<taskName> in the subprojects page 
		 
		When I populate COM08_TaskSearch textfield with "Client Revision 2 Window"
	  And I click the COM08_TaskSearch button  
		And I click on the COM08_TaskEdit icon of "Client Revision 2 Window"
		And I click the COM08_Assignee dropdown
		And I select "Sales Specialist" under the COM08_Assignee dropdown list
		And I click the COM08_Save button of Edit Task Window
		And I click on the COM08_"Client Revision 2 Window" Task 
		And I click on the COM24_ClickToStart button 
		Then I will be able to see that the COM24_TaskStatus text is "IN-PROGRESS"
		
		When I click on the COM24_ClickToComplete button 
		Then I will be able to see that the COM24_TaskStatus text is "COMPLETED"
		
		When I hover to COM14_UserAvatar image
		And I select COM14_Logout link
		And I populate COM01_Username with "tlosrnd321@gmail.com"
		And I populate COM01_Password with "123456789"
		And I click COM01_LogIn button
		Then Ill see that Ive login successfully
		
		When I enter the campaign "Marina Bay" in the COM14_GlobalSearch textfield
		And I select "Marina Bay" in the Campaign Result Section
		Then Ill see the COM08_ProjectManagement tab
		
		When I hover to COM06_ProjectManagement tab
		And I select COM06_Projects link
		And I select "Basic Web Design" Project under the COM08_Project table 
		Then Ill see the COM08_<taskName> in the subprojects page 
		 
		When I populate COM08_TaskSearch textfield with "Revision 2 Implementation"
	  And I click the COM08_TaskSearch button  
		And I click on the COM08_TaskEdit icon of "Revision 2 Implementation"
		And I click the COM08_Assignee dropdown
		And I select "WebDev Specialist" under the COM08_Assignee dropdown list
		And I click the COM08_Save button of Edit Task Window
		And I click on the COM08_"Revision 2 Implementation" Task 
		And I click on the COM24_ClickToStart button 
		Then I will be able to see that the COM24_TaskStatus text is "IN-PROGRESS"
		
		When I click on the COM24_ClickToComplete button 
		Then I will be able to see that the COM24_TaskStatus text is "COMPLETED"
		

	
	Examples:  
    | client                   |   category     |     product      |           categProduct            |  productStatus    |       taskName              |
    | lorraine@truelogic.com.ph| Organic SEO    |  Organic Silver  |   Organic SEO - Organic Silver    |      Active       |   Client Intake Assessment  |