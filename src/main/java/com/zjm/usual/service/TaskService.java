package com.zjm.usual.service;

import com.zjm.usual.bean.Task;

import java.util.List;

/**
 * @program: PMS
 * @description: 任务接口
 * @author: Mr.
 * @create: 2019-04-09 20:08
 **/
public interface TaskService {
    boolean saveInfo(Task task);

    List<Task> showInfo();
}
