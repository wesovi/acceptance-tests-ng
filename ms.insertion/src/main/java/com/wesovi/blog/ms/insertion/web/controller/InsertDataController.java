package com.wesovi.blog.ms.insertion.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wesovi.blog.ms.insertion.application.service.ItemService;
import com.wesovi.blog.ms.insertion.web.domain.ItemRequest;

@RestController
public class InsertDataController {
	
	private final ItemService itemService;
	
	@Autowired
	public InsertDataController(ItemService itemService) {
		this.itemService =itemService;
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void execution(@RequestBody ItemRequest request){
		itemService.insert(request);;
	}

}
