package com.zjm.pro.controller;

import com.zjm.pro.bean.Module;
import com.zjm.pro.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: PMS
 * @description: 模块
 * @author: Mr.
 * @create: 2019-04-08 20:44
 **/
@Controller
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public String saveInfo(Module module){
        String pronameWithId = module.getProname();
        String[] split = pronameWithId.split(",");
        module.setAnalysisFk(Integer.parseInt(split[1]));
        module.setProname(split[0]);
        boolean result=moduleService.saveInfo(module);
        if (result){
            return "redirect:/project-model.jsp";
        }else {
            return "redirect:/project-model-add.jsp" ;
        }
    }
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<Module> getModulesByAnalyseid(@PathVariable("id") Integer aid){
        return  moduleService.getModulesByAnalyseid(aid);
    }
}
