package com.zjm.emp.controller;

import com.zjm.emp.bean.Position;
import com.zjm.emp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: PMS
 * @description: 级别
 * @author: Mr.
 * @create: 2019-04-16 23:03
 **/
@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/saveInfo",method = RequestMethod.GET)
    @ResponseBody
    public List<Position> saveInfo(){
        return positionService.saveInfo();
    }
}
