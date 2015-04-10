Feature: Micro Services Acceptance Tests


	Scenario: Getting the list of items when the database is empty
		Given a database with no items 
		When we ask for the list of items
		Then we obtain no items
		
	
			
			
			 

