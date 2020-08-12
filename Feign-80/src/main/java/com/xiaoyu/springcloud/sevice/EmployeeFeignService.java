package com.xiaoyu.springcloud.sevice;

import com.xiaoyu.springcloud.entities.CommonResult;
import com.xiaoyu.springcloud.entities.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface EmployeeFeignService {

    @PostMapping(value = "/admin/createEmployee")
    public CommonResult create(Employee employee);

    @GetMapping(value = "/getEmployeeById")
    public CommonResult<Employee> getEmployeeById(@RequestParam("id") int id);

    @PostMapping(value = "/admin/updateEmployeeById")
    public CommonResult updateEmployeeById(Employee employee);

    @PostMapping(value = "/admin/deleteEmployeeById")
    public  CommonResult deleteEmployeeById(@RequestParam("id") int id);


}
