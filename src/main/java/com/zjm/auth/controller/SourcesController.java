package com.zjm.auth.controller;

import com.zjm.auth.bean.Sources;
import com.zjm.auth.service.SourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @program: PMS
 * @description: 权限
 * @author: Mr.
 * @create: 2019-04-16 16:52
 **/
@Controller
@RequestMapping("/auth")
public class SourcesController {
    @Autowired
    private SourcesService sourcesService;
    @RequestMapping(value = "/showAuth")
    @ResponseBody
    public List<Sources> getSourcesById(){
          List<Sources> topSources= sourcesService.getSourcesById(0);
          queryChildren(topSources.get(0));
        return topSources;
    }

    private void queryChildren(Sources sources) {
        Integer sid=sources.getId();
        List<Sources> Children = sourcesService.getSourcesById(sid);
        //递归
        for (Sources sources1 : Children) {
            queryChildren(sources1);
        }
        sources.setChildren(Children);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Sources sources){
        boolean result=sourcesService.add(sources);
        if (result){
            return "redirect:/pm.jsp";
        }else {
            return "redirect:/pm-add.jsp";
        }
    }
    @RequestMapping(value = "/getOneById",method = RequestMethod.GET)
    public String getOneById(Map map,Integer id){
        Sources list=sourcesService.getOneById(id);
        map.put("onesource",list);
        return "pm-edit";
    }
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public String updateInfo(Sources sources){
        boolean result=sourcesService.updateInfo(sources);
        if (result){
            return "redirect:/pm.jsp";
        }else {
            return "redirect:/pm-edit.jsp";
        }
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public boolean delete(Integer id){
        return sourcesService.delete(id);

    }
}
