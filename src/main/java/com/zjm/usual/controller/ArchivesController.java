package com.zjm.usual.controller;

import com.zjm.usual.bean.Archives;
import com.zjm.usual.service.ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: PMS
 * @description: 我的档案
 * @author: Mr.
 * @create: 2019-04-12 13:26
 **/
@Controller
@RequestMapping("/mf")
public class ArchivesController {
    @Autowired
    private ArchivesService archivesService;
    @RequestMapping(value = "/mfmi",method = RequestMethod.GET)
    public ModelAndView mfmi(){
        ModelAndView mv=new ModelAndView("myarchives");
            Archives archives=archivesService.mfmi();
            mv.addObject("msg",archives);
        return mv;
    }
}
