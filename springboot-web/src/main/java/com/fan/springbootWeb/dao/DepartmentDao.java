package com.fan.springbootWeb.dao;

import com.fan.springbootWeb.domain.Department;

import java.util.Collection;

public interface DepartmentDao {

    Collection<Department> getDepartments();

    Department findDepartmentById(Integer id);
}
