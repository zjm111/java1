package com.zjm.pro.service;

import com.zjm.pro.bean.Project;
import com.zjm.pro.bean.ProjectExample;
import com.zjm.pro.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: PMS
 * @description: 项目实现类
 * @author: Mr.
 * @create: 2019-04-08 10:22
 **/
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public void saveInfo(Project project) {
        projectMapper.insertSelective(project);
    }

    @Override
    public List<Project> prolist() {
        return projectMapper.getProjectListWithNotAnalyse();
    }

    @Override
    public List<Project> getprolistwithanalyse() {
        return projectMapper.getprolistwithanalyse();
    }

    @Override
    public List<Project> getProjectList() {
        ProjectExample projectExample=new ProjectExample();
        return projectMapper.selectByExample(projectExample);
    }

    @Override
    public List<Project> PList() {
        return projectMapper.selectByExample(null);
    }
}
