package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.springframework.stereotype.Component;

import java.util.Set;


@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "student_id")
	private String id;
	@Column(name = "age")
	private int age;
	@Column(name = "mobile")
	private long mobile;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;
	@Column(name = "gender")
	private String gender;

	@OneToOne
	@JoinColumn(name = "fk_address_id",referencedColumnName = "address_id")
	private Address address;

	@OneToOne
	@JoinColumn(name = "fk_dept_id",referencedColumnName = "dept_id")
	private Department department;

	@ManyToMany
	@JoinTable(
			name="student_subject_map",
			joinColumns = @JoinColumn(name = "fk_student_id",referencedColumnName = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "fk_subject_id",referencedColumnName = "subject_Id"))
	private Set<Subject> subjectsSet;

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Student(String id,String firstName, String lastName, String email) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Student(String id, int age, long mobile, String firstName, String lastName, String email, String gender, Address address, Department department, Set<Subject> subjectsSet) {
		this.id = id;
		this.age = age;
		this.mobile = mobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.department = department;
		this.subjectsSet = subjectsSet;
	}

	public Student(String id, int age, long mobile, String firstName, String lastName, String email, String gender) {
		this.id = id;
		this.age = age;
		this.mobile = mobile;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}

	public Student(){}

	public String getStudentId() {
		return id;
	}

	public void setStudentId(String id) {
		this.id = id;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Subject> getSubjectsSet() {
		return subjectsSet;
	}

	public void setSubjectsSet(Set<Subject> subjectsSet) {
		this.subjectsSet = subjectsSet;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id='" + id + '\'' +
				", age=" + age +
				", mobile=" + mobile +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender='" + gender + '\'' +
				", address=" + address +
				", department=" + department +
				", subjectsSet=" + subjectsSet +
				'}';
	}
}
