package org.example.service;

import org.example.dto.StudentDTO;
import org.example.entity.Address;
import org.example.entity.Department;
import org.example.entity.Student;
import org.example.entity.Subject;
import org.example.repo.StudentRepo;
import org.example.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo studentRepo;
//	@Autowired
	private Address address;
//	@Autowired
	private Department department;
//	@Autowired
	private Student student;

	@Autowired
	private Util util;
	@Autowired
	private AddressService addressService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private SubjectService subjectService;

	@Override
	public boolean addStudent(StudentDTO studentDTO) {

		if(studentRepo.findByFirstNameAndEmail(studentDTO.getFirstName(),studentDTO.getEmail())==null){
			student=util.mapToStudentEntity(studentDTO);
			address=addressService.insertAddress(util.mapToAddressEntity(studentDTO.getAddressDTO()));
			student.setAddress(address);
			department=departmentService.addDepartment(util.mapToDepartmentEntity(studentDTO.getDepartmentName()));
			student.setDepartment(department);
			Set<Subject> subjects=util.mapToSubjectSet(studentDTO.getSubjects());
			student.setSubjectsSet(subjectService.addSubjects(subjects));
			studentRepo.save(student);
			return true;
		}

		return false;
	}

	public List<StudentDTO> getStudents() {

		List<StudentDTO> studentDTOS=new ArrayList<>();
		List<Student> all = studentRepo.findAll();
		for(Student student:all){
			StudentDTO studentDTO=new StudentDTO(student.getStudentId(),
					student.getAge(),
					student.getMobile(),
					student.getFirstName(),
					student.getLastName(),
					student.getEmail(),
					student.getGender());
			studentDTO.setAddressDTO(util.mapToAddressDTO(student.getAddress()));
			studentDTO.setDepartmentName(student.getDepartment().getDepartmentName());
			studentDTO.setSubjects(util.mapSubjectsToStringSet(student.getSubjectsSet()));
			studentDTOS.add(studentDTO);
		}

		return studentDTOS;
	}

	public boolean deleteStudent(String id){
		if(studentRepo.existsById(id)){
			studentRepo.deleteById(id);
			return true;
		}
		return false;

	}
}
