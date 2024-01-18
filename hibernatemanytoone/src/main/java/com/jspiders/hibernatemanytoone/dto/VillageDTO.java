package com.jspiders.hibernatemanytoone.dto;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class VillageDTO {

	@Id
	private int id;
	private String name;
	private String location_city;
}
