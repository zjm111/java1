package com.zjm.pro.service;

import com.zjm.pro.bean.Project;

import java.util.List;

/**
 * @program: PMS
 * @description: 项目接口
 * @author: Mr.
 * @create: 2019-04-08 10:21
 **/
public interface ProjectService {
    void saveInfo(Project project);

    List<Project> prolist();

    List<Project> getprolistwithanalyse();

    List<Project> getProjectList();

    List<Project> PList();

}
