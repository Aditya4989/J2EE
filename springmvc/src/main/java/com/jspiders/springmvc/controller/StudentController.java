package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.pojo.StudentPojo;
import com.jspiders.springmvc.service.StudentService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

//Home Page:-
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "please Login first. ");
		return "Login";
	}

//Add Student:-
	// add Form Controller
	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "AddStudent";
		}
		map.addAttribute("msg", "please Login first. ");
		return "Login";
	}

	// Add Data Controller
	@PostMapping("/add")
	public String addStudent(@RequestParam String name, @RequestParam String email, @RequestParam long mobile,
			@RequestParam String address, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			StudentPojo pojo = service.addStudent(name, email, mobile, address);
			// Success
			if (pojo != null) {
				map.addAttribute("msg", "Data inserted successfully. ");
				return "AddStudent";
			}
			// Failure
			map.addAttribute("msg", "Data not inserted. ");
			return "AddStudent";
		}
		map.addAttribute("msg", "please Login first. ");
		return "Login";
	}

//Search Student:-
	// Search Page Controller
	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "SearchStudent";
		}
		map.addAttribute("msg", "please Login first. ");
		return "Login";
	}

	// Search Data Controller
	@PostMapping("/search")
	public String searchStudent(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			StudentPojo pojo = service.searchStudent(id);

			// Success
			if (pojo != null) {
				map.addAttribute("student", pojo);
				map.addAttribute("msg", "data found successfully");
				return "SearchStudent";
			}
			// Failure
			map.addAttribute("msg", "Student Data does not exists");
			return "SearchStudent";
		}
		map.addAttribute("msg", "please Login first. ");
		return "Login";
	}

//Update Student:-
	// Update Page Controller
	@GetMapping("/update")
	public String updatePage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			List<StudentPojo> students = service.allStudents();
			map.addAttribute("students", students);
			return "UpdateStudent";
		}
		map.addAttribute("msg", "please Login first. ");
		return "Login";
	}

	// Update View Controller
	@PostMapping("/update")
	public String updateForm(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			StudentPojo pojo = service.searchStudent(id);
			// Success
			if (pojo != null) {
				map.addAttribute("student", pojo);
				return "UpdateStudent";
			}
			// Failure
			map.addAttribute("msg", "Student data does not exist. ");
			List<StudentPojo> students = service.allStudents();
			map.addAttribute("students", students);
			return "UpdateStudent";
		}
		map.addAttribute("msg", "please Login first. ");
		return "Login";
	}

	// Update Data Controller
	@PostMapping("/updateData")
	public String update(@RequestParam int id, @RequestParam String name, @RequestParam String email,
			@RequestParam long mobile, @RequestParam String address, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			StudentPojo pojo = service.updateStudent(id, name, email, mobile, address);
			// Success
			if (pojo != null) {
				map.addAttribute("msg", "Student data updated. ");
				List<StudentPojo> students = service.allStudents();
				map.addAttribute("students", students);
				return "UpdateStudent";
			}
			// Failure
			map.addAttribute("msg", "Student data not updated. ");
			List<StudentPojo> students = service.allStudents();
			map.addAttribute("students", students);
			return "UpdateStudent";
		}
		map.addAttribute("msg", "please Login first. ");
		return "Login";
	}

// Remove page controller
	// Remove Page Controller
	@GetMapping("/remove")
	public String removePage(ModelMap map, @SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			List<StudentPojo> students = service.allStudents();
			map.addAttribute("students", students);
			return "RemoveStudent";
		}
		map.addAttribute("msg", "please Login first. ");
		return "Login";
	}

	// Remove data controller
	@PostMapping("/remove")
	public String removeStudent(@RequestParam int id, ModelMap map,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin) {
		if (admin != null) {
			StudentPojo pojo = service.removeStudent(id);
			// Success
			if (pojo != null) {
				List<StudentPojo> students = service.allStudents();
				map.addAttribute("students", students);
				map.addAttribute("msg", "Student data removed successfully. ");
				return "RemoveStudent";
			}
			// Failure
			List<StudentPojo> students = service.allStudents();
			map.addAttribute("students", students);
			map.addAttribute("msg", "Student data does not exist. ");
			return "RemoveStudent";
		}
		map.addAttribute("msg", "please Login first. ");
		return "Login";
	}
}
