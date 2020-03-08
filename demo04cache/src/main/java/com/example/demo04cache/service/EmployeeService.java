package com.example.demo04cache.service;

import com.example.demo04cache.bean.Employee;
import com.example.demo04cache.mapper.EmployeeMapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EmployeeService {
    @Resource
    EmployeeMapper employeeMapper;

    /**
     * CacheManager:管理多个Cache组件的，对缓存的
     * cacheNames/value:指定缓存的名字，
     * key:缓存数据时使用的key.默认使用方法参数的值
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp", key = "#id") //将方法的运行结果进行缓冲，以后相同的缓冲直接从缓存中获取，
    public Employee getEmpByid(Integer id) {
        System.out.println("查询ID" + id + " 的员工");
        return employeeMapper.getEmployee(id);
    }

    /**
     * CachePut:修改数据库的某个数据，同时更新 缓存
     * @param emp
     * @return
     */
    @CachePut(cacheNames = "emp")
    public Employee updateEmp(Employee emp) {
        System.out.println("更新员工"+emp);
        employeeMapper.updateEmp(emp);
        return emp;
    }
}
