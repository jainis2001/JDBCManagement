package org.example.controller;


import org.example.dto.StudentDTO;
import org.example.entity.Address;
import org.example.entity.Student;
import org.example.service.StudentService;
import org.example.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentInfo {
	@Autowired
	private StudentService studentService;

//	@Autowired
	Address address;


	@GetMapping("")
	public List<StudentDTO> getStudents(){
		return studentService.viewStudents();
	}
	@GetMapping("/{id}")
	public StudentDTO getStudentById(@PathVariable String id){
		return studentService.getRecordById(id);
	}

	@PostMapping("/create")
	public String createStudent(@RequestBody StudentDTO studentDTO){
		studentDTO.setStudentId(new Util().createId());
		if(studentService.isStudentExist(studentDTO,false)==null) {
			return studentService.insertStudent(studentDTO)?"Inserted Successfully!":"Could not Inserted!";
		} else{
			return "Student already there";
		}

	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable String id){
			return studentService.deleteStudent(id)?"Deleted Successfully!":"Could not Deleted!";

	}





}
