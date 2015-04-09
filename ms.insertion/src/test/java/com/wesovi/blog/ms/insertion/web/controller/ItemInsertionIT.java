package com.wesovi.blog.ms.insertion.web.controller;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Collection;

import org.apache.http.entity.ContentType;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.wesovi.blog.ms.insertion.MicroServiceApplication;
import com.wesovi.blog.ms.insertion.application.model.Item;
import com.wesovi.blog.ms.insertion.application.repository.ItemRepository;
import com.wesovi.blog.ms.insertion.web.domain.ItemRequest;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroServiceApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ItemInsertionIT {

	@Autowired
	private ItemRepository itemRepository;

	@Value("${local.server.port}")
	private int serverPort;

	@Before
	public void setUp() {
		this.itemRepository.deleteAll();
		RestAssured.port = serverPort;
	}

	@Test
	public void addItemShouldReturnNotcontent(){
		ItemRequest request=  new ItemRequest();
		request.setName("item001");
		request.setDescription("Bargains");
		given()
			.contentType(ContentType.APPLICATION_JSON.toString())
			.body(request)
		.when()
			.post("/")
		.then()
			.statusCode(HttpStatus.NO_CONTENT.value());
		Collection<Item> items = (Collection<Item>) this.itemRepository.findAll();
		assertThat(items,IsCollectionWithSize.hasSize(1));
	}

}
