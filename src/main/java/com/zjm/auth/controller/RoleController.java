package com.zjm.auth.controller;

import com.zjm.auth.bean.Role;
import com.zjm.auth.service.RoleService;
import com.zjm.auth.service.RoleSourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: PMS
 * @description: 角色
 * @author: Mr.
 * @create: 2019-04-16 20:24
 **/
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleSourcesService roleSourcesService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Role role,String sourceIds){
        //保存角色信息
        int roleid=roleService.saveInfo(role);
        //保存权限信息【中间表】
        roleSourcesService.saveInfo(roleid,sourceIds);
        return "redirect:/role.jsp";
    }

    @RequestMapping(value = "/rolelist",method = RequestMethod.GET)
    @ResponseBody
    public List<Role> rolelist(){
        return roleService.rolelist();
    }
}
