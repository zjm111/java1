package com.zjm.Exception.controller;

import com.zjm.Exception.Service.ExceptionHandleService;
import com.zjm.Exception.bean.errorlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: PMS
 * @description: 全局异常处理
 * @author: Mr.
 * @create: 2019-04-17 22:37
 **/
@ControllerAdvice
public class ExceptionHandleController {
    @Resource
    private JavaMailSenderImpl javaMailSender;
    @Autowired
    private ExceptionHandleService exceptionHandleService;

    @ExceptionHandler(value = Exception.class)
    public void  handleException(Exception ex) throws  Exception{
        System.out.println(ex);
        //保存错误信息
        errorlog er =new errorlog();
        er.setTime(new Date());
        er.setCause(ex.toString());
        exceptionHandleService.instinto(er);
        //发送短信或邮件提示
        //创建邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true,"UTF-8");
        //设置邮件发送者
        helper.setFrom("836788919@qq.com");
        //设置邮件接收者
        helper.setTo("1297225044@qq.com");
        //设置邮件标题
        helper.setSubject("错误日志");
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(er.getTime());
        //设置邮件内容
        helper.setText(er.getCause()+"<br>时间"+format,true);
        //发送邮件
        javaMailSender.send(mimeMessage);
        System.out.println("邮件发送成功");
    }

}
