package org.example.repo;

public class Queries {
	public static final String studentExist="select studentid from tempstudent where email=? and firstname=? and lastname=?";
	public static final String studentExistForEdit="select studentid from tempstudent where email=? and firstname=? and lastname=?  and studentid<>?";
	public static final String insertStudent="insert into tempstudent(studentid,firstName,lastName,age,mobile,email,gender,addressid) values(?,?,?,?,?,?,?,?)";
	public static final String updateStudent="update tempstudent set firstName=?,lastName=?,email=?,mobile=?,age=?,gender=?,addressId=? where studentid=?";
	public static final String deleteStudent="delete from tempstudent where studentid=?";
	public static final String getStudents="select studentid,age,mobile,firstName,lastName,email,gender,addressid from tempstudent";
	public static final String getStudentById="select studentid,age,mobile,firstName,lastName,email,gender,addressid from tempstudent where tempstudent.studentid=?";
	public static final String findByAddress="select addressid from address where landmark=? and pincode=?";
	public static final String insertAddress="insert into address(addressid,landmark,city,state,pincode) values(?,?,?,?,?)";
	public static final String getByAddressId="select addressid,landmark,city,state,pincode from address where addressid=?";
	public static final String getAddresses="select addressid,landmark,city,state,pincode from address";




}


