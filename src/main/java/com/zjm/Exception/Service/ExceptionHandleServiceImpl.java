package com.zjm.Exception.Service;

import com.zjm.Exception.bean.errorlog;
import com.zjm.Exception.mapper.errorlogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: PMS
 * @description: 处理异常实现类
 * @author: Mr.
 * @create: 2019-04-17 23:34
 **/
@Service
public class ExceptionHandleServiceImpl implements  ExceptionHandleService {
    @Resource
    private errorlogMapper mapper;

    public void instinto(errorlog er) {
        mapper.instinto(er);
    }
}