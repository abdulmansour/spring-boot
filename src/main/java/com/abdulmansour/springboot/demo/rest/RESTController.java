package com.abdulmansour.springboot.demo.rest;

import com.abdulmansour.springboot.demo.dao.EmployeeDAO;
import com.abdulmansour.springboot.demo.entity.Employee;
import com.abdulmansour.springboot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    private EmployeeService employeeService;

    @Autowired
    public RESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Invalid employee id - " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public void saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Invalid employee id - " + employeeId);
        }
        employeeService.deleteById(employeeId);
    }
}
