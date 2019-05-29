package com.zjm.usual.service;

import com.zjm.usual.bean.Comparison;

import java.util.List;

/**
 * @program: PMS
 * @description: 对标接口
 * @author: Mr.
 * @create: 2019-04-15 21:44
 **/
public interface ComparisonService {
    boolean saveInfo(Comparison comparison);

    List<Comparison> complist();
}
