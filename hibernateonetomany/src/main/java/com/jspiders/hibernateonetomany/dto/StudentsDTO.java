package com.jspiders.hibernateonetomany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class StudentsDTO {

	@Id
	private int id;
	private String name;
	private long contact;
	private String address;
	private String email;
}
