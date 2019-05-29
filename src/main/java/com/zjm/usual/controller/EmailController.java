package com.zjm.usual.controller;

import com.zjm.usual.bean.Email;
import com.zjm.usual.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: PMS
 * @description: 邮箱
 * @author: Mr.
 * @create: 2019-04-15 11:21
 **/
@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @RequestMapping(value = "/emailbc",method = RequestMethod.POST)
    public String emailbc(Email email){
        emailService.emailbc(email);
        return "redirect:/message.jsp";
    }
}
