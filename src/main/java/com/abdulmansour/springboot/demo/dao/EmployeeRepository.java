package com.abdulmansour.springboot.demo.dao;

import com.abdulmansour.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
