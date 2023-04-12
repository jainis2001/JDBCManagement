package org.example.service;

import org.example.dto.response.SubjectDTO;
import org.example.entity.Subject;
import org.example.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	private SubjectRepo subjectRepo;
	@Autowired
	private Mapper mapper;
	public Set<Subject> addSubjects(Set<Subject> subjects){
		return subjects.stream()
				.map(subject->{
					Subject existSubject=subjectRepo.findBySubjectName(subject.getSubjectName().toLowerCase());
					return (existSubject==null)? subjectRepo.save(subject) :existSubject;
		}).collect(Collectors.toSet());
	}

	public List<SubjectDTO> getStudentsBySubject(){
		return mapper.mapSubjectToSubjectDTOList(subjectRepo.findAll());
	}

	public SubjectDTO getStudentsBySubjectId(String id){
		return subjectRepo.findById(id).map(subject->mapper.mapSubjectToSubjectDTO(subject)).orElse(null);

	}
}
