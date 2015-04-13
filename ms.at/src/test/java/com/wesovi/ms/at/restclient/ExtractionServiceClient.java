package com.wesovi.ms.at.restclient;

import java.util.ArrayList;
import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.wesovi.ms.at.model.Item;
import com.wesovi.ms.at.util.ConfigurationProperties;

import javax.ws.rs.core.MediaType;

public class ExtractionServiceClient {
	
	private static ExtractionServiceClient instance = null;
	
	private static ConfigurationProperties configurationProperties = ConfigurationProperties.getInstance();
	
	private static String host = configurationProperties.getProperty("ms.extraction.host",String.class);
	
	private static String port = configurationProperties.getProperty("ms.extraction.port",String.class);;
	
	private WebResource webResource= null;
	
	private ExtractionServiceClient(){
		Client client = Client.create();
		webResource = client.resource(serverPath());
	}
	
	public static ExtractionServiceClient getInstance(){
		if(instance==null){
			instance = new ExtractionServiceClient();
		}
		return instance;
	}
	
	public List<Item> getItems(){
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		return evaluateClientResponse(response);	
	}
	
	private List<Item> evaluateClientResponse(ClientResponse response){
		List<Item> items = new ArrayList<Item>();
		if (response.getStatus() == ClientResponse.Status.NOT_FOUND.getStatusCode()) {
			return items;
		}
		return null;
	}
	
	private String serverPath(){
		return "http://"+host+":"+port+"/";
	}
}
