package com.zjm.auth.service;

import com.zjm.auth.bean.Role;
import com.zjm.auth.mapper.RoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: PMS
 * @description: 角色实现类
 * @author: Mr.
 * @create: 2019-04-16 20:50
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    public int saveInfo(Role role) {
       roleMapper.insert(role);
       return role.getRoleid();
    }

    public List<Role> rolelist() {
        return roleMapper.selectByExample(null);
    }
}