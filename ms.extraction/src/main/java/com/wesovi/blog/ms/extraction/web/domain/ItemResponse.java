package com.wesovi.blog.ms.extraction.web.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemResponse {

	private Long id;
		
	private String name;
	
	private String description;
	
	private Date creationDate;
}
