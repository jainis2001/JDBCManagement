package org.example.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private final Logger LOGGER= LogManager.getLogger(DepartmentResource.class);
	@Autowired
	private DepartmentService departmentService;

	@GetMapping
	public List<DepartmentDTO> getStudentsByDepartment(){
		LOGGER.debug("Fetching students by departments");
		return departmentService.getStudentsByDepartement();
	}

	@GetMapping("/{id}")
	public DepartmentDTO getStudentsByDepartmentId(@PathVariable("id") String id){
		LOGGER.debug("Fetching students by department-id Id: {}",id);
		return departmentService.getStudentsByDepartementId(id);
	}


}
