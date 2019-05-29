package com.zjm.usual.service;

import com.zjm.usual.bean.Email;
import com.zjm.usual.mapper.EmailMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: PMS
 * @description: 邮箱实现类
 * @author: Mr.
 * @create: 2019-04-15 11:22
 **/
@Service
public class EmailServiceImpl implements EmailService {
    @Resource
    private EmailMapper emailMapper;

    public void emailbc(Email email) {
        emailMapper.insert(email);
    }
}
