package com.jspiders.springmvc.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="Stud_details")
public class StudentPojo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "stud_id")
	private int id;
	@Column(name = "stud_name")
	private String name;
	@Column(name = "stud_email")
	private String email;
	@Column(name = "stud_contact")
	private long mobile;
	@Column(name = "stud_address")
	private String address;
}
