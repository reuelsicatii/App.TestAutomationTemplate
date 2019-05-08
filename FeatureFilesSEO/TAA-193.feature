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
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: [TAA-193] [SEOReseller]: Lead Generator Smoke/Regression TestSuite

  #Scenario Description:
  #Given I'm a User
  #When I enter a website
  #And I click "Run New Audit(Beta)" Button
  #Then my report will generated using the web audit tool
  #And I can view the report
  @SRSSMOKETEST @LeadGen @LeadGen_TS01 @TAA-302
  Scenario Outline: TAA-302
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    And I enter a US Location data in SEO15_Location textfield coming from LeadGeneratorData Json
    And I populate SEO15_Keyword textfield with <keyword>
    And I click the the SEO15_GenerateLeads button
    And I click the SE015_ViewLeads button of <keyword> in location from the test data file
    Then Ill see the SE015_LeadGen table
    And Ill see that SEO15_TotalLeadsFound is equal to the row count returned
    And Ill see that the Company Name is available per row

    Examples: 
      | email                | password | keyword           |
      | tlosrnd321@gmail.com | happy123 | veterinary clinic |

  ##========================================================================================
  ## This Test Scenario is deprecated due to SRS-7081
  ##========================================================================================
  #Given I am a user
  #And I open Lead Generator
  #When I enter text that does not match any location in Yellow Pages or Google Places
  #Then I will see the text "No locations found." in red under the field
  @SRSSMOKETEST @LeadGen-Deprecated @SRS-5943_TS01 @TAA-303
  Scenario Outline: TAA-303
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    Then Ill be redirected to Lead Generator page
    And I populate SEO15_Location textfield with <location>
    And I populate SEO15_Keyword textfield with '<keyword>'
    Then Ill see the SEO15_ErrorMessage "No search results for this niche." in red under the field

    Examples: 
      | email                | password | location              |
      | tlosrnd321@gmail.com | happy123 | Florida City, FL, USA |

  ##========================================================================================
  ## This Test Scenario is deprecated due to SRS-7081
  ##========================================================================================
  #Given I am a user
  #And I open Lead Generator
  #And I have selected a US location
  #When I enter text on the Niche field that does not match any of the Autocomplete listings for Yellow Pages
  #Then I will see the text "No search results for this niche." in red under the field
  @SRSSMOKETEST @LeadGen-Deprecated @SRS-5943_TS02 @TAA-304
  Scenario Outline: TAA-304
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    Then Ill be redirected to Lead Generator page
    When I populate SEO15_Location textfield with <location>
    And I enter the keyword <keyword> in the SEO15_Keyword textfield without auto selection
    Then Ill see the SEO15_ErrorMessage "No search results for this niche." in red under the field

    Examples: 
      | email                | password | location      | keyword         |
      | tlosrnd321@gmail.com | happy123 | New York, USA | Video Marketing |

  #Given I am a user
  #And I have selected a Non-US location
  #When I enter <characters> in the niche field
  #Then the Generate Leads button will be enabled
  @SRSSMOKETEST @LeadGen @SRS-5943_TS03 @TAA-305
  Scenario Outline: TAA-305
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    Then Ill be redirected to Lead Generator page
    And Ill see SEO15_Location textfield
    And Ill see SEO15_Keyword textfield
    And Ill see SEO15_GenerateLeads button is Disabled
    When I populate SEO15_Location textfield with <location>
    And I enter the keyword <keyword> in the SEO15_Keyword textfield without auto selection
    Then Ill see SEO15_GenerateLeads button is Enabled

    Examples: 
      | email                | password | location                          | keyword      |
      | tlosrnd321@gmail.com | happy123 | Makati, Metro Manila, Philippines | UST          |
      | tlosrnd321@gmail.com | happy123 | Makati, Metro Manila, Philippines | UST Comp Sci |

  #Given I am a user
  #And I have selected a Non-US location
  #When I enter <characters> in the niche field
  #And I see that the generate Leads button was enabled
  #And I click  the generate leads button
  #Then the Niche textbox will be highlighted in red
  #And I will see the text "Search term must be 3 characters and above." in red under the field
  #And I will not generate any leads
  @SRSSMOKETEST @LeadGen @SRS-5943_TS04 @TAA-306
  Scenario Outline: TAA-306
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    Then Ill be redirected to Lead Generator page
    And Ill see SEO15_Location textfield
    And Ill see SEO15_Keyword textfield
    And Ill see SEO15_GenerateLeads button is Disabled
    When I populate SEO15_Location textfield with <location>
    And I enter the keyword <characters> in the SEO15_Keyword textfield without auto selection
    And I click the the SEO15_GenerateLeads button
    And Ill see the SEO15_ErrorMessage "Search term must be 3 characters and above." in red under the field

    Examples: 
      | email                | password | location                          | characters |
      | tlosrnd321@gmail.com | happy123 | Makati, Metro Manila, Philippines | L          |
      | tlosrnd321@gmail.com | happy123 | Makati, Metro Manila, Philippines | ca         |

  #Given I start typing in the niche/keyword field
  #And I have selected a US location
  #When I keyup
  #And there are matching results from "https://www.yellowpages.com/autosuggest/headings.html?text=my_query"
  #Then I see autocomplete keywords
  #Filtering out list elements with a data-address attribute
  #And keeping only the li elements with class="no-geo"
  @SRSSMOKETEST @LeadGen @SRS-5944_TS01 @TAA-374
  Scenario Outline: TAA-374
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    And I populate SEO15_Location textfield with <location>
    And I populate SEO15_Keyword textfield with <keyword>
    Then Ill see the auto suggestion list for <keyword> matches result from yellowpages

    Examples: 
      | email                | password | location          | keyword   |
      | tlosrnd321@gmail.com | happy123 | New York, NY, USA | chocolate |

  #Given I am a User
  #And I have autocomplete results from Yellow Pages
  #When I select on one of the results
  #Then I see that the selected result is displayed in the niche/keyword field
  @SRSSMOKETEST @LeadGen @SRS-5944_TS02 @TAA-375
  Scenario Outline: TAA-375
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    And I populate SEO15_Location textfield with <location>
    And I enter the keyword <keyword> in the SEO15_Keyword textfield without auto selection
    And I select the <selectedKeyword> in the SEO15_NicheSuggestion List
    Then Ill see that the selected <selectedKeyword> is displayed in the SEO15_Keyword textfield

    Examples: 
      | email                | password | location          | keyword   | selectedKeyword |
      | tlosrnd321@gmail.com | happy123 | New York, NY, USA | chocolate | chocolate store |

  #Given I am a User
  #And I have autocomplete results from Yellow Pages
  #When I enter keyword
  #And I click on outside the niche field
  #Then I see that the first item from the list is displayed in the niche/keyword field
  @SRSSMOKETEST @LeadGen @SRS-5944_TS03 @TAA-376
  Scenario Outline: TAA-376
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    And I populate SEO15_Location textfield with <location>
    And I enter the keyword <keyword> in the SEO15_Keyword textfield without auto selection
    And I click outside of the SEO15_Keyword textfield
    Then Ill see that the first item <firstItem> from the autocomplete list is displayed in the SEO15_Keyword textfield

    Examples: 
      | email                | password | location          | keyword | firstItem             |
      | tlosrnd321@gmail.com | happy123 | New York, NY, USA | Candy   | Candy & Confectionery |

  #Given I am a User
  #And I have entered Non-US location
  #When I enter keyword
  #Then I see no autocomplete in niche field
  @SRSSMOKETEST @LeadGen @SRS-5944_TS04 @TAA-377
  Scenario Outline: TAA-377
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    And I populate SEO15_Location textfield without auto selection with <location>
    And I enter the keyword <keyword> in the SEO15_Keyword textfield without auto selection
    And Ill not see the SEO15_NicheSuggestion list for <keyword>

    Examples: 
      | email                | password | location | keyword |
      | tlosrnd321@gmail.com | happy123 | Makati   | Candy   |

  ##========================================================================================
  ## This Test Scenario is deprecated due to SRS-7081
  ##========================================================================================
  #Given I am a User
  #And I have entered <location>
  #And I enter a valid keyword
  #And I enter an invalid keyword
  #When I clear the niche
  #Then no error message is displayed
  @SRSSMOKETEST @LeadGen-Deprecated @SRS-5944_TS05 @TAA-378
  Scenario Outline: TAA-378
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    Then Ill be redirected to Lead Generator page
    When I populate SEO15_Location textfield with <location>
    And I enter the keyword <keywordA> in the SEO15_Keyword textfield without auto selection
    And I clear SEO15_Keyword textfield
    And I enter the keyword <keywordB> in the SEO15_Keyword textfield without auto selection
    Then Ill see the SEO15_ErrorMessage "No search results for this niche." in red under the field
    When I clear SEO15_Keyword textfield
    Then Ill NOT see the SEO15_ErrorMessage "No search results for this niche." in red under the field

    Examples: 
      | email                | password | location          | keywordA  | keywordB |
      | tlosrnd321@gmail.com | happy123 | New York, NY, USA | ice cream | papamama |

  #Given I'm an AppUser,
  #When I navigate to Dashboard >> Agency Tools >> Lead Generator
  #Then I will see the field Search in (location) enabled
  #And I will see the field for (niche or keyword) disabled
  #And I will see the Generate Leads button disabled
  @SRSSMOKETEST @LeadGen @SRS-5945_TS01 @TAA-379
  Scenario Outline: TAA-379
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    Then Ill be redirected to Lead Generator page
    And Ill see that the SEO15_Location is enabled
    And Ill see that the SEO15_Keyword is disabled
    And Ill see SEO15_GenerateLeads button is Disabled

    Examples: 
      | email                | password |
      | tlosrnd321@gmail.com | happy123 |

  #Given I'm an AppUser,
  #When I type on the location field
  #And the target location is non-US
  #Then the niche field will be enabled
  #When I type on the niche field
  #And click Generate Leads
  #Then I will be able to generate leads based on my search input sourced from Google Places
  @SRSSMOKETEST @LeadGen @SRS-5945_TS03 @TAA-381
  Scenario Outline: TAA-381
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    And I populate SEO15_Location textfield with <location>
    And I enter the keyword <keyword> in the SEO15_Keyword textfield without auto selection
    And I click the the SEO15_GenerateLeads button
    And I click the SE015_ViewLeads button of <keyword> in location from the test data file
    Then Ill see the SE015_LeadGen table
    And Ill see that SEO15_TotalLeadsFound is equal to the row count returned
    And Ill see that the Company Name is available per row

    Examples: 
      | email                | password | location                          | keyword   |
      | tlosrnd321@gmail.com | happy123 | Manila, Metro Manila, Philippines | Pizza     |
      | tlosrnd321@gmail.com | happy123 | Johannesburg, South Africa        | food      |
      | tlosrnd321@gmail.com | happy123 | Sydney NSW, Australia             | chocolate |

  #Given I'm an AppUser,
  #When I type on the location field
  #And the target location is in the US
  #Then the niche field will be enabled
  #When I type on the niche field
  #And click Generate Leads
  #Then I will be able to generate leads based on my search input sourced from Yellow Pages:
  #Business name, Address, Website, Phone number from YP search results
  #Email, additional Phone number & FB from website
  #SEO results and Adwords from spyfu
  @SRSSMOKETEST @LeadGen @SRS-5945_TS04 @TAA-382
  Scenario Outline: TAA-382
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <email>
    And I populate the SEOE6_Password textfield with <password>
    And I click the SEO06_LoginToYourDashBoard button
    Then I see the SEO01_Home Page
    When I click the SEO01_LeadGenQuickAccess icon
    And I populate SEO15_Location textfield with <srslocation>
    And I populate SEO15_Keyword textfield with <keyword>
    And I click the the SEO15_GenerateLeads button
    And I click the SE015_ViewLeads button of <keyword> in location from the test data file
    Then Ill see the SE015_LeadGen table
    And Ill see that the Details for Search Result of <keyword> in <yplocation> matches the details from yellowpages

    Examples: 
      | email                | password | srslocation           | yplocation       | keyword          |
      | tlosrnd321@gmail.com | happy123 | Jersey City, NJ, USA  | Jersey City, NJ  | Basketball Clubs |
      | tlosrnd321@gmail.com | happy123 | Arizona City, AZ, USA | Arizona City, AZ | ice cream        |
