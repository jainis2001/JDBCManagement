package org.example.resource;


import org.example.dto.StudentDTO;
import org.example.service.StudentService;
import org.example.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentResource {
	@Autowired
	private StudentService studentService;

	@PostMapping
	public String createStudent(@RequestBody StudentDTO studentDTO){
		return (studentService.addStudent(studentDTO))?"Inserted":"Could not inserted";

	}



}
