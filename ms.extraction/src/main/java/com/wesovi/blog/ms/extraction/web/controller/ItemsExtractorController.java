package com.wesovi.blog.ms.extraction.web.controller;

import java.util.List;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wesovi.blog.ms.extraction.application.service.ItemService;
import com.wesovi.blog.ms.extraction.application.util.exception.ItemsNotFoundException;
import com.wesovi.blog.ms.extraction.web.domain.ItemResponse;
;

@Log4j
@RestController
public class ItemsExtractorController {


	private final ItemService itemService;
	
	@Autowired
	public ItemsExtractorController(ItemService itemService) {
		this.itemService =itemService;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value=HttpStatus.FOUND)
	public List<ItemResponse> execution(){
		return itemService.getItems();
	}
	
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Items not found")
    @ExceptionHandler(ItemsNotFoundException.class)
    public void handleItemsNotFoundException(){
        log.error("IOException handler executed");
    }
}
