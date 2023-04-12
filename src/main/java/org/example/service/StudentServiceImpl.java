package org.example.service;

import org.example.dto.StudentDTO;
import org.example.entity.Address;
import org.example.entity.Department;
import org.example.entity.Student;
import org.example.entity.Subject;
import org.example.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	private Mapper mapper;
	@Autowired
	private AddressService addressService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private SubjectService subjectService;

	@Override
	public boolean addStudent(StudentDTO studentDTO) {

		if(studentRepo.findByFirstNameAndEmail(studentDTO.getFirstName(),studentDTO.getEmail())==null){
			student=mapper.mapToStudentEntity(studentDTO);
			address=addressService.insertAddress(studentDTO.getAddressDTO());
			student.setAddress(address);
			department=departmentService.addDepartment(studentDTO.getDepartmentName());
			student.setDepartment(department);
			Set<Subject> subjects=mapper.mapToSubjectSet(studentDTO.getSubjects());
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
			studentDTO.setAddressDTO(mapper.mapToAddressDTO(student.getAddress()));
			studentDTO.setDepartmentName(student.getDepartment().getDepartmentName());
			studentDTO.setSubjects(mapper.mapSubjectsToStringSet(student.getSubjectsSet()));
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

	@Override
	public StudentDTO updateStudent(StudentDTO studentDTO) {
		Optional<Student> student = studentRepo.findById(studentDTO.getId());
		if(student.isPresent()) {
			if(studentRepo.findByFirstNameAndEmailAndIdNot(studentDTO.getFirstName(),studentDTO.getEmail(),studentDTO.getId())==null) {
					student.get().setFirstName(studentDTO.getFirstName());
					student.get().setLastName(studentDTO.getLastName());
					student.get().setEmail(studentDTO.getEmail());
					student.get().setAge(studentDTO.getAge());
					student.get().setGender(studentDTO.getGender());
					student.get().setMobile(studentDTO.getMobile());
					address = addressService.insertAddress(studentDTO.getAddressDTO());
					student.get().setAddress(address);
					department = departmentService.addDepartment(studentDTO.getDepartmentName());
					student.get().setDepartment(department);
					Set<Subject> subjects = mapper.mapToSubjectSet(studentDTO.getSubjects());
					student.get().setSubjectsSet(subjectService.addSubjects(subjects));
					studentRepo.save(student.get());
					return studentDTO;
				}
			}
		return null;
		}

	@Override
	public StudentDTO getById(String id) {
		return studentRepo.findById(id).map(student->mapper.mapToStudentDTO(student)).orElse(null);
	}


}
