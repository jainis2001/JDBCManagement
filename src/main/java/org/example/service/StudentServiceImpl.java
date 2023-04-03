package org.example.service;

import org.example.dto.StudentDTO;
import org.example.entity.Address;
import org.example.entity.Student;
import org.example.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private  StudentDao studentDao;
	@Autowired
	private  AddressDao addressDao;
	@Autowired
	private  AddressService addressService;

	Student student;

	@Override
	public boolean insertStudent(StudentDTO studentDTO) {
		addressService.insertAddress(studentDTO.getAddress());
		student=new Student(studentDTO.getStudentId(), studentDTO.getAge(), studentDTO.getMobile(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail(), studentDTO.getGender(), studentDTO.getAddress().getAddressId());
		return studentDao.insert(student);
	}

	@Override
	public StudentDTO getRecordById(String studentId) {
		StudentDTO studentDTO=null;
		try{
			Student student=studentDao.getByStudentId(studentId);
			if(student!=null){
				Address address=addressDao.getByAddressId(student.getAddressId());
				studentDTO=new StudentDTO(student.getStudentId(),
						student.getAge(),
						student.getMobile(),
						student.getFirstName(),
						student.getLastName(),
						student.getEmail(),
						student.getGender(),
						address);
			}


		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return studentDTO;
	}

	@Override
	public String isStudentExist(StudentDTO studentDTO,boolean isForUpdate) {
		String studentId=null;
		try{

			student=new Student(studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail());
			if(isForUpdate){
				studentId=studentDao.isStuentExist(student,true);

			}else{
				studentId=studentDao.isStuentExist(student,false);

			}
		}catch (Exception e){
		System.out.println(e.getMessage());
			System.out.println("Error while inserting student");
		}
		return studentId;
	}



	@Override
	public boolean deleteStudent(String studentId) {
		 boolean isDeleted=false;
		try{
			Student student=studentDao.getByStudentId(studentId);
			if(student!=null){
				if(studentDao.delete(student.getStudentId())){
					isDeleted=true;
				}
			}

		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	return isDeleted;
	}



	@Override
	public List<StudentDTO> viewStudents() {
		List<StudentDTO> studentsList=new ArrayList<>();
		try{
			List<Student> studentsRecord=studentDao.getAllStudentsRecords();
			List<Address> addressRecord=addressDao.getAllAddressRecords();
			studentsList=studentsRecord.stream()
					.map(student -> {
						Address address1 = addressRecord.stream()
								.filter(address -> address.getAddressId().equals(student.getAddressId())).findFirst().get();
								return new StudentDTO(student.getStudentId(), student.getAge(), student.getMobile(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getGender(),address1);
					})
					.collect(Collectors.toList());
		}catch (Exception e){
		System.out.println(e.getMessage());
		}
		return studentsList;
	}

	@Override
	public boolean updateStudent(StudentDTO studentDTO) {
		addressService.insertAddress(studentDTO.getAddress());
		student=new Student(studentDTO.getStudentId(), studentDTO.getAge(), studentDTO.getMobile(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail(), studentDTO.getGender(), studentDTO.getAddress().getAddressId());
		return studentDao.update(student);


	}
}


