Feature: Verification of Personal Information Tab


Scenario: Verify Co-Borrower input form appears when user clicks on Co-Borrower
	Given The user logs in their account and fills out the Preapproval Details
	When The user lands on Personal Information Tab
	Then The user checks the Co-Borrower box
	Then The Co-Borrower input form appears
	

Scenario: Verify the user is unable to proceed if form is not complete
	Given The user logs in their account and fills out the Preapproval Details
	When The user lands on Personal Information Tab
	Then The user skips all required input box and clicks next
	Then The error message is displayed
	


Scenario: Verify the user is unable to proceed if DOB is a future date
	Given The user logs in their account and fills out the Preapproval Details
	When The user lands on Personal Information Tab
	Then The user enters the following info and enters future DOB

| first   |    last   | email               |  dateOfBirth | SSN         | cellPhone     |
| teamb   |    Sana   | teambsana@gmail.com |  03/11/2021  | 487-55-8521 |  571-84-1200  |
	
	Then The error message is displayed to enter correct DOB
	
	

Scenario: Verify the user is unable to proceed if the SSN field contains alphabet 
	Given The user logs in their account and fills out the Preapproval Details
	When The user lands on Personal Information Tab
	Then The user enters the following info and enters invalid SSN
| first   |    last   | email               |  dateOfBirth | cellPhone     |
| Audrey  |  Hepburn  | a.hepburn@gmail.com |  05/04/1929  |  703-84-1590  |
	Then The error message is displayed to enter valid SSN
	
	

Scenario: Verify the user is unable to proceed if the name fields contains numbers
	Given The user logs in their account and fills out the Preapproval Details
	When The user lands on Personal Information Tab
	Then The user enters the following info and enters invalid name
| first   |    last   | email               |  dateOfBirth | SSN         | cellPhone     |
| 01234   |   567890  | a.hepburn@gmail.com |  05/04/1929  | 487-55-8521 |  571-84-1200  |
	Then The error message is displayed to enter valid name
	


Scenario: Verify the user is unable to proceed if the cell phone field contains alphabet
	Given The user logs in their account and fills out the Preapproval Details
	When The user lands on Personal Information Tab
	Then The user enters the following info and enters invalid cellphone number
| first   |    last   | email               |  dateOfBirth | SSN         |
| Audrey  |  Hepburn  | a.hepburn@gmail.com |  05/04/1929  | 487-55-8521 |
	Then The error message is displayed to enter valid cellphone number



Scenario: Verify the user is unable to proceed if the Policy button is unchecked
	Given The user logs in their account and fills out the Preapproval Details
	When The user lands on Personal Information Tab
	Then The user correctly enters the required info and unchecks the policy button
	Then error message is dispalyed instructing the user to accept the policy
	
	
	

Scenario: Verify the user lands on the Privacy Policy webpage
	Given The user logs in their account and fills out the Preapproval Details
	When The user lands on Personal Information Tab
	Then The user click on the Privacy Policy link
	Then The user is directed to the correct Privacy Policy webpage
	

	
	
	
	
	