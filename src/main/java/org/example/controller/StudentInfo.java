package org.example.controller;


import static org.example.controller.Main.reader;
import org.example.dto.StudentDTO;
import org.example.entity.Address;
import org.example.service.StudentService;
import org.example.util.Util;

import java.util.List;

public class StudentInfo {
	StudentService studentService;
	String firstName,lastName,email,gender,studentId;
	Long mobile;
	int age;
	StudentDTO studentDTO=null;

	public StudentInfo(StudentService studentService) {
		this.studentService = studentService;
	}
	public StudentDTO getInput() {

		try{
			Util util=new Util();
			studentId= util.createId();
			System.out.println("Enter FirstName:");
			firstName = reader.readLine();
			System.out.println("Enter LastName:");
			lastName=reader.readLine();
			System.out.println("Enter Email:");
			email=reader.readLine();
			if(Util.verifyEmail(email)) {throw new Exception("Wrong Email");}
			System.out.println("Enter Gender:");
			gender=reader.readLine();
			System.out.println("Enter Mobile Number:");
			mobile=Long.parseLong(reader.readLine());
			if(!Util.verifyMobile(mobile)) {throw new Exception("Mobile Number should be of only 10 digits");}
			System.out.println("Enter Age:");
			age=Integer.parseInt(reader.readLine());
			Address address=getAddressInput();
			studentDTO=new StudentDTO(studentId,age,mobile,firstName,lastName,email,gender,address);


		}catch (Exception e){
			System.err.println(e.getMessage());
			System.out.println("Enter again");
			getInput();
		}
		return studentDTO;

	}


	public Address getAddressInput(){
		Address address=null;
		try{
			Util util=new Util();
			String addressId=util.createId();
			System.out.println("Enter houseNo:");
			int houseNo=Integer.parseInt(reader.readLine());
			System.out.println("Enter Society Name:");
			String societyName=reader.readLine();
			String landMark=houseNo+"/"+societyName;
			System.out.println("Enter City:");
			String city=reader.readLine();
			System.out.println("Enter State:");
			String state=reader.readLine();
			System.out.println("Enter Pin code:");
			int pincode=Integer.parseInt(reader.readLine());
			address=new Address(addressId,landMark,city,state,pincode);
		}catch (Exception e){
			System.err.println(e.getMessage());
			getAddressInput();
		}

		return address;

	}
	public void showStudentsRecords(List<StudentDTO> studentList){
		try{
			for(StudentDTO student:studentList){
				System.out.println(student);
				System.out.println(student.getAddress().toString());
				System.out.println("-------------------------------------------------------------------");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
//
	public void showStudent(StudentDTO studentDTO){
		try{
				System.out.println(studentDTO);
				System.out.println(studentDTO.getAddress().toString());
				System.out.println("-------------------------------------------------------------------");

		}catch(Exception e){
			System.out.println(e.getMessage());

		}
	}


	public void selectEditInput(StudentDTO studentDTO) {
		String studentId=studentDTO.getStudentId();
		try{

				studentDTO=getInput();
				studentDTO.setStudentId(studentId);
				if(studentService.updateStudent(studentDTO)){
					System.out.println("Updated..");
					showStudent(studentDTO);
				}else{
					System.out.println("Could not updated");
				}
		}catch (Exception e){
			System.out.println(e.getMessage());
			selectEditInput(studentDTO);
		}



	}





}
