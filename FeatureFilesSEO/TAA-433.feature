#Author: reuel@truelogic.com.ph, lorraine@truelogic.com.ph
#Version 1.0 06.27 2018 - Initial creation of file
Feature: [TAA-433] [SEOReseller] Onboarding Smoke/Regression TestSuite

  #Scenario Description:
  #Covered Ticket : SRS-6974
	#Given I am a User 
	#And I already finished the sign up process 
	#And I received the "Please confirm your email address email" 
	#When I <EmailAction> in the confirmation email
	#Then I will be redirected to the "Hey there!" page 
	#And I will see that the "Hey there!" page is aligned with the Mock-up
  @SRSSMOKETEST @Onboarding @OnboardingNonFunc_TS01 @TAA-434
  Scenario Outline: TAA-434
		Given Im a new Partner
    And I ensure that <Email> does not exist
    When I navigate to "Login"
    Then Ill see the SEO06_SeoReseller Banner
    
    When I click SEO06_SignUp link
    And I wait for page to load
    And I populate the SEO010_FirstName textfield with <FirstName>
    And I populate the SEO010_LastName textfield with <LastName>
    And I populate the SEO010_Email textfield with <Email>
    And I populate the SEO010_Password textfield with <Password>
    And I click SEO010_CreateAccount button
    And I wait for page to load
    Then Ill be redirected to SEO11_Welcome page
    And I see the SEO11_Congratulations div with "Congratulations! You are just one step away to access all features of your free account."
    
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    Then I see the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
   
		When I click the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    Then Ill see the GMAIL01_ThankYouForRegistering div with "Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below."

    When I click the GMAIL01_GotoMyDashboard <ElementName>
    And I navigate to ChildWindow
    And I wait for page to load
    Then Ill be redirected to the SEO16_HeyThere Page
    And Ill be able to see a SEO16_StepCounter with numbers 1 to 3
		And Ill see the SEO16_SearchGiantQuote div with "By far the best SEO reseller provider we've worked with. Their plans are reasonably priced and staff is phenomenal. I highly recommend them."
		And Ill see the SEO16_Title text with "It's great to have you onboard with SEOReseller." 
		And Ill see the SEO16_SubText with "We're excited to work with you and be your partner in growth. We've helped thousands of clients improve rankings, and helped marketers build powerful digital marketing agencies." 
    And Ill see the SEO16_LetsGetStarted button
     
    Examples: 
			| FirstName | LastName   | Email                         | Password  | ElementName |
      | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      |
      | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | link        |
  
  
  #Scenario Description:
  #Covered Ticket : SRS-6974
	#	Given I am a User 
	#	And I already finished the sign up process 
	#	And I received the "Please confirm your email address email" 
	#	When I click on the "Let's get started" button 
	#	Then I will be able to see the "Getting to know you" first page  
	#	And I will see that the "Getting to know you" first page is aligned with the Mock-up
	#	When I click on any option 
	#	Then I will be able to see that the "Proceed" button will be enabled
  @SRSSMOKETEST @Onboarding @OnboardingNonFunc_TS02 @TAA-435
  Scenario Outline: TAA-435
		Given Im a new Partner
    And I ensure that <Email> does not exist
    When I navigate to "Login"
    Then Ill see the SEO06_SeoReseller Banner
    
    When I click SEO06_SignUp link
    And I wait for page to load
    And I populate the SEO010_FirstName textfield with <FirstName>
    And I populate the SEO010_LastName textfield with <LastName>
    And I populate the SEO010_Email textfield with <Email>
    And I populate the SEO010_Password textfield with <Password>
    And I click SEO010_CreateAccount button
    And I wait for page to load
    Then Ill be redirected to SEO11_Welcome page
    And I see the SEO11_Congratulations div with "Congratulations! You are just one step away to access all features of your free account."
    
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    Then I see the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    
    When I click the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    Then Ill see the GMAIL01_ThankYouForRegistering div with "Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below."
    
    When I click the GMAIL01_GotoMyDashboard <ElementName>
    And I navigate to ChildWindow
    And I wait for page to load
    Then Ill be redirected to the SEO16_HeyThere Page
    
    When I click the SEO16_LetsGetStarted button
    And I click the SEO17_Myself Radio button
    Then Ill see that the SEO17_Proceed button will be enabled
    
    When I click the SEO17_InHouse Radio button
    Then Ill see that the SEO17_Proceed button will be enabled
    
    When I click the SEO17_WithFreelancer Radio button
    Then Ill see that the SEO17_Proceed button will be enabled
    
    When I click the SEO17_WithAnAgency Radio button
    Then Ill see that the SEO17_Proceed button will be enabled
    
   	When I click the SEO17_WithAnOutsource Radio button
   	Then Ill see that the SEO17_Proceed button will be enabled
   	
    When I click the SEO17_DontDoSEO Radio button
    Then Ill see that the SEO17_Proceed button will be enabled
   
   Examples: 
		| FirstName | LastName   | Email                         | Password  | ElementName |
    | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      |
    
  #Scenario Description:
  #Covered Ticket : SRS-6974
	#Given I am a User 
	#And I already finished the sign up process 
	#And I received the "Please confirm your email address email" 
	#When I confirm my Email Address
	#And I click the Lets Get Started button in the "Hey There" Page
	#And I <OptionState> <OptionType> in the list of "How do you handle SEO right now?" 
	#And I click on the "Proceed" button 
	#Then I will see that the "Getting to know you" second page is aligned with the Mock-up
  @SRSSMOKETEST @Onboarding @OnboardingNonFunc_TS03 @TAA-436
  Scenario Outline: TAA-436
		Given Im a new Partner
    And I ensure that <Email> does not exist
    When I navigate to "Login"
    Then Ill see the SEO06_SeoReseller Banner
    
    When I click SEO06_SignUp link
    And I wait for page to load
    And I populate the SEO010_FirstName textfield with <FirstName>
    And I populate the SEO010_LastName textfield with <LastName>
    And I populate the SEO010_Email textfield with <Email>
    And I populate the SEO010_Password textfield with <Password>
    And I click SEO010_CreateAccount button
    And I wait for page to load
    Then Ill be redirected to SEO11_Welcome page
    And I see the SEO11_Congratulations div with "Congratulations! You are just one step away to access all features of your free account."
    
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    Then I see the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    
    When I click the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    Then Ill see the GMAIL01_ThankYouForRegistering div with "Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below."
    
    When I click the GMAIL01_GotoMyDashboard <ElementName>
    And I navigate to ChildWindow
    And I wait for page to load
    Then Ill be redirected to the SEO16_HeyThere Page
    
    When I click the SEO16_LetsGetStarted button
    And I click the radio button of SEO17_<SeoHandling> 
    And I click the SEO17_Proceed button
    Then I will see the SEO19_GettingToKnowYou header
    And I will see the SEO19_CheckMark Icon for Step One Page
    And I will see the SEO19_HowCanWeReachYou header
    And I will see the SEO19_InCaseWeNeedToContact div with "In case we need to contact you about your campaigns, please provide us with a phone number where we can easily reach you."
    And I will see the SEO19_ContactNumber textfield
    And I will see the SEO19_TheDiagnosisCallAllowed div with "The Diagnosis call allowed me to start thinking differently about my agency and build a serious business plan. I've just passed my first million dollar in revenue!"

   
   Examples: 
		| FirstName | LastName   | Email                         | Password  | ElementName |       SeoHandling          |
    | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      |         myself             |
    | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      |         in-house           |
    | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      |      with a freelancer     |
    | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      |        with an agency      |
    | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      | with an outsource provider |
    | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      |          no seo            |

  #Scenario Description:
  #Covered Ticket : SRS-6974
	#Given I am a User 
	#And I already finished the sign up process 
	#And I received the "Please confirm your email address email" 
	#When I confirm my Email Address
	#And I click the Lets Get Started button in the "Hey There" Page
	#And I select an option in the "Getting to know you" first Page
	#And I click Proceed button in the "Getting to know you" first Page
	#And I click on the "Save" button in the "Getting to know you" second Page
	#Then I will be able see the "Let's schedule your onboarding call" calendly page 
	#And I will be able to see the text "We'll discuss our future partnership, how we will be working together, and what you can expect for your business from us" 
	#And I will be able to see an iframe "Calendly" scheduler
	#And I will be able to see the "Done with Booking my Call" button 
	#And I will be able to see "Nah, I'll do it later" clickable text 
  @SRSSMOKETEST @Onboarding @OnboardingNonFunc_TS04 @TAA-437
  Scenario Outline: TAA-437
		Given Im a new Partner
    And I ensure that <Email> does not exist
    When I navigate to "Login"
    Then Ill see the SEO06_SeoReseller Banner
    
    When I click SEO06_SignUp link
    And I wait for page to load
    And I populate the SEO010_FirstName textfield with <FirstName>
    And I populate the SEO010_LastName textfield with <LastName>
    And I populate the SEO010_Email textfield with <Email>
    And I populate the SEO010_Password textfield with <Password>
    And I click SEO010_CreateAccount button
    And I wait for page to load
    Then Ill be redirected to SEO11_Welcome page
    And I see the SEO11_Congratulations div with "Congratulations! You are just one step away to access all features of your free account."
    
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    Then I see the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    
    When I click the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    Then Ill see the GMAIL01_ThankYouForRegistering div with "Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below."
    
    When I click the GMAIL01_GotoMyDashboard <ElementName>
    And I navigate to ChildWindow
    And I wait for page to load
    Then Ill be redirected to the SEO16_HeyThere Page
    
    When I click the SEO16_LetsGetStarted button
    And I click the SEO17_Myself Radio button
    And I click the SEO17_Proceed button
    Then I will see the SEO19_GettingToKnowYou header
    
    When I populate SEO19_ContactNumber textfield with <contactNumber>
    And I click the SEO19_Save button
    Then Ill see the SEO20_LetsScheduleYourcall header with "Let's schedule your onboarding call"
    And Ill see the SEO20_DiscussOurFuturePartnership text with "We'll discuss our future partnership, how we will be working together"
    And Ill see the SEO20_Calendly iframe
    And Ill see the SEO20_DoneWithBookingMyCall button
    And Ill see the SEO20_NahIllDoIt link
    
    
  Examples: 
		| FirstName | LastName   | Email                         | Password  | ElementName | contactNumber |
    | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      | (321) 321-321 |
    
  #Scenario Description:
  #Covered Ticket : SRS-6974
	#Given I am a User 
	#And I access the sign up process using a <Type> 
	#And I already finished the sign up process 
	#And I received the "Please confirm your email address email" 
	#When I confirm my Email Address
	#And clearbit analyzed my Sign Up data 
	#And I click the Lets Get Started button in the "Hey There" Page
	#And I select an option in the "Getting to know you" first Page
	#And I click Proceed button in the "Getting to know you" first Page
	#And I click on the "Save" button in the "Getting to know you" second Page
	#And I already select a schedule in the Calendly scheduler 
	#Then I will be able to see the "You're all set!" page 
	#And I will be able to see a step counter with 3 nodes 
	#And I will see the step counter's 1st node is filled in green with a checkmark
	#And I will see the step counter's 2nd node is filled in green with a checkmark
	#And I will see the step counter's 3rd node is filled in green with a checkmark
	#And I will be able to see the text "We'll contact you at your chosen date and time and send you a reminder beforehand." 
	#And I will be able to see the text "If you have any questions, send us a message, or give us a call at (415) 625-9700."
	#And I will be able to see that the "Message" is highlighted is underlined and is a hyperlink 
	#And I will be able to see the button "Let's go to the dashboard" 
	@SRSSMOKETEST @Onboarding @OnboardingNonFunc_TS05 @TAA-438
  Scenario Outline: TAA-438
		Given Im a new Partner
    And I ensure that <Email> does not exist
    When I navigate to "Login"
    Then Ill see the SEO06_SeoReseller Banner
    
    When I click SEO06_SignUp link
    And I wait for page to load
    And I populate the SEO010_FirstName textfield with <FirstName>
    And I populate the SEO010_LastName textfield with <LastName>
    And I populate the SEO010_Email textfield with <Email>
    And I populate the SEO010_Password textfield with <Password>
    And I click SEO010_CreateAccount button
    And I wait for page to load
    Then Ill be redirected to SEO11_Welcome page
    And I see the SEO11_Congratulations div with "Congratulations! You are just one step away to access all features of your free account."
    
    When I navigate to GMAIL
    And I click the GMAIL01_GoogleHomeSignIn link
    And I populate the GMAIL01_GoogleEmail textField with <Email>
    And I click the GMAIL01_GoogleEmailNext button
    And I populate the GMAIL01_GooglePassword textField with <Password>
    And I click the GMAIL01_GooglePasswordNext button
    Then I see the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    
    When I click the GMAIL01_EmailSubject div with "Please Confirm Your Email Address"
    Then Ill see the GMAIL01_ThankYouForRegistering div with "Thank you for registering at SEOReseller.com There's just one more step to get you started. To confirm your email address, please click on the button below."
    
    When I click the GMAIL01_GotoMyDashboard <ElementName>
    And I navigate to ChildWindow
    And I wait for page to load
    Then Ill be redirected to the SEO16_HeyThere Page
    
    When I click the SEO16_LetsGetStarted button
    And I click the SEO17_Myself Radio button
    And I click the SEO17_Proceed button
    Then I will see the SEO19_GettingToKnowYou header
    
    When I populate SEO19_ContactNumber textfield with <contactNumber>
    And I click the SEO19_Save button
    Then Ill see the SEO20_LetsScheduleYourcall header with "Let's schedule your onboarding call"
    And Ill see the SEO20_DiscussOurFuturePartnership text with "We'll discuss our future partnership, how we will be working together"
    And Ill see the SEO20_Calendly iframe
    
    When I populate the SEO20_FullNameCalendly textfield with <fullName>
    And I populate the SEO20_EmailCalendly textfield with <Email>
    And I select the SEO20_FirstAvailableDay in Calendly
		And I select the SEO20_FirstAvailableTime in Calendly
    And I click the SEO20_FirstAvailableConfirm button in Calendly
    And I click the SEO20_ScheduleEvent button
		And I click the SEO20_DoneWithBookingMyCall button
    Then Ill see the SEO21_WellContactYou header with "We'll contact you at your chosen date and time and send you a reminder beforehand."
    And Ill see the SEO21_IfYouHaveAnyQuestions text with "If you have any questions"
    And Ill see that the SEO21_Message text is a link
    And Ill see the SEO21_LetsGoToTheDashboard button
    
  Examples: 
		| FirstName | LastName   | Email                         | Password  | ElementName | contactNumber |     fullName    |
    | RND       | Automation | RNDAutomationTest12@gmail.com | happy123$ | button      | (786)1234567  | RND Automation  |