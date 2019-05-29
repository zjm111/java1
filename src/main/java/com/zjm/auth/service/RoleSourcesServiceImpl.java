package com.zjm.auth.service;

import com.zjm.auth.bean.RoleSources;
import com.zjm.auth.mapper.RoleSourcesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: PMS
 * @description: 角色来源接口
 * @author: Mr.
 * @create: 2019-04-16 21:17
 **/
@Service
public class RoleSourcesServiceImpl implements RoleSourcesService {
    @Resource
    private RoleSourcesMapper roleSourcesMapper;

    public void saveInfo(int roleid, String sourceIds) {
        String[] ids = sourceIds.split(",");
        List<RoleSources> roleSourcesList=new ArrayList<RoleSources>();
        for (String id : ids) {
            RoleSources roleSources=new RoleSources();
            roleSources.setRoleid(roleid);
            roleSources.setSid(Integer.parseInt(id));

            roleSourcesList.add(roleSources);
        }
        roleSourcesMapper.batchInsert(roleSourcesList);
    }
}
