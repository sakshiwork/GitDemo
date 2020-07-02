Feature: Login In the Application

Scenario Outline: Positive Testcases for login
Given Initializing the browser
Given Navigate to "https://www.linkedin.com/home" site
Given Click on Signin on the home page
When User enter <Username> and <Password> and logsIn
Then Verify it's loggedIn

Examples:
|Username					|Password	|
|sakshisri.1195@gmail.com	|9455614136	|

