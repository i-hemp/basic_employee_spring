package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        System.out.println(employee.toString());
        if (!StringUtils.hasText(employee.getEmployeeName()) || !StringUtils.hasText(employee.getEmployeeAddress()))
            throw new EntityNotFoundException();
        return employeeRepository.save(employee);

    }

    @Override
    public Employee fetchEmployee(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            
        
            throw new EntityNotFoundException();
        }
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public Employee updateEmployee(Employee employee, Long EmployeeId) {

        Employee foundEmployee = employeeRepository.findById(EmployeeId).get();
        if (!StringUtils.hasText(employee.getEmployeeName()) || !StringUtils.hasText(employee.getEmployeeAddress()))
            throw new EntityNotFoundException();

        foundEmployee.setEmployeeName(employee.getEmployeeName());
        foundEmployee.setEmployeeSalary(employee.getEmployeeSalary());
        foundEmployee.setEmployeeAddress(employee.getEmployeeAddress());

        return employeeRepository.save(foundEmployee);
    }

    @Override
    public List<Employee> fetchEmployeeList() {
        List<Employee> list = new ArrayList<>();
        employeeRepository.findAll().forEach(t -> {
            list.add(t);
            System.out.println(t);
        });
        return list;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        if (employeeRepository.existsById(employeeId))
            employeeRepository.deleteById(employeeId);
        else
            throw new EntityNotFoundException();
    }

}
