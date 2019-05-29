package com.zjm.pro.service;

import com.zjm.pro.bean.Function;
import com.zjm.pro.bean.FunctionExample;
import com.zjm.pro.mapper.FunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: PMS
 * @description: 功能实现类
 * @author: Mr.
 * @create: 2019-04-09 18:23
 **/
@Service
public class FunctionServiceImpl implements FunctionService {
    @Autowired
    private FunctionMapper functionMapper;
    @Override
    public List<Function> getFunctionListByMid(Integer mid) {
        List<Function> functions = functionMapper.getFunctionListByMid(mid);
        return functions;
    }
}
