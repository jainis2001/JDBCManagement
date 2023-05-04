package org.example.service;


import org.example.dto.StudentDTO;
import org.example.entity.Student;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StudentService {
	boolean addStudent(StudentDTO studentDTO);
	List<StudentDTO> getStudents(Integer pageNumber,Integer pageSize,String sortBy);
	boolean deleteStudent(String id);
	StudentDTO updateStudent(StudentDTO studentDTO);
	StudentDTO getById(String id);

	List<StudentDTO> getStudentsBySearch(String value);

	MappingJacksonValue searchAndFilter(Map<String,String> query, Set<String> fields);



}
