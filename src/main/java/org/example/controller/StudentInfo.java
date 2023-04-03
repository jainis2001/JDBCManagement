package org.example.controller;


import org.example.dto.StudentDTO;
import org.example.entity.Address;
import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentInfo {
	@Autowired
	private StudentService studentService;
	String firstName,lastName,email,gender,studentId;
	Long mobile;
	int age;
	StudentDTO studentDTO;
//	@Autowired
	Address address;

	@GetMapping("")
	public List<StudentDTO> getStudents(){
		return studentService.viewStudents();
	}





}
