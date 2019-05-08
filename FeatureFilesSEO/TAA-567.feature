#Author: reuel@truelogic.com.ph
#Version 1.0 03.05 2019 - Initial creation of file
Feature: [TAA-567] [SEOReseller] Adhoc Smoke/Regression TestSuite

  #Scenario Description:
  #Given I am a Partner
  #When I navigate to the Store Page
  #And I navigate to the WebAudit Page
  #And I navigate to the LeadGen Page
  #And I navigate to the CRM Page
  #And I navigate to the Store Page
  #Then Ill see that Ive navigated to the Store Page
  @SRSSMOKETEST @Adhoc @SRS-7870_TS01 @TAA-568
  Scenario Outline: TAA-568
    Given Im a new Partner
    When I navigate to "Login"
    When I populate the SEOE6_EmailAddress textfield with <Email>
    And I populate the SEOE6_Password textfield with <Password>
    And I click the SEO06_LoginToYourDashBoard button
    When I navigate to "WebAudit"
    Then Ill see that Ive navigated to "WebAudit"
    When I navigate to "Store"
    Then Ill see that Ive navigated to "Store"
    When I navigate to "StoreFeatured"
    Then Ill see that Ive navigated to "StoreFeatured"
    When I navigate to "StoreC58"
    Then Ill see that Ive navigated to "StoreC58"
    When I navigate to "StoreC3"
    Then Ill see that Ive navigated to "StoreC3"
    When I navigate to "StoreC17"
    Then Ill see that Ive navigated to "StoreC17"
    When I navigate to "StoreC1"
    Then Ill see that Ive navigated to "StoreC1"
    When I navigate to "StoreC2"
    Then Ill see that Ive navigated to "StoreC2"
    When I navigate to "StoreC21"
    Then Ill see that Ive navigated to "StoreC21"
    When I navigate to "StoreC4"
    Then Ill see that Ive navigated to "StoreC4"
    When I navigate to "StoreC19"
    Then Ill see that Ive navigated to "StoreC19"
    When I navigate to "StoreC27"
    Then Ill see that Ive navigated to "StoreC27"
    When I navigate to "ProposalBuilder"
    Then Ill see that Ive navigated to "ProposalBuilder"
    When I navigate to "Store"
    Then Ill see that Ive navigated to "Store"
    When I navigate to "StoreFeatured"
    Then Ill see that Ive navigated to "StoreFeatured"
    When I navigate to "StoreC58"
    Then Ill see that Ive navigated to "StoreC58"
    When I navigate to "StoreC3"
    Then Ill see that Ive navigated to "StoreC3"
    When I navigate to "StoreC17"
    Then Ill see that Ive navigated to "StoreC17"
    When I navigate to "StoreC1"
    Then Ill see that Ive navigated to "StoreC1"
    When I navigate to "StoreC2"
    Then Ill see that Ive navigated to "StoreC2"
    When I navigate to "StoreC21"
    Then Ill see that Ive navigated to "StoreC21"
    When I navigate to "StoreC4"
    Then Ill see that Ive navigated to "StoreC4"
    When I navigate to "StoreC19"
    Then Ill see that Ive navigated to "StoreC19"
    When I navigate to "StoreC27"
    Then Ill see that Ive navigated to "StoreC27"
    When I navigate to "LeadGen"
    Then Ill see that Ive navigated to "LeadGen"
    When I navigate to "Store"
    Then Ill see that Ive navigated to "Store"
    When I navigate to "StoreFeatured"
    Then Ill see that Ive navigated to "StoreFeatured"
    When I navigate to "StoreC58"
    Then Ill see that Ive navigated to "StoreC58"
    When I navigate to "StoreC3"
    Then Ill see that Ive navigated to "StoreC3"
    When I navigate to "StoreC17"
    Then Ill see that Ive navigated to "StoreC17"
    When I navigate to "StoreC1"
    Then Ill see that Ive navigated to "StoreC1"
    When I navigate to "StoreC2"
    Then Ill see that Ive navigated to "StoreC2"
    When I navigate to "StoreC21"
    Then Ill see that Ive navigated to "StoreC21"
    When I navigate to "StoreC4"
    Then Ill see that Ive navigated to "StoreC4"
    When I navigate to "StoreC19"
    Then Ill see that Ive navigated to "StoreC19"
    When I navigate to "StoreC27"
    Then Ill see that Ive navigated to "StoreC27"
    When I click the SEO01_UserAvatar button
    And I click the SEO01_Logout list
    Then Ill see the SEO06_LogIn page

    Examples: 
      | Email                      | Password |
      | clayton@truelogic.com.ph   | happy123 |
      | melissa+2@truelogic.com.ph | testingg |

  #Scenario Description:
  #Given I am a Partner
  #When I navigate to the Login Page
  #And I wait for <Time> millisecond
  #And I login through the Login Page
  #Then Ill see that Ive login successfully
  @SRSSMOKETEST @Adhoc @SRS-7852_TS01 @TAA-570
  Scenario Outline: TAA-570
    Given Im a new Partner
    When I navigate to "Login"
    And I wait for <Time> millisecond
    And I populate the SEOE6_EmailAddress textfield with <Email>
    And I populate the SEOE6_Password textfield with <Password>
    And I click the SEO06_LoginToYourDashBoard button
    Then Ill see the SEO00_Dashboard page

    Examples: 
      | Time    | Email                      | Password |
      | 7200000 | clayton@truelogic.com.ph   | happy123 |
      | 7200000 | melissa+2@truelogic.com.ph | testingg |

  #Scenario Description:
  #Given I a Compass AppUser
  #When I login to Login Page
  #Then I'll see that I'm logged-in successfully to Compass
  #When I navigate to Partner page
  #And I click LoginAsClient button
  #Then I'll see that I'm logged-in successfully to Dashboard
  #And I'll see that I'm redirected to Home Page
  #When I navigate to the Store Page
  #And I navigate to the WebAudit Page
  #And I navigate to the LeadGen Page
  #And I navigate to the CRM Page
  #And I navigate to the Store Page
  #Then Ill see that Ive navigated to the Store Page
  @SRSSMOKETEST @Adhoc @SRS-7870_TS02 @TAA-578
  Scenario Outline: TAA-578
    Given Im a new Partner
    When I navigate to the application exact <CompassURL>
    And I populate COM01_Username with "radscrum@truelogic.com.ph"
    And I populate COM01_Password with "qwerty"
    And I click COM01_LogIn button
    Then Ill see that Ive login successfully
    When I navigate to the application exact <PartnerURL>
    Then Ill see that Ive navigated to the application exact <PartnerURL>
    When I click COM02_LogInAsClient button
    And I navigate to ChildWindow
    And I navigate to "WebAudit"
    Then Ill see that Ive navigated to "WebAudit"
    When I navigate to "Store"
    Then Ill see that Ive navigated to "Store"
    When I navigate to "StoreFeatured"
    Then Ill see that Ive navigated to "StoreFeatured"
    When I navigate to "StoreC58"
    Then Ill see that Ive navigated to "StoreC58"
    When I navigate to "StoreC3"
    Then Ill see that Ive navigated to "StoreC3"
    When I navigate to "StoreC17"
    Then Ill see that Ive navigated to "StoreC17"
    When I navigate to "StoreC1"
    Then Ill see that Ive navigated to "StoreC1"
    When I navigate to "StoreC2"
    Then Ill see that Ive navigated to "StoreC2"
    When I navigate to "StoreC21"
    Then Ill see that Ive navigated to "StoreC21"
    When I navigate to "StoreC4"
    Then Ill see that Ive navigated to "StoreC4"
    When I navigate to "StoreC19"
    Then Ill see that Ive navigated to "StoreC19"
    When I navigate to "StoreC27"
    Then Ill see that Ive navigated to "StoreC27"
    When I navigate to "ProposalBuilder"
    Then Ill see that Ive navigated to "ProposalBuilder"
    When I navigate to "Store"
    Then Ill see that Ive navigated to "Store"
    When I navigate to "StoreFeatured"
    Then Ill see that Ive navigated to "StoreFeatured"
    When I navigate to "StoreC58"
    Then Ill see that Ive navigated to "StoreC58"
    When I navigate to "StoreC3"
    Then Ill see that Ive navigated to "StoreC3"
    When I navigate to "StoreC17"
    Then Ill see that Ive navigated to "StoreC17"
    When I navigate to "StoreC1"
    Then Ill see that Ive navigated to "StoreC1"
    When I navigate to "StoreC2"
    Then Ill see that Ive navigated to "StoreC2"
    When I navigate to "StoreC21"
    Then Ill see that Ive navigated to "StoreC21"
    When I navigate to "StoreC4"
    Then Ill see that Ive navigated to "StoreC4"
    When I navigate to "StoreC19"
    Then Ill see that Ive navigated to "StoreC19"
    When I navigate to "StoreC27"
    Then Ill see that Ive navigated to "StoreC27"
    When I navigate to "LeadGen"
    Then Ill see that Ive navigated to "LeadGen"
    When I navigate to "Store"
    Then Ill see that Ive navigated to "Store"
    When I navigate to "StoreFeatured"
    Then Ill see that Ive navigated to "StoreFeatured"
    When I navigate to "StoreC58"
    Then Ill see that Ive navigated to "StoreC58"
    When I navigate to "StoreC3"
    Then Ill see that Ive navigated to "StoreC3"
    When I navigate to "StoreC17"
    Then Ill see that Ive navigated to "StoreC17"
    When I navigate to "StoreC1"
    Then Ill see that Ive navigated to "StoreC1"
    When I navigate to "StoreC2"
    Then Ill see that Ive navigated to "StoreC2"
    When I navigate to "StoreC21"
    Then Ill see that Ive navigated to "StoreC21"
    When I navigate to "StoreC4"
    Then Ill see that Ive navigated to "StoreC4"
    When I navigate to "StoreC19"
    Then Ill see that Ive navigated to "StoreC19"
    When I navigate to "StoreC27"
    Then Ill see that Ive navigated to "StoreC27"
    When I click the SEO01_UserAvatar button
    And I click the SEO01_Logout list
    Then Ill see the SEO06_LogIn page

    Examples: 
      | CompassURL               | PartnerURL                                |
      | http://app.compass/login | http://app.compass/clients/bucket/1/21649 |
      | http://app.compass/login | http://app.compass/clients/bucket/1/30400 |
      | http://app.compass/login | http://app.compass/clients/bucket/1/40011 |
