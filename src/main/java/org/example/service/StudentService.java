package org.example.service;


import org.example.dto.StudentDTO;

import java.util.List;

public interface StudentService {
	boolean insertStudent(StudentDTO studentModel);
	StudentDTO getRecordById(String studentId);
	String isStudentExist(StudentDTO studentDTO);
	String isStudentExistForEdit(StudentDTO studentDTO);
	boolean deleteStudent(String email);

	List<StudentDTO> viewStudents();

	boolean updateStudent(StudentDTO studentDTO);
}
