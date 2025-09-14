package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.dto.DtoEmployee;
import com.example.EmployeeManagementSystem.service.ServiceEmployeeIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employees")  // <- plural and leading slash
public class ControllerEmployee {

    @Autowired
    private ServiceEmployeeIn serviceEmployee;

    // GET all employees
    @GetMapping
    public ResponseEntity<List<DtoEmployee>> getAllEmployees() {
        List<DtoEmployee> employees = serviceEmployee.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // GET employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<DtoEmployee> getEmployeeById(@PathVariable("id") int id) {
        DtoEmployee employee = serviceEmployee.findById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST new employee
    @PostMapping
    public ResponseEntity<DtoEmployee> createEmployee(@RequestBody DtoEmployee dtoEmployee) {
        DtoEmployee createdEmployee = serviceEmployee.createEmployee(dtoEmployee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    // PUT update employee
    @PutMapping("/{id}")
    public ResponseEntity<DtoEmployee> updateEmployee(@PathVariable("id") int id,
                                                      @RequestBody DtoEmployee updatedEmployee) {
        DtoEmployee employee = serviceEmployee.updateEmployee(id, updatedEmployee);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        serviceEmployee.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }
}
