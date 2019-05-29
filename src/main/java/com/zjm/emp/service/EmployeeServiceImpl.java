package com.zjm.emp.service;

import com.zjm.emp.bean.Employee;
import com.zjm.emp.bean.EmployeeExample;
import com.zjm.emp.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: PMS
 * @description: 员工实现类
 * @author: Mr.
 * @create: 2019-04-07 22:27
 **/
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getManagerList() {
        EmployeeExample employeeExample=new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andPFkEqualTo(4);
        List<Employee> managerList = employeeMapper.selectByExample(employeeExample);
        return managerList;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeMapper.selectByExample(null);
    }

    @Override
    public Employee login(Employee employee) {
        EmployeeExample employeeExample=new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andUsernameEqualTo(employee.getUsername());
        criteria.andPasswordEqualTo(employee.getPassword());
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if (employees!=null&&employees.size()>0){
        return employees.get(0);
        }else {
            return null;
        }
    }
}
