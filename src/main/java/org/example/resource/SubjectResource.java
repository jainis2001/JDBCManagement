package org.example.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dto.response.DepartmentDTO;
import org.example.dto.response.SubjectDTO;
import org.example.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectResource {
	private final Logger LOGGER= LogManager.getLogger(SubjectResource.class);
	@Autowired
	private SubjectService subjectService;
	@GetMapping
	public List<SubjectDTO> getStudentsBySubject(){
		LOGGER.debug("Fetching students details by subjects");
		return subjectService.getStudentsBySubject();
	}

	@GetMapping("/{id}")
	public SubjectDTO getStudentsBySubjectId(@PathVariable("id") String id){
		LOGGER.debug("Fetch students by subject-id- Id: {}",id);
		return subjectService.getStudentsBySubjectId(id);
	}




}
