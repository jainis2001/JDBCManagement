package org.example.entity;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private String studentId;
	private int age;
	private long mobile;
	private String firstName,lastName,email,gender;
	private String addressId;

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Student(String studentId,String firstName, String lastName, String email) {
		this.studentId=studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Student(String studentId, int age, long mobile, String firstName, String lastName, String email, String gender, String addressId) {
		this.studentId = studentId;
		this.age = age;
		this.mobile = mobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.addressId = addressId;
	}


	public Student(){

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

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentId='" + studentId + '\'' +
				", age=" + age +
				", mobile=" + mobile +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender='" + gender + '\'' +
				", addressId='" + addressId + '\'' +
				'}';
	}
}
