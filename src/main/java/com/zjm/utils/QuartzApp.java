package com.zjm.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @program: PMS
 * @description: 定时与邮箱
 * @author: Mr.
 * @create: 2019-04-12 19:40
 **/
public class QuartzApp {
    public  void testapp(){
        System.out.println("***********************************");
    }

    public static void main(String[] args)throws  Exception {
        //定时
//        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext-quartz.xml");
        //邮箱初始化Spring环境
        ApplicationContext ioc1=new ClassPathXmlApplicationContext("spring-mail.xml");
        //获取mailSender邮件发送类
        JavaMailSenderImpl sender =ioc1.getBean(JavaMailSenderImpl.class);
        //创建邮件对象
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true,"UTF-8");
        //设置邮件发送者
        helper.setFrom("836788919@qq.com");
        //设置邮件接收者
        helper.setTo("1297225044@qq.com");
        //设置邮件标题
        helper.setSubject("邮件标题");
        //设置邮件内容
        helper.setText("<h1>内容++++++++++++++++++++</h1><img src='cid:Coupon'>",true);
        //设知内容图片
        FileSystemResource resource=new FileSystemResource(new File("C:\\Users\\83678\\Desktop\\timg.jpg"));
        helper.addInline("Coupon",resource);
        //设置邮件附件
        FileSystemResource fileSystemResource=new FileSystemResource(new File("C:\\Users\\83678\\Desktop\\timg.jpg"));
        helper.addAttachment("222.png", fileSystemResource);
        //发送邮件
        sender.send(message);
        System.out.println("邮件发送成功");

    }

}

//QQ授权码：ydngvdotoupubegj