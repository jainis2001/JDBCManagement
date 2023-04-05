package org.example.repo;

import org.example.entity.Student;

import java.util.List;


public interface StudentDao {
	String isStuentExist(Student student,boolean isForUpdate);

	boolean insert(Student student);
	boolean update(Student student);
	boolean delete(String studentId);

	List<Student> getAllStudentsRecords();

	Student getByStudentId(String studentId);
}
