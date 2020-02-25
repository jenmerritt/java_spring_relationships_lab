package com.codeclan.example.relationshipslab.controllers;

import com.codeclan.example.relationshipslab.models.Employee;
import com.codeclan.example.relationshipslab.models.Project;
import com.codeclan.example.relationshipslab.repositories.EmployeeRepository;
import com.codeclan.example.relationshipslab.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id);
    }

}
