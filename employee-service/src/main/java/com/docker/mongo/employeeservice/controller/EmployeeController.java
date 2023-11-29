package com.docker.mongo.employeeservice.controller;


import com.docker.mongo.employeeservice.model.Employee;
import com.docker.mongo.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/emp")
public class EmployeeController {

    private EmployeeService empService;

    @Autowired
    public EmployeeController(EmployeeService empService){
        this.empService=empService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllEmp() {
        return new ResponseEntity<>(empService.getAllEmp(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmp(@RequestBody Employee emp) {
        return new ResponseEntity<>(empService.addEmp(emp), HttpStatus.OK);
    }

    @PostMapping("/update/{emailId}")
    public ResponseEntity<?> updateEmp(@PathVariable String emailId, @RequestBody Employee emp) {
        return new ResponseEntity<>(empService.updateEmp(emailId,emp),HttpStatus.OK);
    }

    @DeleteMapping("/remove/{emailId}")
    public ResponseEntity<?> removeUser(@PathVariable String emailId) {
        return new ResponseEntity<>(empService.removeEmp(emailId), HttpStatus.OK);
    }







}
