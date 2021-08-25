package com.fan.springbootWeb.controller;

import com.fan.springbootWeb.dao.impl.DepartmentDaoImpl;
import com.fan.springbootWeb.dao.impl.EmployeeDaoImpl;
import com.fan.springbootWeb.domain.Department;
import com.fan.springbootWeb.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    //应该调用service层, 这里为了简便, 先直接调用dao
    @Autowired
    private EmployeeDaoImpl employeeDao;
    @Autowired
    private DepartmentDaoImpl departmentDao;

    @RequestMapping("/list")
    public String empList(Model model) {
        Collection<Employee> employee = employeeDao.findAllEmployee();
        model.addAttribute("empList", employee);

        return "employee/table";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage(Model model) {
        //需要携带部门列表便于页面显示
        Collection<Department> departmentList = departmentDao.getDepartments();
        model.addAttribute("departmentList", departmentList);
        return "employee/form";
    }

    @RequestMapping("/addEmp")
    public String addEmployee(Employee employee) {
        System.out.println("EmployeeController=====>addEmployee: " + employee);
        employeeDao.addEmployee(employee);
        return "redirect:/emp/list";
    }

    @RequestMapping("/toEditPage/{empId}")
    public String toEditPage(@PathVariable("empId")Integer empId, Model model) {
        Employee employee = employeeDao.getEmployeeById(empId);
        model.addAttribute("emp", employee);

        //需要携带部门列表便于页面显示
        Collection<Department> departmentList = departmentDao.getDepartments();
        model.addAttribute("departmentList", departmentList);
        return "employee/update";
    }

    @RequestMapping("/updateEmp")
    public String updateEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
        return "redirect:/emp/list";
    }

    @GetMapping("/deleteEmp/{empId}")
    public String deleteEmployee(@PathVariable("empId") Integer empId) {
        employeeDao.deleteEmployee(empId);
        return "redirect:/emp/list";
    }
}
