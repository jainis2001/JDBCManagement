package org.example.service;

import org.example.dto.response.DepartmentDTO;
import org.example.entity.Department;

import java.util.List;

public interface DepartmentService {
	Department addDepartment(String departmentName);
	List<DepartmentDTO> getStudentsByDepartement();
	DepartmentDTO getStudentsByDepartementId(String id);
}
