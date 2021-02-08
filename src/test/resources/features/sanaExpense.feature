Feature: Verification of Expense Tab
	

Scenario: Verify the user sees the Mortage Payment Field 
	Given The user logs in their account and fills out the first two tabs
	When The user lands on Expenses Tab
	Then The user clicks on the own check box
	Then The user can enter the correct payment amount
	
	

Scenario: Verify the user is unable to proceed if the payment amount is invalid
	Given The user logs in their account and fills out the first two tabs
	When The user lands on Expenses Tab
	Then The user clicks on the rent check box and enters invalid payment
	Then error message is dispalyed instructing the user to enter valid payment
	
	