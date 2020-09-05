package com.zackfusnflash.day3_project.repository;

import com.zackfusnflash.day3_project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}
