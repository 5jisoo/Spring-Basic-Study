package com.genuinecoder.springserver;

import com.genuinecoder.springserver.model.employee.Employee;
import com.genuinecoder.springserver.model.employee.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	void addEmployeeTest() {
		Employee employee = new Employee();
		//id는 스프링에서 자동으로 만들어줌.
		employee.setName("Rachel");
		employee.setLocation("Building-5");
		employee.setBranch("IT");
		employeeDao.save(employee);

	}

	@Test
	void getAllEmployees(){
		List<Employee> employeeList = employeeDao.getAllEmployees();
		System.out.println(employeeList);
	}

	@Test
	void getAllEmployeesAndDeleteThem(){
		List<Employee> employeeList = employeeDao.getAllEmployees();
		for(Employee employee : employeeList){
			employeeDao.delete(employee);
		}
	}
}
