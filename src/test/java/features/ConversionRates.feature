Feature: Conversion Rates
Scenario: Get the conversion rate for the currency
Given set the endpoint
When get the response
Then print the conversion rate 
And verify the status code as 200