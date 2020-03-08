package com.example.demo04cache.mapper;

import com.example.demo04cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id =#{id}")
    public Employee getEmployee(Integer id);


    @Update("update employee set lastName =#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id =#{id}")
    public void updateEmp( Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void delEmpById(Integer id );

    @Insert("insert into employee(lastname,email ,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);
}
