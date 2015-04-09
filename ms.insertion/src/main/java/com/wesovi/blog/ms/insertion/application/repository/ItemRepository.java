package com.wesovi.blog.ms.insertion.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.wesovi.blog.ms.insertion.application.model.Item;


public interface ItemRepository extends CrudRepository<Item,Long>{

}
