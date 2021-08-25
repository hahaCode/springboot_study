package com.fan.springbootWeb.dao.impl;

import com.fan.springbootWeb.dao.EmployeeDao;
import com.fan.springbootWeb.domain.Department;
import com.fan.springbootWeb.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    //模拟数据库中的数据

    private static Map<Integer, Employee> employee = null;
    @Autowired
    private DepartmentDaoImpl departmentDao;
    static {
        employee = new HashMap<>();  //创建一个部门表
        employee.put(1801, new Employee(1801, "小王", "1801@qq.com", "male", new Date(), new Department(101, "研发部")));
        employee.put(1802, new Employee(1802, "小李", "1802@qq.com", "female", new Date(), new Department(102, "销售部")));
        employee.put(1803, new Employee(1803, "小刘", "1803@qq.com", "female", new Date(), new Department(103, "采购部")));
        employee.put(1804, new Employee(1804, "小凯", "1804@qq.com", "male", new Date(), new Department(104, "售后部")));
        employee.put(1805, new Employee(1805, "小龙", "1805@qq.com", "male", new Date(), new Department(102, "销售部")));

    }

    //模拟主键自增
    private static Integer init_id = 1806;
    @Override
    public void addEmployee(Employee e) {
        System.out.println("EmployeeDaoImpl====> addEmployee: " + init_id);
        if(e.getDepartment().getDepartmentName() == null && e.getDepartment().getDepId() != null) {
            e.setDepartment(departmentDao.findDepartmentById(e.getDepartment().getDepId()));
        }

        if(e.getEmpId() == null) {
            //添加
            e.setEmpId(init_id);
            employee.put(init_id++, e);
        } else {
            //更新
            employee.put(e.getEmpId(), e);
        }
        System.out.println("EmployeeDaoImpl====> addEmployee: " + employee.keySet());
    }

    @Override
    public Collection<Employee> findAllEmployee() {
        System.out.println("EmployeeDaoImpl====> findAllEmployee: " + employee.values());
        return employee.values();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employee.get(id);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employee.remove(id);
    }


}
