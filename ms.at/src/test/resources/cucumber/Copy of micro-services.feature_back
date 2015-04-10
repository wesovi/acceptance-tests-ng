Feature: Micro Services Acceptance Tests


	Scenario: Getting the list of items when the database is empty
		Given a database with no items 
		When we ask for the list of items
		Then we obtain no items
		
	Scenario: Getting the list of items when the database already contains items.
		Given the items database is initilized with the folloing data
			| name 		| description		|
			| item001	| Bargains			|
			| item002	| Promotions		|
			| item003	| Exclusive			|
			| item004	| Out of date		|
		When we ask for the list of items
		Then we obtain '4' items
		
	Scenario: We add new items to an empty database
		Given a database with no items
		When we add the below item 
			| name 		| description		|
			| item001	| Bargains			|
		And we ask for the list of items
		Then we obtain '1' item
		
	Scenario: We add new items to an empty database
		Given the items database is initilized with the folloing data
			| name 		| description		|
			| item001	| Bargains			|
			| item002	| Promotions		|
			| item003	| Exclusive			|
		When we add the below item 
			| name 		| description		|
			| item004	| Out of date		|
		And we ask for the list of items
		Then we obtain '4' item
			
			
			
			 

