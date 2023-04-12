package org.example.service;

import org.example.dto.response.DepartmentDTO;
import org.example.entity.Department;
import org.example.repo.DepartmentRepo;
import org.example.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
//		departmentRepo.findAll().stream().forEach(e-> {System.out.println(e.getDepartmentName()+","+e.getId());
//			System.out.println(e.getStudentsSet());
//		});
		return util.mapDepartmentToDepartmentDTOList(departmentRepo.findAll());

	}
}
