package com.zjm.pro.controller;

import com.zjm.pro.bean.Function;
import com.zjm.pro.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: PMS
 * @description: 功能
 * @author: Mr.
 * @create: 2019-04-09 18:21
 **/
@Controller
@RequestMapping( "/function")
public class FunctionController {
   @Autowired
    private FunctionService functionService;

   @RequestMapping(value = "/list/{mid}",method = RequestMethod.GET)
   @ResponseBody
    public List<Function> getFunctionListByMid(@PathVariable("mid") Integer mid){
        return functionService.getFunctionListByMid(mid);
    }
}
