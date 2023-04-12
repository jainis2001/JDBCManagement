package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "dept_id")
	private String id;
	@Column(name = "name")
	private String departmentName;

	@OneToMany(mappedBy = "department")
	Set<Student> studentsSet;

	public Department() {
	}

	public Department(String id, String departmentName, Set<Student> studentsSet) {
		this.id = id;
		this.departmentName = departmentName;
		this.studentsSet = studentsSet;
	}

	public Department(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Student> getStudentsSet() {
		return studentsSet;
	}

	public void setStudentsSet(Set<Student> studentsSet) {
		this.studentsSet = studentsSet;
	}
}
