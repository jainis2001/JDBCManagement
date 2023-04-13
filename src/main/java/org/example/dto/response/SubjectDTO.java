package org.example.dto.response;

import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class SubjectDTO {
	private String id;
	private String name;
	Set<StudentForResponse> subjectStudentsSet;

	public SubjectDTO(String id, String name, Set<StudentForResponse> subjectStudentsSet) {
		this.id = id;
		this.name = name;
		this.subjectStudentsSet = subjectStudentsSet;
	}

	public SubjectDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<StudentForResponse> getSubjectStudentsSet() {
		return subjectStudentsSet;
	}

	public void setSubjectStudentsSet(Set<StudentForResponse> subjectStudentsSet) {
		this.subjectStudentsSet = subjectStudentsSet;
	}
}
