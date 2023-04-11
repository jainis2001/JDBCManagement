package org.example.repo;

import org.example.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,String> {
	Subject findBySubjectName(String subject);
}
