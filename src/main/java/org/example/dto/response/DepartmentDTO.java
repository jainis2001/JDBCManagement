package org.example.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonMerge;
import jakarta.persistence.OneToMany;
import org.example.entity.Department;
import org.example.entity.Student;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
public class DepartmentDTO {
	private String id;
	private String departmentName;
	Set<StudentForResponse> departmentStudentsSet;

	public DepartmentDTO() {
	}

	public DepartmentDTO(String id, String departmentName, Set<StudentForResponse> departmentStudentsSet) {
		this.id = id;
		this.departmentName = departmentName;
		this.departmentStudentsSet = departmentStudentsSet;
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

	public Set<StudentForResponse> getDepartmentStudentsSet() {
		return departmentStudentsSet;
	}

	public void setDepartmentStudentsSet(Set<StudentForResponse> departmentStudentsSet) {
		this.departmentStudentsSet = departmentStudentsSet;
	}
}
