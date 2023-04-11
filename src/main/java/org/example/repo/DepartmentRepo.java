package org.example.repo;

import org.example.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,String> {
	Department findByDepartmentName(String departmentName);
}
