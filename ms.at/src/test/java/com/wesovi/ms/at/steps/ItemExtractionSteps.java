package com.wesovi.ms.at.steps;

import java.util.List;

import junit.framework.Assert;

import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.core.IsEqual;
import org.omg.CosNaming.IstringHelper;

import com.wesovi.ms.at.model.Item;
import com.wesovi.ms.at.restclient.ExtractionServiceClient;
import com.wesovi.ms.at.util.CucumberStore;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.StepDefAnnotation;

@StepDefAnnotation
public class ItemExtractionSteps {

	private static CucumberStore cucumberStore = CucumberStore.getInstance();
	
	private static ExtractionServiceClient restClient = ExtractionServiceClient.getInstance();
	
	private static final String ITEMS_KEY = "at.items.key";
	
	@When("^we ask for the list of items$")
	public void we_ask_for_the_list_of_items() throws Throwable {
		List<Item> items = restClient.getItems();
	    cucumberStore.store(ITEMS_KEY,items);
	}

	@Then("^we obtain no items$")
	public void we_obtain_no_items() throws Throwable {
		@SuppressWarnings("unchecked")
		List<Item> items = cucumberStore.get(ITEMS_KEY,List.class);
		Assert.assertEquals(0,items.size());
	}
	
	@Then("^we obtain '(\\d+)' items$")
	public void we_obtain_items(int numberOfElements) throws Throwable {
		List<Item> items = cucumberStore.get(ITEMS_KEY,List.class);
		Assert.assertEquals(numberOfElements,items.size());
	}
	
	@Then("^we obtain '(\\d+)' item$")
	public void we_obtain_item(int numberOfElements) throws Throwable {
		List<Item> items = cucumberStore.get(ITEMS_KEY,List.class);
		Assert.assertEquals(numberOfElements,items.size());
	}
}
