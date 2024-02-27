package com.example.office.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.office.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
