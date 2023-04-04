package org.example.controller;

import org.example.dto.StudentDTO;
import org.example.service.StudentService;
import org.example.service.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {
	private static final StudentService studentService= new StudentServiceImpl();

	private static final StudentInfo studentInfo=new StudentInfo(studentService);

	public static final BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

	public void insert(){
		StudentDTO studentDTO = studentInfo.getInput();
		String studentId=studentService.isStudentExist(studentDTO,false);
		if(studentId==null){
			System.out.println( studentService.insertStudent(studentDTO)?"Inserted Successfully!" : "Could not Inserted!");
		}
		else{
			System.err.println("This Student is already inserted");
		}
	}
	public void update() throws IOException {
		System.out.println("Enter UUID");
		StudentDTO studentDTO =studentService.getRecordById(reader.readLine());
		if(studentDTO !=null){
			studentInfo.showStudent(studentDTO);
			studentInfo.selectEditInput(studentDTO);
		}
		else{
			System.err.println("Wrong UUID");
		}
	}

	public void delete() throws IOException {
		System.out.println("Enter UUID:");
		System.out.println((studentService.deleteStudent(reader.readLine()))? "Deleted":"Wrong UUID");

	}
	public void show(){
		List<StudentDTO> studentList=studentService.viewStudents();
		studentInfo.showStudentsRecords(studentList);

	}

	public int displayOptions() throws IOException {
		System.out.println("\n1: Insertion");
		System.out.println("2: Update");
		System.out.println("3: Delete Student");
		System.out.println("4: Show");
		System.out.println("0: Exit");
		System.out.println("Enter Choice:");
		return Integer.parseInt(reader.readLine());
	}

	public void getMenu(){
		try
		{
			while(true){

				switch (displayOptions()){
					case 1:
						insert();
						break;
					case 2:
						update();
						break;
					case 3:
						delete();
						break;
					case 4:
						show();
						break;
					case 0:
						System.exit(0);
					default:
						System.out.println("Invalid Choice");
				}
			}

		}catch (Exception e){
			System.out.println(e.getMessage());
			getMenu();
		}
	}
}
