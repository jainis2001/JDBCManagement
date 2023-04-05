package org.example.dto;

import org.example.entity.Address;

public class StudentDTO {
	private String studentId;
	private int age;
	private long mobile;
	private String firstName,lastName,email,gender;
	private Address address;


	public StudentDTO(String studentId, int age, long mobile, String firstName, String lastName, String email, String gender, Address address) {
		this.studentId = studentId;
		this.age = age;
		this.mobile = mobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.address=address;

	}
	public StudentDTO(String studentId, int age, long mobile, String firstName, String lastName, String email, String gender) {
		this.studentId = studentId;
		this.age = age;
		this.mobile = mobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}

	public StudentDTO() {

	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "StudentModel{" +
				"studentId='" + studentId + '\'' +
				", age=" + age +
				", mobile=" + mobile +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender='" + gender +
				'}';
	}
}
