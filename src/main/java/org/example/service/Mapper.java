package org.example.service;

import org.example.dto.AddressDTO;
import org.example.dto.response.DepartmentDTO;
import org.example.dto.StudentDTO;
import org.example.dto.response.*;
import org.example.entity.Address;
import org.example.entity.Department;
import org.example.entity.Student;
import org.example.entity.Subject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Mapper {

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

	public StudentDTO mapToStudentDTO(Student student){
		return new StudentDTO(
				student.getStudentId(),
				student.getAge(),
				student.getMobile(),
				student.getFirstName(),
				student.getLastName(),
				student.getEmail(),
				student.getGender(),
				new AddressDTO(student.getAddress().getId(),student.getAddress().getLandmark(),student.getAddress().getCity(),student.getAddress().getState(),student.getAddress().getPincode()),
				student.getDepartment().getDepartmentName(),
				mapSubjectsToStringSet(student.getSubjectsSet())
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

	public AddressDTO mapToAddressDTO(Address address) {
		return new AddressDTO(
				address.getId(),
				address.getLandmark(),
				address.getCity(),
				address.getState(),
				address.getPincode());
	}
	public Department mapToDepartmentEntity(String departmentName) {
		return new Department(departmentName);
	}

	public Set<Subject> mapToSubjectSet(Set<String> subjects) {
		return subjects.stream()
				.map(Subject::new
				).collect(Collectors.toSet());
	}
	public Set<String> mapSubjectsToStringSet(Set<Subject> subjects) {
		return subjects.stream()
				.map(Subject::getSubjectName
				).collect(Collectors.toSet());
	}

	public List<DepartmentDTO> mapDepartmentToDepartmentDTOList(List<Department> departments) {
		return departments.stream()
				.map(department -> {
					Set<StudentForResponse> collect = department.getStudentsSet().stream()
							.map(student -> new StudentForResponse(student.getStudentId(), student.getFirstName(), student.getLastName(), student.getEmail())).collect(Collectors.toSet());
					return new DepartmentDTO(department.getId(), department.getDepartmentName(),collect);
				})
				.collect(Collectors.toList());

	}
	public DepartmentDTO mapDepartmentToDepartmentDTO(Department department) {
		return new DepartmentDTO(department.getId(),department.getDepartmentName(),
				department.getStudentsSet()
						.stream()
						.map(student -> new StudentForResponse(student.getStudentId(),
						student.getFirstName(),
						student.getLastName(),
						student.getEmail())).collect(Collectors.toSet()));

	}

	public SubjectDTO mapSubjectToSubjectDTO(Subject subject) {
		return new SubjectDTO(subject.getId(),subject.getSubjectName(),
				subject.getStudentsSet()
						.stream()
						.map(student -> new StudentForResponse(student.getStudentId(),
								student.getFirstName(),
								student.getLastName(),
								student.getEmail())).collect(Collectors.toSet()));

	}

	public List<SubjectDTO> mapSubjectToSubjectDTOList(List<Subject> subjects) {
		return subjects.stream()
				.map(subject -> {
					Set<StudentForResponse> collect = subject.getStudentsSet().stream()
							.map(student -> new StudentForResponse(student.getStudentId(), student.getFirstName(), student.getLastName(), student.getEmail())).collect(Collectors.toSet());
					return new SubjectDTO(subject.getId(), subject.getSubjectName(),collect);
				})
				.collect(Collectors.toList());

	}

}
