package com.wesovi.blog.ms.extraction.application.service;

import java.util.List;

import com.wesovi.blog.ms.extraction.web.domain.ItemResponse;



public interface ItemService {
	
	List<ItemResponse> getItems();
}
