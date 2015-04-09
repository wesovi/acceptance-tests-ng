package com.wesovi.blog.ms.extraction.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.wesovi.blog.ms.extraction.application.model.Item;


public interface ItemRepository extends CrudRepository<Item,Long>{

}
