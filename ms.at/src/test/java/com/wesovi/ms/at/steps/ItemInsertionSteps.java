package com.wesovi.ms.at.steps;

import com.wesovi.ms.at.util.CucumberStore;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class ItemInsertionSteps {

	private static CucumberStore cucumberStore = CucumberStore.getInstance();
	
	@When("^we add the below item$")
	public void we_add_the_below_item(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}
}
