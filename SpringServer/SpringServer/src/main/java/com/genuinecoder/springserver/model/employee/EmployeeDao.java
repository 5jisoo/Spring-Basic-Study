package com.genuinecoder.springserver.model.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDao {
    // Dao? Data Access Object
    @Autowired
    private EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        // 원래 findAll() 은 Iterable<Employee> 형태로 반환하지만? List형태로 반환하기 위해 이렇게 써줌.
        List<Employee> employeeList = new ArrayList<>();
        /*
        이런식으로 써줘도 됨!
        Streamable.of(employeeRepository.findAll())
                .forEach(employee -> {
                    employeeList.add(employee);
                        });
         */
        Streamable.of(employeeRepository.findAll())
                .forEach(employeeList::add);
        return employeeList;
    }

    public void delete(int employeeId){
        employeeRepository.deleteById(employeeId);
    }
}
