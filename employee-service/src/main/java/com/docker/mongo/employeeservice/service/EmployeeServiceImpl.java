package com.docker.mongo.employeeservice.service;

import com.docker.mongo.employeeservice.model.Employee;
import com.docker.mongo.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository empRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository empRepo){
        this.empRepo=empRepo;
    }

    @Override
    public List<Employee> getAllEmp() {
        return empRepo.findAll();
    }

    @Override
    public Employee addEmp(Employee emp) {
        return empRepo.save(emp);
    }

    @Override
    public Employee updateEmp(String emailId, Employee emp) {
        if(empRepo.findById(emailId).isPresent()){
            System.out.println("user found "+emailId);
            Employee emp2 = new Employee();
            emp2.setName(emp.getName());
            emp2.setRole(emp.getRole());
            emp2.setPassword(emp.getPassword());
            empRepo.save(emp2);
            return emp2;
        }
        else{
            System.out.println("invalid user");
            return null;
        }
    }

    @Override
    public boolean removeEmp(String emailId) {
        if(empRepo.findById(emailId).isPresent()){
            empRepo.deleteById(emailId);
            return true;
        }
        else{
            System.out.println("invalid user");
            return false;
        }
    }
}
