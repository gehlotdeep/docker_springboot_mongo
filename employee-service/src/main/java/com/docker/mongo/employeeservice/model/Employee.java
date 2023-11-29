package com.docker.mongo.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Employee {

    @Id
    private String email;
    private String name;
    private String password;
    private String role;

}
