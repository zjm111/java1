package com.zjm.pro.service;

import com.zjm.pro.bean.Module;
import com.zjm.pro.bean.ModuleExample;
import com.zjm.pro.mapper.ModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: PMS
 * @description: 模块实现类
 * @author: Mr.
 * @create: 2019-04-08 20:51
 **/
@Service
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleMapper moduleMapper;
    @Override
    public boolean saveInfo(Module module) {
        return moduleMapper.insert(module)==1;
    }

    @Override
    public List<Module> getModulesByAnalyseid(Integer aid) {
        ModuleExample moduleExample=new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andAnalysisFkEqualTo(aid);
        List<Module> modules = moduleMapper.selectByExample(moduleExample);
        return modules;
    }
}
