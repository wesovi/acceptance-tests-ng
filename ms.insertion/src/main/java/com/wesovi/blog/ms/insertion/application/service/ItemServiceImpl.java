package com.wesovi.blog.ms.insertion.application.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesovi.blog.ms.insertion.application.model.Item;
import com.wesovi.blog.ms.insertion.application.repository.ItemRepository;
import com.wesovi.blog.ms.insertion.web.domain.ItemRequest;

@Service
public class ItemServiceImpl implements ItemService{

	private final ItemRepository itemRepository;
	
	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Override
	public void insert(ItemRequest itemRequest) {
		Item item = fromItemRequest(itemRequest);
		this.itemRepository.save(item);
	}
	
	private Item fromItemRequest(ItemRequest itemRequest){
		Item item = new Item();
		item.setCreationDate(Calendar.getInstance().getTime());
		item.setName(itemRequest.getName());
		item.setDescription(itemRequest.getDescription());
		return item;
	}

}
