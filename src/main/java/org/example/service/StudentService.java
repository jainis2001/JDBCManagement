package org.example.service;


import org.example.dto.StudentDTO;
import org.example.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
	boolean addStudent(StudentDTO studentDTO);



}
