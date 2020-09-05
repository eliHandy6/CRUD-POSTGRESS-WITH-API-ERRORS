package com.zackfusnflash.day3_project.service;

import com.zackfusnflash.day3_project.exceptions.ResourceNotFoundException;
import com.zackfusnflash.day3_project.model.Employee;
import com.zackfusnflash.day3_project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeService {

    @Autowired
   private EmployeeRepository employeeRepository;

    //create employee
    @Transactional
    public Employee createEmployee(Employee  employee){
        return employeeRepository.save(employee);
    }

    //read all employees
    @Transactional
    public List<Employee> getAllEmployees(){
        return  employeeRepository.findAll();
    }

    //read emeployee by id

    @Transactional
    public Employee getByEmployeeId(Integer id) throws ResourceNotFoundException {
        return  employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("EmpoyeeFound for this id::"+id));
    }

    //update employee
    @Transactional
    public Employee  updateEmployee(Employee employee) throws ResourceNotFoundException {
        Employee employee1=employeeRepository.findById(employee.getId()).orElseThrow(()->new ResourceNotFoundException("EmpoyeeFound for this id::"+employee.getId()));
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());

        return employeeRepository.save(employee1);
    }

    //delete employee

    @Transactional
    public  void deleteEmployee(int id)throws ResourceNotFoundException{
        Employee employee=employeeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee not found"+id));
        employeeRepository.delete(employee);
    }



}
