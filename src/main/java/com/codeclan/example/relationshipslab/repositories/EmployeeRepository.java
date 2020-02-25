package com.codeclan.example.relationshipslab.repositories;

import com.codeclan.example.relationshipslab.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
