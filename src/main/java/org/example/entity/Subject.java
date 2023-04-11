package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "subject_id")
	private String id;
	@Column(name = "name")
	private String subjectName;
//	@JsonIgnore
	@ManyToMany(mappedBy = "subjectsSet")
	private Set<Student> studentsSet=new HashSet<>();

	public Subject() {
	}

	public Subject(String id, String subjectName, Set<Student> studentsSet) {
		this.id = id;
		this.subjectName = subjectName;
		this.studentsSet = studentsSet;
	}
	public Subject(String subjectName) {

		this.subjectName = subjectName;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Set<Student> getStudentsSet() {
		return studentsSet;
	}

	public void setStudentsSet(Set<Student> studentsSet) {
		this.studentsSet = studentsSet;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Subject subject = (Subject) o;
		return Objects.equals(subjectName, subject.subjectName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(subjectName);
	}
}
