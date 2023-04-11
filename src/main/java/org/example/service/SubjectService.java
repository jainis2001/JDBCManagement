package org.example.service;

import org.example.entity.Department;
import org.example.entity.Subject;
import org.example.repo.DepartmentRepo;
import org.example.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SubjectService {
	@Autowired
	private SubjectRepo subjectRepo;
	public Set<Subject> addSubjects(Set<Subject> subjects){
		return subjects.stream()
				.map(subject->{
					Subject existSubject=subjectRepo.findBySubjectName(subject.getSubjectName().toLowerCase());
					return (existSubject==null)? subjectRepo.save(subject) :existSubject;
		}).collect(Collectors.toSet());

	}
}
