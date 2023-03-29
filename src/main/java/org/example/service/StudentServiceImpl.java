package org.example.service;

import org.example.dto.StudentDTO;
import org.example.entity.Address;
import org.example.entity.Student;
import org.example.repo.*;

import java.util.ArrayList;
import java.util.List;


public class StudentServiceImpl implements StudentService{
	private final StudentDao studentDao=new StudentDaoImpl();
	private final AddressDao addressDao=new AddressDaoImpl();
	private final AddressService addressService=new AddressServiceImpl();

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
//			studentDTO=studentDao.getById(studentId);
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
	public String isStudentExist(StudentDTO studentDTO) {
		String studentId=null;
		try{
			student=new Student(studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail());
			studentId=studentDao.isStuentExist(student);
		}catch (Exception e){
		System.out.println(e.getMessage());
			System.out.println("Error while inserting student");
		}
		return studentId;
	}

	@Override
	public String isStudentExistForEdit(StudentDTO studentDTO) {
		String studentId=null;
		try{
			student=new Student(studentDTO.getStudentId(),studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail());
			studentId=studentDao.isStuentExistForEdit(student);
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
//			StudentDTO studentDTO=studentDao.getById(studentId);
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
//			studentsList= studentDao.showRecords();
			List<Student> studentsRecord=studentDao.getAllStudentsRecords();
			List<Address> addressRecord=addressDao.getAllAddressRecords();

			for(Student student:studentsRecord){
				StudentDTO studentDTO=new StudentDTO(student.getStudentId(), student.getAge(), student.getMobile(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getGender());
				for(Address address:addressRecord){
					if(student.getAddressId().equals(address.getAddressId())){
						studentDTO.setAddress(address);
					}
				}
				studentsList.add(studentDTO);
			}
		}catch (Exception e){
		System.out.println(e.getMessage());
		}
		return studentsList;
	}


	@Override
	public boolean updateStudent(StudentDTO studentDTO) {
		addressService.updateAddress(studentDTO.getAddress());
		student=new Student(studentDTO.getStudentId(), studentDTO.getAge(), studentDTO.getMobile(), studentDTO.getFirstName(), studentDTO.getLastName(), studentDTO.getEmail(), studentDTO.getGender(), studentDTO.getAddress().getAddressId());
		return studentDao.update(student);


	}
}


