package com.wesovi.ms.at.steps;

import com.wesovi.ms.at.util.CucumberStore;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class CommonSteps {
	private static CucumberStore cucumberStore = CucumberStore.getInstance();
	
	@Given("^a database with no items$")
	public void a_database_with_no_items() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
	
	@Given("^the items database is initilized with the folloing data$")
	public void the_items_database_is_initilized_with_the_folloing_data(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}
	
	

}
