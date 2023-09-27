package com.test.demo;

import com.test.demo.dao.EmployeeRepository;
import com.test.demo.model.Employee;
import com.test.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class DemoApplicationTests {

	@InjectMocks
	EmployeeService employeeService;

	@Mock
	EmployeeRepository  employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void saveEmployee(){
		Employee employee = getEmployee();
		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		employeeService.saveEmployee(employee);
	}

	private Employee getEmployee() {
		Employee employee = new Employee(1,"Sid","CSE");
		return employee;
	}


}
