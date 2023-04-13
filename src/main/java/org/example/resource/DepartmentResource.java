package org.example.resource;

import org.example.dto.response.DepartmentDTO;
import org.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentResource {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public List<DepartmentDTO> getStudentsByDepartment(){
		return departmentService.getStudentsByDepartement();
	}

	@GetMapping("/{id}")
	public DepartmentDTO getStudentsByDepartmentId(@PathVariable("id") String id){
		return departmentService.getStudentsByDepartementId(id);
	}


}
