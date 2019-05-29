package com.zjm.usual.controller;

import com.zjm.emp.bean.Employee;
import com.zjm.usual.bean.Task;
import com.zjm.usual.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: PMS
 * @description: 任务
 * @author: Mr.
 * @create: 2019-04-09 20:05
 **/
@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Task task, HttpSession session, RedirectAttributes re){
        Employee emp = (Employee)session.getAttribute("activeUser");
        if (emp==null){
            task.setEmpFk(1);
        }else {
            task.setEmpFk(emp.getEid());
        }
        boolean result=taskService.saveInfo(task);
        if (result){
            return "redirect:/task/showInfo";
        }else {
            re.addFlashAttribute("msg","添加失败");
            return "/redirect:task-add.jsp";
        }
    }
    @RequestMapping(value = "/showInfo",method = RequestMethod.GET)
    public ModelAndView showInfo(Task task){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("task");
        List<Task> tasks=taskService.showInfo();
        mv.addObject("tasks",tasks);
        return mv;
    }
}
