#Author: reuel@truelogic.com.ph, lorraine@truelogic.com.ph
#Version 1.0 06.27 2018 - Initial creation of file
Feature: [TAA-37] [SEOReseller]: Campaign Settings Smoke/Regression TestSuite

  #Scenario Description:
  #Covered Tickets : None, Exploratory Test
  #Given Im an existing Partner
  #When I navigate to my TLOS Campaign
  #And I integrate TLOS Google Analytics
  #Then I'll be able to integrate successfully
  @SRSSMOKETEST @CampaignSettings @Integrations_TS01 @TAA-418
  Scenario Outline: TAA-418
    Given Im an existing Partner
    When I navigate to "Login"
    And I populate the SEOE6_EmailAddress textfield with <Email>
    And I populate the SEOE6_Password textfield with <Password>
    And I click the SEO06_LoginToYourDashBoard button
    Then Ill see the SEO00_Dashboard page
    When I click the SEO01_Campaign dropdown to choose <Campaign>
    Then Ill be redirected to SEO16_<Campaign> page
    When I click SEOXX_Settings
    And I click SEOXX_Integrations
    Then Ill be redirected to <Campaign> Settings>Integration page
    When I click SEOXX_Manage button
    And I click the SEOXX_Account dropdown to choose <Account>
    And I click the SEOXX_Goal dropdown to choose <Goal>
    And I click the SEOXX_SaveChanges button
    Then Ill see that Google Analytics is integrate successfully

    Examples: 
      | Email                    | Password | Campaign                        | Account              | Goal           |
      | clayton@truelogic.com.ph | happy123 | Truelogic Online Solutions Inc. | sam@truelogic.com.ph | All Traffic    |
      | clayton@truelogic.com.ph | happy123 | Seoreseller.com                 | sam@truelogic.com.ph | Main Analytics |
