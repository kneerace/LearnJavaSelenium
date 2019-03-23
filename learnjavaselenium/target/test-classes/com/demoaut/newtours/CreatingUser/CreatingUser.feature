Feature: Access http://newtours.demoaut.com/ and validate Sign Up availability
As a user, we should be able to access the site mentioned above, and validate Sign Up functionality

Scenario: Validate site access
Given User has access to web-browser
When User enters site "http://newtours.demoaut.com/"
Then User should land to site homepage

Scenario: Validate User name and password tab
Given User logs into newtours site
When User lands into homepage
Then User checks Username tab is present 
And User checks password tab is present


