package org.example.dto.response;

import org.springframework.stereotype.Component;

@Component
public class StudentForResponse {
	private String studentId;
	private String FirstName;
	private String LastName;
	private String email;

	public StudentForResponse() {
	}

	public StudentForResponse(String studentId, String firstName, String lastName, String email) {
		this.studentId = studentId;
		FirstName = firstName;
		LastName = lastName;
		this.email = email;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
