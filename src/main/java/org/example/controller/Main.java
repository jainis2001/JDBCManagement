package org.example.controller;


import org.example.dto.StudentDTO;
import org.example.service.StudentService;
import org.example.service.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
	private static final StudentService studentService= new StudentServiceImpl();
	
	private static final StudentInfo studentInfo=new StudentInfo(studentService);

void disp(){

}
	public static final BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		try
		{
			int ch;
			do{
				System.out.println("\n1: Insertion");
				System.out.println("2: Update");
				System.out.println("3: Delete Student");
				System.out.println("4: Show");
				System.out.println("0: Exit");
				System.out.println("Enter Choice:");
				ch=Integer.parseInt(reader.readLine());
				switch (ch){
					case 1:
						StudentDTO studentDTO = studentInfo.getInput();
						String studentId=studentService.isStudentExist(studentDTO);
						if(studentId==null){
							System.out.println( studentService.insertStudent(studentDTO)?"Inserted Successfully!" : "Could not Inserted!");
						}
						else{
							System.err.println("This Student is already inserted");
						}

						break;
					case 2:
						System.out.println("Enter UUID");
						studentDTO =studentService.getRecordById(reader.readLine());
						if(studentDTO !=null){
							studentInfo.showStudent(studentDTO);
							studentInfo.selectEditInput(studentDTO);
//							student =studentInfo.editStudentInput(student);
						}
						else{
							System.err.println("Wrong UUID");
						}
						break;
					case 3:
						System.out.println("Enter UUID:");
						System.out.println((studentService.deleteStudent(reader.readLine()))? "Deleted":"Wrong UUID");
						break;
					case 4:
						List<StudentDTO> studentList=studentService.viewStudents();
						studentInfo.showStudentsRecords(studentList);
						break;
					case 0:
						System.exit(0);
					default:
						System.out.println("Invalid Choice");
				}

			}while(true);

		}catch (Exception e){
			System.out.println("Enter again");
			main(args);
		}





	}
}
