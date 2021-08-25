package com.fan.springbootWeb.dao;

import com.fan.springbootWeb.domain.Employee;

import java.util.Collection;

public interface EmployeeDao {

    void addEmployee(Employee e);

    Collection<Employee> findAllEmployee();

    Employee getEmployeeById(Integer id);

    void deleteEmployee(Integer id);
}
