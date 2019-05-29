package com.zjm.usual.controller;

import com.zjm.emp.bean.Employee;
import com.zjm.usual.bean.Comparison;
import com.zjm.usual.service.ComparisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: PMS
 * @description: 对标
 * @author: Mr.
 * @create: 2019-04-15 21:42
 **/
@Controller
@RequestMapping("/comp")
public class ComparisonController {

    @Autowired
    private ComparisonService comparisonService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.POST)
    public String saveInfo(Comparison comparison, HttpSession session){
        Employee employee=(Employee)session.getAttribute("activeUser");
        comparison.setEmpFk(employee.getEid());
        System.out.println(comparison.getEmpFk()+"********************************************");
        boolean result=comparisonService.saveInfo(comparison);
        if (result){
            return "redirect:/indexvalue-base.jsp";
        }else {
            return "redirect:/indexvalue-add.jsp";
        }
    }
    @RequestMapping(value = "/complist",method = RequestMethod.GET)
    @ResponseBody
    public List<Comparison> complist(){
        List<Comparison> list=comparisonService.complist();
        return list;
    }

}
