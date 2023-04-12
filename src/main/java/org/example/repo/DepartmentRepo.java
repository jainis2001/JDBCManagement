package org.example.repo;

import org.example.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,String> {
	Department findByDepartmentName(String departmentName);
	List<Department> findAllByDepartmentName(String departmentName);
}
