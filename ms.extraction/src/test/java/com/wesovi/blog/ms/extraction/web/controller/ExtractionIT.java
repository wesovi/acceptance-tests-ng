package com.wesovi.blog.ms.extraction.web.controller;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Collection;

import org.apache.http.entity.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;
import com.wesovi.blog.ms.extraction.MicroServiceApplication;
import com.wesovi.blog.ms.extraction.application.model.Item;
import com.wesovi.blog.ms.extraction.application.repository.ItemRepository;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroServiceApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ExtractionIT {

	@Autowired
	private ItemRepository itemRepository;

	@Value("${local.server.port}")
	private int serverPort;

	private Item createItem(String name,String description){
		Item item = new Item();
		item.setName(name);
		item.setDescription(description);
		return item;
	}
	
	@Before
	public void setUp() {
		this.itemRepository.deleteAll();
		Item bargain = createItem("item001","Bargain");
		Item promotion = createItem("item002","promotion");
		this.itemRepository.save(bargain);
		this.itemRepository.save(promotion);
		RestAssured.port = serverPort;
	}

	@Test
	public void getListOfItems(){
		when()
			.get("/")
		.then()
			.statusCode(HttpStatus.FOUND.value())
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.body("",hasSize(2));
	}
	
	@Test
	public void testWhenThereAreNotItemsInToTheDatabase(){
		this.itemRepository.deleteAll();
		when()
			.get("/")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
}
