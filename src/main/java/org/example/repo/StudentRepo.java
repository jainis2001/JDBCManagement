package org.example.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.example.entity.Address;
import org.example.entity.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,String>, JpaSpecificationExecutor<Student> {
	Student findByFirstNameAndEmail(String firstName,String email);
	Student findByFirstNameAndEmailAndIdNot(String firstName,String email,String id);

	List<Student> findByFirstNameStartingWith(String name);

}
