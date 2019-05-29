package com.zjm.pro.service;

import com.zjm.pro.bean.Module;

import java.util.List;

/**
 * @program: PMS
 * @description: 模块接口
 * @author: Mr.
 * @create: 2019-04-08 20:50
 **/
public interface ModuleService {
    boolean saveInfo(Module module);

    List<Module> getModulesByAnalyseid(Integer aid);
}
