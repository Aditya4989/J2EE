package com.jspiders.hibernatemanytoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class PeopleDTO {

	@Id
	private int id;
	private String name;
	private long contact;
	private int age;
	@ManyToOne
	private VillageDTO village;
}
