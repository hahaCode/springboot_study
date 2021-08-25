package com.fan.springbootWeb.dao.impl;

import com.fan.springbootWeb.dao.DepartmentDao;
import com.fan.springbootWeb.domain.Department;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {

    //模拟数据库中的数据

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();  //创建一个部门表
        departments.put(101, new Department(101, "研发部"));
        departments.put(102, new Department(102, "销售部"));
        departments.put(103, new Department(103, "采购部"));
        departments.put(104, new Department(104, "售后部"));
        departments.put(105, new Department(105, "人事部"));
    }


    @Override
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    @Override
    public Department findDepartmentById(Integer id) {
        return departments.get(id);
    }
}
