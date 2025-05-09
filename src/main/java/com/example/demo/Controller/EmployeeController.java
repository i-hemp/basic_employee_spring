package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.ServiceImplementation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeController {
    @Autowired
    ServiceImplementation implementation;

    @GetMapping("/hey")
    public ResponseEntity<String> helloAPI() {
        return new ResponseEntity<String>("Hello!", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id) {
        Employee existingItem = implementation.fetchEmployee(id);

        if (Objects.nonNull(existingItem)) {
            return new ResponseEntity<>(existingItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Employee> create(@RequestBody Employee item) {
        System.out.println(item.toString());
        try {
            Employee savedItem = implementation.saveEmployee(item);
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee existingItem = implementation.updateEmployee(employee, id);
        if (Objects.nonNull(existingItem)) {
            return new ResponseEntity<>(existingItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Employee>> getAll() {
        try {
            List<Employee> items = implementation.fetchEmployeeList();

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            implementation.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
