package com.wesovi.blog.ms.extraction.application.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.wesovi.blog.ms.extraction.application.model.Item;
import com.wesovi.blog.ms.extraction.application.repository.ItemRepository;
import com.wesovi.blog.ms.extraction.application.util.exception.ItemsNotFoundException;
import com.wesovi.blog.ms.extraction.web.domain.ItemResponse;

@Service
public class ItemServiceImpl implements ItemService{

	private final ItemRepository itemRepository;
	
	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public List<ItemResponse> getItems() {
	  Collection<Item> items = (Collection<Item>) this.itemRepository.findAll();
	  asssertNotEmpty(items);
	  return createItemResponseList(items);
	}
	
	private void asssertNotEmpty(Collection<?> items){
		 if(CollectionUtils.isEmpty(items)){
			  throw new ItemsNotFoundException();
		  }
	}
	
	private List<ItemResponse> createItemResponseList(Collection<Item> items){
		List<ItemResponse> itemResponseList= new ArrayList<>();
		for(Item item : items){
			itemResponseList.add(fromItem(item));
		}
		return itemResponseList;
	}

	private ItemResponse fromItem(Item item){
		ItemResponse itemResponse = new ItemResponse();
		itemResponse.setCreationDate(Calendar.getInstance().getTime());
		itemResponse.setName(item.getName());
		itemResponse.setDescription(item.getDescription());
		itemResponse.setId(item.getId());
		return itemResponse;
	}

}
