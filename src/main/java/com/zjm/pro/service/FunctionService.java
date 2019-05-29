package com.zjm.pro.service;

import com.zjm.pro.bean.Function;

import java.util.List;

/**
 * @program: PMS
 * @description: 功能接口
 * @author: Mr.
 * @create: 2019-04-09 18:22
 **/
public interface FunctionService {
    List<Function> getFunctionListByMid(Integer mid);
}
