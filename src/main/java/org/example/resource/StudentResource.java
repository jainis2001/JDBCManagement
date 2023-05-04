package org.example.resource;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dto.StudentDTO;
import org.example.service.StudentService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@Tag(name = "Student-Resource",description = "This is controller of student")
@RequestMapping("/students")
public class StudentResource {
	private static final Logger LOGGER = LogManager.getLogger(StudentResource.class);
	@Autowired
	private StudentService studentService;


	@Operation(summary = "Get Students",description = "students information will come with address,departmet and selected subjects.")
	@GetMapping
	public ResponseEntity<List<StudentDTO>> getAll(
			@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(defaultValue = "5") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy){
		LOGGER.debug("Fetching all students");
		return new ResponseEntity<>(studentService.getStudents(pageNumber,pageSize,sortBy), HttpStatus.OK);
	}

	@Operation(summary = "Create The Student")
	@PostMapping
	public ResponseEntity<String> createStudent(@RequestBody StudentDTO studentDTO){
			LOGGER.debug("Creating new student");
			return new ResponseEntity<>((studentService.addStudent(studentDTO))?"Inserted":"",HttpStatus.OK);
	}

	@Operation(summary = "Get Student by id",description = "student information will come with address,departmet and selected subjects.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",description = "Student Found",
			content = {@Content(mediaType = "application/json",
					schema = @Schema(implementation = StudentDTO.class))}),
			@ApiResponse(responseCode = "404",description = "Student  Not Found",
			content = @Content)
	})
	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> getById(@PathVariable("id") String id){
		LOGGER.debug("Fetching student- Id: {}", id);
		return new ResponseEntity<>(studentService.getById(id),HttpStatus.OK);

	}

	@Operation(summary = "Delete Student")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") String id){
		LOGGER.debug("Deleting student- Id: {}", id);
		return new ResponseEntity<>((studentService.deleteStudent(id))?"Deleted":"Wrong Id",HttpStatus.OK);
	}
	@Operation(summary = "Update Student")
	@PutMapping("/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable("id") String id,@RequestBody StudentDTO studentDTO){
		LOGGER.debug("Updating student- Id: {}", id);
		studentDTO.setId(id);
		return new ResponseEntity<>((studentService.updateStudent(studentDTO)!=null) ? "Updated" : "",HttpStatus.OK);
	}

//	@GetMapping("/search")
//	public List<StudentDTO> getStudentBySearch(
//			@RequestParam(name = "firstname",defaultValue = "a")String value){
//		LOGGER.debug("Fetching student whose "+0 +" starts with: "+value);
//		return studentService.getStudentsBySearch(value);
//	}
	@GetMapping("/search")
	public ResponseEntity<MappingJacksonValue> getStudentBySearch(
			@RequestParam(value = "fields",defaultValue = "empty") Set<String> fields,
					@RequestParam Map<String,String> query ){

			return new ResponseEntity<>(studentService.searchAndFilter(query,fields),HttpStatus.OK);
	}

}
