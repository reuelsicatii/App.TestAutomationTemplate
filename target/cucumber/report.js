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
      "line": 5,
      "value": "#Scenario Description:"
    },
    {
      "line": 6,
      "value": "#Given I am a Partner"
    },
    {
      "line": 7,
      "value": "#When I navigate to the Manage Users Page"
    },
    {
      "line": 8,
      "value": "#And I click the Add New User button"
    },
    {
      "line": 9,
      "value": "#Then Ill see the Add New User Modal"
    },
    {
      "line": 10,
      "value": "#And Ill see that the UI of Add New User Modal is aligned with the requirements"
    }
  ],
  "line": 12,
  "name": "TAA-535",
  "description": "",
  "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;taa-535",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@SRSSMOKETEST"
    },
    {
      "line": 11,
      "name": "@ManageUsers"
    },
    {
      "line": 11,
      "name": "@ManageUsers_TS01"
    },
    {
      "line": 11,
      "name": "@TAA-535"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "Im a new Partner",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I navigate to \"Login\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I populate the SEOE6_EmailAddress textfield with \u003cemail\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I populate the SEOE6_Password textfield with \u003cpassword\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I click the SEO06_LoginToYourDashBoard button",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I wait for page to load",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Ill see the SEO00_Dashboard page",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I click the SEO01_UserAvatar button",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "I click the SEO01_ManageUsers list",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Ill be able to see the SEO22_ManageUsers Page",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "I click the SEO22_AddNewUser button",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "Ill see the SEO22_AddNewUser Modal",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Ill see the SEO22_EmailAddress textfield",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "Ill see the SEO22_Username textfield",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Ill see the SEO22_Role dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Ill see the SEO22_Password textfield",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "Ill see that the Password textfield contains a SEO22_Toggle icon",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Ill see the SEO22_Save button",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Ill see the SEO22_Close button",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "Ill see the SEO22_Xclose button of Add New User Modal",
  "keyword": "And "
});
formatter.examples({
  "line": 36,
  "name": "",
  "description": "",
  "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;taa-535;",
  "rows": [
    {
      "cells": [
        "FirstName",
        "LastName",
        "email",
        "password"
      ],
      "line": 37,
      "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;taa-535;;1"
    },
    {
      "cells": [
        "RND",
        "Automation",
        "lorraine@truelogic.com.ph",
        "123456789"
      ],
      "line": 38,
      "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;taa-535;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 22731657579,
  "status": "passed"
});
formatter.before({
  "duration": 9253,
  "status": "passed"
});
formatter.before({
  "duration": 8225,
  "status": "passed"
});
formatter.scenario({
  "line": 38,
  "name": "TAA-535",
  "description": "",
  "id": "[taa-519]-[seoreseller]-manage-users-menu-smoke/regression-testsuite;taa-535;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@ManageUsers_TS01"
    },
    {
      "line": 11,
      "name": "@TAA-535"
    },
    {
      "line": 11,
      "name": "@ManageUsers"
    },
    {
      "line": 11,
      "name": "@SRSSMOKETEST"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "Im a new Partner",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I navigate to \"Login\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I populate the SEOE6_EmailAddress textfield with lorraine@truelogic.com.ph",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I populate the SEOE6_Password textfield with 123456789",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "I click the SEO06_LoginToYourDashBoard button",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I wait for page to load",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Ill see the SEO00_Dashboard page",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "I click the SEO01_UserAvatar button",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "I click the SEO01_ManageUsers list",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Ill be able to see the SEO22_ManageUsers Page",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "I click the SEO22_AddNewUser button",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "Ill see the SEO22_AddNewUser Modal",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Ill see the SEO22_EmailAddress textfield",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "Ill see the SEO22_Username textfield",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Ill see the SEO22_Role dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Ill see the SEO22_Password textfield",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "Ill see that the Password textfield contains a SEO22_Toggle icon",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Ill see the SEO22_Save button",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Ill see the SEO22_Close button",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "Ill see the SEO22_Xclose button of Add New User Modal",
  "keyword": "And "
});
formatter.match({
  "location": "SEO00_CommonSteps.im_a_new_Partner()"
});
formatter.result({
  "duration": 253096546,
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
  "duration": 13062297429,
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
  "duration": 286846898,
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
  "duration": 52035328,
  "status": "passed"
});
formatter.match({
  "location": "SEO06_Login.i_click_the_login_to_your_dashboard_button()"
});
formatter.result({
  "duration": 3084106774,
  "status": "passed"
});
formatter.match({
  "location": "CommonSteps.i_wait_for_page_to_load()"
});
formatter.result({
  "duration": 70758279,
  "status": "passed"
});
formatter.match({
  "location": "SEO00_CommonSteps.ill_see_the_dashboard_page()"
});
});