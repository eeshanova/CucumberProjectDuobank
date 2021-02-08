Feature: Verification of Sign Up Website Duobank 

@kate @parallel
Scenario: Verify response when Sign Up with positive information 
	Given The User is on the Sign Up page 
	When The user add all required information 
	And The user clicks on Sign Up 
	Then The user should receive  message "Welcome Back, Automation Testers!" 
	
	
@kate @parallel
Scenario: Verify response when Sign Up with negative information 
	Given The User is on the Sign Up page 
	When The user add negative information 
	And The user clicks on Sign Up 
	Then The user should not be able to Sign Up and shoul receive error message "Correct your information" 
	
@kate @regression
Scenario: Verify response when Sign Up with different language information 
	Given The User is on the Sign Up page 
	When The user add russ. language information 
	And The user clicks on Sign Up 
	Then The user should not be able to Sign Up and shoul receive error message "Correct your information" 
	
@kate @smoke
Scenario: Verify account name after Sign In 
	Given The User is on the Sign in page 
	When The user land on Accound page 
	Then The name of acount nedd to be "Katya Katya" 
	
@kate @smoke
Scenario Outline: Verify multiple positive user preapproval details 

	Given The User is on the preapproval details tab 
	When The users click on all needed checkboxes 
	And The user enters "<ESTIMATED PURCHASE PRICE>" , "<DOWN PAYMENT PERCENTAGE>" 
	Then The user should be able to click on Next Button 
	
	Examples: 
		|ESTIMATED PURCHASE PRICE | DOWN PAYMENT PERCENTAGE | 
		|300000                   |30                       |
		|200000                   |20                       |
		|100000                   |10                       |
		
		
@kate @regression
Scenario Outline: Verify multiple negative user preapproval details 
		
			Given The User is on the preapproval details tab 
			When The users click on all needed checkboxes 
			And The user enters "<ESTIMATED PURCHASE PRICE>" , "<DOWN PAYMENT PERCENTAGE>" 
			And Then user change ESTIMATED PURCHASE PRICE to negative information 
			Then The user should be not able to click on Next Button 
			
			Examples: 
				|ESTIMATED PURCHASE PRICE | DOWN PAYMENT PERCENTAGE | 
				|1000                     |99                       |
				|1000                     |88                       |
				|1000                     |77                       |
				
				
	  