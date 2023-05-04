package org.example.service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Exception.DuplicateResourceException;
import org.example.Exception.NotFoundResourceException;
import org.example.dto.StudentDTO;
import org.example.entity.Address;
import org.example.entity.Department;
import org.example.entity.Student;
import org.example.entity.Subject;
import org.example.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger LOGGER= LogManager.getLogger(StudentServiceImpl.class);
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

	private final EntityManager entityManager;

	public StudentServiceImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

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
				LOGGER.info("Student created successfully.");
				return true;
			}
			else{
				LOGGER.info("Student already exists found");
				throw new DuplicateResourceException("Student Already Exists");
			}
	}

	public List<StudentDTO> getStudents(Integer pageNumber,Integer pageSize,String sortBy) {
		Pageable page=PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
		Page<Student> pageOfStudents = studentRepo.findAll(page);
		List<Student> studentsRecord = pageOfStudents.getContent();
		List<StudentDTO> students= studentsRecord.stream()
				.map(student -> mapper.mapToStudentDTO(student)).collect(Collectors.toList());
		if(students.isEmpty()){
			throw new NotFoundResourceException("Student List is empty");
		}
		else{
			LOGGER.info("Receive {} students", (long) students.size());
			return students;
		}


		
	}
	public boolean deleteStudent(String id){

		if(studentRepo.existsById(id)){
			studentRepo.deleteById(id);
			LOGGER.info("Student deleted with id: {}",id);
			return true;
		}
		else{
			LOGGER.info("Wrong student id for delete, id: {}",id);
			throw new NotFoundResourceException("wrong student-id provided");
		}

	}

	@Override
	public StudentDTO updateStudent(StudentDTO studentDTO) {

		Optional<Student> student = studentRepo.findById(studentDTO.getId());
		if (student.isPresent()) {
			if (studentRepo.findByFirstNameAndEmailAndIdNot(studentDTO.getFirstName(), studentDTO.getEmail(), studentDTO.getId()) == null) {

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
				LOGGER.info("Student updated successfully- Id: {}",studentDTO.getId());
				return studentDTO;
			}
			else{
				LOGGER.info("Another student already exists for update");
				throw new DuplicateResourceException("Student Already Exists");
			}

		} else {
			LOGGER.warn("Wrong student id for update");
			throw new NotFoundResourceException("wrong student-id provided");
		}

	}


	@Override
	public StudentDTO getById(String id) {

		Optional<Student> studentById = studentRepo.findById(id);
		if(studentById.isEmpty()){
			LOGGER.info("wrong student-id for fetch the student details");
			throw new NotFoundResourceException("wrong student-id provided");
		}
		else{
			LOGGER.info("Fetched student successfully.");
			return studentById.map(student->mapper.mapToStudentDTO(student)).get();
		}
	}

	@Override
	public List<StudentDTO> getStudentsBySearch(String value) {
		List<StudentDTO> students = studentRepo.findByFirstNameStartingWith(value).stream()
				.map(student -> mapper.mapToStudentDTO(student)).collect(Collectors.toList());
		if(students.size()==0){
			throw new NotFoundResourceException("No students found starting firstname with: "+value);
		}
		else{
			LOGGER.info("Receive {} students", (long) students.size());
			return students;
		}
	}


	public MappingJacksonValue searchAndFilter(Map<String,String> queryy,Set<String> fields) {
		String key=null;
		String value=null;
		for(Map.Entry<String,String> map:queryy.entrySet()){
			key=map.getKey();
			value=map.getValue();
		}
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		Root<Student> root = query.from(Student.class);
		if(!Objects.equals(value, "")){
			String[] splitArr= key.split("\\.");
			if(splitArr.length>1){
				Join<Object,Object> join=root.join(splitArr[0]);
				query.where(builder.equal(join.get(splitArr[1]), value));
			}
			else{
				query.where(builder.equal(root.get(key), value));
			}
		}
		List<StudentDTO> resultList = entityManager.createQuery(query).getResultList().stream().map(student -> mapper.mapToStudentDTO(student)).collect(Collectors.toList());

		MappingJacksonValue mappingJacksonValue=null;
		if(!fields.contains("empty")) {
				SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
			FilterProvider filterProvider = new SimpleFilterProvider().addFilter("student_filter", filter);
				mappingJacksonValue = new MappingJacksonValue(resultList);
				mappingJacksonValue.setFilters(filterProvider);

		}
		else{
			FilterProvider filterProvider = new SimpleFilterProvider().addFilter("userFilter", SimpleBeanPropertyFilter.serializeAllExcept(fields));
			mappingJacksonValue=new MappingJacksonValue(resultList);
			mappingJacksonValue.setFilters(filterProvider);
		}

		return mappingJacksonValue;

	}


}
