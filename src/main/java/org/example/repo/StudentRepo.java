package org.example.repo;

import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,String> {
	Student findByFirstNameAndEmail(String firstName,String email);
}
