package com.zjm.usual.service;

import com.zjm.usual.bean.Msg;
import com.zjm.usual.mapper.MsgMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: PMS
 * @description: 邮件实现类
 * @author: Mr.
 * @create: 2019-04-14 22:59
 **/
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MsgMapper msgMapper;

}
