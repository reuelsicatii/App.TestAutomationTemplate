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
Feature: [IN-25] Setup Keyword Tracker for Campaign

  @SMOKETEST
  Scenario: GIVEN Im an existing Partner WHEN I login with correct and exiting credentials THEN Ill be able to login successfully
    Given Im an existing Partner
    When I navigate to "INTROVIO"
    And I populate Email_Address textfield with "clayton@truelogic.com.ph"
    And I populate Password textfield with "happy123"
    And I clicked Login button
    Then Ill be able to login successfully

  @SMOKETEST
  Scenario: GIVEN Im an existing Partner WHEN I login with incorrect and non-exiting credentials THEN I wont be able to login successfully
    Given Im an existing Partner
    When I navigate to "INTROVIO"
    And I populate Email_Address textfield with "klayton@truelogic.com.ph"
    And I populate Password textfield with "happy1234"
    And I clicked Login button
    Then I wont be able to login successfully

  @IN-25
  Scenario Outline: GIVEN Im an existing Partner WHEN I navigate to Add_New_Campaign AND I populate the textfields with a combination of alpha, numeric, alphanumeric and special character THEN Ill be able to create a campaign
    Given Im an existing Partner
    When I navigate to "INTROVIO"
    And I populate Email_Address textfield with "clayton@truelogic.com.ph"
    And I populate Password textfield with "happy123"
    And I clicked Login button
    Then Ill be able to login successfully
    When I click Campaigns tab
    And I click Add_New_Campaign button
    And I populate Domain txtfield with <URL>
    And I click Check_Domain button
    And I populate Business_Name textfield with <Business_Name>
    And I populate Business_Email textfield with <Business_Email>
    And I populate Address textfield with <Address>
    And I populate City textfield with <City>
    And I choose a selection from  Country drop-down
    And I choose a selection from  State drop-down
    And I populate Postal_Code textfield with <Postal_Code>
    And I populate Business_Phone textfield with <Business_Phone>
    And I click Create_Campaign button
    Then Ive successfully added a new campaign
    

    Examples: 
      | URL                                                                                    | Business_Name          | Business_Email | Address                    | City                | Postal_Code | Business_Phone |
      | https://www.williamhill.com.au/horse-racing-multiples/doublestrebles                   | WilliamHill            | Wiliam@WH.com  | 1234 Address Address       | City City           |       12345 |        1234567 |
      | http://www.racingnsw.com.au/default.aspx                                               | Canterbury Park02      | Wiliam@WH.com  | 1234 #$$%@ Address Address | 1234 #$$%@City City |  0123456789 |      123456789 |
      | http://www.skyracing.com.au/index.php?component=racing&task=todayraces&Itemid=89&id=18 | Canterbury $$%@ Park02 | Wiliam@WH.com  | 1234 #$$%@ Address Address | 1234 #$$%@City City |  0123456789 |      123456789 |
      | https://www.racenet.com.au/horse-racing-results/                                       |                   1234 | Wiliam@WH.com  |                       1234 |                1234 | asdasd      | asdasd         |
      | http://bmovanmarathon.ca/runvan-marathon?gclid=CLiE0Or24dMCFU8EKgodc5YPJg              | !@$$%@                 | Wiliam@WH.com  | !@#$$%@                    | !@#$$%@             | asdasd1234  | asdasd1234     |
      | https://www.racing.com/calendar#/month-view                                            | Park02                 | Wiliam@WH.com  | Park02                     | Park02              | !@#$$%@     | !@#$$%@        |

  @IN-25
  Scenario Outline: GIVEN Im an existing Partner WHEN I navigate to Add_New_Campaign AND I populate the BusinessEmail textfields with invalid data AND I populate others textfields with a combination of alpha, numeric, alphanumeric and special character THEN I wont be able to create a campaign
    Given Im an existing Partner
    When I navigate to "INTROVIO"
    And I populate Email_Address textfield with "clayton@truelogic.com.ph"
    And I populate Password textfield with "happy123"
    And I clicked Login button
    Then Ill be able to login successfully
    When I click Campaigns tab
    And I click Add_New_Campaign button
    And I populate Domain txtfield with <URL>
    And I click Check_Domain button
    And I populate Business_Name textfield with <Business_Name>
    And I populate Business_Email textfield with <Business_Email>
    And I populate Address textfield with <Address>
    And I populate City textfield with <City>
    And I choose a selection from  Country drop-down
    And I choose a selection from  State drop-down
    And I populate Postal_Code textfield with <Postal_Code>
    And I populate Business_Phone textfield with <Business_Phone>
    And I click Create_Campaign button
    Then Ive not successfully added a new campaign

    Examples: 
      | URL                                                                                    | Business_Name           | Business_Email      | Address                    | City                | Postal_Code | Business_Phone |
      | https://www.williamhill.com.au/jockeytrainerdriver?eventType=1                         | WilliamHill             | Wiliam!@#$$%@WH.com | 1234 Address Address       | City City           |       12345 |        1234567 |
      | http://www.racingnsw.com.au/default.aspx                                               | Canterbury Park02       | Park02!@#$$%@WH.com | 1234 #$$%@ Address Address | 1234 #$$%@City City |  0123456789 |      123456789 |
      | http://www.skyracing.com.au/index.php?component=racing&task=todayraces&Itemid=89&id=18 | Canterbury #$$%@ Park02 | Park02!@#$$%@WH.com | 1234 #$$%@ Address Address | 1234 #$$%@City City |  0123456789 |      123456789 |
      | https://www.racenet.com.au/horse-racing-results/                                       |                    1234 |                1234 |                       1234 |                1234 | asdasd      | asdasd         |
      | https://rv.racing.com/racing-and-integrity/race-dates                                  | !@#$$%@                 | !@#$$%@             | !@#$$%@                    | !@#$$%@             | asdasd1234  | asdasd1234     |
      | https://fasttrack.grv.org.au/Meeting                                                   | Park02                  | Park02              | Park02                     | Park02              | !@#$$%@     | !@#$$%@        |
      

	@IN-25
  Scenario: GIVEN Im an existing Partner AND does have an existing ORAGANIC campaign AND doesnt have an existing keyword tracking setup WHEN I navigate to Setup_Keyword_Tracking page AND I populate Enter_Keyword textfields with a combination of alpha, numeric, alphanumeric and special character THEN Ill be able to create a  keyword tracking
      
  Given I'm an existing Partner

	When I navigate to "INTROVIO"
	And I populate Email_Address textfield with "clayton@truelogic.com.ph"
	And I populate Password textfield with "Hapy123"
	And I clicked Login button
	Then Ill be able to login successfully
	
	When I navigate to Setup_Keyword_Tracking page without existing keyword tracking setup
	And I tick the  Use_Google.com tickbox
	And I click Save_Changes button
	Then Ive successfully created a keyword tracking

