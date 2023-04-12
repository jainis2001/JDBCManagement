package org.example.service;

import org.example.dto.response.SubjectDTO;
import org.example.entity.Subject;

import java.util.List;
import java.util.Set;

public interface SubjectService  {
	Set<Subject> addSubjects(Set<Subject> subjects);
	List<SubjectDTO> getStudentsBySubject();
	SubjectDTO getStudentsBySubjectId(String id);
}
