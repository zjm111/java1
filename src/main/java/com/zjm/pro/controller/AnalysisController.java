package com.zjm.pro.controller;

import com.zjm.pro.bean.Analysis;
import com.zjm.pro.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

/**
 * @program: PMS
 * @description: 需求分析
 * @author: Mr.
 * @create: 2019-04-08 18:30
 **/
@Controller
@RequestMapping("/analyse")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;
    @RequestMapping(value = "/info/{pid}",method = RequestMethod.GET)
    @ResponseBody
    public Analysis getAnalyseWithId(@PathVariable("pid") Integer pid){
        return  analysisService.getAnalyseWithId(pid);
    }

    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public String saveInfo(Analysis analysis, String pronamewithid, RedirectAttributes re){
        String[] split = pronamewithid.split(",");
        analysis.setId(Integer.parseInt(split[1]));
        analysis.setProname(split[0]);
        analysis.setAddtime(new Date());
        analysis.setUpdatetime(new Date());
        boolean result=analysisService.saveInfo(analysis);
        if (result){
            return "redirect:/project-need.jsp";
        }else {
        re.addFlashAttribute("msg","添加失败");
        return "redirect:/project-need-add.jsp";
        }
    }
    @RequestMapping(value = "/anlist",method = RequestMethod.GET)
    public ModelAndView anlist(){
        ModelAndView mv=new ModelAndView("project-need");
        List<Analysis> anlist = analysisService.anlist();
        mv.addObject("msg",anlist);
        return mv;
    }
}
