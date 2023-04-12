package org.example.service;

import org.example.dto.response.SubjectDTO;
import org.example.entity.Department;
import org.example.entity.Subject;
import org.example.repo.DepartmentRepo;
import org.example.repo.SubjectRepo;
import org.example.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectService {
	@Autowired
	private SubjectRepo subjectRepo;
	@Autowired
	private Util utill;
	public Set<Subject> addSubjects(Set<Subject> subjects){
		return subjects.stream()
				.map(subject->{
					Subject existSubject=subjectRepo.findBySubjectName(subject.getSubjectName().toLowerCase());
					return (existSubject==null)? subjectRepo.save(subject) :existSubject;
		}).collect(Collectors.toSet());
	}

	public List<SubjectDTO> getStudentsBySubject(){
		return utill.mapSubjectToSubjectDTOList(subjectRepo.findAll());
	}

	public SubjectDTO getStudentsBySubjectId(String id){
		return subjectRepo.findById(id).map(subject->utill.mapSubjectToSubjectDTO(subject)).orElse(null);

	}
}
