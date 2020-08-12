package com.xiaoyu.springcloud.service;

import com.xiaoyu.springcloud.entities.CommonResult;
import com.xiaoyu.springcloud.entities.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    int addEmployee(Employee employee);

    Employee getEmployeeById(int id);

    Employee getEmployeeByName(String name);

    int updateEmployeeById(Employee employee);

    int deleteEmployeeById(int id);

    int add(Employee employee);

    Employee login(String employeeName,String password);

    ArrayList<Employee> getAllEmployee();
}
