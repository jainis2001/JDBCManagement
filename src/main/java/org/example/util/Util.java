package org.example.util;

import org.example.dto.AddressDTO;
import org.example.dto.StudentDTO;
import org.example.entity.Address;
import org.example.entity.Department;
import org.example.entity.Student;
import org.example.entity.Subject;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class Util {

	public Student mapToStudentEntity(StudentDTO studentDTO) {
		return new Student(
				studentDTO.getId(),
				studentDTO.getAge(),
				studentDTO.getMobile(),
				studentDTO.getFirstName(),
				studentDTO.getLastName(),
				studentDTO.getEmail(),
				studentDTO.getGender()
				);
	}

	public Address mapToAddressEntity(AddressDTO addressDTO) {
		return new Address(
				addressDTO.getId(),
				addressDTO.getLandmark(),
				addressDTO.getCity(),
				addressDTO.getState(),
				addressDTO.getPinCode());
	}
	public Department mapToDepartmentEntity(String departmentName) {
		return new Department(departmentName);
	}

	public Set<Subject> mapToSubjectSet(Set<String> subjects) {
		return subjects.stream()
				.map(Subject::new
				).collect(Collectors.toSet());
	}

}
