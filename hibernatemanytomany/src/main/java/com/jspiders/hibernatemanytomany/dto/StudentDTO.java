package com.jspiders.hibernatemanytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table (name ="Student")
public class StudentDTO {

	@Id
	private int id;
	private String name;
	private String email;
	private String address;
	@ManyToMany
	List<SubjectDTO> subjects;
}
