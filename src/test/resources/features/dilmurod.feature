Feature: Verify Credit Report page options 

Background: 
	Given The User is on the homepage 
	When The user inputs "bsmith@gmail.com" for email address and "bsmith123" for password 
	And The user clicks on login button 
	And The user clicks on Mortgage Application and lands on "PREAPPROVAL DETAILS" tab 
	And The user enters preapproval details info, clicks on Next button and lands on "PERSONAL INFORMATION" tab 
	And The user enters personal info, clicks on Next button and lands on "EXPENSES" tab 
	And The user enters expenses info, clicks on Next button and lands on "EMPLOYMENT AND INCOME" tab 
	And The user enters employment info and clicks on Next button 
	Then The user lands on "CREDIT REPORT" tab 
	

@dilmuRod @smoke 
Scenario: Verify the Credit tab option NO 
	When user clicks on NO option for order credit report and clicks on NEXT button
	Then The user lands on ECONSENT tab 
	
@dilmuRod @smoke
Scenario: Verify the Credit tab option YES
	When The user is on CREDIT REPORT tab 
	Then The user clicks on YES option for credit report and clicks on NEXT button
	Then The user lands on ECONSENT tab 

@dilmuRod @smoke @test
Scenario: Need to verify the required fields pop-up when they are not filled-out
	When The user is on ECONSENT tab 
	Then The user leaves required fields blank and clicks on NEXT button
	Then The user sees the "THIS FIELD IS REQUIRED." are empty and displaying appropriate message;
	
#@dilmuRod @smoke @negative @bugFyi
Scenario: Need to verify that required fields will accept inappropriate values
	When The user is on ECONSENT tab 
	And  The input information should be the following using custom type
           |          FIRST NAME      | LAST NAME     | EMAIL 		| 
           |  Kevin                	  | Lee    	  	  |   1@1      	|
           |  @1234                	  | 127&  	  	  |   1@com     |
           |  Первый             	  | Второй    	  |   12@1      |   	          
                      
    And The user selects "don't agree" and click on next button   
	Then The application goes to next SUMMARY page

	
	
  