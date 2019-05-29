package com.zjm.auth.service;

import com.zjm.auth.bean.Sources;

import java.util.List;

/**
 * @program: PMS
 * @description: 权限接口
 * @author: Mr.
 * @create: 2019-04-16 16:54
 **/
public interface SourcesService {
    List<Sources> getSourcesById(int i);

    boolean add(Sources sources);

    Sources getOneById(Integer id);

    boolean updateInfo(Sources sources);

    boolean delete(Integer id);

    List<Sources> getSourcesByEid(Integer eid);
}
