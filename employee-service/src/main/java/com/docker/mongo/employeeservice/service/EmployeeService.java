package com.docker.mongo.employeeservice.service;

import com.docker.mongo.employeeservice.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmp();
    Employee addEmp(Employee emp);
    Employee updateEmp(String emailId, Employee emp);
    boolean removeEmp(String emailId);


}
