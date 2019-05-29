package com.zjm.usual.controller;

import com.zjm.usual.bean.TieZi;
import com.zjm.usual.service.TieZiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @program: PMS
 * @description: 帖子
 * @author: Mr.
 * @create: 2019-04-15 19:03
 **/
@Controller
@RequestMapping("/tz")
public class TieZiController {

    @Autowired
    private TieZiService tieZiService;

    @RequestMapping(value = "/seaveInfo",method = RequestMethod.POST)
    public String seaveInfo(TieZi tieZi){
        tieZi.setDate(new Date());
        tieZiService.seaveInfo(tieZi);
        System.out.println(tieZi);
        return "redirect:/main.jsp";
    }
    @RequestMapping(value = "/tzlist",method = RequestMethod.GET)
    @ResponseBody
    public List<TieZi> tzlist(){
        List<TieZi> list=tieZiService.tzlist();
        return list;
    }
}
