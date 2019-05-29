package com.zjm.usual.service;

import com.zjm.emp.bean.Employee;
import com.zjm.emp.mapper.EmployeeMapper;
import com.zjm.usual.bean.Task;
import com.zjm.usual.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PMS
 * @description: 任务实现类
 * @author: Mr.
 * @create: 2019-04-09 20:09
 **/
@Service
public class TaskServiceImpl implements TaskService{
    @Resource
    private TaskMapper taskMapper;
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public boolean saveInfo(Task task) {
        return taskMapper.insertSelective(task)==1;
    }

    @Override
    public List<Task> showInfo() {
        List<Task> tasks = taskMapper.selectByExample(null);
        for (Task task:tasks) {
            Employee employee = employeeMapper.selectByPrimaryKey(task.getEmpFk2());
            task.setEmp(employee);
        }
        return tasks;
    }
}
