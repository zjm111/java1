package com.zjm.usual.controller;

import com.zjm.usual.bean.Notice;
import com.zjm.usual.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: PMS
 * @description: 通知公告
 * @author: Mr.
 * @create: 2019-04-11 18:59
 **/
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping(value = "/saveinfo",method = RequestMethod.POST)
    public String seaveInfo(Notice notice){
        notice.setNdate(new Date());
        noticeService.seaveInfo(notice);
        return "redirect:/notice.jsp";
    }
    @RequestMapping(value = "/showAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Notice> showAll(Map<String,Object> map){
        List<Notice> result=noticeService.showAll();
        return result;
    }
    @RequestMapping(value = "/infoByNid/{nid}",method = RequestMethod.GET)
    @ResponseBody
    public Notice infoByNid(@PathVariable("nid") Integer nid){
        Notice result=noticeService.infoByNid(nid);
        return result;
    }

}
