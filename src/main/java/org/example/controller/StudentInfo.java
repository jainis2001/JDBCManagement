package org.example.controller;


import static org.example.controller.Menu.reader;
import org.example.dto.StudentDTO;
import org.example.entity.Address;
import org.example.service.StudentService;
import org.example.util.Util;

import java.util.List;

public class StudentInfo {
	StudentService studentService;
	StudentDTO studentDTO=null;
	Address address=null;

	public StudentInfo(StudentService studentService) {
		this.studentService = studentService;
	}
	public StudentDTO getInput() {


		try{
			Util util=new Util();
			String studentId= util.createId();
			System.out.println("Enter FirstName:");
			String firstName = reader.readLine();
			System.out.println("Enter LastName:");
			String lastName=reader.readLine();
			System.out.println("Enter Email:");
			String email=reader.readLine();
			if(Util.verifyEmail(email)) {throw new Exception("Wrong Email");}
			System.out.println("Enter Gender:");
			String gender=reader.readLine();
			System.out.println("Enter Mobile Number:");
			Long mobile=Long.parseLong(reader.readLine());
			if(!Util.verifyMobile(mobile)) {throw new Exception("Mobile Number should be of only 10 digits");}
			System.out.println("Enter Age:");
			int age=Integer.parseInt(reader.readLine());
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
				studentId=studentService.isStudentExist(studentDTO,true);
				if(studentId==null){
					if(studentService.updateStudent(studentDTO)){
						System.out.println("Updated..");
						showStudent(studentDTO);
					}else{
						System.out.println("Could not updated");
					}
				}
				else{
					System.out.println("This Student already there!");
				}

		}catch (Exception e){
			System.out.println(e.getMessage());
			selectEditInput(studentDTO);
		}



	}





}
