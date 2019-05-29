package com.zjm.emp.service;

import com.zjm.emp.bean.Employee;

import java.util.List;

/**
 * @program: PMS
 * @description: 员工接口
 * @author: Mr.
 * @create: 2019-04-07 22:22
 **/
public interface EmployeeService {
    public List<Employee> getManagerList();

    List<Employee> getEmployeeList();

    Employee login(Employee employee);
}
