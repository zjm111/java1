package com.zjm.pro.controller;

import com.zjm.pro.bean.Project;
import com.zjm.pro.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: PMS
 * @description: 项目控制器
 * @author: Mr.
 * @create: 2019-04-08 10:16
 **/
@Controller
@RequestMapping("/pro")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/projectList",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getProjectList(){
        return projectService.getProjectList();
    }

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Project project,String companyname){
        String[] arr=companyname.split(",");
        project.setComname(Integer.parseInt(arr[2]));
        projectService.saveInfo(project);
        return "redirect:/project-base.jsp";
    }
    @RequestMapping(value = "/prolist",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> prolist(){
        return  projectService.prolist();
    }
    @RequestMapping(value = "/prolistwithanalyse",method = RequestMethod.GET)
    @ResponseBody
    public List<Project> prolistwithanalyse(){
        return projectService.getprolistwithanalyse();
    }
    @RequestMapping(value = "/PList",method = RequestMethod.GET)
    public ModelAndView PList(){
        ModelAndView mv=new ModelAndView("project-base");
           List<Project> pList= projectService.PList();
        System.out.println(pList);
          mv.addObject("msg1",pList);
        return mv;
    }

}
