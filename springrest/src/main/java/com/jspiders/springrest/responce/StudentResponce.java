package com.jspiders.springrest.responce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.springrest.pojo.StudentPojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude (JsonInclude.Include.NON_NULL)
@Data
public class StudentResponce {

	private String message;
	private StudentPojo data;
	private List<StudentPojo> list;
	
}
