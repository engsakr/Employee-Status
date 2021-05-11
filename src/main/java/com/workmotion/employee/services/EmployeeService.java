package com.workmotion.employee.services;

import com.workmotion.employee.models.Employee;
import com.workmotion.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List employees() {
        List employees = new ArrayList();
        employeeRepository.findAll().forEach(movie -> employees.add(movie));
        return employees;
    }

    public Employee getEmployeeById(long id) {
        return  employeeRepository.findById(id).get();
    }

    public Employee saveOrUpdate(Employee employee) {
         return employeeRepository.save(employee);
    }

    public void delete(long id) {
        employeeRepository.deleteById(id);
    }
}
