package com.yutt.zidongpeizhi.controller;

import com.sun.org.glassfish.external.statistics.annotations.Reset;
import com.yutt.zidongpeizhi.dao.DepartmentDao;
import com.yutt.zidongpeizhi.dao.EmployeeDao;
import com.yutt.zidongpeizhi.entity.Department;
import com.yutt.zidongpeizhi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
//请求查询页面员工信息
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model)
    {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //自动将请求参数和入参对象一一绑定
    @PostMapping("/emp")
    public String addEmp(Employee employee)
    {
        System.out.println("员工信息："+employee);
        employeeDao.save(employee);
        //redirect:重定向视图--渲染 sendredirect
        //forward: 渲染方法 转发器，转发
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String modifyEmp(@PathVariable("id") Integer id, Model model)
    {
        Employee employee=employeeDao.get(id);
        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return "emp/add";
    }
    //修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee)
    {
        System.out.println("修改的员工数据为："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id)
    {
        employeeDao.delete(id);
        System.out.println("删除数据");
        return "redirect:/emps";
    }
}
