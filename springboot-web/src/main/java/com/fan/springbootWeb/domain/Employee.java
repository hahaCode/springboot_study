package com.fan.springbootWeb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer empId;
    private String empName;
    private String empEmail;
    private String empGender;
    private Date empBirthday;

    private Department department;
}
