#Author: Prashanth Veldandi <prashanth.veldandi@gqaustralia.edu.au>
#[PV 12.13.16]
## (Comments-)
#Sample Feature Definition Template
Feature: [TAA-519] [SEOReseller]

  @DEBUG
  Scenario Outline: Debug
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
      | Email                    | Password |
      | clayton@truelogic.com.ph | happy123 |
      | melissa+2@truelogic.com.ph | testingg |
