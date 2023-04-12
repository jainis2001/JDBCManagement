package org.example.dto;


import org.example.entity.Subject;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class StudentDTO {

	private String id;
	private int age;
	private long mobile;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private AddressDTO addressDTO;
	private String departmentName;
	private Set<String> subjects;

	public StudentDTO() {
	}

	public StudentDTO(String id, int age, long mobile, String firstName, String lastName, String email, String gender, AddressDTO addressDTO, String departmentName, Set<String> subjects) {
		this.id = id;
		this.age = age;
		this.mobile = mobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.addressDTO = addressDTO;
		this.departmentName = departmentName;
		this.subjects = subjects;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "StudentDTO{" +
				"id='" + id + '\'' +
				", age=" + age +
				", mobile=" + mobile +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender='" + gender + '\'' +
				", addressDTO=" + addressDTO +
				", departmentName='" + departmentName + '\'' +
				", subjects=" + subjects +
				'}';
	}
}
