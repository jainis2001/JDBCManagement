package org.example.service;

import org.example.entity.Department;
import org.example.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo departmentRepo;
	public Department addDepartment(Department department){
		Department existDepartment=departmentRepo.findByDepartmentName(department.getDepartmentName().toLowerCase());
		return (existDepartment==null)? departmentRepo.save(department) : existDepartment;
	}
}
