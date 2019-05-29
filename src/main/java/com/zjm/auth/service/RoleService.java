package com.zjm.auth.service;

import com.zjm.auth.bean.Role;

import java.util.List;

/**
 * @program: PMS
 * @description: 角色接口
 * @author: Mr.
 * @create: 2019-04-16 20:49
 **/
public interface RoleService {
    int saveInfo(Role role);

    List<Role> rolelist();
}
