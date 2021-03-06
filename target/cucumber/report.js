$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FeatureFilesSEO/TAA-532.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: reuel@truelogic.com.ph, lorraine@truelogic.com.ph"
    },
    {
      "line": 2,
      "value": "#Version 1.0 01.28 2019 - Initial creation of file"
    }
  ],
  "line": 3,
  "name": "[TAA-519] [SEOReseller] Manage Users Menu Smoke/Regression TestSuite",
  "description": "",
  "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 38,
      "value": "#Scenario Description:"
    },
    {
      "line": 39,
      "value": "#When I navigate to the Manage Users Page"
    },
    {
      "line": 40,
      "value": "#And I click the Add New User button"
    },
    {
      "line": 41,
      "value": "#Then Ill be able to add New Users"
    }
  ],
  "line": 43,
  "name": "ManageUsers_TS02",
  "description": "",
  "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;manageusers-ts02",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@SRSSMOKETEST"
    },
    {
      "line": 42,
      "name": "@ManageUsers"
    },
    {
      "line": 42,
      "name": "@ManageUsers_TS02"
    },
    {
      "line": 42,
      "name": "@TAA-539"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "Im a new Partner",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "I navigate to \"Login\"",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "I populate the SEOE6_EmailAddress textfield with \u003cemail\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "I populate the SEOE6_Password textfield with \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "I click the SEO06_LoginToYourDashBoard button",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "I wait for page to load",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "Ill see the SEO00_Dashboard page",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "I click the SEO01_UserAvatar button",
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "I click the SEO01_ManageUsers list",
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "Ill be able to see the SEO22_ManageUsers Page",
  "keyword": "Then "
});
formatter.step({
  "line": 54,
  "name": "I click the SEO22_AddNewUser button",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "I populate SEO22_EmailAddress textfield with \u003cuserEmailAdd\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "I populate SEO22_Username textfield with \u003cusername\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "I select \u003croleClassification\u003e in SEO22_Role dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "I populate SEO22_Password textfield with \u003cuserPassword\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "I click the SEO22_Save button",
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "Ill see the SEO23_ProfileInformation header",
  "keyword": "Then "
});
formatter.examples({
  "line": 62,
  "name": "",
  "description": "",
  "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;manageusers-ts02;",
  "rows": [
    {
      "cells": [
        "FirstName",
        "LastName",
        "email",
        "password",
        "userEmailAdd",
        "username",
        "roleClassification",
        "userPassword"
      ],
      "line": 63,
      "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;manageusers-ts02;;1"
    },
    {
      "cells": [
        "RND",
        "Automation",
        "lorraine@truelogic.com.ph",
        "123456789",
        "EmployeeTS02@gmail.com",
        "EmployeeTS02",
        "Employee",
        "emp12345"
      ],
      "line": 64,
      "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;manageusers-ts02;;2"
    },
    {
      "cells": [
        "RND",
        "Automation",
        "lorraine@truelogic.com.ph",
        "123456789",
        "ClientTS02@gmail.com",
        "ClientTS02",
        "Client",
        "cli12345"
      ],
      "line": 65,
      "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;manageusers-ts02;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 31565747449,
  "status": "passed"
});
formatter.before({
  "duration": 9253,
  "status": "passed"
});
formatter.before({
  "duration": 7197,
  "status": "passed"
});
formatter.scenario({
  "line": 64,
  "name": "ManageUsers_TS02",
  "description": "",
  "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;manageusers-ts02;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@ManageUsers_TS02"
    },
    {
      "line": 42,
      "name": "@TAA-539"
    },
    {
      "line": 42,
      "name": "@ManageUsers"
    },
    {
      "line": 42,
      "name": "@SRSSMOKETEST"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "Im a new Partner",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "I navigate to \"Login\"",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "I populate the SEOE6_EmailAddress textfield with lorraine@truelogic.com.ph",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "I populate the SEOE6_Password textfield with 123456789",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "I click the SEO06_LoginToYourDashBoard button",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "I wait for page to load",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "Ill see the SEO00_Dashboard page",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "I click the SEO01_UserAvatar button",
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "I click the SEO01_ManageUsers list",
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "Ill be able to see the SEO22_ManageUsers Page",
  "keyword": "Then "
});
formatter.step({
  "line": 54,
  "name": "I click the SEO22_AddNewUser button",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "I populate SEO22_EmailAddress textfield with EmployeeTS02@gmail.com",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "I populate SEO22_Username textfield with EmployeeTS02",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "I select Employee in SEO22_Role dropdown",
  "matchedColumns": [
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "I populate SEO22_Password textfield with emp12345",
  "matchedColumns": [
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "I click the SEO22_Save button",
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "Ill see the SEO23_ProfileInformation header",
  "keyword": "Then "
});
formatter.match({
  "location": "SEO00_CommonSteps.im_a_new_Partner()"
});
formatter.result({
  "duration": 243809358,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Login",
      "offset": 15
    }
  ],
  "location": "CommonSteps.i_navigate_to_URL_variable(String)"
});
formatter.result({
  "duration": 11178022068,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lorraine@truelogic.com.ph",
      "offset": 49
    }
  ],
  "location": "SEO06_Login.i_enter_email_value_in_emailaddress_field(String)"
});
formatter.result({
  "duration": 1224312258,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "123456789",
      "offset": 45
    }
  ],
  "location": "SEO06_Login.i_enter_password_value_in_password_field(String)"
});
formatter.result({
  "duration": 324324852,
  "status": "passed"
});
formatter.match({
  "location": "SEO06_Login.i_click_the_login_to_your_dashboard_button()"
});
formatter.result({
  "duration": 3158557869,
  "status": "passed"
});
formatter.match({
  "location": "CommonSteps.i_wait_for_page_to_load()"
});
formatter.result({
  "duration": 66037634,
  "status": "passed"
});
formatter.match({
  "location": "SEO00_CommonSteps.ill_see_the_dashboard_page()"
});
formatter.result({
  "duration": 7180292651,
  "status": "passed"
});
formatter.match({
  "location": "SEO01_Home.i_click_user_avatar()"
});
formatter.result({
  "duration": 69643220,
  "status": "passed"
});
formatter.match({
  "location": "SEO01_Home.i_click_the_manage_users()"
});
formatter.result({
  "duration": 69654529,
  "status": "passed"
});
formatter.match({
  "location": "SEO22_SettingsUsers.ill_see_manage_users_page()"
});
formatter.result({
  "duration": 6956772040,
  "status": "passed"
});
formatter.match({
  "location": "SEO22_SettingsUsers.i_click_add_new_user_button()"
});
formatter.result({
  "duration": 41602003,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "EmployeeTS02@gmail.com",
      "offset": 45
    }
  ],
  "location": "SEO22_SettingsUsers.i_populate_email_address_textfield_with_value(String)"
});
formatter.result({
  "duration": 355573262,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "EmployeeTS02",
      "offset": 41
    }
  ],
  "location": "SEO22_SettingsUsers.i_populate_username_textfield_with_value(String)"
});
formatter.result({
  "duration": 165813763,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Employee",
      "offset": 9
    }
  ],
  "location": "SEO22_SettingsUsers.i_select_role_value_under_role_dropwdown(String)"
});
formatter.result({
  "duration": 161455599,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "emp12345",
      "offset": 41
    }
  ],
  "location": "SEO22_SettingsUsers.i_populate_password_textfield_with_value(String)"
});
formatter.result({
  "duration": 3121665129,
  "status": "passed"
});
formatter.match({
  "location": "SEO22_SettingsUsers.i_click_save_button()"
});
formatter.result({
  "duration": 57661612,
  "status": "passed"
});
formatter.match({
  "location": "SEO23_SettingsUsersUserId.ill_see_profile_information_header()"
});
formatter.result({
  "duration": 120109265594,
  "error_message": "org.openqa.selenium.TimeoutException: Timed out after 60 seconds waiting for element to be clickable: Proxy element for: DefaultElementLocator \u0027By.xpath: //h3[text()\u003d\u0027Profile Information\u0027]/ancestor::div[@class\u003d\u0027widget\u0027]//button[text()\u003d\u0027Save\u0027]\u0027\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LPT-308\u0027, ip: \u0027192.168.56.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed), userDataDir\u003dC:\\Users\\reuel\\AppData\\Local\\Temp\\scoped_dir300_23930}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d53.0.2785.116, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 10fcde2eba085b64e460f323f4a0464f\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:80)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:261)\r\n\tat webApp.Seoreseller.SEO23_SettingsUsersUserId.ill_see_profile_information_header(SEO23_SettingsUsersUserId.java:34)\r\n\tat ???.Then Ill see the SEO23_ProfileInformation header(FeatureFilesSEO/TAA-532.feature:60)\r\nCaused by: org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//h3[text()\u003d\u0027Profile Information\u0027]/ancestor::div[@class\u003d\u0027widget\u0027]//button[text()\u003d\u0027Save\u0027]\"}\n  (Session info: chrome\u003d53.0.2785.116)\n  (Driver info: chromedriver\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 60.04 seconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.53.0\u0027, revision: \u002735ae25b1534ae328c771e0856c93e187490ca824\u0027, time: \u00272016-03-15 10:43:46\u0027\nSystem info: host: \u0027LPT-308\u0027, ip: \u0027192.168.56.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_181\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.25.426923 (0390b88869384d6eb0d5d09729679f934aab9eed), userDataDir\u003dC:\\Users\\reuel\\AppData\\Local\\Temp\\scoped_dir300_23930}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d53.0.2785.116, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: 10fcde2eba085b64e460f323f4a0464f\n*** Element info: {Using\u003dxpath, value\u003d//h3[text()\u003d\u0027Profile Information\u0027]/ancestor::div[@class\u003d\u0027widget\u0027]//button[text()\u003d\u0027Save\u0027]}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:206)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:158)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:678)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:363)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:500)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:361)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:355)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy17.isDisplayed(Unknown Source)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:302)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$100(ExpectedConditions.java:41)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:288)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:285)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:687)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$23.apply(ExpectedConditions.java:680)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:238)\r\n\tat webApp.Seoreseller.SEO23_SettingsUsersUserId.ill_see_profile_information_header(SEO23_SettingsUsersUserId.java:34)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:37)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:13)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:31)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:299)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:91)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:93)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:37)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:98)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 18569256907,
  "status": "passed"
});
formatter.before({
  "duration": 18498943358,
  "status": "passed"
});
formatter.before({
  "duration": 6169,
  "status": "passed"
});
formatter.before({
  "duration": 4112,
  "status": "passed"
});
formatter.scenario({
  "line": 65,
  "name": "ManageUsers_TS02",
  "description": "",
  "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;manageusers-ts02;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 42,
      "name": "@ManageUsers_TS02"
    },
    {
      "line": 42,
      "name": "@TAA-539"
    },
    {
      "line": 42,
      "name": "@ManageUsers"
    },
    {
      "line": 42,
      "name": "@SRSSMOKETEST"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "Im a new Partner",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "I navigate to \"Login\"",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "I populate the SEOE6_EmailAddress textfield with lorraine@truelogic.com.ph",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 47,
  "name": "I populate the SEOE6_Password textfield with 123456789",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 48,
  "name": "I click the SEO06_LoginToYourDashBoard button",
  "keyword": "And "
});
formatter.step({
  "line": 49,
  "name": "I wait for page to load",
  "keyword": "And "
});
formatter.step({
  "line": 50,
  "name": "Ill see the SEO00_Dashboard page",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "I click the SEO01_UserAvatar button",
  "keyword": "When "
});
formatter.step({
  "line": 52,
  "name": "I click the SEO01_ManageUsers list",
  "keyword": "And "
});
formatter.step({
  "line": 53,
  "name": "Ill be able to see the SEO22_ManageUsers Page",
  "keyword": "Then "
});
formatter.step({
  "line": 54,
  "name": "I click the SEO22_AddNewUser button",
  "keyword": "When "
});
formatter.step({
  "line": 55,
  "name": "I populate SEO22_EmailAddress textfield with ClientTS02@gmail.com",
  "matchedColumns": [
    4
  ],
  "keyword": "And "
});
formatter.step({
  "line": 56,
  "name": "I populate SEO22_Username textfield with ClientTS02",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 57,
  "name": "I select Client in SEO22_Role dropdown",
  "matchedColumns": [
    6
  ],
  "keyword": "And "
});
formatter.step({
  "line": 58,
  "name": "I populate SEO22_Password textfield with cli12345",
  "matchedColumns": [
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 59,
  "name": "I click the SEO22_Save button",
  "keyword": "And "
});
formatter.step({
  "line": 60,
  "name": "Ill see the SEO23_ProfileInformation header",
  "keyword": "Then "
});
formatter.match({
  "location": "SEO00_CommonSteps.im_a_new_Partner()"
});
formatter.result({
  "duration": 799356,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Login",
      "offset": 15
    }
  ],
  "location": "CommonSteps.i_navigate_to_URL_variable(String)"
});
formatter.result({
  "duration": 10670834286,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lorraine@truelogic.com.ph",
      "offset": 49
    }
  ],
  "location": "SEO06_Login.i_enter_email_value_in_emailaddress_field(String)"
});
formatter.result({
  "duration": 68767269,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "123456789",
      "offset": 45
    }
  ],
  "location": "SEO06_Login.i_enter_password_value_in_password_field(String)"
});
formatter.result({
  "duration": 49009030,
  "status": "passed"
});
formatter.match({
  "location": "SEO06_Login.i_click_the_login_to_your_dashboard_button()"
});
formatter.result({
  "duration": 3047641642,
  "status": "passed"
});
formatter.match({
  "location": "CommonSteps.i_wait_for_page_to_load()"
});
formatter.result({
  "duration": 7532970,
  "status": "passed"
});
formatter.match({
  "location": "SEO00_CommonSteps.ill_see_the_dashboard_page()"
});
formatter.result({
  "duration": 5431401084,
  "status": "passed"
});
formatter.match({
  "location": "SEO01_Home.i_click_user_avatar()"
});
formatter.result({
  "duration": 46897803,
  "status": "passed"
});
formatter.match({
  "location": "SEO01_Home.i_click_the_manage_users()"
});
formatter.result({
  "duration": 57165035,
  "status": "passed"
});
formatter.match({
  "location": "SEO22_SettingsUsers.ill_see_manage_users_page()"
});
formatter.result({
  "duration": 7065136494,
  "status": "passed"
});
formatter.match({
  "location": "SEO22_SettingsUsers.i_click_add_new_user_button()"
});
formatter.result({
  "duration": 39061540,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ClientTS02@gmail.com",
      "offset": 45
    }
  ],
  "location": "SEO22_SettingsUsers.i_populate_email_address_textfield_with_value(String)"
});
formatter.result({
  "duration": 313904432,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ClientTS02",
      "offset": 41
    }
  ],
  "location": "SEO22_SettingsUsers.i_populate_username_textfield_with_value(String)"
});
formatter.result({
  "duration": 104683303,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Client",
      "offset": 9
    }
  ],
  "location": "SEO22_SettingsUsers.i_select_role_value_under_role_dropwdown(String)"
});
formatter.result({
  "duration": 170614014,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "cli12345",
      "offset": 41
    }
  ],
  "location": "SEO22_SettingsUsers.i_populate_password_textfield_with_value(String)"
});
formatter.result({
  "duration": 3047382557,
  "status": "passed"
});
formatter.match({
  "location": "SEO22_SettingsUsers.i_click_save_button()"
});
formatter.result({
  "duration": 44094144,
  "status": "passed"
});
formatter.match({
  "location": "SEO23_SettingsUsersUserId.ill_see_profile_information_header()"
});
formatter.result({
  "duration": 2756381357,
  "status": "passed"
});
formatter.after({
  "duration": 16181263702,
  "status": "passed"
});
});