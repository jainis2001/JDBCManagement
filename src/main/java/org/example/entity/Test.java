package org.example.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("filter")
class Student1 {
	String name;
//	@JsonFilter("address")
	Address1 address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address1 getAddress() {
		return address;
	}

	public void setAddress(Address1 address) {
		this.address = address;
	}
}

class Address1 {
	int pincode;
	String city;

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
public class Test {
	public static void main(String[] args) throws JsonProcessingException {
		Student1 student = new Student1();
		student.setName("John");
		Address1 address = new Address1();
		address.setPincode(12345);
		address.setCity("New York");
		student.setAddress(address);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("name", "address");
		FilterProvider filterProvider = new SimpleFilterProvider().setFailOnUnknownId(true).addFilter("filter", filter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(student);
		mappingJacksonValue.setFilters(filterProvider);

		ObjectWriter writer = mapper.writer(filterProvider).withDefaultPrettyPrinter();
		String writeValueAsString = writer.writeValueAsString(student);
//		Student1 resultCustomer = mapper.readValue(writeValueAsString, Student1.class);
//		return ResponseEntity.status(HttpStatus.OK).body(resultCustomer);
//		String output = writer.writeValueAsString(mappingJacksonValue);
		System.out.println(writeValueAsString);
	}
}
