Feature: Access http://newtours.demoaut.com/ and validate Sign Up availability
As a user, User should be able to access newtours site mentioned above, and validate presence of Username and Password label
as well as input box for those respectively.

Scenario: Validate site access
Given User log into newtours site "http://newtours.demoaut.com/"
When User lands into homepage  
Then User should see "Mercury Tours" logo
And User exit the browser

Scenario: Validate User name label and input box
Given User log into newtours site "http://newtours.demoaut.com/"
When User lands into homepage
Then User checks Username label is present 
And User checks input box for Username is present
And User exit the browser

Scenario: Validate User password label and input box
Given User log into newtours site "http://newtours.demoaut.com/"
When User lands into homepage
Then User checks Password label is present 
And User checks input box for password tab is present
And User exit the browser

Scenario: Validate user able to type in input box for UserName and Password
Given User log into newtours site "http://newtours.demoaut.com/"
When User enters UserName
And User enters Password
Then User checks user UserName is present
And User checks user Password is present
But User Password should be masked
And User exit the browser
