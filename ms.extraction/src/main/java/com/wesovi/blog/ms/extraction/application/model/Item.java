package com.wesovi.blog.ms.extraction.application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@Column(length=50)
	private String name;
	
	@Column(length=200)
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date creationDate;
}
