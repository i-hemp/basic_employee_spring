package com.example.demo.Service;

import java.util.List;


import com.example.demo.Entity.Employee;


public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    Employee fetchEmployee(Long employeeId);
    Employee updateEmployee(Employee employee,Long EmployeeId);
    List<Employee> fetchEmployeeList();
    void deleteEmployee(Long employeeId);

}
