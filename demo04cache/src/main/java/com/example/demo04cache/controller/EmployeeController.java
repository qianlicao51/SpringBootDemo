package com.example.demo04cache.controller;

import com.example.demo04cache.bean.Employee;
import com.example.demo04cache.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EmployeeController {
    @Resource
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        return employeeService.getEmpByid(id);
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        return employeeService.updateEmp(employee);
    }

}
