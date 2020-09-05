package com.zackfusnflash.day3_project.controller;

import com.zackfusnflash.day3_project.exceptions.ResourceNotFoundException;
import com.zackfusnflash.day3_project.model.Employee;
import com.zackfusnflash.day3_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
   private EmployeeService employeeService;



    //get all employees

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //get EmployeeById

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable(value = "id")int employeeId) throws
            ResourceNotFoundException {
        Employee employee=employeeService.getByEmployeeId(employeeId);
        return ResponseEntity.ok().body(employee);
    }
    //create a new Employee

    @PostMapping("employees")
    public  Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);

    }

    @PutMapping("employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) throws
            ResourceNotFoundException {
        employee=employeeService.updateEmployee(employee);
        return ResponseEntity.ok().body(employee);
    }


    @DeleteMapping("/employees/{id}")
    public  Map<String,Boolean>deleteEmployeeById( @PathVariable(value = "id")int employeeId) throws
            ResourceNotFoundException {
            employeeService.deleteEmployee(employeeId);

        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);

        return response;
    }









}
