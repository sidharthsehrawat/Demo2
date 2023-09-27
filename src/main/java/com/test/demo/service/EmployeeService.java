package com.test.demo.service;

import com.test.demo.dao.EmployeeRepository;
import com.test.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee saveEmployee(Employee employee){
       return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee findByDept(String dept) {
        Employee employee =  employeeRepository.findByDept(dept);
        if(employee==null){
            return null;
        }
        return employee;
    }
}
