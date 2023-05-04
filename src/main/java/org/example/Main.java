package org.example;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import org.example.criteria_queries.specification.AddressSpecification;
import org.example.criteria_queries.without_specification.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.net.ConnectException;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student API",version = "1.0",description = "this is REST-CRUD of students",
		contact = @Contact(name = "Jainis Talaviya",email = "jainis.talaviya@brevitaz.com")))
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);



//		run.getBean(AddressSpecification.class).getAddress();
//		System.out.println("------------");
//		run.getBean(WithoutSpecificationImple.class).findByCityAndPincode("amd",5678).forEach(System.out::println);

	}
}
