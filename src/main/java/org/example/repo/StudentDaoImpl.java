package org.example.repo;

import org.example.entity.Student;
import org.example.util.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentDaoImpl implements StudentDao{

	@Override
	public String isStuentExist(Student student,boolean isForUpdate) {
		String studentId=null;

		try(Connection con= DBConnection.getConnection())
		{
			PreparedStatement pstmt=null;
			if(isForUpdate){
				pstmt=con.prepareStatement(Queries.STUDENT_EXISTS_FOR_EDIT);
				pstmt.setString(1, student.getEmail());
				pstmt.setString(2, student.getFirstName());
				pstmt.setString(3, student.getLastName());
				pstmt.setString(4, student.getStudentId());
			}
			else{
				pstmt=con.prepareStatement(Queries.STUDENT_EXISTS);
				pstmt.setString(1, student.getEmail());
				pstmt.setString(2, student.getFirstName());
				pstmt.setString(3, student.getLastName());
			}

			ResultSet result=pstmt.executeQuery();
			if(result.next()){
				studentId=result.getString(1);
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return studentId;
	}




	@Override
	public boolean insert(Student student) {
		boolean isInserted=false;

		try(Connection con= DBConnection.getConnection())
		{
			PreparedStatement pStmtStudent=con.prepareStatement(Queries.INSERT);
			pStmtStudent.setString(1,student.getStudentId());
			pStmtStudent.setString(2,student.getFirstName());
			pStmtStudent.setString(3,student.getLastName());
			pStmtStudent.setInt(4,student.getAge());
			pStmtStudent.setLong(5,student.getMobile());
			pStmtStudent.setString(6,student.getEmail());
			pStmtStudent.setString(7,student.getGender());
			pStmtStudent.setString(8,student.getAddressId());
			pStmtStudent.executeUpdate();
			isInserted=true;
		}
		catch(Exception e){
		System.out.println(e.getMessage());
			System.err.println("Student record is not inserted!");

		}
		return isInserted;
	}

	@Override
	public boolean update(Student student) {
		boolean hasUpdated=false;


		try(Connection con= DBConnection.getConnection()) {
			PreparedStatement pstmt=con.prepareStatement(Queries.UPDATE);
			pstmt.setString(1,student.getFirstName());
			pstmt.setString(2,student.getLastName());
			pstmt.setString(3,student.getEmail());
			pstmt.setLong(4,student.getMobile());
			pstmt.setInt(5,student.getAge());
			pstmt.setString(6,student.getGender());
			pstmt.setString(7,student.getAddressId());
			pstmt.setString(8,student.getStudentId());
			int result=pstmt.executeUpdate();
			if(result==1){
				hasUpdated=true;

			}

		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	return hasUpdated;
	}

	@Override
	public boolean delete(String studentId) {
		boolean isDeleted=false;

		try(Connection con= DBConnection.getConnection()){
			PreparedStatement pstmt=con.prepareStatement(Queries.DELETE);
			pstmt.setString(1,studentId);
			int result=pstmt.executeUpdate();
			if(result==1){
				isDeleted=true;
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return isDeleted;
	}


	public List<Student> getAllStudentsRecords() {
		List<Student> studentsList=new ArrayList<>();

		try(Connection con= DBConnection.getConnection()){
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(Queries.GET_STUDENTS);
			while(result.next()) {
				Student student=new Student(result.getString(1),
						result.getInt(2),
						result.getLong(3),
						result.getString(4),
						result.getString(5),
						result.getString(6),
						result.getString(7),
						result.getString(8));
				studentsList.add(student);
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return studentsList;
	}





	public Student getByStudentId(String studentId) {
		Student student=null;

		try(Connection con= DBConnection.getConnection()){
			PreparedStatement pstmt=con.prepareStatement(Queries.GET_STUDENT_BY_ID);
			pstmt.setString(1,studentId);
			ResultSet result=pstmt.executeQuery();
			if(result.next()){
				student=new Student(result.getString(1),
						result.getInt(2),
						result.getLong(3),
						result.getString(4),
						result.getString(5),
						result.getString(6),
						result.getString(7),
				result.getString(8));
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return student;

	}


}
