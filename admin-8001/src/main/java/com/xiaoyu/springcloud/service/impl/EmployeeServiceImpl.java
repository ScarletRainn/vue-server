package com.xiaoyu.springcloud.service.impl;

import com.xiaoyu.springcloud.dao.EmployeeDao;
import com.xiaoyu.springcloud.entities.Employee;
import com.xiaoyu.springcloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    EmployeeDao employeeDao;
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public int addEmployee(Employee employee) {

        int effectedNum = employeeDao.insertEmployee(employee);
        return effectedNum;

    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = employeeDao.queryEmployeeById(id);
        return employee;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        Employee employee  = employeeDao.queryEmployeeByName(name);
        return employee;
    }

    @Override
    public int updateEmployeeById(Employee employee) {
        int effectedNum = employeeDao.updateEmployeeById(employee);
        return effectedNum;
    }

    @Override
    public int deleteEmployeeById(int id) {
        int effectedNum = employeeDao.deleteEmployeeById(id);
        return effectedNum;
    }

    @Override
    //注册admin
    public int add(Employee employee) {
        employee.setPassword(encoder.encode(employee.getPassword()));
        employee.setAdmin(1);
        int res=employeeDao.insertEmployee(employee);
        return res;

    }

    public Employee login(String employeeName,String password){
        Employee employee=employeeDao.queryEmployeeByName(employeeName);
        if(employee!=null&&encoder.matches(password,employee.getPassword())&&employee.getAdmin()==1){
            return employee;
        }
        return  null;
    }


    @Override
    public ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> employees = employeeDao.queryAllEmployee();
        return employees;
    }
}
