package org.example.resource;

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
	@Autowired
	private SubjectService subjectService;
	@GetMapping
	public List<SubjectDTO> getStudentsBySubject(){
		return subjectService.getStudentsBySubject();
	}

	@GetMapping("/{id}")
	public SubjectDTO getStudentsBySubjectId(@PathVariable("id") String id){
		return subjectService.getStudentsBySubjectId(id);
	}




}
