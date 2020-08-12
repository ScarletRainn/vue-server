package com.xiaoyu.springcloud.controller;

import com.xiaoyu.springcloud.entities.CommonResult;
import com.xiaoyu.springcloud.entities.Employee;
import com.xiaoyu.springcloud.sevice.EmployeeFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@ResponseBody
@CrossOrigin
public class UserFeignController {

    @Resource
    private EmployeeFeignService employeeFeignService;

    @PostMapping(value = "/user/admin/createEmployee")
    public CommonResult create( Employee employee) {
        return  employeeFeignService.create(employee);
    }


    @GetMapping(value = "/admin/getEmployeeById")
    public CommonResult<Employee> getEmployeeById(@RequestParam("id") int id) {
        return employeeFeignService.getEmployeeById(id);
    }
    @PostMapping(value = "/user/admin/updateEmployeeById")
    public CommonResult updateEmployeeById(Employee employee){
        return  employeeFeignService.updateEmployeeById(employee);
    }

    @PostMapping(value = "/user/admin/deleteEmployeeById")
    public  CommonResult deleteEmployeeById(@RequestParam("id") int id) {
        return  employeeFeignService.deleteEmployeeById(id);
    }



}
