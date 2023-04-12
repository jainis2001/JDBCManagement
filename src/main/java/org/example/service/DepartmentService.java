package org.example.service;

import org.example.dto.response.DepartmentDTO;
import org.example.entity.Department;
import org.example.repo.DepartmentRepo;
import org.example.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private Util util;
	public Department addDepartment(String departmentName){
		Department department=util.mapToDepartmentEntity(departmentName);
		Department existDepartment=departmentRepo.findByDepartmentName(departmentName.toLowerCase());
		return (existDepartment==null)? departmentRepo.save(department) : existDepartment;
	}

	public List<DepartmentDTO> getStudentsByDepartement(){
		return util.mapDepartmentToDepartmentDTOList(departmentRepo.findAll());
	}

	public DepartmentDTO getStudentsByDepartementId(String id){
		Optional<Department> department = departmentRepo.findById(id);
		return department.map(value -> util.mapDepartmentToDepartmentDTO(value)).orElse(null);
	}

}
