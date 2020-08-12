package com.xiaoyu.springcloud.dao;

import com.xiaoyu.springcloud.entities.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface EmployeeDao {
    int insertEmployee(@Param("employeeInfo") Employee employee);

    Employee queryEmployeeById(@Param("id") int id);

    int updateEmployeeById(@Param("employeeInfo") Employee employee);

    int deleteEmployeeById(@Param("id") int id);

    Employee queryEmployeeByName(@Param("name") String name);

    ArrayList<Employee> queryEmployee();


    ArrayList<Employee> queryAllEmployee();
}
