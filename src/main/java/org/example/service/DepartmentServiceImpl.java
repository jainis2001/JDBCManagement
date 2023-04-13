package org.example.service;

import org.example.dto.response.DepartmentDTO;
import org.example.entity.Department;
import org.example.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private Mapper mapper;
	public Department addDepartment(String departmentName){
		Department department=mapper.mapToDepartmentEntity(departmentName);
		Department existDepartment=departmentRepo.findByDepartmentName(departmentName.toLowerCase());
		return (existDepartment==null)? departmentRepo.save(department) : existDepartment;
	}

	public List<DepartmentDTO> getStudentsByDepartement(){
		return mapper.mapDepartmentToDepartmentDTOList(departmentRepo.findAll());
	}

	public DepartmentDTO getStudentsByDepartementId(String id){

		return departmentRepo.findById(id).map(value -> mapper.mapDepartmentToDepartmentDTO(value)).orElse(null);
	}

}
