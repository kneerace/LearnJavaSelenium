@All
Feature: Access http://newtours.demoaut.com/ and validate Sign Up availability via Chrome web-Browser
As a user, User should be able to access newtours site mentioned above, and validate presence of Username and Password label
as well as input box for those respectively.

@Smoke @Regression
Scenario: 1. Validate site access
Given User log into newtours site "http://newtours.demoaut.com/"
When User lands into homepage  
Then User should see "Welcome: Mercury Tours" page title
And User exit the browser

@Smoke @feature1
Scenario: 2. Validate User name label and input box
Given User log into newtours site "http://newtours.demoaut.com/"
When User lands into homepage
Then User checks Username label is present 
And User checks input box for Username is present
And User exit the browser

@Smoke @Regression @feature1
Scenario: 3. Validate User password label and input box
Given User log into newtours site "http://newtours.demoaut.com/"
When User lands into homepage
Then User checks Password label is present
And User checks input box for password tab is present
And User exit the browser

@Smoke @Regression @feature2
Scenario: 4. Validate user able to type in input box for UserName and Password
Given User log into newtours site "http://newtours.demoaut.com/"
When User enters UserName
And User enters Password
Then User checks UserName is present
And User checks Password is present
But User Password should be masked
Then User exit the browser
