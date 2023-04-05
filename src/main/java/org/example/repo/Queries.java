package org.example.repo;

public class Queries {
	public static final String STUDENT_EXISTS="select studentid from tempstudent where email=? and firstname=? and lastname=?";
	public static final String STUDENT_EXISTS_FOR_EDIT="select studentid from tempstudent where email=? and firstname=? and lastname=?  and studentid<>?";
	public static final String INSERT="insert into tempstudent(studentid,firstName,lastName,age,mobile,email,gender,addressid) values(?,?,?,?,?,?,?,?)";
	public static final String UPDATE="update tempstudent set firstName=?,lastName=?,email=?,mobile=?,age=?,gender=?,addressId=? where studentid=?";
	public static final String DELETE="delete from tempstudent where studentid=?";
	public static final String GET_STUDENTS="select studentid,age,mobile,firstName,lastName,email,gender,addressid from tempstudent";
	public static final String GET_STUDENT_BY_ID="select studentid,age,mobile,firstName,lastName,email,gender,addressid from tempstudent where tempstudent.studentid=?";
	public static final String FIND_BY_ADDRESS="select addressid from address where landmark=? and pincode=?";
	public static final String INSERT_ADDRESS="insert into address(addressid,landmark,city,state,pincode) values(?,?,?,?,?)";
	public static final String GET_BY_ADDRESS_ID="select addressid,landmark,city,state,pincode from address where addressid=?";
	public static final String GET_ADDRESS="select addressid,landmark,city,state,pincode from address";




}


