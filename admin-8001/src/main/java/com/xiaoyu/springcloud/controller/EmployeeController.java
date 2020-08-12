package com.xiaoyu.springcloud.controller;

import com.xiaoyu.springcloud.entities.CommonResult;
import com.xiaoyu.springcloud.entities.Employee;
import com.xiaoyu.springcloud.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




@Controller
@Slf4j
@ResponseBody
@CrossOrigin
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    private HttpServletRequest request;
    //增
    @PostMapping(value = "/admin/createEmployee")
    public CommonResult create(@RequestBody Employee employee){
        int  result = employeeService.addEmployee(employee);
        log.info("*****插入结果："+result);
        if (result>0){  //成功
            return new CommonResult(200,"插入数据库成功" ,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }
    //根据员工Id查询员工信息
    @GetMapping(value = "/getEmployeeById")
    public CommonResult<Employee> getEmployeeById(int id){
        Employee result = employeeService.getEmployeeById(id);
        log.info("*****插入结果："+result);
        if (result != null){  //成功
            return new CommonResult(200,"查询成功" ,result);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }

    //查询所有员工信息
    @GetMapping(value = "/admin/getAllEmployee")
    public CommonResult<ArrayList<Employee>> getAllEmployee(){
        ArrayList<Employee> result = employeeService.getAllEmployee();
        log.info("*****插入结果："+result);
        if (result != null){  //成功
            return new CommonResult(200,"查询成功" ,result);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }



    //改
    @PostMapping(value = "/admin/updateEmployeeById")
    public CommonResult updateEmployeeById(@RequestBody Employee employee){
        int result = employeeService.updateEmployeeById(employee);
        log.info("*****修改结果："+result);
        if (result>0){  //成功
            return new CommonResult(200,"修改数据库成功" ,result);
        }else {
            return new CommonResult(444,"修改数据库失败",null);
        }
    }
    //删除员工
    @PostMapping(value = "/admin/deleteEmployeeById")
    public  CommonResult deleteEmployeeById(int id){
        int result = employeeService.deleteEmployeeById(id);
        log.info("*****修改结果："+result);
        if (result>0){  //成功
            return new CommonResult(200,"删除数据成功" ,result);
        }else {
            return new CommonResult(444,"删除数据失败",null);
        }

    }

    //注册admin
    @PostMapping(value ="/admin/register")
    public CommonResult add(@RequestBody Employee employee){
        int res = employeeService.add(employee);
        return new CommonResult(200,"注册成功",res);
    }

    //登录
    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    public CommonResult login(@RequestBody Employee employee){
        Employee loginRes = employeeService.login(employee.getEmployeeName(), employee.getPassword());
        if(loginRes==null){
            return new CommonResult(444,"登录失败",null);
        }
        Map<String,Object>map=new HashMap<>();
        //
        String token="admin"+loginRes.getEmployeeName();
        map.put("token",token);
        return new CommonResult(200,"登录成功",map);
    }
    //鉴权删除
    @PostMapping(value = "/admin/deleteById")
    public  CommonResult deleteById(int id){
        String token= (String) request.getHeader("token");
        if(token.substring(0, 5).equals("admin")){
            int result = employeeService.deleteEmployeeById(id);
            log.info("*****修改结果："+result);
            if (result>0){  //成功
                return new CommonResult(200,"删除数据成功" ,result);
            }else {
                return new CommonResult(444,"删除数据失败",null);
            }
        }else {
            return new CommonResult(444,"你不是管理员",null);
        }

    }




}
