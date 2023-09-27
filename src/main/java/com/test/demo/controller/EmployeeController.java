package com.test.demo.controller;

import com.test.demo.model.Employee;
import com.test.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public ResponseEntity saveEmployee(@RequestBody Employee employee){
      employeeService.saveEmployee(employee);
      return ResponseEntity.ok("Saved Success");
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getEmployee/{dept}")
    public ResponseEntity getAllEmployeeByDept(@PathVariable String dept){
        Employee employee =  employeeService.findByDept(dept);
        if(employee ==null){
          return   ResponseEntity.ok("Employee Not Exist");
        }

        return ResponseEntity.ok("Employee Found : " + employee);
    }

}
