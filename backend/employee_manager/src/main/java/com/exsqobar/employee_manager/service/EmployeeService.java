package com.exsqobar.employee_manager.service;

import com.exsqobar.employee_manager.exception.UserNotFoundException;
import com.exsqobar.employee_manager.model.Employee;
import com.exsqobar.employee_manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }


    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + " was not found"));
    }

    public void  deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }

    //find all employees
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
}
