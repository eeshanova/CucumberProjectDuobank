Feature: Employment and Income Tab 


Background: 
	Given The User is on the homepage 
	When The User inputs "bsmith@gmail.com" for email address and "bsmith123" for password 
	And The User clicks on login button 
	And The User clicks on Mortgage Application and lands on "PREAPPROVAL DETAILS" tab 
	And The User enters preapproval details info, clicks on Next button and lands on "PERSONAL INFORMATION" tab 
	And The User fills out personal info, clicks on Next button and lands on "EXPENSES" tab 
	And The User enters expenses info and clicks on Next button 
	Then The User lands on "EMPLOYMENT AND INCOME" tab 
	
@katerina @smoke
Scenario: Verify the employment and income tab using Pojo 
	When the User inputs the following data and clicks on Next button 
		|employer	  |position	             |city	        |state	  |startDate  |monthlyIncome|
		|Yamia        |Programmer Analyst II |Atlanta       |GA       |07/03/2002 |14652.10     |
		#	|Thoughtstorm |Statistician III      |Sioux Falls   |SD       |04/05/1973 |15459.25     | 
		#	|Voonder  	  |Project Manager       |Louisville    |KY       |09/04/2002 |20720.08     | 
		#	|Cogilith     |Social Worker         |Philadelphia  |PA       |10/02/2009 |7562.50      | 
		#	|Edgepulse    |Sales Associate       |Las Vegas     |NV       |07/24/1992 |24445.74     | 
		#	|Vipe         |Tax Accountant        |Oklahoma City |OK       |11/15/2012 |16838.84     |
		#	|Chatterpoint |Senior Sales Associate|Louisville    |KY       |10/19/1989 |10107.74     | 
		
		
	Then The User lands on Credit Report tab 
	
@katerina @regression
Scenario: Verify the list of States using Excel file 

	Then The list of dropdown values for state should be the same as in Excel file 
	
@katerina	@parallel
Scenario: Verify Income Source options 

	Then The list of dropdown values for income source should be the following 
	
		|Alimony/Child Support 				|
		|Social Security/Disability Income  |
		|Other Types of Income 				|

		
@katerina @regression	
Scenario: Verify Add Another Employer button 
	When the User clicks on Add Another Employer button and enters the following info 
		|employer	  |position	             |city	        |startDate  | endDate	|
		|Thoughtstorm |Statistician III      |Sioux Falls   |04/05/1973 | 01/01/1985|	
		
	Then the User clicks on Clear button and Remove button and gets a confirmation message 
	
@katerina @temp @parallel
Scenario: Verify the user is able to input the info in all fields 
	When the User enter the following info and clicks on Next Button 
		|employer	  |position	             |city	        |startDate  |monthlyIncome| monthlyOvertime | monthlyBonus | monthlyComm | monthlyDiv | incomeSource 			| amount |
		|Voonder  	  |Project Manager       |Louisville    |09/04/2002 |20720.08     | 500				| 1000	       | 350	     | 870		  |Other Types of Income   | 200   |
		
		
	Then The User lands on Credit Report tab 
	
	
	